package br.com.spark.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.spark.model.Aparelho;
import br.com.spark.model.Prevencao;

@Controller
public class HomeController extends BaseController{
	@Transactional(readOnly=true)
	@RequestMapping(value="home.do", method=RequestMethod.GET)
	public String showIndex(HttpServletRequest request,HttpServletResponse response){	
		recarregarDados(request);
		
		return "home";
	}
	
	@Transactional
	@RequestMapping(value="addPrevApar.do", method=RequestMethod.POST)
	public String addPrevencao(HttpServletRequest request,HttpServletResponse response){
		String aparPrevId = request.getParameter("aparPrevId");
		Aparelho aparelho = aparelhoDao.findById(aparPrevId);
		
		Prevencao novaPrevencao = new Prevencao();
		novaPrevencao.setInicio(new Date());
		novaPrevencao.setAparelho(aparelho);
		
		prevencaoDao.save(novaPrevencao);
		
		recarregarDados(request);
		
		return "home";
	}
	
	@Transactional
	@RequestMapping(value="stopPrev.do", method=RequestMethod.GET)
	public String stopPrevencao(HttpServletRequest request,HttpServletResponse response){
		String prevencaoId = request.getParameter("prevId");
		
		Prevencao prevencao = prevencaoDao.findById(prevencaoId);
		prevencao.setFim(new Date());
		
		prevencaoDao.save(prevencao);
		
		recarregarDados(request);
		
		return "home";
	}
	
	@RequestMapping(value="testTemplate.do", method=RequestMethod.GET)
	public String testTemplate(HttpServletRequest request,HttpServletResponse response){
		return "testTemplate";
	}
}
