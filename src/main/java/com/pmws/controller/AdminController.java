package com.pmws.controller;
/**
 *@author guruprasanna n
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pmws.beans.ProductBean;
import com.pmws.beans.PromotionBean;
import com.pmws.beans.UserBean;
import com.pmws.beans.UserValidator;
import com.pmws.service.ProductService;
import com.pmws.service.PromotionService;
import com.pmws.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController extends AppController{
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	@Autowired
	PromotionService promotionService;
	@Autowired
	UserValidator uservalidator;
	/*@InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(uservalidator);
    }*/

	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String getUsers(Model model,@ModelAttribute UserBean userbean){
		String view="users";
		if(userbean.getAction().isEmpty()){
			userbean=(UserBean) userService.getAll(userbean);
			model.addAttribute("user_bean", userbean);
			view="users";
		}else if(userbean.getAction().equalsIgnoreCase("add")){
			model.addAttribute("user_bean",userbean);
			view="user_action";
		}else if(userbean.getAction().equalsIgnoreCase("remove")){
			userbean=(UserBean) userService.remove(userbean);
			if(userbean.getResponseStatus()!=null && !userbean.getResponseStatus().equalsIgnoreCase("error")){
				model.addAttribute("posted_user_data",userbean);
				model.addAttribute("user_bean",userService.getAll(userbean));
				view="user_listing";
			}else{
				userbean.setResponseMsg("Access Denied.. This config entry was using by other resource. .");
				model.addAttribute("user_bean",userbean);
				view="user_action";
			}
		}else if(userbean.getAction().equalsIgnoreCase("edit")){
			model.addAttribute("user_bean",userService.get(userbean));
			view="user_action";
		}
		return view;
	}

	@RequestMapping(value="/users-save",method=RequestMethod.POST)
	public String saveUser(Model model,@ModelAttribute UserBean userBean,BindingResult bindingResult){
		String view="users";
		if(userBean.getAction().equalsIgnoreCase("add")){
			if(userBean.getUserName().isEmpty() || userBean.getUserName().length()<6){
				userBean.getListOfErrorDesc().add("User name not be empty & at least contains 6 letter");
			}if(userBean.getPassword().isEmpty() || userBean.getPassword().length()<6){
				userBean.getListOfErrorDesc().add("Password not be empty & at least it should contains 6 letter");
			}
			if(userBean.getRoles()==null){
				userBean.getListOfErrorDesc().add("Select at least one role for this user");
			}
			if(userBean.getListOfErrorDesc().size()>0){
				model.addAttribute("user_bean",userBean);
				return "user_action";
			}
			/*uservalidator.validate(userBean, bindingResult);
	          if(bindingResult.hasErrors()){
	              return "user_action";
	          }*/
			userBean=(UserBean) userService.add(userBean);
			if(userBean.getResponseStatus()!=null && !userBean.getResponseStatus().equalsIgnoreCase("error")){
				model.addAttribute("posted_user_data",userBean);
				model.addAttribute("user_bean",userService.getAll(userBean));
				view="user_listing";
			}
			else
			{
				model.addAttribute("user_bean",userBean);
				view="user_action";
			}
		}else if(userBean.getAction().equalsIgnoreCase("edit")){
			if(userBean.getUserName().isEmpty() || userBean.getUserName().length()<6){
				userBean.getListOfErrorDesc().add("User name not be empty & at least contains 6 letter");
			}if(userBean.getPassword().isEmpty() || userBean.getPassword().length()<6){
				userBean.getListOfErrorDesc().add("Password not be empty & at least it should contains 6 letter");
			}
			if(userBean.getRoles()==null){
				userBean.getListOfErrorDesc().add("Select at least one role for this user");
			}
			if(userBean.getListOfErrorDesc().size()>0){
				return "user_action";
			}
			userBean=(UserBean) userService.update(userBean);
			if(userBean.getResponseStatus()!=null && !userBean.getResponseStatus().equalsIgnoreCase("error")){
				model.addAttribute("posted_user_data",userBean);
				model.addAttribute("user_bean",userService.getAll(userBean));
				view= "user_listing";
			}
			else
			{
				model.addAttribute("user_bean",userBean);
				view="user_action";
			}
		}
		return view;

	}


	@RequestMapping(value="/products",method=RequestMethod.GET)
	public String getProducts(Model model,@ModelAttribute ProductBean productBean){
		String view="products";
		if(productBean.getAction().isEmpty()){
			productBean =(ProductBean) productService.getAll(productBean);
			model.addAttribute("product_bean", productBean);
			view="products";
		}else if(productBean.getAction().equalsIgnoreCase("add")){
			model.addAttribute("product_bean",productBean);
			view="product_action";
		}else if(productBean.getAction().equalsIgnoreCase("remove")){
			productBean=(ProductBean) productService.remove(productBean);
			if(productBean.getResponseStatus()!=null && !productBean.getResponseStatus().equalsIgnoreCase("error")){
				model.addAttribute("posted_product_data",productBean);
				model.addAttribute("product_bean",productService.getAll(productBean));
				view="product_listing";
			}else{
				productBean.setResponseMsg("Access Denied.. This config entry was using by other resource. .");
				model.addAttribute("product_bean",productBean);
				view="product_action";
			}
		}else if(productBean.getAction().equalsIgnoreCase("edit")){
			model.addAttribute("product_bean",productService.get(productBean));
			view="product_action";
		}
		return view;
	}
	@RequestMapping(value="/products-save",method=RequestMethod.POST)
	public String saveProduct(Model model,@ModelAttribute ProductBean productBean){
		String view="products";
		if(productBean.getAction().equalsIgnoreCase("add")){
			if(productBean.getProductName().isEmpty()){
				productBean.getListOfErrorDesc().add("Enter Product Name");
			}
			if(productBean.getPrice()==null){
				productBean.getListOfErrorDesc().add("Enter Price");
			}
			if(productBean.getListOfErrorDesc().size()>0){
				model.addAttribute("product_bean",productBean);
				return "product_action";
			}
			productBean=(ProductBean) productService.add(productBean);
			if(productBean.getResponseStatus()!=null && !productBean.getResponseStatus().equalsIgnoreCase("error")){
				model.addAttribute("posted_product_data",productBean);
				model.addAttribute("product_bean",productService.getAll(productBean));
				view="product_listing";
			}
			else
			{
				model.addAttribute("product_bean",productBean);
				view="product_action";
			}
		}else if(productBean.getAction().equalsIgnoreCase("edit")){
			if(productBean.getProductName().isEmpty()){
				productBean.getListOfErrorDesc().add("Enter Product Name");
			}
			if(productBean.getPrice()==null){
				productBean.getListOfErrorDesc().add("Enter Price");
			}
			if(productBean.getListOfErrorDesc().size()>0){
				model.addAttribute("product_bean",productBean);
				return "product_action";
			}
			productBean=(ProductBean) productService.update(productBean);
			if(productBean.getResponseStatus()!=null && !productBean.getResponseStatus().equalsIgnoreCase("error")){
				model.addAttribute("posted_user_data",productBean);
				model.addAttribute("product_bean",productService.getAll(productBean));
				view= "product_listing";
			}
			else
			{
				model.addAttribute("product_bean",productBean);
				view="product_action";
			}
		}
		return view;
	}

	@RequestMapping(value="/promotions",method=RequestMethod.GET)
	public String getPromotions(Model model,@ModelAttribute PromotionBean promotionBean){
		String view="promotions";
		if(promotionBean.getAction().isEmpty()){
			promotionBean=	(PromotionBean) promotionService.getAll(promotionBean);
			model.addAttribute("promotion_bean", promotionBean);
			view="promotions";
		}else if(promotionBean.getAction().equalsIgnoreCase("add")){
			model.addAttribute("promotion_bean",promotionBean);
			view="promotion_action";
		}else if(promotionBean.getAction().equalsIgnoreCase("remove")){
			promotionBean=(PromotionBean) promotionService.remove(promotionBean);
			if(promotionBean.getResponseStatus()!=null && !promotionBean.getResponseStatus().equalsIgnoreCase("error")){
				model.addAttribute("posted_promotion_data",promotionBean);
				model.addAttribute("promotion_bean",promotionService.getAll(promotionBean));
				view="promotion_listing";
			}else{
				promotionBean.setResponseMsg("Access Denied.. This config entry was using by other resource. .");
				model.addAttribute("promotion_bean",promotionBean);
				view="promotion_action";
			}
		}else if(promotionBean.getAction().equalsIgnoreCase("edit")){
			model.addAttribute("promotion_bean",promotionService.get(promotionBean));
			view="promotion_action";
		}
		return view;
	}
	@RequestMapping(value="/promotions-save",method=RequestMethod.POST)
	public String savePromotion(Model model,@ModelAttribute PromotionBean promotionBean){
		String view="promotions";
		System.out.println("popopopopopo"+"  "+promotionBean.getAction());
		if(promotionBean.getAction().equals("update")){
			System.out.println("lksogjdxkfjb"+"  "+promotionBean.getReviewStatus()+"  "+promotionBean.getPromotionId());
			promotionBean=(PromotionBean) promotionService.updateReviewStatus(promotionBean);
			if(promotionBean.getResponseStatus()!=null && !promotionBean.getResponseStatus().equalsIgnoreCase("error")){
				model.addAttribute("posted_promotion_data",promotionBean);
				model.addAttribute("promotion_bean",promotionService.getAll(promotionBean));
				view= "promotions";
			}
			view="promotions";
		}
		if(promotionBean.getAction().equalsIgnoreCase("add")){
			if(promotionBean.getProductId()==0){
				promotionBean.getListOfErrorDesc().add("Select one product for promotioon");
			}
			if(promotionBean.getDicount()==0.0 || promotionBean.getDicount()>20){
				promotionBean.getListOfErrorDesc().add("Enter Discount & it should not exceed 20%");
			}
			if(promotionBean.getStartDate()==null || promotionBean.getStartDate().isEmpty()){
				promotionBean.getListOfErrorDesc().add("Enter Start Date");
			}
			if(promotionBean.getEndDate()==null || promotionBean.getEndDate().isEmpty()){
				promotionBean.getListOfErrorDesc().add("Enter End Date");
			}

			if(promotionBean.getStartDate()!=null && !promotionBean.getStartDate().isEmpty()){
				Date startDate=null;
				Date endDate=null;
				Date date2=null;
				SimpleDateFormat format=new SimpleDateFormat("dd MMMM yyyy");
				Calendar c = Calendar.getInstance();
				c.setTime(new Date()); // Now use today date.
				c.add(Calendar.DATE, 14);
				String newdate=format.format(c.getTime());
				try {
					startDate=format.parse(promotionBean.getStartDate());
					endDate=format.parse(promotionBean.getEndDate());
					date2=format.parse(newdate)	;
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(date2.before(startDate)){
					promotionBean.getListOfErrorDesc().add("Start date should be not less than next two weeks");
				}
				if(endDate.before(startDate)){
					promotionBean.getListOfErrorDesc().add("End Date should be not less than Start Date");
				}
			}

			if(promotionBean.getListOfErrorDesc().size()>0){
				model.addAttribute("promotion_bean",promotionBean);
				return "promotion_action";
			}
			promotionBean=(PromotionBean) promotionService.add(promotionBean);
			if(promotionBean.getResponseStatus()!=null && !promotionBean.getResponseStatus().equalsIgnoreCase("error")){
				model.addAttribute("posted_promotion_data",promotionBean);
				model.addAttribute("promotion_bean",promotionService.getAll(promotionBean));
				view="promotion_listing";
			}
			else
			{
				model.addAttribute("promotion_bean",promotionBean);
				view="promotion_action";
			}
		}else if(promotionBean.getAction().equalsIgnoreCase("edit")){
			promotionBean=(PromotionBean) promotionService.update(promotionBean);
			if(promotionBean.getResponseStatus()!=null && !promotionBean.getResponseStatus().equalsIgnoreCase("error")){
				model.addAttribute("posted_promotion_data",promotionBean);
				model.addAttribute("promotion_bean",promotionService.getAll(promotionBean));
				view= "promotion_listing";
			}
			else
			{
				model.addAttribute("promotion_bean",promotionBean);
				view="promotion_action";
			}
		}

		return view;
	}

	@RequestMapping(value="/search-promotion",method=RequestMethod.GET)
	public String searchPromotions(Model model,@ModelAttribute PromotionBean promotionBean){
		String view="search_promotions";
		if(promotionBean.getAction().isEmpty()){
			model.addAttribute("promotion_bean", promotionBean);
			view="search_promotions";
		}
		return view;
	}

	@RequestMapping(value="/fetchsearch",method=RequestMethod.POST)
	public String getSerachPromotions(Model model,@ModelAttribute PromotionBean promotionBean){
		String view="search_promotions";
		System.out.println("okokoko"+" "+promotionBean.getAction());
		if(promotionBean.getAction().isEmpty()){
			model.addAttribute("promotion_bean", promotionBean);
			view="search_promotions";
		}else if(promotionBean.getAction().equalsIgnoreCase("search")){
			promotionBean=(PromotionBean) promotionService.search(promotionBean);
			if(promotionBean.getResponseStatus()!=null && !promotionBean.getResponseStatus().equalsIgnoreCase("error")){
				promotionBean.setAction("search_result");
				model.addAttribute("promotion_bean_result",promotionBean);
				model.addAttribute("promotion_bean",new PromotionBean());
				view="search_promotions";
			}
			model.addAttribute("promotion_bean",promotionBean);
			view="promotion_action";
		}

		return view;
	}
}
