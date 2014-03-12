package com.pj.ebcenter.manager.hq.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * <p>Description: </p>
 * @date 2013年11月22日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class Goods implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 18784539006841258L;

	/**
	 * 商品主键，流水号
	 */
	private Long goodsNo;
	
	/**
	 * 商品业务ID
	 */
	private String goodsId;
	
	/**
	 * 不等于当前商品ID -- 用于查询，无实际意义
	 */
	private String goodsIdNot;
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 商品类型编码
	 */
	private String goodsTypeCode;
	
	/**
	 * 商品类型名称
	 */
	private String goodsTypeName;
	/**
	 * 商品类型ID 用于通用商品传值
	 */
	private String goodsTypeCodeTYSP;
	
	private String[] goodsTypeCodeTYSPAar;
	
	/**
	 * 商品分类ID
	 */
	private Long goodsCategoryId;
	
	/**
	 * 商品分类名称
	 */
	private String goodsCategoryName;
	
	/**
	 * 商品分类一级分类
	 */
	private Long goodsCategoryIdLV1;
	
	/**
	 * 是否套餐（0否1是）
	 */
	private Integer isPackage;
	
	/**
	 * 市场价
	 */
	private BigDecimal listPrice;
	
	/**
	 * 销售价
	 */
	private BigDecimal salePrice;
	
	/**
	 * 供应商结算价
	 */
	private BigDecimal supplierSettlementPrice;
	
	
	/**
	 * 供应商结算类型（0.固定金额，1.销售价比例）
	 */
	private Integer supplierSettlementType;
	
	/**
	 * 供应商ID
	 */
	private String supplierId;
	
	/**
	 * 供应商名称
	 */
	
	private String supplierName;
	/**
	 * 商品可使用有效期类型（1:指定出行当天有效 2:固定有效期 3:变动有效期
	 */
	private Integer useValidityType;
	
	/**
	 * 商品封面图
	 */
	private String goodsCover;
	
	/**
	 * 销售类型（1散客票 2团体票）
	 */
	private Integer saleType;
	
	/**
	 * 商品可购买的开始时间
	 */
	private Timestamp sellStartTime;
	/**
	 * 商品可购买的结束时间
	 */
	private Timestamp sellEndTime;
	
	/**
	 * 最大销售数量
	 */
	private Integer maxSellNum;
	
	/**
	 * 每天允许最大的销售数量
	 */
	private Integer dayMaxSellNum;
	
	/**
	 * 证件类型（0不需要，1身份证）
	 */
	private Integer idType;
	
	/**
	 * 当前购买数量
	 */
	private Integer sellNumNow;
	
	/**
	 * 发布时间
	 */
	private Timestamp createTime;
	
	/**
	 * 修改时间
	 */
	private Timestamp modifyTime;
	
	/**
	 * 信息审核状态：0待审核；1通过；2不通过
	 */
	private Integer checkStatus;
	
	/**
	 * 财务审核状态 0待审核；1通过；2不通过
	 */
	private Integer financeCheckStatus;
	
	/**
	 * 商品状态 0：草稿；1：上架；2：下架；100：删除
	 */
	private Integer status;
	
	/**
	 * 是否允许退订（0否，1允许）
	 */
	private Integer isAllowUnsubscribe;
	
	/**
	 * 是否二次验证 0:否 1:是
	 */
	private Integer isSecondValid;
	
	/**
	 * 是否参与返利(0否,1是)
	 */
	private Integer isRebate;
	
	/**
	 * 返利类型（0按售价比例，1固定金额返利）
	 */
	private Integer rebateType;
	
	/**
	 * 外部代码
	 */
	private String outCode;
	
	/**
	 * 在线支付短信模板ID
	 */
	private String onlineSmsModelId;
	
	/**
	 * 到付短信模板ID
	 */
	private String delaySmsModelId;
	
	/**
	 * 纸质票模板Id
	 */
	private String ticketModelId;
	
	/**
	 * 是否联票
	 */
	private Integer isJoint;
	
	/**
	 * 关联产地ID（酒店、高尔夫球场、剧院）
	 */
	private Integer relatePlaceId;
	
	/**
	 * 商品开放平台 0所有,1web,2html5,3自有站点,4渠道商
	 */
	private Integer openPlatform;
	
	/**
	 * 景区Id
	 */
	private String scenicSoptId;
	
	/**
	 * 景区名称
	 */
	private String scenicSoptName;

	/**
	 * 扩展表
	 */
	private GoodsExt goodsExt = new GoodsExt();
	
	/**
	 * 查询条件操作时间 1.创建时间 2.修改时间 3.可销售开始时间 4.可销售结束时间
	 */
	private Integer searchTime;
	/**
	 * 查询条件传入的开始时间
	 */
	private String searchStartTime;
	/**
	 * 查询条件传入的结束时间
	 */
	private String searchEndTime;
	
	/**
	 * 查询条件商品类型
	 */
	private String goodsTypeCodeSearch;
	/**
	 * 查询条件 商品分类一级
	 */
	private String goodsCategoryIdLV2;
	/**
	 * 查询条件 商品分类二级
	 */
	private String goodsCategoryIdLV3;
	
	public Goods() {
		super();
	}


	/**
	 * @return the goodsNo
	 */
	public Long getGoodsNo() {
		return goodsNo;
	}


	/**
	 * @param goodsNo the goodsNo to set
	 */
	public void setGoodsNo(Long goodsNo) {
		this.goodsNo = goodsNo;
	}


	/**
	 * @return the goodsId
	 */
	public String getGoodsId() {
		return goodsId;
	}


	/**
	 * @param goodsId the goodsId to set
	 */
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}


	/**
	 * @return the goodsIdNot
	 */
	public String getGoodsIdNot() {
		return goodsIdNot;
	}


	/**
	 * @param goodsIdNot the goodsIdNot to set
	 */
	public void setGoodsIdNot(String goodsIdNot) {
		this.goodsIdNot = goodsIdNot;
	}


	/**
	 * @return the goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}


	/**
	 * @param goodsName the goodsName to set
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	/**
	 * @return the goodsTypeCode
	 */
	public String getGoodsTypeCode() {
		return goodsTypeCode;
	}


	/**
	 * @param goodsTypeCode the goodsTypeCode to set
	 */
	public void setGoodsTypeCode(String goodsTypeCode) {
		this.goodsTypeCode = goodsTypeCode;
	}


	/**
	 * @return the goodsTypeName
	 */
	public String getGoodsTypeName() {
		return goodsTypeName;
	}


	/**
	 * @param goodsTypeName the goodsTypeName to set
	 */
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}


	/**
	 * @return the goodsTypeCodeTYSP
	 */
	public String getGoodsTypeCodeTYSP() {
		return goodsTypeCodeTYSP;
	}


	/**
	 * @param goodsTypeCodeTYSP the goodsTypeCodeTYSP to set
	 */
	public void setGoodsTypeCodeTYSP(String goodsTypeCodeTYSP) {
		this.goodsTypeCodeTYSP = goodsTypeCodeTYSP;
	}


	/**
	 * @return the goodsCategoryId
	 */
	public Long getGoodsCategoryId() {
		return goodsCategoryId;
	}


	/**
	 * @param goodsCategoryId the goodsCategoryId to set
	 */
	public void setGoodsCategoryId(Long goodsCategoryId) {
		this.goodsCategoryId = goodsCategoryId;
	}


	/**
	 * @return the goodsCategoryIdLV1
	 */
	public Long getGoodsCategoryIdLV1() {
		return goodsCategoryIdLV1;
	}


	/**
	 * @return the goodsCategoryName
	 */
	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}


	/**
	 * @param goodsCategoryName the goodsCategoryName to set
	 */
	public void setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName = goodsCategoryName;
	}


	/**
	 * @param goodsCategoryIdLV1 the goodsCategoryIdLV1 to set
	 */
	public void setGoodsCategoryIdLV1(Long goodsCategoryIdLV1) {
		this.goodsCategoryIdLV1 = goodsCategoryIdLV1;
	}


	/**
	 * @return the isPackage
	 */
	public Integer getIsPackage() {
		return isPackage;
	}


	/**
	 * @param isPackage the isPackage to set
	 */
	public void setIsPackage(Integer isPackage) {
		this.isPackage = isPackage;
	}


	/**
	 * @return the listPrice
	 */
	public BigDecimal getListPrice() {
		return listPrice;
	}


	/**
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}


	/**
	 * @return the salePrice
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}


	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}


	/**
	 * @return the supplierSettlementPrice
	 */
	public BigDecimal getSupplierSettlementPrice() {
		return supplierSettlementPrice;
	}


	/**
	 * @return the supplierSettlementType
	 */
	public Integer getSupplierSettlementType() {
		return supplierSettlementType;
	}


	/**
	 * @param supplierSettlementType the supplierSettlementType to set
	 */
	public void setSupplierSettlementType(Integer supplierSettlementType) {
		this.supplierSettlementType = supplierSettlementType;
	}


	/**
	 * @param supplierSettlementPrice the supplierSettlementPrice to set
	 */
	public void setSupplierSettlementPrice(BigDecimal supplierSettlementPrice) {
		this.supplierSettlementPrice = supplierSettlementPrice;
	}


	/**
	 * @return the supplierId
	 */
	public String getSupplierId() {
		return supplierId;
	}


	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}


	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}


	/**
	 * @param supplierName the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	/**
	 * @return the useValidityType
	 */
	public Integer getUseValidityType() {
		return useValidityType;
	}


	/**
	 * @param useValidityType the useValidityType to set
	 */
	public void setUseValidityType(Integer useValidityType) {
		this.useValidityType = useValidityType;
	}


	/**
	 * @return the goodsCover
	 */
	public String getGoodsCover() {
		return goodsCover;
	}


	/**
	 * @param goodsCover the goodsCover to set
	 */
	public void setGoodsCover(String goodsCover) {
		this.goodsCover = goodsCover;
	}


	/**
	 * @return the saleType
	 */
	public Integer getSaleType() {
		return saleType;
	}


	/**
	 * @param saleType the saleType to set
	 */
	public void setSaleType(Integer saleType) {
		this.saleType = saleType;
	}


	/**
	 * @return the sellStartTime
	 */
	public Timestamp getSellStartTime() {
		return sellStartTime;
	}


	/**
	 * @param sellStartTime the sellStartTime to set
	 */
	public void setSellStartTime(Timestamp sellStartTime) {
		this.sellStartTime = sellStartTime;
	}


	/**
	 * @return the sellEndTime
	 */
	public Timestamp getSellEndTime() {
		return sellEndTime;
	}


	/**
	 * @param sellEndTime the sellEndTime to set
	 */
	public void setSellEndTime(Timestamp sellEndTime) {
		this.sellEndTime = sellEndTime;
	}


	/**
	 * @return the maxSellNum
	 */
	public Integer getMaxSellNum() {
		return maxSellNum;
	}


	/**
	 * @param maxSellNum the maxSellNum to set
	 */
	public void setMaxSellNum(Integer maxSellNum) {
		this.maxSellNum = maxSellNum;
	}


	/**
	 * @return the dayMaxSellNum
	 */
	public Integer getDayMaxSellNum() {
		return dayMaxSellNum;
	}


	/**
	 * @param dayMaxSellNum the dayMaxSellNum to set
	 */
	public void setDayMaxSellNum(Integer dayMaxSellNum) {
		this.dayMaxSellNum = dayMaxSellNum;
	}


	/**
	 * @return the idType
	 */
	public Integer getIdType() {
		return idType;
	}


	/**
	 * @param idType the idType to set
	 */
	public void setIdType(Integer idType) {
		this.idType = idType;
	}


	/**
	 * @return the sellNumNow
	 */
	public Integer getSellNumNow() {
		return sellNumNow;
	}


	/**
	 * @param sellNumNow the sellNumNow to set
	 */
	public void setSellNumNow(Integer sellNumNow) {
		this.sellNumNow = sellNumNow;
	}


	/**
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}


	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


	/**
	 * @return the modifyTime
	 */
	public Timestamp getModifyTime() {
		return modifyTime;
	}


	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}


	/**
	 * @return the checkStatus
	 */
	public Integer getCheckStatus() {
		return checkStatus;
	}


	/**
	 * @param checkStatus the checkStatus to set
	 */
	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}


	/**
	 * @return the financeCheckStatus
	 */
	public Integer getFinanceCheckStatus() {
		return financeCheckStatus;
	}


	/**
	 * @param financeCheckStatus the financeCheckStatus to set
	 */
	public void setFinanceCheckStatus(Integer financeCheckStatus) {
		this.financeCheckStatus = financeCheckStatus;
	}


	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}


	/**
	 * @return the isAllowUnsubscribe
	 */
	public Integer getIsAllowUnsubscribe() {
		return isAllowUnsubscribe;
	}


	/**
	 * @param isAllowUnsubscribe the isAllowUnsubscribe to set
	 */
	public void setIsAllowUnsubscribe(Integer isAllowUnsubscribe) {
		this.isAllowUnsubscribe = isAllowUnsubscribe;
	}


	/**
	 * @return the isRebate
	 */
	public Integer getIsRebate() {
		return isRebate;
	}


	/**
	 * @param isRebate the isRebate to set
	 */
	public void setIsRebate(Integer isRebate) {
		this.isRebate = isRebate;
	}


	/**
	 * @return the rebateType
	 */
	public Integer getRebateType() {
		return rebateType;
	}


	/**
	 * @param rebateType the rebateType to set
	 */
	public void setRebateType(Integer rebateType) {
		this.rebateType = rebateType;
	}


	/**
	 * @return the outCode
	 */
	public String getOutCode() {
		return outCode;
	}


	/**
	 * @param outCode the outCode to set
	 */
	public void setOutCode(String outCode) {
		this.outCode = outCode;
	}


	/**
	 * @return the onlineSmsModelId
	 */
	public String getOnlineSmsModelId() {
		return onlineSmsModelId;
	}


	/**
	 * @param onlineSmsModelId the onlineSmsModelId to set
	 */
	public void setOnlineSmsModelId(String onlineSmsModelId) {
		this.onlineSmsModelId = onlineSmsModelId;
	}


	/**
	 * @return the delaySmsModelId
	 */
	public String getDelaySmsModelId() {
		return delaySmsModelId;
	}


	/**
	 * @param delaySmsModelId the delaySmsModelId to set
	 */
	public void setDelaySmsModelId(String delaySmsModelId) {
		this.delaySmsModelId = delaySmsModelId;
	}


	/**
	 * @return the ticketModelId
	 */
	public String getTicketModelId() {
		return ticketModelId;
	}


	/**
	 * @param ticketModelId the ticketModelId to set
	 */
	public void setTicketModelId(String ticketModelId) {
		this.ticketModelId = ticketModelId;
	}


	/**
	 * @return the isJoint
	 */
	public Integer getIsJoint() {
		return isJoint;
	}


	/**
	 * @param isJoint the isJoint to set
	 */
	public void setIsJoint(Integer isJoint) {
		this.isJoint = isJoint;
	}


	/**
	 * @return the relatePlaceId
	 */
	public Integer getRelatePlaceId() {
		return relatePlaceId;
	}


	/**
	 * @param relatePlaceId the relatePlaceId to set
	 */
	public void setRelatePlaceId(Integer relatePlaceId) {
		this.relatePlaceId = relatePlaceId;
	}


	/**
	 * @return the openPlatform
	 */
	public Integer getOpenPlatform() {
		return openPlatform;
	}


	/**
	 * @param openPlatform the openPlatform to set
	 */
	public void setOpenPlatform(Integer openPlatform) {
		this.openPlatform = openPlatform;
	}


	/**
	 * @return the scenicSoptId
	 */
	public String getScenicSoptId() {
		return scenicSoptId;
	}


	/**
	 * @param scenicSoptId the scenicSoptId to set
	 */
	public void setScenicSoptId(String scenicSoptId) {
		this.scenicSoptId = scenicSoptId;
	}


	/**
	 * @return the scenicSoptName
	 */
	public String getScenicSoptName() {
		return scenicSoptName;
	}


	/**
	 * @param scenicSoptName the scenicSoptName to set
	 */
	public void setScenicSoptName(String scenicSoptName) {
		this.scenicSoptName = scenicSoptName;
	}

	/**
	 * @return the isSecondValid
	 */
	public Integer getIsSecondValid() {
		return isSecondValid;
	}


	/**
	 * @param isSecondValid the isSecondValid to set
	 */
	public void setIsSecondValid(Integer isSecondValid) {
		this.isSecondValid = isSecondValid;
	}


	/**
	 * @return the goodsExt
	 */
	public GoodsExt getGoodsExt() {
		return goodsExt;
	}


	/**
	 * @param goodsExt the goodsExt to set
	 */
	public void setGoodsExt(GoodsExt goodsExt) {
		this.goodsExt = goodsExt;
	}


	/**
	 * @return the goodsTypeCodeTYSPAar
	 */
	public String[] getGoodsTypeCodeTYSPAar() {
		return goodsTypeCodeTYSPAar;
	}


	/**
	 * @param goodsTypeCodeTYSPAar the goodsTypeCodeTYSPAar to set
	 */
	public void setGoodsTypeCodeTYSPAar(String[] goodsTypeCodeTYSPAar) {
		this.goodsTypeCodeTYSPAar = goodsTypeCodeTYSPAar;
	}


	/**
	 * @return the searchStartTime
	 */
	public String getSearchStartTime() {
		return searchStartTime;
	}


	/**
	 * @param searchStartTime the searchStartTime to set
	 */
	public void setSearchStartTime(String searchStartTime) {
		this.searchStartTime = searchStartTime;
	}


	/**
	 * @return the searchEndTime
	 */
	public String getSearchEndTime() {
		return searchEndTime;
	}


	/**
	 * @param searchEndTime the searchEndTime to set
	 */
	public void setSearchEndTime(String searchEndTime) {
		this.searchEndTime = searchEndTime;
	}


	/**
	 * @return the searchTime
	 */
	public Integer getSearchTime() {
		return searchTime;
	}


	/**
	 * @param searchTime the searchTime to set
	 */
	public void setSearchTime(Integer searchTime) {
		this.searchTime = searchTime;
	}


	/**
	 * @return the goodsCategoryIdLV2
	 */
	public String getGoodsCategoryIdLV2() {
		return goodsCategoryIdLV2;
	}


	/**
	 * @param goodsCategoryIdLV2 the goodsCategoryIdLV2 to set
	 */
	public void setGoodsCategoryIdLV2(String goodsCategoryIdLV2) {
		this.goodsCategoryIdLV2 = goodsCategoryIdLV2;
	}


	/**
	 * @return the goodsCategoryIdLV3
	 */
	public String getGoodsCategoryIdLV3() {
		return goodsCategoryIdLV3;
	}


	/**
	 * @param goodsCategoryIdLV3 the goodsCategoryIdLV3 to set
	 */
	public void setGoodsCategoryIdLV3(String goodsCategoryIdLV3) {
		this.goodsCategoryIdLV3 = goodsCategoryIdLV3;
	}


	/**
	 * @return the goodsTypeCodeSearch
	 */
	public String getGoodsTypeCodeSearch() {
		return goodsTypeCodeSearch;
	}


	/**
	 * @param goodsTypeCodeSearch the goodsTypeCodeSearch to set
	 */
	public void setGoodsTypeCodeSearch(String goodsTypeCodeSearch) {
		this.goodsTypeCodeSearch = goodsTypeCodeSearch;
	}
}
