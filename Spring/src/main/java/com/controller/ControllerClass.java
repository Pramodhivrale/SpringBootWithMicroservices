package com.controller;

import java.util.List;
import com.req.SearchReqData;
import com.entity.EntityClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletResponse;
import com.service.ServiceClass;
@Controller
public class ControllerClass 
{
	@Autowired
	private ServiceClass service;
	
	public void getPdf(HttpServletResponse response) throws Exception
	{
		service.getPdf(response);
	}
	
	
	@GetMapping("/excel")
	public void getExcelData( HttpServletResponse response) throws Exception 
	{
		 response.setContentType("application/vnd.ms-excel");
		 response.setHeader("Content-Disposition", "attachment; filename=plans.xls");
		 service.getExcel(response);
		
	}
	@GetMapping("/search")
	public String getAllData(SearchReqData searchReqData,Model model)
	{
		List<EntityClass> citizens = service.getAllData(searchReqData);
		model.addAttribute("citizens", citizens);
		model.addAttribute("searchForm", searchReqData);
		init(model);
		return "index";
	}
	
	@GetMapping("/")
	public String loadFrom(Model model)
	{
		model.addAttribute("searchForm", new SearchReqData());
		init(model);
		return"index";
		
	}

	private void init(Model model) {
		
		model.addAttribute("planNames", service.getPlanNames());
		model.addAttribute("planStatuses", service.getPlanStatus());
	}

}
