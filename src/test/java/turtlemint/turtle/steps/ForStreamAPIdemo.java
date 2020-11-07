package turtlemint.turtle.steps;

public class ForStreamAPIdemo {
	
	String Name;
	int Age;
	String Designation;
	String Company;
	
	public ForStreamAPIdemo(String Name, int Age, String Designation, String Company) {
		this.Age=Age;
		this.Name=Name;
		this.Designation=Designation;
		this.Company=Company;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}
	
	
	

}
