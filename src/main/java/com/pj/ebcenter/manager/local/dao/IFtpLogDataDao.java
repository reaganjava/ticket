package com.pj.ebcenter.manager.local.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pj.ebcenter.manager.local.vo.FtpLogDataVo;

/**
 * <p>Description: </p>
 * @date 2014年1月20日
 * @author 王方威
 * @version 1.0
 * <p>Company:Mopon</p>
 * <p>Copyright:Copyright(c)2013</p>
 */
@Repository
public interface IFtpLogDataDao {

	public void insertFtpLogDataVo(@Param("log")
	FtpLogDataVo log);
}
