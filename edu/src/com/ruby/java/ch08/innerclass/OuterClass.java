package com.ruby.java.ch08.innerclass;

public class OuterClass {
	
	class InstanceClass{
	int a;
		
	void method2() {
		System.out.println("Instance Class : " + a);
	}
	
	}
	static class StaticClass{
		int b;
		static int c;
		void method() {
			System.out.println("static class: " + b);
		}
		static void metod4() {
			System.out.println("Static Class : " + c);
		}
	}

}
