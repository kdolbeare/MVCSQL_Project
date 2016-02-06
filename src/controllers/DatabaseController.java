package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.DatabaseDAO;

@Controller
public class DatabaseController 
{
	//this replaces instantiating the object every time i need to use it.
	@Autowired
	private DatabaseDAO databaseDAO;
	
	@RequestMapping(path = "select.do", params = "sqlText", method = RequestMethod.GET) 
	public ModelAndView doQuery (@RequestParam("sqlText") String s) 
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("results.jsp");
		mv.addObject("results", databaseDAO.doQuery(s));
		return mv;	
	}
	@RequestMapping(path = "update.do", params = "newInfo", method = RequestMethod.GET)
	public ModelAndView doUpdate (@RequestParam("newInfo") String n) 
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("countResults.jsp");
		mv.addObject("count", databaseDAO.doUpdate(n));
		return mv;
	}
}
