package ch07;

public class LMSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee1 e = new Employee1();
		Professor p = new Professor();
		Student s = new Student();
		
		e.setName("오정임");
		e.setAge(47);
		e.setDept("입학처");
		
		p.setName("김푸름");
		p.setAge(52);
		p.setSubject("빅데이터");
		
		s.setName("김유빈");
		s.setAge(20);
		s.setMajor("컴퓨터과학");
		
//		System.out.println(e.toString());
		System.out.println(e);
		System.out.println(p.toString());
		System.out.println(s.toString());
		
		

	}

}
