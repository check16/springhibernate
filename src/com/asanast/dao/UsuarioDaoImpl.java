package com.asanast.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asanast.pojo.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Usuario findByUsername(String username) {
		Criteria crit = getSession().createCriteria(Usuario.class).add(Restrictions.eq("usuario", username));
		return (Usuario) crit.uniqueResult();

	}

	@Override
	public void save(Usuario usuario) {
		getSession().save(usuario);

	}

	/*
	 * Otra forma diferente para evitar el warning del List que devuelve
	 * hibernate en su metodo list()
	 */
	@Override
	public List<Usuario> findAll() {

		Query query = getSession().createQuery("from Usuario");
		final List<Usuario> usuarios = new ArrayList<>();

		for (final Object usuario : query.list()) {
			usuarios.add((Usuario) usuario);
		}

		return usuarios;
	}
}
