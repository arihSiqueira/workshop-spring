package workshop.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {
	
	
	@RequestMapping("/")
	public ModelAndView carregarIndex(){
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("todoList", new ArrayList<>());
		
		return mv;
	}
	
}
