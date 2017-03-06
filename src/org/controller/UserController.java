package org.controller;

import javax.servlet.http.HttpSession;

import org.dao.UserDao;
import org.dao.imp.UserDaoImp;
import org.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tool.JsonObject;

@Controller
public class UserController {

	@RequestMapping("/register")
	@ResponseBody
	public Object register(User u) throws Exception {
		UserDao uDao = new UserDaoImp();
		User user = new User();
		user.setUsername(u.getUsername());
		user.setPassword(u.getPassword());
		user.setAck(false);
		long uid = uDao.addUser(user);
		if (uid != -1) {
			return JsonObject.getResult(1, "添加用户成功", true);
		} else {
			return JsonObject.getResult(0, "添加用户失败", false);
		}
	}

	@RequestMapping("/login")
	@ResponseBody
	public Object login(User u, HttpSession session) throws Exception {
		UserDao uDao = new UserDaoImp();
		User user = uDao.getUser(u.getUsername(), u.getPassword());
		if (user != null) {
			session.setAttribute("user", user);
			return JsonObject.getResult(1, "登录成功", true);
		} else {
			return JsonObject.getResult(0, "用户名或密码错误", false);
		}
	}
}
