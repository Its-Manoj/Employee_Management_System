package EMP;

import java.io.Serializable;
@SuppressWarnings("serial")
public class EmployeeBean implements Serializable{
	
	private int id;
	private String Name, Designation, Email;
    private Double Salary;
    
    public EmployeeBean() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	
    
    
}
