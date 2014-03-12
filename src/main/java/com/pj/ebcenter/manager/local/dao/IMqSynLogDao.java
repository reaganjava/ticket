package com.pj.ebcenter.manager.local.dao;

import org.springframework.stereotype.Repository;

import com.pj.ebcenter.manager.local.vo.MqSynLog;

@Repository
public interface IMqSynLogDao {
	
	public int deleteByPrimaryKey(Integer logId);

    /**
     * 方法用途:添加同步日志 <br>
     * 实现步骤: <br>
     * @param record
     * @return
     */
    public int insert(MqSynLog record);

    public int insertSelective(MqSynLog record);

    public MqSynLog selectByPrimaryKey(Integer logId);

    public int updateByPrimaryKeySelective(MqSynLog record);

    public int updateByPrimaryKey(MqSynLog record);
}