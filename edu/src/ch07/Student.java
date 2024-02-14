package ch07;

public class Student extends Person {
	private String major;
	
	public Student(String name, int age, String major) {
		super(name, age);
		setMajor(major);
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ":" + major;
	}
	
	

}
