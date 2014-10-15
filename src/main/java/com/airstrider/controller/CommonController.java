package com.airstrider.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airstrider.service.impl.CommonService;
import com.airstrider.util.TestEntityGenerator;

@Controller
@RequestMapping("/company")
public class CommonController {

	ApplicationContext context;
	CommonService service;
	TestEntityGenerator testData;
	ModelMap modelMap;
	
	@RequestMapping(value="/batchSave", method=RequestMethod.GET)
//	public @ResponseBody String batchSave(@RequestBody Object inputData) {
	public String batchSave(ModelMap modelMap) {
		System.out.println("* CommonController.batchSave() start *");

		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (CommonService)context.getBean("commonService");

		//1. Set a map object included data for persistence
		Map<String, Object> persistMap = new HashMap<String, Object>();
		testData = new TestEntityGenerator();
		persistMap.put("dept", testData.setPersistDepartmentEntity());
		persistMap.put("emp", testData.setPersistEmployeeEntity());
		persistMap.put("pjt", testData.setPersistProjectEntity());

		//2. Execute the persistence work
		service.batchSave(persistMap);

		//3. Return the result to a JSP page
		modelMap.addAttribute("result", "Saving a batch data complete.");

		System.out.println("* CommonController.batchSave() end *");
		return "list";
	}

	@RequestMapping(value="/batchUpdate", method=RequestMethod.GET)
	public String batchUpdate(ModelMap modelMap) {
		System.out.println("* CommonController.batchUpdate() start *");

		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (CommonService)context.getBean("commonService");

		//1. Set a map object included data for update
		Map<String, Object> updateMap = new HashMap<String, Object>();
		testData = new TestEntityGenerator();
		updateMap.put("emp", testData.setUpdateEntity());

		//2. Execute the update work
		service.batchUpdate(updateMap);

		//3. Return the result to a JSP page
		modelMap.addAttribute("result", "Updating the batch data complete.");

		System.out.println("* CommonController.batchUpdate() end *");
		return "list";
	}
}
