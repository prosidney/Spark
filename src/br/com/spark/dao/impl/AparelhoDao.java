package br.com.spark.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.spark.dao.AbstractDao;
import br.com.spark.dao.GenericDao;
import br.com.spark.model.Aparelho;

@Repository("aparelhoDao")
public class AparelhoDao extends AbstractDao<Aparelho> implements GenericDao<Aparelho> {

	public AparelhoDao() {
		super(Aparelho.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public Aparelho findById(Integer id) {
		return (Aparelho) sessionFactory.getCurrentSession()
					.getNamedQuery("Aparelho.findById")
					.setParameter("id", id).uniqueResult();
	}

	public Aparelho findById(String aparelhoId) {
		return findById(Integer.valueOf(aparelhoId));
	}
}
