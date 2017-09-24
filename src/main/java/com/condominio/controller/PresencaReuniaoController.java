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

import com.condominio.model.Ocorrencia;
import com.condominio.model.PresencaReuniao;
import com.condominio.model.Reuniao;
import com.condominio.model.Unidades;
import com.condominio.repository.Condominios;
import com.condominio.repository.PresencaReunioes;
import com.condominio.repository.Reunioes;
import com.condominio.service.PresencaReunioesService;

@Controller
@RequestMapping("/presencaReuniao")
public class PresencaReuniaoController {
	
	
	@Autowired
	private PresencaReunioes presencaReunioes;
	
	@Autowired
	private PresencaReunioesService presencaReunioesService;
	
	@Autowired
	private Reunioes reunioes;
	
	@Autowired
	private Condominios condominios;
	
	private static final String INDEX="CadastroPresencaReuniao";
	
	@RequestMapping("/novo")
	public ModelAndView novo(PresencaReuniao presencaReuniao) {

		ModelAndView mv = new ModelAndView(INDEX);
		
		mv.addObject(presencaReuniao);
		
		return mv;
	}
	
	
	
	@ModelAttribute("unidade")
	public List<Unidades> todasUnidades(){
		
		return condominios.findAll();
	}
	
	
	@ModelAttribute("reuniao")
	public List<Reuniao> todaReunioes() {

		return reunioes.findAll();
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvaPresenca(@Validated PresencaReuniao presencaReuniao,Errors errors,Long idReuniao,Long idUnidade,RedirectAttributes attributes){
		
		if(errors.hasErrors()){
			
			
			return INDEX;
		}
		
		Reuniao reuniao= reunioes.findOne(idReuniao);
		Unidades unidade= condominios.findOne(idUnidade);
		
		ModelAndView mv = new  ModelAndView("CadastroPresencaReuniao");
		
		presencaReuniao.setReuniao(reuniao);
		presencaReuniao.setUnidades(unidade);
		presencaReunioesService.salvar(presencaReuniao);
		attributes.addFlashAttribute("mensagem","Presença de Reuniao salva com sucesso!!!");
		
		
		return "redirect:/presencaReuniao/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){
		
		
		
		ModelAndView mv = new ModelAndView("PesquisaPresencaReunioes");
		mv.addObject("presenca",presencaReunioesService.listar());
		
		return mv;
	}
	
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") PresencaReuniao presencaReuniao){
		
		//Unidades unidade=condominios.findOne(codigo);
		ModelAndView mv= new ModelAndView("CadastroPresencaReuniao");
		mv.addObject(presencaReuniao);
		
		return mv;
	}
	
	
	@RequestMapping(value="{codigo}",method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo){
		
		presencaReunioesService.delete(codigo);
		return "redirect:/presencaReuniao";
		
	}


}
