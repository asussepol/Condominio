package com.condominio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.condominio.model.AreaComum;
import com.condominio.model.PresencaReuniao;
import com.condominio.model.ReservaAreaComum;
import com.condominio.model.Unidades;
import com.condominio.repository.AreaComuns;
import com.condominio.repository.Condominios;
import com.condominio.service.ReservaAreaComumService;

@Controller
@RequestMapping("/reservaAreaComum")
public class ReservaAreaComumController {
	
	
	
	@Autowired
	ReservaAreaComumService reservaAreaComumService;
	
	@Autowired
	Condominios condominios;
	
	@Autowired
	AreaComuns areaComuns;
	
	private static  final String INDEX="CadastroReservaAreaComum";
	
	@RequestMapping("/novo")
	public ModelAndView novo(ReservaAreaComum reservaAreacomum){
		
		ModelAndView mv = new ModelAndView(INDEX);
		return mv;
		
	}
	
	
	
	@ModelAttribute("unidade")
	public List<Unidades> todasUnidades(){
		
		return condominios.findAll();
	}
	
	
	@ModelAttribute("areaComum")
	public List<AreaComum> todaReunioes() {

		return areaComuns.findAll();
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvaPresenca(@Validated ReservaAreaComum reservaAreaComum,Errors errors,Long idAreaComum,Long idUnidade,RedirectAttributes attributes){
		
		
		if(errors.hasErrors()){
			
			return INDEX;
		}
		
		AreaComum areaComum= areaComuns.findOne(idAreaComum);
		Unidades unidade= condominios.findOne(idUnidade);
		
		ModelAndView mv = new  ModelAndView(INDEX);
		
		reservaAreaComum.setAreaComum(areaComum);
		reservaAreaComum.setUnidades(unidade);
		reservaAreaComumService.salvar(reservaAreaComum);
		attributes.addFlashAttribute("mensagem","Reserva Área Comum salva com sucesso!!!");
		
		
		return "redirect:/reservaAreaComum/novo";
	}
	
	
	@RequestMapping
	public ModelAndView pesquisar(){
		
		
		
		ModelAndView mv = new ModelAndView("PesquisaReservaAreaComum");
		mv.addObject("reserva",reservaAreaComumService.listar());
		
		return mv;
	}
	
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") ReservaAreaComum reservaAreaComum){
		
		//Unidades unidade=condominios.findOne(codigo);
		ModelAndView mv= new ModelAndView(INDEX);
		mv.addObject(reservaAreaComum);
		
		return mv;
	}
	
	@RequestMapping(value="{codigo}",method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo){
		
		reservaAreaComumService.delete(codigo);
		return "redirect:/reservaAreaComum";
		
	}
	

}
