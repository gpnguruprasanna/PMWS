package com.pmws.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class HibernateDao{
	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session currentSession() {
		return  sessionFactory.getCurrentSession();
	}
}
