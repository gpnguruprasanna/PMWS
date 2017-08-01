package com.pmws.dao;
/**
 *@author guruprasanna n
 */
import com.pmws.beans.LoginBean;

public interface LoginDao<T> extends DaoActions<T> {
	public LoginBean getAdminAuthenticate(LoginBean obj);
}
