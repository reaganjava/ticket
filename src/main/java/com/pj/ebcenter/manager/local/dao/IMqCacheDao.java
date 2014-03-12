package com.pj.ebcenter.manager.local.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pj.ebcenter.manager.local.vo.MqCache;

@Repository
public interface IMqCacheDao {

	/**
	 * 
	 * 方法用途:记录未同步数据 <br>
	 * 实现步骤: <br>
	 * @param record
	 * @return
	 */
    public void insert(MqCache record);

    /**
     * 
     * 方法用途:查询所有未同步数据 <br>
     * 实现步骤: <br>
     * @return
     */
    public List<MqCache> selectByDelFlag();
    
    /**
     * 
     * 方法用途:查询是否未同步的数据 <br>
     * 实现步骤: <br>
     * @return
     */
    public Integer selectByDelFlagCount();

    /**
     * 
     * 方法用途:删除所有未同步的数据 <br>
     * 实现步骤: <br>
     * @param record
     * @return
     */
    public int delMqCache(Integer mqTaskId);
}