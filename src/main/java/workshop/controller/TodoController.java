package workshop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class TodoController {
	
	
	@Autowired
	public ResourceBundleMessageSource message;
	
	
	@RequestMapping("/normal")
	public ModelAndView carregarIndex(RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("index");
		
		
		mv.addObject("todoList", new ArrayList<>());
		
		return mv;
		
	}
	
	@RequestMapping("/redirect")
	public ModelAndView rcarregarIndex(RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView("index");
		
		
		mv.addObject("todoList", new ArrayList<>());
		
		//return mv;
		
		attributes.addFlashAttribute("mensagem","Redirecionou");
		return new ModelAndView("redirect:/teste/");
	}
	
	
	//@RequestMapping(value="/marca", method=RequestMethod.POST)
	@RequestMapping("/teste")
	public ModelAndView redirecionarPagina(){
		
		
		ModelAndView mv = new ModelAndView("index");
		
		
		return mv;
	}
	
	
	
	@RequestMapping(value="/REQUISITAR", produces = {MediaType.APPLICATION_JSON_VALUE},
			 method=RequestMethod.GET)
	public @ResponseBody String listarPdvsGestor(HttpServletResponse response) throws IOException{
		
		
		return "REST GET";
	}
	
	
	@RequestMapping(value="/POSTAR", consumes = MediaType.APPLICATION_JSON_VALUE,produces = {MediaType.APPLICATION_JSON_VALUE},
			 method=RequestMethod.POST)
	public @ResponseBody String listarSetores(@RequestBody String teste) throws IOException{
		return teste;
	}
}
