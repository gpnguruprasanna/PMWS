package com.pmws.dao;
/**
 *@author guruprasanna n
 */
public interface PromotionDao<T> extends DaoActions<T> {
public T search(T t);
public T updateReviewStatus(T t);
}
