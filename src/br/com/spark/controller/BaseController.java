package br.com.spark.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.spark.dao.impl.AparelhoDao;
import br.com.spark.dao.impl.ManutencaoDao;
import br.com.spark.dao.impl.PerfilDao;
import br.com.spark.dao.impl.PrevencaoDao;
import br.com.spark.dao.impl.UsuarioDao;

public abstract class BaseController {
	
	@Autowired
	PerfilDao perfilDao;
	
	@Autowired
	ManutencaoDao manutencaoDao;
	
	@Autowired
	AparelhoDao aparelhoDao;
	
	@Autowired
	UsuarioDao usuarioDao;	
	
	@Autowired
	PrevencaoDao prevencaoDao;
	
	protected void recarregarDados(HttpServletRequest request){
		request.setAttribute("perfis", perfilDao.findAll());
		request.setAttribute("manutencoes", manutencaoDao.findAll());
		request.setAttribute("aparelhos", aparelhoDao.findAll());
		request.setAttribute("usuarios", usuarioDao.findAll());
		request.setAttribute("prevencoes", prevencaoDao.findAll());
	}
}
