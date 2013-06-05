package br.com.spark.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.spark.dao.AbstractDao;
import br.com.spark.dao.GenericDao;
import br.com.spark.model.Perfil;

@Repository("perfilDao")
public class PerfilDao extends AbstractDao<Perfil> implements GenericDao<Perfil> {

	public PerfilDao() {
		super(Perfil.class);
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Perfil findById(Integer id) {
		return (Perfil) sessionFactory.getCurrentSession()
							.getNamedQuery("Perfil.findById")
							.setParameter("id", id).uniqueResult();
	}
	
	public Perfil findById(String id) {
		return findById(Integer.valueOf(id));
	}
}
