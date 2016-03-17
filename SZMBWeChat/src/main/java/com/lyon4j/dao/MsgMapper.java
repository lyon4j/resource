package com.lyon4j.dao;

import org.springframework.stereotype.Repository;

import com.lyon4j.pojo.MsgRecord;

@Repository
public interface MsgMapper {
	/**
	 * 新增消息到数据库
	 */
	public void addMsg(MsgRecord msgRecord);
}
