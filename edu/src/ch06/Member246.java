package ch06;

public class Member246 {
	private String name;
	private int age;
	
	public Member246() {
		System.out.println("Member246() 생성자 실행");
	}
	
	public void setName(String name) {
	}
	
	public static void main(String[] args) {
		System.out.println("main() 메서드 실행");
		new Member246();
	}

	@Override
	public String toString() {
		return "Member246 [name=" + name + ", age=" + age + "]";
	}

	
}
