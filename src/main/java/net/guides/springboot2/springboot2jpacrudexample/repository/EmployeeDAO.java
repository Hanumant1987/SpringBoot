package net.guides.springboot2.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;




// @ repository is mentioned so this class can be autowired , spring identify if a class is mentioned as @repository, bean , component and controller
// Employee over here is the Model class(getter/setter)



@Repository
public interface EmployeeDAO  extends JpaRepository<Employee, Long>{

	/*
	 * // here access model class to interact with database
	 * 
	 * public List<Employee> getAllEmployees(){ Employee e = new Employee();
	 * e.setFirstName("lavish");
	 * 
	 * 
	 * return Arrays.asList(e);
	 */
		
	
}