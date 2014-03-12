package com.pj.ebcenter.manager.hq.packed.handler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pj.ebcenter.manager.hq.packed.entity.BaseEntity;
import com.pj.ebcenter.manager.hq.packed.entity.CheckETTicket;

/**
 * <p>Description: bean对象转化成xml字符串</p>
 * @date 2013年11月22日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class XmlHandler {
	private static final Log logger = LogFactory.getLog(XmlHandler.class);

	/**
	 * 消息对象转成XML文件
	 * */
	public static String BeanToXml(BaseEntity response) throws JAXBException, UnsupportedEncodingException{
	    JAXBContext ctx = JAXBContext.newInstance(response.getClass(),BaseEntity.class,CheckETTicket.class);  
        Marshaller marchaller = ctx.createMarshaller() ;  
		marchaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);//是否格式化生成的xml串
		marchaller.setProperty(Marshaller.JAXB_FRAGMENT, false);//是否省略xml头信息
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        marchaller.marshal(response,byteArrayOutputStream);
       String xmlContent = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
       return xmlContent;
	}

	/**
	 *  XML转成消息对象
	 * */
	public static Object parse(String metadata,Class clazz){
		Object obj = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller um = jaxbContext.createUnmarshaller();
			return obj = (Object)um.unmarshal(new ByteArrayInputStream(metadata.getBytes()));
		} catch (JAXBException e) {
			logger.error("JAXB castor failed to convert the metadata to module instance by{}",e);
			e.printStackTrace();
		}
		return obj;
	}
}
