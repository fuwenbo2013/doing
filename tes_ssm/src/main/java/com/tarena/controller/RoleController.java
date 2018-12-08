package com.tarena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarena.entity.Role;
import com.tarena.service.RoleService;
import com.tarena.vo.Page;
import com.tarena.vo.Result;

@Controller
@RequestMapping("role/")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value="findRoleByPage",method=RequestMethod.GET)
	@ResponseBody
	public Result findRoleByPage(Page page) {
		
		Result result=null;
		result=roleService.findRoleByPage(page);		
		
		return result;		
	}
	
	@RequestMapping(value="addRole",method=RequestMethod.POST)
	@ResponseBody
	public Result addRole(Role role) {
		
		Result 	result=roleService.addRole(role);		
				
		return result;		
	}
	
	@RequestMapping(value="updateRole",method=RequestMethod.POST)
	@ResponseBody
	public Result updateRoleName(Role role) {
		System.out.println("---gggggg---");
		Result 	result=roleService.updateRoleName(role);		
		System.out.println(result);		
		return result;		
	}
	
}
