package com.lyon4j.dao;

import org.springframework.stereotype.Repository;

import com.lyon4j.pojo.MsgRecord;

@Repository
public interface MsgMapper {
	/**
	 * ������Ϣ�����ݿ�
	 */
	public void addMsg(MsgRecord msgRecord);
}
