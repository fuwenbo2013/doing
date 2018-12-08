package com.tarena.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarena.service.UserService;
import com.tarena.vo.Result;
@Controller
@RequestMapping("user/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login/{loginName}/{password}",method=RequestMethod.GET)
	@ResponseBody
	public Result login(@PathVariable String loginName,@PathVariable String password,HttpSession session) {
		//System.out.println(111);
		Result result=userService.login(loginName,password,session);
		//System.out.println(loginName+"----"+password);
		return result;
		
	}
	@RequestMapping(value="logout",method=RequestMethod.DELETE)
	@ResponseBody
	public Result logout(HttpSession session) {
		//System.out.println(111);
		Result result=new Result();
		session.invalidate();
		result.setStatus(1);
		//System.out.println(loginName+"----"+password);
		return result;
		
	}
	
	
}
