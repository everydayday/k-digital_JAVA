package ch06;

public class Member {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Member() {
		System.out.println("Member() 생성자 실행");
		
	}
	public Member(String name) {
		System.out.println("Member(String) 생성자 실행");
		this.name = name;
	}
	public Member(String name, int age) {
		System.out.println("Member(String, int) 생성자 실행");
		System.out.println(name + " : " + age);
		this.name = name;
		this.age = age;
	}
	
	
	public static void main(String[] args) {
		System.out.println("main() 메서드 실행");
		new Member();
		new Member("Amy");
		new Member("Amy",23);
	}
	

}
