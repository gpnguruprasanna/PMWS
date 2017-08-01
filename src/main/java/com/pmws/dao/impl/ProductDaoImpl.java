package com.pmws.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pmws.beans.ProductBean;
import com.pmws.dao.HibernateDao;
import com.pmws.dao.ProductDao;
import com.pmws.entity.Products;

@Repository("productDao")
public class ProductDaoImpl extends HibernateDao<Products, Integer> implements ProductDao<ProductBean> {

	public ProductBean add(ProductBean obj) {
		try{
			Products products=new Products();
			products.setProductName(obj.getProductName());
			products.setPrice(obj.getPrice());
			products.setCreatedDate(new Date());
			products.setStatus("T");
			products.setCategory(obj.getCategory());
			products.setQuantity(obj.getQuantity());
			currentSession().save(products);
			products.setProductId(products.getProductId());	
			obj.setResponseStatus("success");
			obj.setResponseMsg("Product added succesfully");
		}catch(Exception e){
			obj.setErrorDesc("Error Occured while Saving new product in to Database");
			obj.setResponseStatus("error");
			obj.setResponseMsg("Server is not responding... please wait.... ");
		}
		return obj;
	}

	public ProductBean remove(ProductBean obj) {
		try{
			System.out.println("kkkkkkkkkkkkkkcccccc"+"  "+obj.getProductId());
			currentSession().createQuery("delete from Products a where a.productId='"+obj.getProductId()+"'").executeUpdate();
			obj.setResponseMsg(obj.getProductName()+" product has been removed succussully.");
			obj.setResponseStatus("success");
		}catch(Exception e){
			obj.setErrorDesc("Error Occured while Saving new product in to Database");
			obj.setResponseStatus("error");
			obj.setResponseMsg("Server is not responding... please wait.... ");
		}
		return obj;
	}

	public ProductBean get(ProductBean obj) {
		try{
			System.out.println("bvvvvvvvvvv"+"  "+obj.getProductId());
			List<Object []> listOfProducts=currentSession().createQuery("select productId,productName,price,status,createdDate,category,quantity from Products where productId="+obj.getProductId()).list();
			if(listOfProducts!=null && listOfProducts.size()>0){
				System.out.println("bvvvvvvvvvv"+"  "+listOfProducts.size());
				Object [] product=listOfProducts.get(0);
				obj.setProductId((Long) product[0]);
				obj.setProductName((String) product[1]);
				obj.setPrice( (Double) product[2]);
				obj.setStatus((String) product[3]);
				//obj.setCreatedDate((String) product[4]);
				obj.setCategory((String) product[5]);
				obj.setQuantity((Integer) product[6]);
			}
		}catch(Exception e){
			obj.setResponseStatus("error");
			obj.setResponseMsg("Internal error while fetching data");
		}
		System.out.println("oooooooo"+"  "+obj.getAction());
		return obj;
	}

	public ProductBean getAll(ProductBean obj) {
		try{
			List<Object []> listOfProducts=currentSession().createQuery("select productId,productName,price,status,createdDate,category,quantity from Products").list();
			if(listOfProducts!=null && listOfProducts.size()>0){
				for(Object [] product:listOfProducts){
					ProductBean productBean=new ProductBean();
					productBean.setProductId((Long) product[0]);
					productBean.setProductName((String) product[1]);
					productBean.setPrice((Double) product[2]);
					productBean.setStatus((String) product[3]);
					//productBean.setCreatedDate((String) product[4]);
					productBean.setCategory((String) product[5]);
					productBean.setQuantity((Integer) product[6]);
					obj.getbList().add(productBean);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			obj.setResponseStatus("error");
			obj.setResponseMsg("Internal error while fetching data");
		}
		return obj;
	}

	public ProductBean update(ProductBean obj) {
		try{
			Products products=new Products();
			products.setProductId(obj.getProductId());
			products.setProductName(obj.getProductName());
			products.setPrice(obj.getPrice());
			//	products.setCreatedDate(new Date());
			products.setStatus(obj.getStatus());
			products.setCategory(obj.getCategory());
			products.setQuantity(obj.getQuantity());
			currentSession().update(products);
			products.setProductId(products.getProductId());	
			obj.setResponseStatus("success");
			obj.setResponseMsg("Product added succesfully");
		}catch(Exception e){
			obj.setErrorDesc("Error Occured while Saving new product in to Database");
			obj.setResponseStatus("error");
			obj.setResponseMsg("Server is not responding... please wait.... ");
		}
		return obj;
	}

}
