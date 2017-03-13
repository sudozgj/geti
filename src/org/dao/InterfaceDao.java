package org.dao;

import java.util.List;

import org.model.Interface;
import org.view.VIMId;

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
	 * 通过名字获取接口——视图形
	 * @param name
	 * @return
	 */
	public VIMId getInterface(String name);
	
	/**
	 * 检验接口名字
	 * @param name
	 * @return
	 */
	public Interface checkInterface(String name);
	
	/**
	 * 编辑接口
	 * @param i
	 * @return
	 */
	public boolean updateInterface(Interface i);
	
	/**
	 * 删除接口，通过删除接口对象来操作
	 * @param i
	 * @return
	 */
	public boolean deleteInterfaceById(long id);
	
	/**
	 * 删除接口，通过属于的模块id（外键），来进行删除
	 * @param MId
	 * @return
	 */
	public boolean deleteInterfaceByMId(long MId);
}
