package com.lyon4j.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyon4j.dao.MsgMapper;
import com.lyon4j.pojo.MsgRecord;
import com.lyon4j.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	MsgMapper msgMapper;
	
	public void addMsg(MsgRecord msgRecord) {
		msgMapper.addMsg(msgRecord);
	}
	
}
