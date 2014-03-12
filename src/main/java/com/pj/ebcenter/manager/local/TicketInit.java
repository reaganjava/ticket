package com.pj.ebcenter.manager.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mopon.listener.JmsMessageListener;
import com.mopon.service.impl.sys.BaseServiceImpl;
import com.mopon.service.sys.ISysInitService;

@Component
public class TicketInit extends BaseServiceImpl implements ISysInitService {

	@Autowired
	private JmsReceiveProcessor jmsReceiveProcessor;

	@Override
	public void initializer() throws Exception {
		System.out.println("========================TicketInit初始化开始=========================");
		queueMessageMdp.setListener((JmsMessageListener) jmsReceiveProcessor);
		System.out.println("========================TicketInit初始化结束=========================");
	}

}
