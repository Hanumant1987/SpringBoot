package net.guides.springboot2.springboot2jpacrudexample.dto;

// dto is the class where we set getter and setter, data transfer object. Client communicate with controller in the form of DTP
// so we create a method in controller class which return DTO


public class EmployeeDTO {

	private long id;
	private String firstName;
	private String lastName;
	private String emailId;
	
	public EmployeeDTO() {
		
	}
	
	
	// working for creating json
	
	public EmployeeDTO(String firstName, String lastName, String emailId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
}
