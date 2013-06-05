package br.com.spark.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.spark.dao.impl.AparelhoDao;
import br.com.spark.dao.impl.ManutencaoDao;
import br.com.spark.dao.impl.PerfilDao;
import br.com.spark.dao.impl.UsuarioDao;
import br.com.spark.model.Perfil;

@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class PerfilController extends BaseController{
	
	@Transactional(readOnly=true)
	@RequestMapping(value="addPerfil.do", method=RequestMethod.GET)
	public String showPageAdd(Map model, HttpServletRequest request, HttpSession session){
		Perfil novoPerfil = new Perfil();
		
		model.put("perfil", novoPerfil);
		return "addPerfil";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="editPerfil.do", method=RequestMethod.GET)
	public String showPageEdit(Map model, HttpServletRequest request, HttpSession session){
		String perfilId = request.getParameter("perfilId");
		
		Perfil perfil = perfilDao.findById(Integer.valueOf(perfilId));
		perfil.getUsuarios().size(); // will make hibernate initialize the collection for you instead of the proxy
		
		model.put("perfil", perfil);
		return "addPerfil";
	}
	
	@Transactional
	@RequestMapping(value="savePerfil.do", method=RequestMethod.POST)
	public String save(Perfil product, BindingResult result,
			 Map model,HttpSession session, HttpServletRequest request) throws Exception{
		perfilDao.save(product);
		
		recarregarDados(request);
		
		return "listPerfis";
	}
	
	@Transactional
	@RequestMapping(value="removePerfil.do", method=RequestMethod.GET)
	public String delete(Perfil product, BindingResult result,
			 Map model,HttpSession session, HttpServletRequest request) throws Exception{
		String perfilId = request.getParameter("perfilId");
		
		Perfil perfilDelete = perfilDao.findById(perfilId);
		
		perfilDao.delete(perfilDelete);
		
		recarregarDados(request);
		
		return "listPerfis";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="listPerfis.do", method=RequestMethod.GET)
	public String showPageList(HttpServletRequest request, HttpSession session){
		request.setAttribute("perfis", perfilDao.findAll());
		
		return "listPerfis";
	}
}
