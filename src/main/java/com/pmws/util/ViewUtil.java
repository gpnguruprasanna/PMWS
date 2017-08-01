package com.pmws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmws.beans.LinksBean;

@Service("viewUtil")
@Transactional
@Async
public class ViewUtil {
	@Resource(name="sessionFactory")
	protected  SessionFactory sessionFactory;

	public List<LinksBean> getLinks(String userId){
		List<LinksBean> links=new ArrayList<LinksBean>();
		List<String>	roleIds=getCurrentUserRoles(userId);
		List<Object []> listOfLinks=sessionFactory.getCurrentSession().createQuery("select a.linkId ,a.linkName,a.url from AppLinks a").list();
		if(listOfLinks!=null && listOfLinks.size()>0){
			for(Object obj[]:listOfLinks){
				LinksBean linksBean=new LinksBean();
				linksBean.setLinkId((Long) obj[0]);
				linksBean.setLinkName((String) obj[1]);
				linksBean.setUrl((String) obj[2]);
				if(roleIds.contains("A") && (linksBean.getLinkName().equals("users")|| linksBean.getLinkName().equals("products"))){
					links.add(linksBean);
				}
				if((roleIds.contains("S") || roleIds.contains("R")) && linksBean.getLinkName().equals("promotions")){
					links.add(linksBean);
				}
			}
		}
		return links;
	}

	public List<Integer> getQuantity(){
		List<Integer> quantity=new ArrayList<Integer>();
		for(int i=0;i<50;i++){
			quantity.add(i);
		}
		return quantity;
	}

	public List<String> getCurrentUserRoles(String userId){
		List<String> listIds=new ArrayList<String>();	
		List<Object []> listOfRoles=sessionFactory.getCurrentSession().createQuery("select userId,roles from Users where userId="+Long.parseLong(userId)+" ").list();
		if(listOfRoles!=null && listOfRoles.size()>0){
			for(Object [] role:listOfRoles){
				String roles=(String) role[1];
				String s[]=roles.split(",");
				if(s!=null && s.length>1){
					for(String str:s){
						listIds.add(str);
					}
				}else {
					listIds.add(roles);
				}

			}
		}
		return listIds;
	}
	public Map<String ,String> getStatuses(){
		Map<String,String> status=new LinkedHashMap<String, String>();
		status.put("T", "Active");
		status.put("F", "Inactive");
		return status;
	}

	public Map<String ,String> getProductCategory(){
		Map<String,String> status=new LinkedHashMap<String, String>();
		status.put("L", "Laptop");
		status.put("M", "Mobile");
		return status;
	}

	public Map<String ,String> getReviewStatuses(){
		Map<String,String> status=new LinkedHashMap<String, String>();
		status.put("NR", "Not Reviewed");
		status.put("A", "Approved");
		status.put("R", "Rejected");
		return status;
	}

	public Map<Long ,String> getProducts(){
		Map<Long,String> products=new LinkedHashMap<Long, String>();
		products.put(0l, "Select Product");
		List<Object []> listOfProducts=sessionFactory.getCurrentSession().createQuery("select productId,productName,price,category,quantity from Products").list();
		if(listOfProducts!=null && listOfProducts.size()>0){
			for(Object [] product:listOfProducts){
				String categary=(String) product[3];
				products.put((Long) product[0], "Name:("+product[1]+")   "+
						"Price:("+(String)product[2].toString()+")  "+"category:("+getProductCategory().get(categary)+")  "+"quantity:("+product[4].toString()+")");
			}
		}
		return products;
	}

	public String getProductBasedOnId(String id){
		String productDetail="";
		if(!id.isEmpty()){
			List<Object []> listOfProducts=sessionFactory.getCurrentSession().createQuery("select productId,productName,price,category,quantity from Products where productId="+Long.parseLong(id)+"").list();
			if(listOfProducts!=null && listOfProducts.size()>0){
				Object [] product=listOfProducts.get(0);
				String categary=(String) product[3];
				productDetail= "Name:("+product[1]+")   "+"Price:("+(String)product[2].toString()+")  "+"category:("+getProductCategory().get(categary)+")  "+"quantity:("+product[4].toString()+")";
			}
		}
		return productDetail;
	}

	public Map<String ,String> getRoles(){
		Map<String,String> status=new LinkedHashMap<String, String>();
		status.put("A", "Admin");
		status.put("S", "submitter");
		status.put("R", "reviewer ");
		return status;
	}

	public String getCurrentViewDate(){
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
		return dt1.format(new Date());
	}

	public Date getStringToDate(String date){
		SimpleDateFormat format=new SimpleDateFormat("dd MMMM yyyy");
		Date dateformat=null;
		try {
			dateformat = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateformat;
	}
	public String getDateToString(Date date){
		SimpleDateFormat format=new SimpleDateFormat("dd MMMM yyyy");
		String stringformat=null;
		stringformat = format.format(date);
		return stringformat;
	}

	public String getRole(String id){
		return getRoles().get(id);
	}

	public boolean isCurrentUserReviewer(String userId){
		List<String> listOfRoles=getCurrentUserRoles(userId);
		return listOfRoles.contains("R");
	}



}
