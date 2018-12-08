package com.tarena.service;

import com.tarena.entity.Role;
import com.tarena.vo.Page;
import com.tarena.vo.Result;

public interface RoleService {

	Result findRoleByPage(Page page);
    //新增角色
	Result addRole(Role role);
	

}
