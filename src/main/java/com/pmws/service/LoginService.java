package com.pmws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmws.beans.LoginBean;
import com.pmws.dao.LoginDao;

/**
 *@author guruprasanna n
 */
@Service("loginService")
public class LoginService  {
	@Autowired
	@Qualifier("loginDao")
	private LoginDao<LoginBean> loginDao;
	
	public LoginBean getAdminAuthenticate(LoginBean obj){
		return  loginDao.getAdminAuthenticate(obj);
	}

}
