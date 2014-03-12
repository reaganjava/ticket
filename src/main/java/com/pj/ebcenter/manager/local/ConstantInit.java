package com.pj.ebcenter.manager.local;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.mopon.service.sys.ISysInitService;
import com.mopon.util.PropertiesUtil;

@Component
public class ConstantInit implements ISysInitService {

	protected Logger log = Logger.getLogger(this.getClass());

	public static PropertiesUtil config;

	public static Map<String, String> configMap;

	@Override
	public void initializer() throws Exception {
		log.debug("========================ConstantInitConstantInit系统启动时进行初始化处理========================");

		configMap = new HashedMap();
		config = new PropertiesUtil("config/constant.properties");

		configMap.put(SystemKeyConstant.LOCAL_SCENIC_CODE, config.getProperty(SystemKeyConstant.LOCAL_SCENIC_CODE));
		configMap.put(SystemKeyConstant.DOWN_LOAD_FILE_PATH, config.getProperty(SystemKeyConstant.DOWN_LOAD_FILE_PATH));
		configMap.put(SystemKeyConstant.LOCAL_JSON_DES_KEY, config.getProperty(SystemKeyConstant.LOCAL_JSON_DES_KEY));
		log.debug("========================ConstantInitConstantInit初始化完成========================");
	}
}
