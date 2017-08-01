package com.pmws.service;
/**
 *@author guruprasanna n
 */
public interface GenericService<T> {
	public T add(Object obj);
	public T update(Object obj);
	public T remove(Object obj);
	public T getAll(Object obj);
	public T get(Object obj);
}
