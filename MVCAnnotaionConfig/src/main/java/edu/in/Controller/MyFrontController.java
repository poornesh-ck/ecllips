package edu.in.Controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyFrontController {
	@RequestMapping("/index")
	public ModelAndView viewdetails(String uname) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("uname", uname);
		mv.setViewName("index.jsp");
		return mv;
		
		
	}
//	@RequestMapping("/")
//	public ModelAndView view(String uname) {
//		ModelAndView mv=new ModelAndView("index.jsp");
//		return mv;
//		
//	}
//	
	
	

}
