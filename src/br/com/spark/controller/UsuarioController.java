package br.com.spark.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.spark.model.Usuario;
import br.com.spark.util.Util;

@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UsuarioController extends BaseController{
	
	@Transactional(readOnly=true)
	@RequestMapping(value="addUsuario.do", method=RequestMethod.GET)
	public String showPageAdd(Map model, HttpServletRequest request, HttpSession session){
		request.setAttribute("perfis", perfilDao.findAll());
		
		Usuario novoUsuario = new Usuario();
		
		model.put("usuario", novoUsuario);
		return "addUsuario";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="editUsuario.do", method=RequestMethod.GET)
	public String showPageEdit(Map model, HttpServletRequest request, HttpSession session){
		request.setAttribute("perfis", perfilDao.findAll());
		
		String usuarioId = request.getParameter("usuarioId");
		Usuario usuario = usuarioDao.findById(Integer.valueOf(usuarioId));
		
		model.put("usuario", usuario);
		return "addUsuario";
	}
	
	@Transactional
	@RequestMapping(value="saveUsuario.do", method=RequestMethod.POST)
	public String save(@Valid Usuario usuario, BindingResult result,
			 Map model,HttpSession session, HttpServletRequest request) throws Exception{
		Util util = new Util();
		String passEncrypted = util.createMD5(usuario.getSenha());
		usuario.setSenha(passEncrypted);
		
		usuarioDao.save(usuario);
		
		recarregarDados(request);
		
		return "listUsuarios";
	}
	
	@Transactional
	@RequestMapping(value="removeUsuario.do", method=RequestMethod.GET)
	public String delete(Usuario usuario, BindingResult result, Map model,HttpSession session, HttpServletRequest request) throws Exception{
		String usuarioId = request.getParameter("usuarioId");
		
		Usuario usuarioRemove = usuarioDao.findById(Integer.valueOf(usuarioId));
		usuarioDao.delete(usuarioRemove);
		
		recarregarDados(request);
		
		return "listUsuarios";
	}	
	
	@Transactional(readOnly=true)
	@RequestMapping(value="listUsuarios.do", method=RequestMethod.GET)
	public String showPageList(HttpServletRequest request, HttpSession session){
		request.setAttribute("usuarios", usuarioDao.findAll());
		
		return "listUsuarios";
	}
}
