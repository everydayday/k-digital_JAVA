package ch07;

public class Person {
	private String name;
	private int age;
	
	public Person() {
		// TODO Auto-generated constructor stub
		System.out.println("Person 생성자");
	}
	
	public Person(String name, int age) {
		setName(name);
		setAge(age);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}
