package com.pmws.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pmws.beans.LoginBean;

@Component("sessionProvider")
public class SessionProvider {

	public static HttpServletRequest getCurrentRequest(){

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		/*	System.out.println("------------------------- coming to sessionprovider.java --------------------------------"+requestAttributes);*/
		if(requestAttributes!=null){
			return requestAttributes.getRequest();
		}
		else{
			return null;
		}
	}

	public static HttpSession getCurrentSession(){
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		if(requestAttributes!=null && requestAttributes.getRequest()!=null){
			return requestAttributes.getRequest().getSession(false);
		}
		else{
			return null;
		}
	}

	public static Object getSessionData(String sname){

		if(getCurrentRequest()!=null){
			return getCurrentRequest().getSession().getAttribute(sname);
		}
		else{
			return null;
		}

	}

	public static String getAppUrl(){

		if(getCurrentRequest()!=null){
			return getCurrentRequest().getRequestURI();
		}
		else{
			return "NA";
		}
	}

	public static String getUserLanguage(){
		return "en";
	}

	public void setLoginSessionData(HttpSession session,LoginBean lbean){
		if(session.getAttribute("_l_session_data")!=null){
			session.setAttribute("_l_session_data", lbean);
		}
		else{
			session.removeAttribute("_l_session_data");
			session.setAttribute("_l_session_data", lbean);
		}
	}

	public LoginBean getLoginSessionData(){
		LoginBean lbean=new LoginBean();
		if(getCurrentSession()!=null){
			getCurrentSession().getId();


			if(getCurrentSession().getAttribute("_l_session_data")!=null){
				lbean=(LoginBean)getCurrentSession().getAttribute("_l_session_data");
			}
		}
		return lbean;
	}

}
