package com.pmws.controller;
/**
 *@author guruprasanna n
 *This class is used for login & logout purpose
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pmws.beans.LoginBean;
import com.pmws.service.LoginService;

@Controller
public class LoginController extends AppController{
	@Autowired
	LoginService loginService;
	
	/**
	 * This method redirect login page
	 * @param : request & reponse
	 * @return : model & view
	 *
	 */
	@RequestMapping(value="/login" ,method = RequestMethod.GET)
    public ModelAndView getLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
	    mav.addObject("adminlogin", new LoginBean());
	    return mav;
    }
	
	/**
	 * This method  for login to application 
	 * @param : request & reponse
	 * @return : model & view
	 *
	 */
	@RequestMapping(value="/loginpost" ,method = RequestMethod.POST)
    public String loginPost(Model model,@ModelAttribute("adminlogin") LoginBean lbean,HttpServletRequest request ) {
		 lbean=(LoginBean) loginService.getAdminAuthenticate(lbean);
		 
		if(lbean.getResponseStatus().equals("error")){
			return "login";
		}
		HttpSession session=request.getSession();
		session.setAttribute("currentUserId", lbean.getUserId());
		session.setAttribute("currentUserName", lbean.getUsername());
	    return "admin";
    }
	
	/**
	 * This method for log out from application
	 * @param : request & reponse
	 * @return : model & view
	 *
	 */
	@RequestMapping(value="/admin_logout" ,method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }
}
