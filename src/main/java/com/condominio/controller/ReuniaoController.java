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

import com.condominio.model.Reuniao;
import com.condominio.service.ReuniaoService;

@Controller
@RequestMapping("/reuniao")
public class ReuniaoController {
	
	
	private static final String INDEX="CadastroReuniao";
	
	@Autowired
	ReuniaoService reuniaoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Reuniao reuniao){
		
		ModelAndView mv = new ModelAndView(INDEX);
		
		return mv;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvaReuniao(@Validated Reuniao reuniao,Errors errors,RedirectAttributes attributes){
		
		ModelAndView mv = new  ModelAndView(INDEX);
		
		if(errors.hasErrors()){
			
			return  INDEX;
		}
		
		reuniaoService.salvar(reuniao);
		
		attributes.addFlashAttribute("mensagem","Reunião salva com sucesso!!");
		
		return "redirect:/reuniao/novo";
		
	}
	
	
	@RequestMapping(value="{codigo}",method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo){
		
		reuniaoService.delete(codigo);
		return "redirect:/reuniao";
		
	}
	
	

	@RequestMapping
	public ModelAndView pesquisar(){
		
		
		
		ModelAndView mv = new ModelAndView("PesquisaDeReunioes");
		mv.addObject("reunioes",reuniaoService.listar());
		
		return mv;
	}
	
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Reuniao reuniao){
		
		//Unidades unidade=condominios.findOne(codigo);
		ModelAndView mv= new ModelAndView("CadastroReuniao");
		
		mv.addObject(reuniao);
		return mv;
	}


}
