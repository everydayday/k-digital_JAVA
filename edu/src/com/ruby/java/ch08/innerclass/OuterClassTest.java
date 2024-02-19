package com.ruby.java.ch08.innerclass;

//class OuterClass {
//	
//	class InstanceClass{
//		int a;
//
//	
//	void method2() {
//		System.out.println("Instance Class : " + a);
//	}
//	
//	}
//
//}



public class OuterClassTest {
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		OuterClass.InstanceClass inner01 = outer.new InstanceClass();
		inner01.a =123;
		inner01.method2();
		OuterClass.StaticClass inner02 = outer.OuterClass.StaticClass();
		OuterClass.StaticClass.c = 789;
		OuterClass.StaticClass.metod4();
		
		
	}

}
