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

import br.com.spark.model.Manutencao;
import br.com.spark.model.Perfil;
import br.com.spark.model.Usuario;

@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ManutencaoController extends BaseController{
	@Transactional(readOnly=true)
	@RequestMapping(value="addManut.do", method=RequestMethod.GET)
	public String showPageAdd(Map model, HttpServletRequest request, HttpSession session){
		request.setAttribute("aparelhos", aparelhoDao.findAll());
		Manutencao novaManutencao = new Manutencao();
		
		model.put("manutencao", novaManutencao);
		return "addManutencao";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="editManut.do", method=RequestMethod.GET)
	public String showPageEdit(Map model, HttpServletRequest request, HttpSession session){
		request.setAttribute("aparelhos", aparelhoDao.findAll());
		
		String manutId = request.getParameter("manutencaoId");
		Manutencao manutencao = manutencaoDao.findById(Integer.valueOf(manutId));
		
		model.put("manutencao", manutencao);
		return "addManutencao";
	}
	
	@Transactional
	@RequestMapping(value="saveManut.do", method=RequestMethod.POST)
	public String save(@Valid Manutencao manut, BindingResult result,
			 Map model,HttpSession session, HttpServletRequest request) throws Exception{
		manut.setUsuario((Usuario) request.getSession().getAttribute("usuarioLogado"));
		manutencaoDao.save(manut);
		
		recarregarDados(request);
		
		return "listManutencoes";
	}
	
	@Transactional
	@RequestMapping(value="removeManut.do", method=RequestMethod.GET)
	public String delete(Perfil product, BindingResult result,
			 Map model,HttpSession session, HttpServletRequest request) throws Exception{
		String manutId = request.getParameter("manutId");
		
		Manutencao manutDelete = manutencaoDao.findById(manutId);
		
		manutencaoDao.delete(manutDelete);
		
		recarregarDados(request);
		
		return "listManutencoes";
	}	
	
	@Transactional(readOnly=true)
	@RequestMapping(value="listManut.do", method=RequestMethod.GET)
	public String showPageList(HttpServletRequest request, HttpSession session){
		request.setAttribute("manutencoes", manutencaoDao.findAll());
		
		return "listManutencoes";
	}	
}
