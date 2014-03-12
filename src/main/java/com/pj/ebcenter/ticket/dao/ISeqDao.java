package com.pj.ebcenter.ticket.dao;

import org.springframework.stereotype.Repository;

/**
 * 
 * <p>Description: 序列器管理．</p>
 * @date 2013年10月15日
 * @author dyxiang
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Repository
public interface ISeqDao {

	/**
	 * 
	 * 方法用途: 根据序列名称查询序列值<br>
	 * 实现步骤: <br>
	 * @param seqName
	 * @return
	 * @throws Exception
	 */
	public String getNextVal(String seqName) throws Exception;
	
}
