package ch07;

public class LMSTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Professor p = new Professor("홍길동", 32, "컴공");
		Student s = new Student("김영희", 23, "인공지능");
		Employee1 e = new Employee1("김남일", 37, "보안");
			
//		p.setName("김푸름");
//		p.setAge(52);
//		p.setSubject("빅데이터");
		
		
//		System.out.println(e.toString());
		
		// 상속 해서 toString 사용 가능
		System.out.println(p.toString());
		System.out.println(s.toString());
		System.out.println(e.toString());
		
		
		

	}

}
