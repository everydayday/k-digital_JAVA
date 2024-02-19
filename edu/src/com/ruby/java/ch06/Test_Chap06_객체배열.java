package com.ruby.java.ch06;
//하나의 java file에 Student 객체를 정의하고 구현하는 실습
/*
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */
abstract class InterfaceStudents {
	public abstract void showObject();
}
class Student extends InterfaceStudents {
 static int countStudents;//객체수
 int sid;//학번
 String sname; //학생 이름
 String city; //주소 도시
 
 static void showStudent() {
	 
 }
 
 public Student() {	// Student 상속 받은 객체 생성마다 static 변수 증가
	 countStudents ++;
 }
 
 public Student(int num) {	// 생성자 오버로딩
	 sid = num;
	 countStudents ++;
	 
 }
 
 public Student(int num, String sname, String city) {
	 this.sid = num;
	 this.sname = sname;
	 this.city = city;
	 countStudents ++;
 }

 public Student(int num, String sname) {
	 this.sid = num;
	 this.sname = sname;
	 countStudents ++;
 }
 
 public String toString() {
	 return "sid="+sid + ", sname=" + sname + ", city=" + city;
 }
 public void showObject() {
	 System.out.println("["+sid +", " + sname + ", " + city+"]");
 }
 static void showNumberObjects() {//생성된 객체수를 출력한다.
	 System.out.println(" 생성객체수=" + countStudents);
	 
 }
}


class WorkStudent extends Student {
	String eno;
	String company;
	
	// 생성자 생성함
	public WorkStudent(int num, String sname, String city,String eno, String company) {
		super(num, sname,city);
		this.eno = eno;
		this.company = company;
		
	}
	
	// 상속 시, 상속 받은 클래스에서는 매개변수 없는 생성자 실행 됨.. 구현해주어야 ****
	public WorkStudent() {
		
	}
	
	public WorkStudent(String eno) {
		this.eno = eno;		
	}
	
	
	
@Override
	public String toString() {
		return super.toString()+ "WorkStudent [eno=" + eno + ", company=" + company + "]";
	}

	 public void showObject() {
		 //Student 출력 코드 추가
		 super.showObject();
		 System.out.println("["+eno +", " + company + "]");
	 }
}
class CodingWorkStudent extends WorkStudent {
	String language;
	
	public CodingWorkStudent(int num, String sname, String city,String eno, String company,String language) {
		super(201705, "대조영","발해","eno3","LG");
		this.language = language;
	}
	
	
@Override
	public String toString() {
		return super.toString()+ "CodingWorkStudent [language=" + language + "]";
	}

	 public void showObject() {
		 //WorkStudent 출력 코드 추가 
		 super.showObject();
		 System.out.println("["+language+"]");
	 }
}
 // 생성자 구현한다.
public class Test_Chap06_객체배열 {
	 static void showObjects(InterfaceStudents is) {
		 is.showObject();
	 }
	 public static void main(String[] args) {
	 Student arry[] = new Student[6];
	 Student.showNumberObjects();	//  상속받은 클래스에서는 정적 메소드 접근 못 하는 이유...?  => 접근 가능
	 arry[0] = new Student(202301,"김대희","부산");	
	 arry[1] = new Student(202301, "올빼미", "정글");				// 무슨 차이..? => 생성자 오버로딩
	 arry[2] = new Student(202301,"김동희","가야");
	 arry[3] = new WorkStudent(202203,"김환희","울산","eno","삼성");	// 객체로 생성 시 static 메소드 접근 못 하나? ... => 접근 가능
	 arry[4] = new WorkStudent(201605, "홍길동","대전","eno","넥슨");	
	 arry[5] = new CodingWorkStudent(201705, "대조영","발해","eno3","LG","JAVA");
	 //arry[3] = new WorkStudent();				// 3 두번...? => arry 여러개로 설정해서 해도 됨
	 Student.showNumberObjects();
	 for (Student s : arry) {
		 System.out.println(s.toString());
	 }
	 for (Student sx : arry) {
		 showObjects(sx);
	 }
	 
 }

}
