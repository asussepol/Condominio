package com.condominio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.condominio.model.AreaComum;
import com.condominio.model.Reuniao;
import com.condominio.service.AreaComumService;

@Controller
@RequestMapping("/areaComum")
public class AreaComumController {
	
	
	private static final String INDEX="CadastroAreaComum";
	
	@Autowired
	private AreaComumService areaComumService;
	
	
	@RequestMapping("/novo")
	public ModelAndView novo(AreaComum areaComum){
		
		ModelAndView mv = new ModelAndView(INDEX);
		
		return mv;
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarAreaComum(@Validated AreaComum areaComum,Errors errors,RedirectAttributes attributes){
		
		if(errors.hasErrors()){
			
			return INDEX;
		}
		
		
		ModelAndView mv= new ModelAndView(INDEX);
		
		areaComumService.salvar(areaComum);
		attributes.addFlashAttribute("mensagem","Area comum  salva com sucesso!!");
		
		return "redirect:/areaComum/novo";
		
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){
		
		
		
		ModelAndView mv = new ModelAndView("PesquisaAreaComum");
		mv.addObject("area",areaComumService.listar());
		
		return mv;
	}
	
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") AreaComum areaComum){
		
		
		ModelAndView mv= new ModelAndView(INDEX);
		
		mv.addObject(areaComum);
		return mv;
	}
	

	@RequestMapping(value="{codigo}",method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo){
		
		areaComumService.delete(codigo);
		return "redirect:/areaComum";
		
	}
	

}
