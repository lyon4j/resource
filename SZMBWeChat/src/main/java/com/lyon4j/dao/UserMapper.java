package com.lyon4j.dao;
import org.springframework.stereotype.Repository;

import com.lyon4j.pojo.User;

@Repository
public interface UserMapper {
	/**
	 * �û���ע
	 * @param user
	 */
	public void addUser(User user);
}
