package com.pmws.dao.impl;
/**
 *@author guruprasanna n
 *this class perform curd operation for User entity
 */
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pmws.beans.UserBean;
import com.pmws.dao.HibernateDao;
import com.pmws.dao.UserDao;
import com.pmws.entity.Users;

@Repository("userDao")
public class UserDaoImpl extends HibernateDao implements UserDao<UserBean> {

	public UserBean add(UserBean obj) {
		try{
			Users users=new Users();
			users.setUserName(obj.getUserName());
			users.setPassWord(obj.getPassword());
			users.setStatus(obj.getStatus());
			String roles="";
			for(String s:obj.getRoles()){
				roles+=s+",";
			}
			roles=roles.substring(0,roles.length()-1);
			users.setRoles(roles);
			currentSession().save(users);
			obj.setUserId(users.getUserId());
			obj.setResponseStatus("success");
			obj.setResponseMsg("User added succesfully");
		}catch(Exception e){
			obj.setErrorDesc("Error Occured while Saving new user in to Database");
			obj.setResponseStatus("error");
			obj.setResponseMsg("Server is not responding... please wait.... ");
		}
		return obj;
	}

	public UserBean remove(UserBean obj) {
		try{
			currentSession().createQuery("delete from Users a where a.userId='"+obj.getUserId()+"'").executeUpdate();
			obj.setResponseMsg(obj.getUserName()+" User has been removed succussully.");
			obj.setResponseStatus("success");
		}catch(Exception e){
			obj.setErrorDesc("Error Occured while Saving new user in to Database");
			obj.setResponseStatus("error");
			obj.setResponseMsg("Server is not responding... please wait.... ");
		}
		return obj;
	}

	public UserBean get(UserBean obj) {
		try{
			List<Object []> listOfUsers=currentSession().createQuery("select userId,userName,passWord,status,roles from Users where userId="+obj.getUserId()).list();
			if(listOfUsers!=null && listOfUsers.size()>0){
				Object [] user=listOfUsers.get(0);
				obj.setUserId((Long) user[0]);
				obj.setUserName((String) user[1]);
				obj.setPassword((String) user[2]);
				obj.setStatus((String) user[3]);
				String roles=(String)user[4];
				String s[]=roles.split(",");
				if(s!=null && s.length>1){
					for(String str:s){
						obj.getRoles().add(str);
					}
				}else {
					obj.getRoles().add(roles);
				}
			}
		}catch(Exception e){
			obj.setResponseStatus("error");
			obj.setResponseMsg("Internal error while fetching data");
		}
		return obj;
	}

	public UserBean getAll(UserBean obj) {
		try{
			List<Object []> listOfUsers=currentSession().createQuery("select userId,userName,passWord,status,roles from Users").list();
			if(listOfUsers!=null && listOfUsers.size()>0){
				for(Object [] user:listOfUsers){
					UserBean userBean=new UserBean();
					userBean.setUserId((Long) user[0]);
					userBean.setUserName((String) user[1]);
					userBean.setPassword((String) user[2]);
					userBean.setStatus((String) user[3]);
					String roles=(String) user[4];
					String s[]=roles.split(",");
					if(s!=null && s.length>1){
						for(String str:s){
							userBean.getRoles().add(str);
						}
					}else {
						userBean.getRoles().add(roles);
					}
					obj.getbList().add(userBean);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			obj.setResponseStatus("error");
			obj.setResponseMsg("Internal error while fetching data");
		}
		return obj;
	}

	public UserBean update(UserBean obj) {
		try{
			Users users=new Users();
			users.setUserId(obj.getUserId());
			users.setUserName(obj.getUserName());
			users.setPassWord(obj.getPassword());
			users.setStatus(obj.getStatus());
			String roles="";
			for(String s:obj.getRoles()){
				roles+=s+",";
			}
			roles=roles.substring(0,roles.length()-1);
			users.setRoles(roles);
			currentSession().update(users);
			obj.setUserId(users.getUserId());
			obj.setResponseStatus("success");
			obj.setResponseMsg("User updated succesfully");
		}catch(Exception e){
			obj.setErrorDesc("Error Occured while Saving new user in to Database");
			obj.setResponseStatus("error");
			obj.setResponseMsg("Server is not responding... please wait.... ");
		}
		return obj;
	}

}
