package com.pj.ebcenter.ticket.util;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.ebcenter.ticket.dao.IVoucherDao;
import com.pj.ebcenter.ticket.entity.Equipment;

/**
 * <p>Description: 缓存管理类</p>
 * @date 2014年1月9日
 * @author 蒋伟
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Component("cacheManager")
public class CacheManager {
	Logger logger = Logger.getLogger(CacheManager.class);
	@Autowired 
	private IVoucherDao voucherDao;

	private static Map<String, Equipment> equipmentMap = new HashMap<String, Equipment>();// 存放缓存数据
	
	/**
	 *@method initCache
	 *@param equipmentNumber
	 *@desc  init cache
	 * **/
	 public void initCache() {
		equipmentMap.clear();
		try {
			List<Equipment> equipmentList = voucherDao.queryAllEquipment();
			Iterator<Equipment> it = equipmentList.iterator();
			while (it.hasNext()) {
				Equipment equipment = (Equipment) it.next();
				equipmentMap.put(equipment.getEquipmentNumber(), equipment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("process  in  CacheMap.initCache() has exception is voucherDao.selectEquipmentByEquipmentNumber(params)");
		}
		logger.info("===========加载缓存数据结束===========");
	}

	
	  
	  public void refreshCache(String equipmentNumber) {
			 Map<String,String> map = new HashMap<String,String>();
			 map.put("deviceid", equipmentNumber);
			 try {
						List<Equipment> list = voucherDao.selectEquipmentByEquipmentNumber(map);
						if(list==null || list.size()==0)
						return;
						else{
							Equipment e = list.get(0);
							equipmentMap.put(equipmentNumber, e);
							logger.info("设备签到刷新缓存成功设备编号=============="+equipmentNumber);
						}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	/**
	 * 删除指定key对应的元素
	 * 
	 * ***/
	 public void removeElement(String key){
		 	if(equipmentMap.containsKey(key)){
		 		equipmentMap.remove(key);
		 	}
	 }
	/**
	 * 获取缓存数据
	 * **/
	  public Equipment getCacheEquipment(String equipmentNumber) {
		Set<String> keyes = equipmentMap.keySet();
		Iterator<String> it = keyes.iterator();
		while (it.hasNext()) {
			String key = it.next();
			if (key.contains(equipmentNumber)) {
				return equipmentMap.get(key);
			}
		}
		return null;
	}
	

}
