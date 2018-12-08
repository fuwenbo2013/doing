package com.tarena.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tarena.dao.RoleMapper;
import com.tarena.entity.Role;
import com.tarena.service.RoleService;
import com.tarena.util.PageUtil;
import com.tarena.util.PaginationUtil;
import com.tarena.util.UUIDUtil;
import com.tarena.vo.Page;
import com.tarena.vo.Result;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	PageUtil pageUtil;
	PaginationUtil paginationUtil=new PaginationUtil();
	@Override	
	public Result findRoleByPage(Page page) {
		//关键字判断
		String roleKW=page.getRoleKW();

		roleKW="undefined".equals(roleKW)? "%%" : "%"+roleKW+"%";
		page.setRoleKW(roleKW);

		//根据关键字查询数据库role的数量
		int totalCount=roleMapper.getCount(roleKW);
		page.setTotalCount(totalCount);
		//从属性配置文件中获取页面设置
		page.setShowNum(pageUtil.getShowNum());
		page.setPageSize(pageUtil.getPageSize());

		int pageSize=pageUtil.getPageSize();
		int totalPages=(totalCount%pageSize==0)?totalCount/pageSize:(totalCount/pageSize+1);
		page.setTotalPages(totalPages);
		//前一页 后一页计算
		int currentPage=page.getCurrentPage();

		if (currentPage==1) {
			page.setPreviousPage(1);
		}else{
			page.setPreviousPage(currentPage-1);
		}
		if (currentPage==totalPages) {
			page.setNextPage(totalPages);
		}else{
			page.setNextPage(currentPage+1);
		}		
		//计算界面显示的页码列表
		List<Integer> nums=paginationUtil.getPagination(page);
		page.setNums(nums);

		//根据当前页查询数据
		List<Role> roles=roleMapper.getRoles(page);
		page.setRoles(roles);
		//返回结果的处理
		Result result=new Result();
		result.setData(page);
		result.setStatus(1);	
		System.out.println(result);
		return result;
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public Result addRole(Role role) {
		role.setId(UUIDUtil.getUUID());
		roleMapper.addRole(role);
		Result result=new Result();
		result.setStatus(1);
		result.setMessage("新增角色成功");

		return result;
	}

}
