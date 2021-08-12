package com.emilyread.dojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emilyread.dojos.models.Dojo;
import com.emilyread.dojos.models.Ninja;
import com.emilyread.dojos.services.DojoService;
import com.emilyread.dojos.services.NinjaService;


@Controller
public class MainController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public MainController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	//create dojo
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/new.jsp";
	}
	
	@RequestMapping(value= "/dojos", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo d, BindingResult result){
		if(result.hasErrors()) {
			return "/dojos/new.jsp";
		}
		else {
			dojoService.createDojo(d);
			return "redirect:/dojos/new";
		}	
	}
	
	//create ninja
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List <Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "ninjas/new.jsp";
	}
	
	@RequestMapping(value= "/ninjas", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja n, BindingResult result){
		if(result.hasErrors()) {
			return "ninjas/new.jsp";
		}
		else {
			ninjaService.createNinja(n);
			return "redirect:/ninjas/new";
		}	
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(Model model, @PathVariable("id") Long id) {
		Dojo d = dojoService.findDojo(id);
		model.addAttribute("dojo", d);
		List<Ninja> ninjas = ninjaService.ninjasByDojo(id);
		model.addAttribute("ninjas", ninjas);
		return "dojos/show.jsp";
		
	}
}


