package org.dao;

import java.util.List;

import org.model.Interface;

public interface InterfaceDao {
	/**
	 * 添加接口
	 * @param r
	 * @return
	 */
	public long addInterface(Interface r);
	
	/**
	 * 通过模块id获取模块下所有接口
	 * @param mId
	 * @return
	 */
	public List getInterfaceList(long mId);
	
	/**
	 * 通过名字获取接口
	 * @param name
	 * @return
	 */
	public Interface getInterface(String name);
}
