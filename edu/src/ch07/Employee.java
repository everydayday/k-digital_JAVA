package ch07;

public class Employee extends Person {
	private String dept;
	
	public Employee(String name, int age, String dept) {
		super(name, age);
		setDept(dept);
	}
	

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ":" + dept;
	}
	
	

}
