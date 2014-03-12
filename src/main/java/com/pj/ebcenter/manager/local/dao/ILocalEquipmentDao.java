package com.pj.ebcenter.manager.local.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pj.ebcenter.manager.local.vo.LocalEquipmentVo;

/**
 * <p>Description: </p>
 * @date 2014年1月20日
 * @author 王方威
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Repository
public interface ILocalEquipmentDao {

	/**
	 * 保存设备信息
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param localEquipment
	 */
	public void saveLocalEquipment(@Param("localEquipment")LocalEquipmentVo localEquipment);
	
	/**
	 * 更新设备信息
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param localEquipmentVo
	 */
	public void updateLocalEquiment(@Param("localEquipment")LocalEquipmentVo localEquipmentVo);
	
	/**
	 * 通过ID查找设备信息
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param equimentId
	 * @return
	 */
	public List<LocalEquipmentVo> findLocalEquimentById(List<String> ids);
}
