package com.tarena.dao;

import java.util.List;
import com.tarena.entity.Role;
import com.tarena.vo.Page;
import com.tarena.vo.Result;
public interface RoleMapper {
	public int getCount(String roleKW);
	public  List<Role> getRoles(Page page);	
	public int addRole(Role role);
	//根据ID更新role表
	public void updateRole(Role role);
	//根据id删除角色
	public void delRole(String id);
}

