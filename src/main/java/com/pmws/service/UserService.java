package com.pmws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pmws.dao.UserDao;

/**
 *@author guruprasanna n
 */
@Service("userService")
public class UserService<UserBean> implements GenericService<UserBean>{
	@Autowired
	@Qualifier("userDao")
	private UserDao<UserBean> userDao;
	
	public UserBean add(Object obj) {
		return userDao.add((UserBean) obj);
	}

	public UserBean update(Object obj) {
		return userDao.update((UserBean) obj);
	}

	public UserBean remove(Object obj) {
		return userDao.remove((UserBean) obj);
	}

	public UserBean  getAll(Object obj) {
		return userDao.getAll((UserBean) obj);
	}

	public UserBean get(Object obj) {
		return userDao.get((UserBean) obj);
	}

}
