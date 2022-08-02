package net.guides.springboot2.springboot2jpacrudexample.manager;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.guides.springboot2.springboot2jpacrudexample.Response;
import net.guides.springboot2.springboot2jpacrudexample.dto.EmployeeDTO;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.mapper.EmployeeMapper;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeDAO;

@Component
public class EmployeeManager {

	
	// autowired of EmployeeDAO dao means there is no need to create object for EmployeeDAO class with new keyword it automaticall 
	// create it and we just have to annotate EmployeeDAO with spring annotation like @repository
	
	// DTO is getter and setter class 
	
	// Client communicate with controller class in the form of DTO objects
	// Controller tell the manager to communicate with DAO layer for data 
	// Manager ask Mapper to get the data
	// mapper calls DAO to get the data and finally DAO interact with database using JPA to get the relevant data
	// ** All business logic , getting the dao , converting it to DTO is the responsibility of Manager Class
	
	@Autowired
	private EmployeeDAO dao;
	

	
	public  List<EmployeeDTO> getMeAllEmployees() {
		//get data from dao - manager gets the data from DAO, which is a JPA interface and we use inbuild JPA functions like findAll 
		List<Employee> list = dao.findAll();
		List<EmployeeDTO> dtos = new LinkedList<>();
		//mapping DAO to dto ** now dao need to be converted in DTO form as we need to return it to controller which understand only DTO
		// form
		for(Employee e : list) {
			dtos.add(EmployeeMapper.toEmployeeDTO(e));
		}
		return dtos;	
	}
	
	public  EmployeeDTO getEmployeeByID(long id) {
		//get data from dao
		Optional<Employee> e = dao.findById(id);
		if(e.isPresent()) {
			return EmployeeMapper.toEmployeeDTO(e.get());
		}
		throw new ResourceNotFoundException("Employee with id : "+id+" not found");
		
	}
	
	public  Response deleteEmployeeByID(long id) {
		//get data from dao
		Optional<Employee> e = dao.findById(id);
		if(e.isPresent()) {
			 dao.delete(e.get());
			 return new Response("Succesfully Deleted ID : "+ id);
		}
		throw new ResourceNotFoundException("Employee with id : "+id+" not found");
	}
	
	public  EmployeeDTO createEmployee(EmployeeDTO empDto) {
		 Employee e = dao.save(EmployeeMapper.toEmployeeModel(empDto));
		//Employee e = dao.save(emp);
		 
		 // this is to return created or saved json in db
		return EmployeeMapper.toEmployeeDTO(e);
	}
	
}
