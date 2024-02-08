package com.ruby.java.ch05;

public class Armor1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("1");
		String num = takeoff(8, 6);
		
		System.out.println(num);
		
		System.out.println();
		
	}
	
	static String takeoff(int num1, int num2) {
		System.out.println("takeoff");
		return num1 + " ===> " + num2;
	}

}
