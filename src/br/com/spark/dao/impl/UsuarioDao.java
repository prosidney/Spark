package br.com.spark.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import br.com.spark.dao.AbstractDao;
import br.com.spark.dao.GenericDao;
import br.com.spark.model.Usuario;

@Repository("usuarioDao")
public class UsuarioDao extends AbstractDao<Usuario> implements GenericDao<Usuario> {

	public UsuarioDao() {
		super(Usuario.class);
	}

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public Usuario findById(Integer id) {
		return (Usuario) sessionFactory.getCurrentSession()
				.getNamedQuery("Usuario.findById")
				.setParameter("id", id).uniqueResult();
	}
	
	public Usuario findByUsuario(String usuario, String senha) {
		return (Usuario) sessionFactory.getCurrentSession()
				.getNamedQuery("Usuario.findByUsuario")
				.setParameter("usuario", usuario).uniqueResult();
	}
	
}
