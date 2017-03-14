package org.dao;

import java.util.List;

import org.model.Module;

public interface ModuleDao {
	/**
	 * 添加模块
	 * @param m
	 * @return
	 */
	public long addModule(Module m);
	
	/**
	 * 获取模块列表
	 * @return
	 */
	public List getModuleList();
	
	/**
	 * 通过名字获取模块
	 * @param name
	 * @return
	 */
	public Module getModule(String name);
	
	/**
	 * 删除模块
	 * @param m
	 * @return
	 */
	public boolean deleteModule(long id);
	
	/**
	 * 编辑模块
	 * @param m
	 * @return
	 */
	public boolean updateModule(Module m);
}
