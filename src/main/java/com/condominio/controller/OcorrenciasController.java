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
import com.condominio.model.Reuniao;
import com.condominio.model.Unidades;
import com.condominio.repository.Condominios;
import com.condominio.repository.Ocorrencias;
import com.condominio.service.OcorrenciasService;

@Controller
@RequestMapping("/ocorrencias")
public class OcorrenciasController {

	@Autowired
	private Ocorrencias ocorrencias;

	@Autowired
	private Condominios condominios;
	@Autowired
	private OcorrenciasService ocorrenciasService;

	@RequestMapping("/novo")
	public ModelAndView novo(Ocorrencia ocorrencia) {

		ModelAndView mv = new ModelAndView("CadastroOcorrencias");
		//mv.addObject(new Ocorrencia());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Ocorrencia ocorrencia, Errors errors, Long codigo_unidade, RedirectAttributes attributes) {
		//ModelAndView mv = new ModelAndView("CadastroOcorrencias");
		if(errors.hasErrors()){
			
			
			return "CadastroOcorrencias";
			
		}
		
		Unidades unidade = condominios.findOne(codigo_unidade);
		ocorrencia.setUnidade(unidade);
		//ModelAndView mv = new ModelAndView("CadastroOcorrencias");
		ocorrencias.save(ocorrencia);
		attributes.addFlashAttribute("mensagem","Ocorrência salva com sucesso!!");
		return "redirect:/ocorrencias/novo";

	}

	
	@RequestMapping("{codigo_ocorrencia}")
	public ModelAndView edicao(@PathVariable("codigo_ocorrencia") Ocorrencia ocorrencia){
		
		//Unidades unidade=condominios.findOne(codigo);
		ModelAndView mv= new ModelAndView("CadastroOcorrencias");
		mv.addObject(ocorrencia);
		return mv;
	}
	
	@RequestMapping(value="{codigo_ocorrencia}",method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo_ocorrencia){
		
		ocorrencias.delete(codigo_ocorrencia);
		return "redirect:/ocorrencias";
		
	}
	
	@ModelAttribute("unidad")
	public List<Unidades> todaUnidades() {

		return condominios.findAll();
	}

	@RequestMapping
	public ModelAndView pesquisar(){
		
		
		
		ModelAndView mv = new ModelAndView("PesquisaOcorrencias");
		mv.addObject("ocorrencias",ocorrenciasService.todaOcorrencias());
		
		return mv;
	}

}
