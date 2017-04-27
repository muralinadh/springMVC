package com.murali.logistics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.murali.ProjectService;
import com.murali.logistics.model.Logistics;

@Controller
public class LogisticsController {
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/findAll")
	public ModelAndView displayAllLogisticsDetails(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("alllogistics");
		
		mv.addObject("listLogistics",projectService.getAllLogistics());
		return mv;
		
	}
	
	@RequestMapping(value="/show")
	@ResponseBody
	public String getShow(){
		return "Hello Spring MVC!!";
	}
	
	@RequestMapping(value="/index")
	//@ResponseBody
	public String getIndex(){
		return "index";
	}
	
	/*
	 * URI Template Example
	 * @PathVariable recognize the value given in URL
	 * Variable Name and URI template name should be same or else need to be mapped as below
	 */
	@RequestMapping(value="/index/{logName}")
	//public String getIndex(@PathVariable String logName){/* With same variable name as URI template name*/
	public ModelAndView getIndex(@PathVariable(value="logName") String logNameMurali){
//		System.out.println("You Sent : "+ logNameMurali);
		
		ModelAndView mV = new ModelAndView();
		
		mV.setViewName("index");
		mV.addObject("logisticsName",logNameMurali);
		
		return mV;
	}
	
	/* Above two methods are differentiated only by the responsebody... */
	
	@RequestMapping(value="/findlogistic/{logLogistic}")
	public ModelAndView findLogistic(@PathVariable(value="logLogistic") String logisticId){
		
		Logistics logistics1 = new Logistics(101,"HathWay",45.4f);
		Logistics logistics2 = new Logistics(102,"Amazon",55.4f);
		Logistics logistics3 = new Logistics(103,"FlipKart",65.4f);
		Logistics logisticsDef = new Logistics(100,"TechM",165.4f);
		
		ModelAndView mV = new ModelAndView();
		mV.setViewName("findLogistic");
		
		switch (Integer.parseInt(logisticId)) {
		case 101:
			mV.addObject("logisticData",logistics1);
			break;
		case 102:
			mV.addObject("logisticData",logistics2);
			break;
		case 103:
			mV.addObject("logisticData",logistics3);
			break;

		default:
			mV.addObject("logisticData",logisticsDef);
			break;
		}
				
		return mV;
	} 

}
