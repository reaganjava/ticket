package com.pj.ebcenter.manager.hq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pj.ebcenter.manager.hq.entity.Equipment;

/**
 * <p>Description: </p>
 * @date 2013年12月2日
 * @author あんど おか
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Repository
public interface IEquipmentDao {

	public List<Equipment> queryEquipmentByIsSync();
	
	public void save(Equipment equipment);
	
	public void updateIsSync(Equipment equipment);
}
