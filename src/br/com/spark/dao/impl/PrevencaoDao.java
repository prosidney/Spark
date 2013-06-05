package br.com.spark.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import br.com.spark.dao.AbstractDao;
import br.com.spark.dao.GenericDao;
import br.com.spark.model.Prevencao;

@SuppressWarnings("unchecked")
@Repository("prevencaoDao")
public class PrevencaoDao extends AbstractDao<Prevencao> implements GenericDao<Prevencao> {
	private static final Logger log =  Logger.getLogger(PrevencaoDao.class.getName());

	public PrevencaoDao() {
		super(Prevencao.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Prevencao findById(Integer id) {
		return (Prevencao) sessionFactory.getCurrentSession()
				.getNamedQuery("Prevencao.findById")
				.setParameter("id", id).uniqueResult();
	}
	
	public Prevencao findById(String id) {
		return findById(Integer.valueOf(id));
	}
	
	@Override
	public List<Prevencao> findAll(){
		log.info("finding all " + Prevencao.class + " instances");
		return sessionFactory.getCurrentSession().createCriteria(Prevencao.class)
				.addOrder(Order.desc("id"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();		
	}
}
