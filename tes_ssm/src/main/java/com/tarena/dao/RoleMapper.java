package com.tarena.dao;

import java.util.List;
import com.tarena.entity.Role;
import com.tarena.vo.Page;
import com.tarena.vo.Result;
public interface RoleMapper {
	public int getCount(String roleKW);
	public  List<Role> getRoles(Page page);	
	public int addRole(Role role);
}

