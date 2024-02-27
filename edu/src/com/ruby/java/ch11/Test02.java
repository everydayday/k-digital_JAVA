package com.ruby.java.ch11;

public class Test02 {	
	
	public static void main(String[] args) {
		test02();
	}
	
	
	private static void test02() {
		try {
			System.out.println("1");
			String s = null;
			s.length();
			System.out.println("2");
			System.out.println("3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("오류 발생");
			return;
		} finally {
			System.out.println("OK");
		}
		System.out.println("4");
	
	
	}
}
