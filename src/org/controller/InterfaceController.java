package org.controller;

import java.util.Date;

import org.dao.InterfaceDao;
import org.dao.ModuleDao;
import org.model.Interface;
import org.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tool.JsonObject;
import org.view.VIMId;

@Controller
public class InterfaceController {
	@Autowired
	private InterfaceDao iDao;
	@Autowired
	private ModuleDao mDao;

	/**
	 * 1添加接口，需要传模块名
	 * @param i
	 * @param mName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addInterface")	
	@ResponseBody
	public Object addInterface(Interface i, String mName) throws Exception {
		Module md = mDao.getModule(mName);
		long mId;
		if (md != null) {
			mId = md.getId();
			long time = new Date().getTime() / 1000;
			i.setTime(time);
			i.setMId(mId);
			long iId = iDao.addInterface(i);
			if (iId != -1)
				return JsonObject.getResult(1, "添加成功", true);
			else
				return JsonObject.getResult(0, "添加失败", false);
		} else {
			return JsonObject.getResult(0, "模块名无效", false);
		}
	}
	
	/**
	 * 2获取接口信息，根据接口名
	 * @param iName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getInterface")
	@ResponseBody
	public Object getInterface(String iName) throws Exception {
		VIMId i = iDao.getInterface(iName);
		if (i != null)
			return JsonObject.getResult(1, "获取接口信息成功", i);
		else
			return JsonObject.getResult(0, "获取接口信息失败", null);
	}

	/**
	 * 3修改接口信息
	 * @param i
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateInterface")
	@ResponseBody
	public Object updateInterface(Interface i) throws Exception {
		i.setTime(new Date().getTime() / 1000);
		if(iDao.updateInterface(i))
			return JsonObject.getResult(1, "修改接口信息成功", true);
		else
			return JsonObject.getResult(0, "修改接口信息失败", false);
	}
	
	/**
	 * 4删除接口
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteInterface")
	@ResponseBody
	public Object deleteInterface(long id) throws Exception {
		if(iDao.deleteInterfaceById(id))
			return JsonObject.getResult(1, "删除接口成功", true);
		else
			return JsonObject.getResult(0, "删除接口失败", false);
	}
	
	/**
	 * 5检验接口名
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkInterface")
	@ResponseBody
	public Object checkInterface(String name) throws Exception{
		Interface i = iDao.checkInterface(name);
		if(i!=null){	
			return JsonObject.getResult(0, "接口名已使用", false);	
		}else{
			return JsonObject.getResult(1, "接口名可用", true);
		}
	}
}
