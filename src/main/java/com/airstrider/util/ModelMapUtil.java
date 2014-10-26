package com.airstrider.util;

import org.springframework.ui.ModelMap;

import com.airstrider.entity.Department;
import com.airstrider.entity.Employee;
import com.airstrider.entity.Project;

public class ModelMapUtil {

	public static void setModelMap(Object result, ModelMap modelMap) {

		modelMap.addAttribute("result", "Retreiving the result complete.");
		if(result instanceof Department) {
			modelMap.addAttribute("id", ((Department)result).getId());
			modelMap.addAttribute("name", ((Department)result).getName());
		} else if(result instanceof Employee) {
			modelMap.addAttribute("id", ((Employee)result).getId());
			modelMap.addAttribute("name", ((Employee)result).getName());
		} else if(result instanceof Project) {
			modelMap.addAttribute("id", ((Project)result).getId());
			modelMap.addAttribute("name", ((Project)result).getProjectName());
		}		
	}
}
