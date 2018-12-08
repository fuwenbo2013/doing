package com.tarena.service;

import javax.servlet.http.HttpSession;

import com.tarena.vo.Result;

public interface UserService {

	public Result login(String loginName, String password, HttpSession session);

}
