package com.pj.ebcenter.manager.hq.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <p>Description: </p>
 * @date 2013年10月23日
 * @author reagan
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
public class Config {
	
	private Properties proper; 
	
	public Config(String configName) {
		try {
			proper = new Properties();
			InputStream in = this.getClass().getResourceAsStream("/" + configName);
			proper.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		return proper.getProperty(key);
	}
	
	public static void main(String[] args) {
		Config config = new Config("db.properties");
		System.out.println(config.getProperty("db.address"));
	}
}
