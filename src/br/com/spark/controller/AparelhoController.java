package br.com.spark.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.spark.model.Aparelho;
import br.com.spark.model.Usuario;

@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class AparelhoController  extends BaseController{
	
	@Transactional(readOnly=true)
	@RequestMapping(value="listAparelhos.do", method=RequestMethod.GET)
	public String showPageList(Map model, HttpServletRequest request, HttpSession session){
		recarregarDados(request);
		
		return "listAparelhos";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="addAparelho.do", method=RequestMethod.GET)
	public String showPageAdd(Map model, HttpServletRequest request, HttpSession session){
		Aparelho novo = new Aparelho();
		novo.setUsuario((Usuario) request.getSession().getAttribute("usuarioLogado"));
		novo.setDtInclusao(new Date());
		
		model.put("aparelho", novo);
		return "addAparelho";
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="editAparelho.do", method=RequestMethod.GET)
	public String showPageEdit(Map model, HttpServletRequest request, HttpSession session){
		String aparelhoId = request.getParameter("aparelhoId");
		
		Aparelho aparelho = aparelhoDao.findById(Integer.valueOf(aparelhoId));
		
		model.put("aparelho", aparelho);
		return "addAparelho";
	}
	
	@Transactional
	@RequestMapping(value="saveAparelho.do", method=RequestMethod.POST)
	public String save(Aparelho aparelho, BindingResult result,
			 Map model,HttpSession session, HttpServletRequest request) throws Exception{
		aparelho.setUsuario((Usuario) request.getSession().getAttribute("usuarioLogado"));
		aparelhoDao.save(aparelho);
		
		recarregarDados(request);
		
		return "listAparelhos";
	}
	
	@Transactional
	@RequestMapping(value="removeAparelho.do", method=RequestMethod.GET)
	public String delete(Aparelho aparelho, BindingResult result, Map model,HttpSession session, HttpServletRequest request) throws Exception{
		String aparelhoId = request.getParameter("aparelhoId");
		
		Aparelho aparelhoRemove = aparelhoDao.findById(Integer.valueOf(aparelhoId));
		aparelhoDao.delete(aparelhoRemove);
		
		recarregarDados(request);
		
		return "listAparelhos";
	}	
}
