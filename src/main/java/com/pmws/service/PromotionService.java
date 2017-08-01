package com.pmws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmws.dao.PromotionDao;
@Service("promotionService")
public class PromotionService<PromotionBean> implements GenericService<PromotionBean>{
	
@Autowired
@Qualifier("promotionDao")
PromotionDao<PromotionBean> promotionDao;
	
	public PromotionBean add(Object obj) {
		return promotionDao.add((PromotionBean) obj);
	}

	public PromotionBean update(Object obj) {
		return promotionDao.update((PromotionBean) obj);
	}

	public PromotionBean remove(Object obj) {
		return promotionDao.remove((PromotionBean) obj);
	}

	public PromotionBean getAll(Object obj) {
		return promotionDao.getAll((PromotionBean) obj);
	}

	public PromotionBean get(Object obj) {
		return promotionDao.get((PromotionBean) obj);
	}
	
	public PromotionBean search(Object obj) {
		return promotionDao.search((PromotionBean) obj);
	}
	
	public PromotionBean updateReviewStatus(Object obj) {
		return promotionDao.updateReviewStatus((PromotionBean) obj);
	}

}
