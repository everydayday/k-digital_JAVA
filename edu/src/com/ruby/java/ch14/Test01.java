package com.ruby.java.ch14;

interface MyInterface{
	public void print();
}

class MyClass1 implements MyInterface{
	@Override
	public void print() {
		System.out.println("MyClass1");
	}	
}

class MyClass2 implements MyInterface{
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("MyClass2");
	}
}



public class Test01 {
	public static void test(MyInterface mi) {
		mi.print();									// 구현 안 할 시, 선언해도 사용 못함
	}
	
	public static MyInterface test2() {
		MyInterface mi = new MyInterface() {
			
			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("test2()메서드에서 반환된 MyInterfacce");
			}
		};
		return mi;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass1 mc1 = new MyClass1();
		MyClass2 mc2 = new MyClass2();
		mc1.print();
		mc2.print();
		
		MyInterface mi = new MyInterface() {
			
			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("익명 클래스로 구현");
			}
		};
		
		test(mc1);
		test(mi);
		
		mi.print();
		
		(new MyInterface() {	// 변수 선언 자체가 없어진 거	// 한 번만 사용할 때
			@Override
			public void print() {
			// TODO Auto-generated method stub
			System.out.println("선언, 생성, 호출을 한번에 처리");
		}}).print();
		
		MyInterface mi2 = test2();
		mi2.print();
		
	}

}
