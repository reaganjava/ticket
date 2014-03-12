package com.pj.ebcenter.manager.local;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mopon.entity.sys.MessageEntity;
import com.mopon.listener.JmsMessageListener;
import com.mopon.service.impl.sys.BaseServiceImpl;
import com.pj.ebcenter.manager.local.ftp.service.ILocalFtpService;
import com.pj.ebcenter.manager.local.jms.service.ILocalVoucherService;

/**
 * <p>Description: </p>
 * @date 2014年1月17日
 * @author 王方威
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Service("jmsReceiveProcessor")
public class JmsReceiveProcessor extends BaseServiceImpl implements JmsMessageListener {

	protected Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ILocalVoucherService localVoucherService;

	@Autowired
	private ILocalFtpService localFtpService;

	/** 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param messageEntity   
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void receiveMsg(MessageEntity messageEntity) {
		log.debug(" process in JmsReceiveProcessor.receiveMsg method, type: " + messageEntity.getType());

		switch (messageEntity.getType()) {

		case 1:
			// MQ发送Pos同步消息
			localFtpService.saveLocalEquipmentVo(messageEntity.getArrayBody());
			break;
		case 2:
			// MQ发送FTP完成上传完成通知
			localFtpService.getVoucherDataFromTtp(messageEntity.getTextBody());
			break;

		case 3:
			// MQ接受阿里云平台的同步信息
			localVoucherService.localSynCloudToLocal(messageEntity.getArrayBody());

			break;
		default:
			log.debug(" has not found the notice on the Receive,Type: " + messageEntity.getType());
			break;
		}
	}
}
