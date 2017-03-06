package org.dao;

import org.model.User;

public interface UserDao {
	/**
	 * 1检验用户名是否重复,true 可用,flase 已用
	 * @param username
	 * @return
	 */
	public User getUser(String username);
	/**
	 * 2验证登录
	 * @param u
	 * @return
	 */
	public User getUser(String username,String password);
	
	/**
	 * 3添加用户（注册）
	 * @param u
	 * @return
	 */
	public long addUser(User u);
	
	public boolean getAck(User u);
}
