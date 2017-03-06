package org.test;

import java.util.Date;

import org.dao.InterfaceDao;
import org.dao.ModuleDao;
import org.dao.imp.InterfaceDaoImp;
import org.dao.imp.ModuleDaoImp;
import org.model.Interface;
import org.model.Module;


public class test01 {
	public static void main(String[] args) {
		
		ModuleDao mDao = new ModuleDaoImp();
		Module m = mDao.getModule("Log2");
		System.out.println(m.getId());
	}
}
