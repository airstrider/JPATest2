package com.airstrider.controller;

import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airstrider.entity.Department;
import com.airstrider.entity.Employee;
import com.airstrider.entity.Project;
import com.airstrider.service.ICommonService;
import com.airstrider.service.impl.CommonService;
import com.airstrider.util.ModelMapUtil;
import com.airstrider.util.TestEntityGenerator;
@Controller
@RequestMapping("/company")
//@Path("/company")
public class CommonController {
	public static Logger logger = Logger.getLogger(CommonController.class.getName());
	//Property
	ApplicationContext context;
	ICommonService service;
	TestEntityGenerator testData;

	Object result;
	String resultMessage;
	Integer resultId;
	String resultName;
	
	//Methods
	@RequestMapping(value="/findById/{category}/{id}", method=RequestMethod.GET)
	public String findById(@PathVariable("category") String category, @PathVariable("id") Integer id, ModelMap modelMap) {
		System.out.println("* CommonController.findById() start *");
		logger.fatal("log4j:logger.fatal()");
		logger.error("log4j:logger.error()");
		logger.warn("log4j:logger.warn()");
		logger.info("log4j:logger.info()");
		logger.debug("log4j:logger.debug()");
		logger.trace("log4j:logger.trace()");
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		service = (CommonService)context.getBean("commonService");		//no AOP
		service = (CommonService)context.getBean("commonServiceProxy");	//AOP

		//1. Parse the request data
		if (category.equals("department")) {
			Department dept = new Department();
			dept.setId(id);
			result = service.findById(dept);
		} else if (category.equals("employee")){
			Employee emp = new Employee();
			emp.setId(id);
			result = service.findById(emp);
		} else if (category.equals("project")) {
			Project pjt = new Project();
			pjt.setId(id);
			result = service.findById(pjt);
		} else {
			System.err.println("* No the category found *");
		}
		
		ModelMapUtil.setModelMap(result, modelMap);

		System.out.println("* CommonController.findById() end *");
		return "list2";
	}
	
	@RequestMapping(value="/batchDepartmentSave", method=RequestMethod.POST)
//	public @ResponseBody ArrayList<Department> batchDepartmentSave(@RequestBody ArrayList<Department> department) {
	public @ResponseBody Object batchDepartmentSave(@RequestBody Object department) {
		System.out.println("* CommonController.batchDepartmentSave() start *");

		context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		service = (CommonService)context.getBean("commonService");		//no AOP
		service = (CommonService)context.getBean("commonServiceProxy");	//AOP

		//1. Set a map object included data for persistence
//		Map<String, ArrayList<Department>> persistMap = new HashMap<String, ArrayList<Department>>();
		Map<String, Object> persistMap = new HashMap<String, Object>();
		persistMap.put("dept", department);

		//2. Execute the persistence work
		service.batchSave(persistMap);

		System.out.println("* CommonController.batchDepartmentSave() end *");
		return department;
	}

	@RequestMapping(value="/batchEmployeeSave", method=RequestMethod.POST)
	public @ResponseBody Object batchEmployeeSave(@RequestBody Object employee) {
		System.out.println("* CommonController.batchEmployeeSave() start *");

		context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		service = (CommonService)context.getBean("commonService");		//no AOP
		service = (CommonService)context.getBean("commonServiceProxy");	//AOP

		//1. Set a map object included data for persistence
		Map<String, Object> persistMap = new HashMap<String, Object>();
		persistMap.put("emp", employee);

		//2. Execute the persistence work
		service.batchSave(persistMap);

		System.out.println("* CommonController.batchEmployeeSave() end *");
		return employee;
	}

	@RequestMapping(value="/batchProjectSave", method=RequestMethod.POST)
	public @ResponseBody Object batchProjectSave(@RequestBody Object project) {
		System.out.println("* CommonController.batchProjectSave() start *");

		context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		service = (CommonService)context.getBean("commonService");		//no AOP
		service = (CommonService)context.getBean("commonServiceProxy");	//AOP

		//1. Set a map object included data for persistence
		Map<String, Object> persistMap = new HashMap<String, Object>();
		persistMap.put("pjt", project);

		//2. Execute the persistence work
		service.batchSave(persistMap);

		System.out.println("* CommonController.batchProjectSave() end *");
		return project;
	}

//	@RequestMapping(value="/batchSave", method=RequestMethod.GET)
//	public String batchSave(ModelMap modelMap) {
//		System.out.println("* CommonController.batchSave() start *");
//
//		context = new ClassPathXmlApplicationContext("applicationContext.xml");
////		service = (CommonService)context.getBean("commonService");		//no AOP
//		service = (CommonService)context.getBean("commonServiceProxy");	//AOP
//
//		//1. Set a map object included data for persistence
//		Map<String, Object> persistMap = new HashMap<String, Object>();
//		testData = new TestEntityGenerator();
//		persistMap.put("dept", testData.setPersistDepartmentEntity());
//		persistMap.put("emp", testData.setPersistEmployeeEntity());
//		persistMap.put("pjt", testData.setPersistProjectEntity());
//
//		//2. Execute the persistence work
//		service.batchSave(persistMap);
//
//		//3. Return the result to a JSP page
//		modelMap.addAttribute("result", "Saving a batch data complete.");
//
//		System.out.println("* CommonController.batchSave() end *");
//		return "list2";
//	}

	@RequestMapping(value="/batchUpdate", method=RequestMethod.POST)
	public @ResponseBody Employee batchUpdate(@RequestBody Employee employee) {
		System.out.println("* CommonController.batchUpdate() start *");

		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		service = (CommonService)context.getBean("commonService");		//no AOP
		service = (CommonService)context.getBean("commonServiceProxy");	//AOP

		//1. Set a map object included data for update
		Map<String, Object> updateMap = new HashMap<String, Object>();
		testData = new TestEntityGenerator();
//		updateMap.put("emp", testData.setUpdateEntity());
		updateMap.put("emp", employee);

		//2. Execute the update work
		service.batchUpdate(updateMap);

		System.out.println("* CommonController.batchUpdate() end *");
		return employee;
	}

/*
	@RequestMapping(value="/batchUpdate", method=RequestMethod.GET)
	public String batchUpdate(ModelMap modelMap) {
		System.out.println("* CommonController.batchUpdate() start *");

		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		service = (CommonService)context.getBean("commonService");		//no AOP
		service = (CommonService)context.getBean("commonServiceProxy");	//AOP

		//1. Set a map object included data for update
		Map<String, Object> updateMap = new HashMap<String, Object>();
		testData = new TestEntityGenerator();
		updateMap.put("emp", testData.setUpdateEntity());

		//2. Execute the update work
		service.batchUpdate(updateMap);

		//3. Return the result to a JSP page
		modelMap.addAttribute("result", "Updating the batch data complete.");

		System.out.println("* CommonController.batchUpdate() end *");
		return "list2";
	}
*/
	
}
