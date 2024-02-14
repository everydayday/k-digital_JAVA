package ch07;

public class Professor extends Person{
	private String subject;
	
	public Professor() {
		// TODO Auto-generated constructor stub
		System.out.println("Professor 생성자");
	}
	
	// Professor 생성자
	public Professor(String name, int age, String sub) {
		super(name, age);
		setSubject(sub);		
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ":" + subject;
	}
	
	

}
