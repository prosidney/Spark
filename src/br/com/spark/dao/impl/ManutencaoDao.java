package br.com.spark.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.spark.dao.AbstractDao;
import br.com.spark.dao.GenericDao;
import br.com.spark.model.Manutencao;

@Repository("manutencaoDao")
public class ManutencaoDao extends AbstractDao<Manutencao> implements GenericDao<Manutencao> {

	public ManutencaoDao() {
		super(Manutencao.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public Manutencao findById(Integer id) {
		return (Manutencao) sessionFactory.getCurrentSession()
				.getNamedQuery("Manutencao.findById")
				.setParameter("id", id).uniqueResult();
	}

	public Manutencao findById(String id) {
		return findById(Integer.valueOf(id));
	}
}
