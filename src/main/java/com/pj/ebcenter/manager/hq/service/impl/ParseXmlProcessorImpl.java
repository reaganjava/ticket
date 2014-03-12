package com.pj.ebcenter.manager.hq.service.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.ebcenter.manager.hq.constant.DateUtil;
import com.pj.ebcenter.manager.hq.constant.LocalConstant;
import com.pj.ebcenter.manager.hq.constant.PacketsConstant;
import com.pj.ebcenter.manager.hq.constant.PacketsTargetConstant;
import com.pj.ebcenter.manager.hq.constant.StatusCode;
import com.pj.ebcenter.manager.hq.entity.OutlineProduct;
import com.pj.ebcenter.manager.hq.entity.Voucher;
import com.pj.ebcenter.manager.hq.exception.BussinessException;
import com.pj.ebcenter.manager.hq.exception.ParseXmlException;
import com.pj.ebcenter.manager.hq.exception.SignedErrorException;
import com.pj.ebcenter.manager.hq.exception.XmlContentFormatException;
import com.pj.ebcenter.manager.hq.packed.entity.ProductVo;
import com.pj.ebcenter.manager.hq.service.ICheckETTicketService;
import com.pj.ebcenter.manager.hq.service.IOutTicketNoticeService;
import com.pj.ebcenter.manager.hq.service.IOutlineProductService;
import com.pj.ebcenter.manager.hq.service.IParseXmlProcessor;
import com.pj.ebcenter.manager.hq.util.DateUtils;
import com.pj.ebcenter.manager.hq.util.EncryptUtil;
import com.pj.ebcenter.manager.hq.util.ParseXmlPackets;
import com.pj.ebcenter.manager.local.jms.service.ILocalVoucherService;

/**
 * <p>Copyright:Copyright(c)2012</p>
 * <p>Company:Mopon</p>
 * @date 2013年11月25日
 * @author あんど おか
 * @version 1.0
 */
@Service("parseXmlProcessor")
public class ParseXmlProcessorImpl implements IParseXmlProcessor {

	protected Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private IOutlineProductService outlineProductService;
	@Autowired
	private ICheckETTicketService checkETTicketService;

	@Autowired
	private IOutTicketNoticeService outTicketService;
	
	@Autowired
	private ILocalVoucherService localVoucherService;

	@Override
	@Transactional(readOnly = true)
	public String tranToOutTicketNoticePackets(String xmlContent) {

		logger.debug(" Process in ParseXmlProcessorImpl.tranToOutTicketNoticePackets method, parameter xmlContent: "
				+ xmlContent);

		// 定义返回的报文
		String res = PacketsConstant.RESPONSE_PACKETS;

		// 返回的报文体
		String bodyPackets = PacketsConstant.RESPONSE_PACKETS_BODY;

		// 定义错误码
		String status = StatusCode.CODE_SUCCESS;

		// 定义错误消息
		String message = StatusCode.MESSAGE_CODE_SUCCESS;

		String tempstamp = DateUtil.fromatDate(null, null);

		String sequenceId = null;

		String encrptySigned = null;
		String offlineAccount = null;
		try {

			// 将XML报文中的参数封装成Map对象
			Map<String, Object> packetsMap = ParseXmlPackets.parseOutTicketNotice(xmlContent, LocalConstant.KEY);

			sequenceId = (String) packetsMap.get("SequenceId");
			offlineAccount = (String) packetsMap.get("OfflineAccount");

			// 从XMl解析对象中取出凭证的值
			String voucherValue = (String) packetsMap.get(PacketsTargetConstant.XML_BODY);

			// 出票业务逻辑
			if (outTicketService.updateVoucherOutTicket(voucherValue)) {
				message = StatusCode.MESSAGE_CODE_SUCCESS_UPDATE;
			}
		} catch (ParseXmlException e) {
			logger.error("  tranToOutTicketNoticePackets happen ParseXmlException ", e);
			status = StatusCode.CODE_PARSE_XML_ERROR;
			message = StatusCode.MESSAGE_CODE_PARSE_XML_ERROR;
		} catch (SignedErrorException e) {
			logger.error("  tranToOutTicketNoticePackets happen SignedErrorException ", e);
			status = StatusCode.CODE_SIGNED_ERROR;
			message = StatusCode.MESSAGE_CODE_SIGNED_ERROR;
		} catch (BussinessException e) {
			e.printStackTrace();
			status = e.getErrorCode();
			message = e.getMessage();
		} catch (Exception e) {
			logger.error("  tranToOutTicketNoticePackets happen Exception ", e);
			status = StatusCode.CODE_ERROR_SYSTEM;
			message = StatusCode.MESSAGE_CODE_ERROR_SYSTEM;
		} finally {
			// SequenceId，OfflineAccount，TimeStamp，Message
			String temp = sequenceId + offlineAccount + tempstamp + message;
			encrptySigned = EncryptUtil.BASE64Encrypt(EncryptUtil.MD5(temp));
		}

		if (status.equals(StatusCode.CODE_PARSE_XML_ERROR) || status.equals(StatusCode.CODE_SIGNED_ERROR)) {
			res = message;
		} else {
			bodyPackets = bodyPackets.replace("${Message}", message);

			res = res
					.replace("${Version}", StatusCode.XML_VERSION)
					.replace("${TimeStamp}", tempstamp)
					.replace("${StatusCode}", status)
					.replace("${SequenceId}", sequenceId)
					.replace("${Signed}", encrptySigned)
					.replace("${Body}",
							EncryptUtil.BASE64Encrypt(EncryptUtil.DES3Encrypt(LocalConstant.KEY, bodyPackets)));

		}
		return res;

	}

	/** 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param xmlContent
	 * @return   
	 */
	@Override
	@Transactional(readOnly = true)
	public String tranToSysnProductPackets(String xmlContent) {

		logger.debug(" Process in ParseXmlProcessorImpl.tranToSysnProductPackets method, parameter xmlContent: "
				+ xmlContent);
		// 定义返回的报文
		String res = PacketsConstant.RESPONSE_PACKETS;

		// 返回的报文体
		String bodyPackets = PacketsConstant.RESPONSE_PACKETS_BODY;

		// 定义错误码
		String status = StatusCode.CODE_SUCCESS;

		// 定义错误消息
		String message = StatusCode.MESSAGE_CODE_SUCCESS;

		String tempstamp = DateUtil.fromatDate(null, null);

		String sequenceId = null;

		String encrptySigned = null;
		String offlineAccount = null;
		try {

			// 将XML报文中的参数封装成Map对象
			Map<String, Object> packetsMap = ParseXmlPackets.parseDownProduct(xmlContent, LocalConstant.KEY);

			sequenceId = (String) packetsMap.get("SequenceId");
			offlineAccount = (String) packetsMap.get("OfflineAccount");

			// 去除参数中的商品信息
			ProductVo vo = (ProductVo) packetsMap.get(PacketsTargetConstant.XML_BODY);

			OutlineProduct outlineProduct = new OutlineProduct();
			outlineProduct.setRefConsumeArea(vo.getRefConsumeArea());
			outlineProduct.setRefDescription(vo.getRefDescription());
			outlineProduct.setRefGuestPrompt(vo.getRefGuestPrompt());
			outlineProduct.setRefMarketPrice(vo.getRefMarketPrice());
			outlineProduct.setRefProductId(vo.getRefProductId());
			outlineProduct.setRefProductName(vo.getRefProductName());
			outlineProduct.setRefLimitCount(vo.getRefLimitCount());
			outlineProduct.setRefValidityBuyStart(vo.getRefValidityBuyStart());
			outlineProduct.setRefValidityBuyEnd(vo.getRefValidityBuyEnd());
			outlineProduct.setRefValidityStart(vo.getRefValidityStart());
			outlineProduct.setRefValidityEnd(vo.getRefValidityEnd());
			outlineProduct.setRefSalesPrice(vo.getRefSalesPrice());
			outlineProduct.setRefValidityDesc(vo.getRefValidityDesc());
			outlineProduct.setOfflineAccount(offlineAccount);

			outlineProductService.saveOutlineProduct(outlineProduct);
			
			//将数据发送到云平台
			localVoucherService.synOutlineProduct(outlineProduct);
		} catch (ParseXmlException e) {
			logger.error("  tranToSysnProductPackets happen ParseXmlException ", e);
			status = StatusCode.CODE_PARSE_XML_ERROR;
			message = StatusCode.MESSAGE_CODE_PARSE_XML_ERROR;
		} catch (SignedErrorException e) {
			logger.error("  tranToSysnProductPackets happen ParseXmlException ", e);
			status = StatusCode.CODE_SIGNED_ERROR;
			message = StatusCode.MESSAGE_CODE_SIGNED_ERROR;
		} catch (BussinessException e) {
			logger.error("  tranToSysnProductPackets happen BussinessException ", e);
			status = e.getErrorCode();
			message = e.getMessage();
		} catch (XmlContentFormatException e) {
			logger.error("  tranToSysnProductPackets happen XmlContentFormatException ", e);
			status = StatusCode.CODE_PARAMETER_ERROR;
			message = StatusCode.MESSAGE_CODE_PARAMETER_ERROR;
		} catch (Exception e) {
			logger.error("  tranToSysnProductPackets happen Exception ", e);
			status = StatusCode.CODE_ERROR_SYSTEM;
			message = StatusCode.MESSAGE_CODE_ERROR_SYSTEM;
		} finally {
			// SequenceId，OfflineAccount，TimeStamp，Message
			String temp = sequenceId + offlineAccount + tempstamp + message;
			encrptySigned = EncryptUtil.BASE64Encrypt(EncryptUtil.MD5(temp));
		}

		if (status.equals(StatusCode.CODE_PARSE_XML_ERROR) || status.equals(StatusCode.CODE_SIGNED_ERROR)) {
			res = message;
		} else {
			bodyPackets = bodyPackets.replace("${Message}", message);

			res = res
					.replace("${Version}", StatusCode.XML_VERSION)
					.replace("${TimeStamp}", tempstamp)
					.replace("${StatusCode}", status)
					.replace("${SequenceId}", sequenceId)
					.replace("${Signed}", encrptySigned)
					.replace("${Body}",
							EncryptUtil.BASE64Encrypt(EncryptUtil.DES3Encrypt(LocalConstant.KEY, bodyPackets)));

		}

		return res;
	}

	@Transactional(readOnly = true)
	public String tranCheckETTicketPackets(String xmlContent) {
		logger.debug(" Process in ParseXmlProcessorImpl.tranCheckETTicketPackets method, parameter xmlContent: "
				+ xmlContent);

		// 定义返回的报文
		String res = PacketsConstant.RESPONSE_PACKETS;

		// 返回的报文体
		String bodyPackets = PacketsConstant.RESPONSE_CKECKET_BODY;

		// 定义错误码
		String status = StatusCode.CODE_SUCCESS;

		// 定义错误消息
		String message = StatusCode.MESSAGE_CODE_SUCCESS;

		String tempstamp = DateUtil.fromatDate(null, null);

		String sequenceId = null;

		String encrptySigned = null;
		String offlineAccount = null;
		String voucherValue = null;
		Voucher voucherPo = null;
		String StatusDec = "";
		try {

			// 将XML报文中的参数封装成Map对象
			Map<String, Object> packetsMap = ParseXmlPackets.parseCheckETTicket(xmlContent, LocalConstant.KEY);

			sequenceId = (String) packetsMap.get("SequenceId");
			offlineAccount = (String) packetsMap.get("OfflineAccount");

			// 从XMl解析对象中取出凭证的值
			voucherValue = (String) packetsMap.get(PacketsTargetConstant.XML_BODY);
			// 根据凭证值得到凭证记录
			voucherPo = checkETTicketService.queryVoucherDetail(voucherValue);

			if (voucherPo == null) {
				throw new BussinessException(StatusCode.CODE_VOUCHER_NOT_FOUND,
						StatusCode.MESSAGE_CODE_VOUCHER_NOT_FOUND);
			}

			logger.debug(" get the voucher.status: " + voucherPo.getStatus());

			switch (voucherPo.getStatus()) {
			case StatusCode.Voucher.voucher_not_used:
				StatusDec = StatusCode.VoucherText.voucher_not_used;
				break;
			case StatusCode.Voucher.voucher_expired_refund:
				StatusDec = StatusCode.VoucherText.voucher_expired_refund;
				break;
			case StatusCode.Voucher.voucher_expired_retreat:
				StatusDec = StatusCode.VoucherText.voucher_expired_retreat;
				break;
			case StatusCode.Voucher.voucher_has_used:
				StatusDec = StatusCode.VoucherText.voucher_has_used;
				break;
			case StatusCode.Voucher.voucher_not_effective:
				StatusDec = StatusCode.VoucherText.voucher_not_effective;
				break;
			case StatusCode.Voucher.voucher_obsolete:
				StatusDec = StatusCode.VoucherText.voucher_obsolete;
				break;
			case StatusCode.Voucher.voucher_postpone:
				StatusDec = StatusCode.VoucherText.voucher_postpone;
				break;
			}

		} catch (ParseXmlException e) {
			logger.error("  tranCheckETTicketPackets happen ParseXmlException ", e);
			status = StatusCode.CODE_PARSE_XML_ERROR;
			message = StatusCode.MESSAGE_CODE_PARSE_XML_ERROR;
		} catch (SignedErrorException e) {
			logger.error("  tranCheckETTicketPackets happen Exception ", e);
			status = StatusCode.CODE_SIGNED_ERROR;
			message = StatusCode.MESSAGE_CODE_SIGNED_ERROR;
		} catch (BussinessException e) {
			logger.error("  tranCheckETTicketPackets happen BussinessException ", e);
			status = e.getErrorCode();
			message = e.getMessage();
		} catch (Exception e) {
			logger.error("  tranCheckETTicketPackets happen Exception ", e);
			status = StatusCode.CODE_ERROR_SYSTEM;
			message = StatusCode.MESSAGE_CODE_ERROR_SYSTEM;
		} finally {
			// SequenceId，OfflineAccount，TimeStamp，OrderId， VoucherValue，OfflineGoodsId
			String temp = sequenceId + offlineAccount + tempstamp
					+ ((voucherPo == null || voucherPo.getOrderId() == null) ? "" : voucherPo.getOrderId())
					+ ((voucherPo == null || voucherPo.getVoucherValue() == null) ? "" : voucherPo.getVoucherValue())
					+ ((voucherPo == null || voucherPo.getOutCode() == null) ? "" : voucherPo.getOutCode());
			encrptySigned = EncryptUtil.BASE64Encrypt(EncryptUtil.MD5(temp));
		}

		if (status.equals(StatusCode.CODE_PARSE_XML_ERROR) || status.equals(StatusCode.CODE_SIGNED_ERROR)) {
			res = message;
		} else {
			if (null != voucherPo) {
				bodyPackets = bodyPackets
						.replace("${OrderId}", voucherPo.getOrderId())
						.replace("${VoucherValue}", voucherPo.getVoucherValue())
						.replace("${Status}", voucherPo.getStatus().toString())
						.replace("${StatusDec}", StatusDec)
						.replace("${OfflineGoodsId}", voucherPo.getOutCode())
						.replace("${SalePrice}", voucherPo.getPrice().toString())
						.replace("${UseStartTime}",
								DateUtils.fromatDate(voucherPo.getStartDate(), DateUtils.dateFormat))
						.replace("${UseEndTime}", DateUtils.fromatDate(voucherPo.getEndDate(), DateUtils.dateFormat))
						.replace("${Message}", message);
			} else {
				bodyPackets = bodyPackets.replace("${OrderId}", "").replace("${VoucherValue}", "")
						.replace("${Status}", "").replace("${StatusDec}", "").replace("${OfflineGoodsId}", "")
						.replace("${SalePrice}", "").replace("${UseStartTime}", "").replace("${UseEndTime}", "")
						.replace("${Message}", message);
			}

			res = res
					.replace("${Version}", StatusCode.XML_VERSION)
					.replace("${TimeStamp}", tempstamp)
					.replace("${StatusCode}", status)
					.replace("${SequenceId}", sequenceId)
					.replace("${Signed}", encrptySigned)
					.replace("${Body}",
							EncryptUtil.BASE64Encrypt(EncryptUtil.DES3Encrypt(LocalConstant.KEY, bodyPackets)));
		}

		return res;
	}
}
