package com.condominio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class Indexcontroller {
	
	
	@RequestMapping
	public ModelAndView novo(){
		
		ModelAndView mv = new ModelAndView("Index");
		return mv;
		
	}

}
