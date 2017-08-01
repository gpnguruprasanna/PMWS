package com.pmws.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pmws.beans.PromotionBean;
import com.pmws.dao.HibernateDao;
import com.pmws.dao.PromotionDao;
import com.pmws.entity.Promotions;
import com.pmws.util.ViewUtil;

@Repository("promotionDao")
public class PromotionDaoImpl extends HibernateDao<Promotions, Integer> implements PromotionDao<PromotionBean>{
	@Autowired
	ViewUtil viewUtil;
	public PromotionBean add(PromotionBean obj) {
		try{
			Promotions promotions=new Promotions();
			promotions.setProductId(obj.getProductId());
			promotions.setDiscount(obj.getDicount());
			if(obj.getStartDate()!=null){
				Date startdate=	viewUtil.getStringToDate(obj.getStartDate());
				promotions.setStartDate(startdate);
			}
			if(obj.getEndDate()!=null){
				Date endDate=	viewUtil.getStringToDate(obj.getEndDate());
				promotions.setEndDate(endDate);
			}
			promotions.setStatus(obj.getStatus());
			promotions.setReviewStatus("NR");
			currentSession().save(promotions);
			obj.setPromotionId(promotions.getPromotionId());
			obj.setResponseStatus("success");
			obj.setResponseMsg("Promotion  added succesfully");
		}catch(Exception e){
			obj.setErrorDesc("Error Occured while Saving new promotion in to Database");
			obj.setResponseStatus("error");
			obj.setResponseMsg("Server is not responding... please wait.... ");
		}
		return obj;
	}

	public PromotionBean remove(PromotionBean obj) {
		try{
			currentSession().createQuery("delete from Promotions a where a.promotionId='"+obj.getPromotionId()+"'").executeUpdate();
			obj.setResponseMsg(obj.getPromotionId()+" Promotions has been removed succussully.");
			obj.setResponseStatus("success");
		}catch(Exception e){
			obj.setErrorDesc("Error Occured while Saving new product in to Database");
			obj.setResponseStatus("error");
			obj.setResponseMsg("Server is not responding... please wait.... ");
		}
		return obj;
	}

	public PromotionBean get(PromotionBean obj) {
		try{
			List<Object []> listOfPromotions=currentSession().createQuery("select promotionId,productId,startDate,endDate,discount,status,reviewStatus from Promotions where promotionId="+obj.getPromotionId()).list();
			if(listOfPromotions!=null && listOfPromotions.size()>0){
				Object [] promotion=listOfPromotions.get(0);
				obj.setPromotionId((Long) promotion[0]);
				obj.setProductId((Long) promotion[1]);
				if(promotion[2]!=null){
					Date startDate=(Date) promotion[2];
					obj.setStartDate(viewUtil.getDateToString(startDate));
				}
				if(promotion[3]!=null){
					Date endDate=(Date) promotion[3];
					obj.setEndDate(viewUtil.getDateToString(endDate));
				}
				obj.setDicount((Double) promotion[4]);
				obj.setStatus((String) promotion[5]);
				obj.setReviewStatus((String) promotion[6]);
			}
		}catch(Exception e){
			obj.setResponseStatus("error");
			obj.setResponseMsg("Internal error while fetching data");
		}
		return obj;
	}

	public PromotionBean getAll(PromotionBean obj) {
		try{
			List<Object []> listOfPromotions=currentSession().createQuery("select promotionId,productId,startDate,endDate,discount,status,reviewStatus from Promotions").list();
			if(listOfPromotions!=null && listOfPromotions.size()>0){
				for(Object [] promotion:listOfPromotions){
					PromotionBean bean=new PromotionBean();
					bean.setPromotionId((Long) promotion[0]);
					bean.setProductId((Long) promotion[1]);
					if(promotion[2]!=null){
						Date startDate=(Date) promotion[2];
						bean.setStartDate(viewUtil.getDateToString(startDate));
					}
					if(promotion[3]!=null){
						Date endDate=(Date) promotion[3];
						bean.setEndDate(viewUtil.getDateToString(endDate));
					}
					bean.setDicount((Double) promotion[4]);
					bean.setStatus((String) promotion[5]);
					bean.setReviewStatus((String) promotion[6]);
					obj.getbList().add(bean);
				}

			}
		}catch(Exception e){
			e.printStackTrace();
			obj.setResponseStatus("error");
			obj.setResponseMsg("Internal error while fetching data");
		}
		return obj;
	}

	public PromotionBean update(PromotionBean obj) {
		try{
			Promotions promotions=new Promotions();
			promotions.setPromotionId(obj.getPromotionId());
			promotions.setProductId(obj.getProductId());
			promotions.setDiscount(obj.getDicount());
			if(obj.getStartDate()!=null){
				Date startdate=	viewUtil.getStringToDate(obj.getStartDate());
				promotions.setStartDate(startdate);
			}
			if(obj.getEndDate()!=null){
				Date endDate=	viewUtil.getStringToDate(obj.getEndDate());
				promotions.setEndDate(endDate);
			}
			promotions.setStatus(obj.getStatus());
			promotions.setReviewStatus("NR");
			currentSession().update(promotions);
			obj.setPromotionId(promotions.getPromotionId());
			obj.setResponseStatus("success");
			obj.setResponseMsg("Promotion  updated succesfully");
		}catch(Exception e){
			obj.setErrorDesc("Error Occured while updating new promotion in to Database");
			obj.setResponseStatus("error");
			obj.setResponseMsg("Server is not responding... please wait.... ");
		}
		return obj;
	}

	public PromotionBean search(PromotionBean obj) {
		try{
			boolean istrue=false;
			StringBuffer sb=new StringBuffer();
			sb.append("select promotionId,productId,startDate,endDate,discount,status,reviewStatus from Promotions");
			if(obj.getProductId()>0){
				istrue=true;
				sb.append(" where productId="+obj.getProductId()+" ");
			}
			if(obj.getListOfReviewStatus()!=null){
				String s[]=  (String[]) obj.getListOfReviewStatus().toArray();
				if(istrue){
					sb.append(" and reviewStatus in ("+s+") ");
				}else{
					sb.append(" where reviewStatus in ("+s+") ");
					istrue=true;
				}
			}
			if(!obj.getStartDate().isEmpty()){
				Date date=viewUtil.getStringToDate(obj.getStartDate());
				if(istrue){
					sb.append(" and startDate >="+date+"");
				}else{
					sb.append(" where  startDate >="+date+" ");
					istrue=true;
				}
			}
			if(!obj.getEndDate().isEmpty()){
				Date date=viewUtil.getStringToDate(obj.getEndDate());
				if(istrue){
					sb.append(" and endDate <="+date+"");
				}else{
					sb.append(" where  endDate <="+date+" ");
					istrue=true;
				}
			}
			List<Object []> listOfPromotions=currentSession().createQuery(sb.toString()).list();
			if(listOfPromotions!=null && listOfPromotions.size()>0){
				for(Object [] promotion:listOfPromotions){
					PromotionBean bean=new PromotionBean();
					bean.setPromotionId((Long) promotion[0]);
					bean.setProductId((Long) promotion[1]);
					if(promotion[2]!=null){
						Date startDate=(Date) promotion[2];
						bean.setStartDate(viewUtil.getDateToString(startDate));
					}
					if(promotion[3]!=null){
						Date endDate=(Date) promotion[3];
						bean.setEndDate(viewUtil.getDateToString(endDate));
					}
					bean.setDicount((Double) promotion[4]);
					bean.setStatus((String) promotion[5]);
					bean.setReviewStatus((String) promotion[6]);
					obj.getbList().add(bean);
				}

			}
		}catch(Exception e){
			e.printStackTrace();
			obj.setResponseStatus("error");
			obj.setResponseMsg("Internal error while fetching data");
		}
		return obj;
	}

	public PromotionBean updateReviewStatus(PromotionBean obj) {
		try{
			System.out.println("hjxfgshgdhdfhgfh"+"  "+obj.getReviewStatus()+"  "+obj.getPromotionId());
			currentSession().createQuery("update  Promotions a set a.reviewStatus='"+obj.getReviewStatus()+"' where a.promotionId='"+obj.getPromotionId()+"'").executeUpdate();
			obj.setResponseMsg(" Promotions has been reviewd succussully.");
			obj.setResponseStatus("success");
		}catch(Exception e){
			obj.setErrorDesc("Error Occured while Saving new product in to Database");
			obj.setResponseStatus("error");
			obj.setResponseMsg("Server is not responding... please wait.... ");
		}
		return obj;
	}


}
