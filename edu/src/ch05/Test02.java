package com.ruby.java.ch05;

public class Test02 {
	static void test(String name, int... v) {
		System.out.print(name + " : ");
		for(int num : v) {
			System.out.print(num + " ");
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test("김대희", 3, 4, 5);
		test("이말숙", 1, 2, 3, 4, 5);
		test("홍길동", 1, 3, 5, 6);
		
		
		
	}

}
