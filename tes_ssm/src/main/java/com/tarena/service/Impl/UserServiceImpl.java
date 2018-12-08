package com.tarena.service.Impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarena.dao.UserMapper;
import com.tarena.entity.User;
import com.tarena.service.UserService;
import com.tarena.vo.Result;

@Service("userService")
public class UserServiceImpl implements UserService {	
	@Autowired
	private UserMapper userMapper;

	Result result=new Result();
	User user=new User();

	public Result login(String loginName, String password,HttpSession session) {
		//user属性赋值,以便使用userMapper的login方法查询结果
		user.setLoginName(loginName);
		user.setPassword(password);
		//设置登录session
		session.setAttribute("loginName", loginName);
		
		String id=userMapper.login(user);
		if (id!=null) {
			result.setStatus(1);
			result.setMessage("登录成功");			
		}
		else {
			result.setStatus(0);
			result.setMessage("登录失败");		
		}
		return result;
	}

	
}
