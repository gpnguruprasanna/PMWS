package com.pmws.dao.impl;
/**
 *@author guruprasanna n
 */
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.pmws.beans.LoginBean;
import com.pmws.dao.HibernateDao;
import com.pmws.dao.LoginDao;
import com.pmws.entity.Users;

@Repository("loginDao")
public class LoginDaoImpl extends HibernateDao<Users, Integer> implements LoginDao<LoginBean>{

	public LoginBean add(LoginBean obj) {
		return null;
	}

	public LoginBean remove(LoginBean obj) {
		return null;
	}

	public LoginBean get(LoginBean obj) {
		return null;
	}

	public LoginBean getAll(LoginBean obj) {
		return null;
	}

	public LoginBean update(LoginBean obj) {
		return null;
	}

	public LoginBean getAdminAuthenticate(LoginBean bean) {
		try{
			StringBuffer	sb=new StringBuffer();
			sb.append("select a.userId,a.userName,a.passWord from Users a where a.userName = '"+bean.getUsername()+"' and a.passWord  ='"+bean.getPassword()+"' ");

			List<Object []> lobj= currentSession().createQuery(sb.toString()).list();
			if(lobj!=null && lobj.size()>0){
				bean.setUserId((Long)lobj.get(0)[0]);
				bean.setResponseStatus("success");
			}else{
				bean.setErrorCode("500");
				bean.setResponseStatus("error");
				bean.setResponseMsg("Incorrect Username/Password.");
			}
		}catch (HibernateException e) {
			bean.setErrorCode("PMWS500");
			bean.setErrorDesc("Error occured while login");
			bean.setResponseStatus("error");
			bean.setResponseMsg("Error occured while login");
			e.printStackTrace();
		} 
		return bean;
	}

}
