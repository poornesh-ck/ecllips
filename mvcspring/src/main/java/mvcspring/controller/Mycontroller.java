package mvcspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.w3c.dom.views.AbstractView;
@Controller
public class Mycontroller  extends AbstractAnnotationConfigDispatcherServletInitializer{
	@RequestMapping("/index")
	public ModelAndView returnname(String uname) {
//		System.out.println(uname);
		ModelAndView mv=new ModelAndView();
		mv.addObject("uname" ,uname);
		mv.setViewName("display.jsp");
		return mv;
		
		
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
