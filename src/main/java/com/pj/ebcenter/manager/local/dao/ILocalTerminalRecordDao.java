package com.pj.ebcenter.manager.local.dao;

import org.springframework.stereotype.Repository;
import com.pj.ebcenter.manager.local.vo.LocalTerminalRecordVo;

/**
 * 
 * <p>Description: </p>
 * @date 2014年1月15日
 * @author 王丽松
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Repository
public interface ILocalTerminalRecordDao {
	
	/**
	 * 
	 * 方法用途:同步出票记录表 <br>
	 * 实现步骤: <br>
	 * @param entity
	 */
	public void insertSynToCloudData(LocalTerminalRecordVo entity);
	
	/**
	 * 获取出票记录表信息
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param terminalRecordId
	 * @return
	 */
	public LocalTerminalRecordVo selectByTerminalRecordId(Integer terminalRecordId);
}
