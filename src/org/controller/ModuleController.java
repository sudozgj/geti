package org.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dao.InterfaceDao;
import org.dao.ModuleDao;
import org.model.Interface;
import org.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tool.JsonObject;

@Controller
public class ModuleController {
	@Autowired
	private ModuleDao mDao;
	@Autowired
	private InterfaceDao iDao;
	
	/**
	 * 1添加模块
	 * @param mName
	 * @param mDescription
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addModule")
	@ResponseBody
	public Object addModule(String mName, String mDescription) throws Exception {
		Module m = new Module(mName, mDescription);
		long mId = mDao.addModule(m);
		if (mId != -1) {
			return JsonObject.getResult(1, "添加模块成功", true);
		} else
			return JsonObject.getResult(0, "添加模块失败", false);
	}
	
	/**
	 * 2删除模块以及包含的接口
	 * @param mid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteModule")
	@ResponseBody
	public Object deleteModule(long mid) throws Exception {
		if(mDao.deleteModule(mid)){
			if(iDao.deleteInterfaceByMId(mid))
				return JsonObject.getResult(1, "删除模块、接口成功", true);
			else
				return JsonObject.getResult(0, "删除模块成功，删除接口失败", false);
		}else
			return JsonObject.getResult(-1, "删除模块失败", false);
	}
	
	/**
	 * 3获取模块，接口信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getIM")
	@ResponseBody
	public Object getIM() throws Exception {
		List<Module> mList = mDao.getModuleList();

		List list = new ArrayList<>();

		for (Module m : mList) {
			Map<String, Object> nMap = new HashMap<String, Object>();
			long mId = m.getId();
			String mName = m.getName();
			String mDesc = m.getDescription();
			List<Interface> iList = iDao.getInterfaceList(mId);

			List inList = new ArrayList<>();
			for (Interface i : iList) {
				String iName = i.getName();
				inList.add(iName);
			}
			nMap.put("mId", mId);
			nMap.put("mDesc", mDesc);
			nMap.put("mName", mName);
			nMap.put("iName", inList);
			list.add(nMap);
		}

		return JsonObject.getResult(1, "模块接口列表", list);
	}
	
	/**
	 * 4检验模块名
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkModule")
	@ResponseBody
	public Object checkModule(String name) throws Exception{
		Module m = mDao.getModule(name);
		if(m!=null){	
			return JsonObject.getResult(0, "模块名已使用", false);	
		}else{
			return JsonObject.getResult(1, "模块名可用", true);
		}
	}
	
	/**
	 * 5修改模块信息
	 * @param m
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateModule")
	@ResponseBody
	public Object updateModule(Module m) throws Exception{
		if(mDao.updateModule(m)){	
			return JsonObject.getResult(1, "修改模块成功", true);	
		}else{
			return JsonObject.getResult(0, "修改模块失败", false);
		}
	}
}
