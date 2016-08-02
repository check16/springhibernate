package com.asanast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asanast.pojo.Admin;

@Transactional
@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Admin admin) {
		getSession().save(admin);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findAll() {
		Query query = getSession().createQuery( "from Admin" );
		return query.list();
	}

	@Override
	public Admin findById(int id) {
		Criteria criteria = getSession().createCriteria(Admin.class);
		criteria.add(Restrictions.eq("idAd", id));
		return (Admin) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findByNombre(String nombre) {
		Criteria criteria = getSession().createCriteria(Admin.class);
		criteria.add(Restrictions.like("nombre", "%" + nombre + "%"));
		return criteria.list();
	}

	@Override
	public void update(Admin admin) {
		getSession().update(admin);
		
	}

	@Override
	public void delete(Admin admin) {
		getSession().delete(admin);
		
	}

	

}
