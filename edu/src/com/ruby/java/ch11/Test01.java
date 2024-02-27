package com.ruby.java.ch11;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();		
	}
		
	
	private static void test1() {
		System.out.println("test1 start");
		test2();
		System.out.println("test1 end");
	}
	
	private static void test2() {
		try {
			//int temp = 10/0;
			
			String s = new String("java");
			int len = s.length();
			s = null;
			s.length();
			
			int arr[] = new int[3];
			arr[3] = 30;
			System.out.println("OK");
		} catch (ArrayIndexOutOfBoundsException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		} catch(NullPointerException e2) {
			e2.printStackTrace();;
		} catch(Exception e) {
			System.out.println("오류 발생 :" + e);
		}
		System.out.println("GOOD");
	}
		
	
		
	

}
