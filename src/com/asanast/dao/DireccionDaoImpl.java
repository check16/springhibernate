package com.asanast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asanast.pojo.Admin;
import com.asanast.pojo.Direccion;

@Transactional
@Repository
public class DireccionDaoImpl implements DireccionDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Direccion direccion) {
		getSession().save(direccion);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Direccion> findAll(Admin admin) {
		Criteria criteria = getSession().createCriteria(Direccion.class).setFetchMode("admin", FetchMode.JOIN)
				.add(Restrictions.eq("admin.idAd", admin.getIdAd())).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@Override
	public Direccion findById(int idDireccion) {
		Criteria criteria = getSession().createCriteria(Direccion.class);
		criteria.add(Restrictions.eq("idDireccion", idDireccion));
		return (Direccion) criteria.uniqueResult();
	}

	@Override
	public void update(Direccion direccion) {
		getSession().update(direccion);
		
	}

	@Override
	public void delete(Direccion direccion) {
		getSession().delete(direccion);
		
	}

}
