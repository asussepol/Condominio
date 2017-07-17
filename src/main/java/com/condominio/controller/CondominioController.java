package com.condominio.controller;

import java.util.Arrays;
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

import com.condominio.model.AlugadoCondominio;
import com.condominio.model.InativoCondominio;
import com.condominio.model.Unidades;
import com.condominio.repository.Condominios;
import com.condominio.service.UnidadesService;


@Controller
@RequestMapping("/unidades")
public class CondominioController {
	
	private static final String CADASTRO_VIEW= "CadastroCondominio";
	
	@Autowired
	private Condominios condominios;
	
	@Autowired
	private UnidadesService unidadesService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		
		
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		//mv.addObject("todosOsAlugados",AlugadoCondominio.values());
		//mv.addObject("todosOsInativos", InativoCondominio.values());
		mv.addObject(new Unidades());
		return mv;
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(@Validated Unidades unidades, Errors errors){
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		
		if(errors.hasErrors()){
			
			return CADASTRO_VIEW;
		}
		condominios.save(unidades);
		
		mv.addObject("mensagem","Unidade Salva com Sucesso!!!");
		
		
		return "redirect:/unidades/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){
		
		//List<Unidades> todasUnidades = condominios.findAll();
		
		ModelAndView mv = new ModelAndView("PesquisaUnidades");
		mv.addObject("unidades",unidadesService.todasUnidades());
		
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Unidades unidade){
		
		//Unidades unidade=condominios.findOne(codigo);
		ModelAndView mv= new ModelAndView("CadastroCondominio");
		mv.addObject(unidade);
		return mv;
	}
	
	@RequestMapping(value="{codigo}",method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo){
		
		condominios.delete(codigo);
		return "redirect:/unidades";
		
	}
	
	@ModelAttribute("todosOsAlugados")
	public List<AlugadoCondominio> todosAlugados(){
		
		return Arrays.asList(AlugadoCondominio.values());
	}
	
	@ModelAttribute("todosOsInativos")
	public List<InativoCondominio> todosInativos(){
		
		return Arrays.asList(InativoCondominio.values());
	}

}
