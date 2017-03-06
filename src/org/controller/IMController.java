package org.controller;

import java.util.ArrayList;
import java.util.Date;
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
public class IMController {
	@Autowired
	private InterfaceDao iDao;
	@Autowired
	private ModuleDao mDao;

	@RequestMapping("/addInterface")
	@ResponseBody
	public Object addInterface(Interface i, String mName, String mDescription)
			throws Exception {
		System.out.println(i.getOutput());
		
		Module md = mDao.getModule(mName);
		long mId;
		if (md != null) {
			mId = md.getId();
		} else {
			Module m = new Module(mName, mDescription);
			mId = mDao.addModule(m);
		}
		if (mId != -1) {
			long time = new Date().getTime() / 1000;
			Interface it = new Interface(i.getName(), i.getInput(),
					i.getOutput(), i.getDescription(), time, mId);
			long iId = iDao.addInterface(it);
			if (iId != -1)
				return JsonObject.getResult(1, "添加成功", true);
			else
				return JsonObject.getResult(0, "添加模块成功，添加接口失败", false);
		} else
			return JsonObject.getResult(0, "添加模块失败", false);
	}

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
			nMap.put("iName", inList);
			nMap.put("mName", mName);
			list.add(nMap);
		}

		return JsonObject.getResult(1, "模块接口列表", list);
	}

	@RequestMapping("/getInterface")
	@ResponseBody
	public Object getInterface(String iName) throws Exception {
		Interface i = iDao.getInterface(iName);
		if(i!=null)
			return JsonObject.getResult(1, "获取接口信息成功", i);
		else
			return JsonObject.getResult(0, "获取接口信息失败", null);
	}

}
