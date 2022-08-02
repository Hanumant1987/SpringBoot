package net.guides.springboot2.springboot2jpacrudexample.mapper;

import net.guides.springboot2.springboot2jpacrudexample.dto.EmployeeDTO;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

/*
 * mapper just convert DTO to Model and Model to DTO so we can use them in controller as controller understands only DTO  
 * 
 */


public class EmployeeMapper {

	
	public static EmployeeDTO toEmployeeDTO(Employee e) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmailId(e.getEmailId());
		dto.setId(e.getId());
		dto.setFirstName(e.getFirstName());
		dto.setLastName(e.getLastName());
		return dto;
	}
	
	public static Employee toEmployeeModel(EmployeeDTO e) {
		Employee model = new Employee();
		model.setEmailId(e.getEmailId());
		model.setFirstName(e.getFirstName());
		model.setLastName(e.getLastName());
		return model;
	}
}
