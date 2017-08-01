package com.pmws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pmws.dao.ProductDao;
/**
 *@author guruprasanna n
 */
@Service("productService")
public class ProductService<ProductBean> implements GenericService<ProductBean> {

	@Autowired
	@Qualifier("productDao")
	ProductDao<ProductBean> productDao;

	public ProductBean add(Object obj) {
		return productDao.add((ProductBean) obj);
	}

	public ProductBean update(Object obj) {
		return productDao.update((ProductBean) obj);
	}

	public ProductBean remove(Object obj) {
		return productDao.remove((ProductBean) obj);
	}

	public ProductBean getAll(Object obj) {
		return productDao.getAll((ProductBean) obj);
	}

	public ProductBean get(Object obj) {
		return productDao.get((ProductBean) obj);
	}

}
