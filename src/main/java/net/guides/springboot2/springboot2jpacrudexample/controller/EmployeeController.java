package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.Response;
import net.guides.springboot2.springboot2jpacrudexample.dto.EmployeeDTO;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.manager.EmployeeManager;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	
	/*
	 * 
	 */
	
	
	@Autowired
	private EmployeeManager employeeManager;
	
	//@Autowired
	//private JpaRepository<Employee, Long> employeeRepository;
	//controller communicate in the form of DTO only because it understand DTO only
	// ** controller call the manager to get the DTO and DTO functions mail logic is written in manager class only
	// ** 
	
	
	@GetMapping("/employees")
	public List<EmployeeDTO> getAllEmployees() {
		return employeeManager.getMeAllEmployees(); // 
	}

	@GetMapping("/employees/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable(value = "id") Long employeeId) {
		return employeeManager.getEmployeeByID(employeeId);
	}
	
	@PostMapping("/employees") 
	public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO employee) {
		return employeeManager.createEmployee(employee); 
	}
	
	@DeleteMapping("/employees/{id}") 
	  Response deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException 
	{ 
		return employeeManager.deleteEmployeeByID(employeeId);
	
	}
	
	
	/*
	 * @GetMapping("/employees/{id}") public ResponseEntity<Employee>
	 * getEmployeeById(@PathVariable(value = "id") Long employeeId) throws
	 * ResourceNotFoundException { Employee employee =
	 * employeeRepository.findById(employeeId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found for this id :: " +
	 * employeeId)); return ResponseEntity.ok().body(employee); }
	 * 
	 * @PostMapping("/employees") public Employee createEmployee(@Valid @RequestBody
	 * EmployeeDTO employee) { return employeeRepository.save(employee); }
	 * 
	 * @PutMapping("/employees/{id}") public ResponseEntity<Employee>
	 * updateEmployee(@PathVariable(value = "id") Long employeeId,
	 * 
	 * @Valid @RequestBody Employee employeeDetails) throws
	 * ResourceNotFoundException { Employee employee =
	 * employeeRepository.findById(employeeId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found for this id :: " +
	 * employeeId));
	 * 
	 * employee.setEmailId(employeeDetails.getEmailId());
	 * employee.setLastName(employeeDetails.getLastName());
	 * employee.setFirstName(employeeDetails.getFirstName()); final Employee
	 * updatedEmployee = employeeRepository.save(employee); return
	 * ResponseEntity.ok(updatedEmployee); }
	 * 
	 * @DeleteMapping("/employees/{id}") public Map<String, Boolean>
	 * deleteEmployee(@PathVariable(value = "id") Long employeeId) throws
	 * ResourceNotFoundException { Employee employee =
	 * employeeRepository.findById(employeeId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Employee not found for this id :: " +
	 * employeeId));
	 * 
	 * employeeRepository.delete(employee); Map<String, Boolean> response = new
	 * HashMap<>(); response.put("deleted", Boolean.TRUE); return response; }
	 */
}
