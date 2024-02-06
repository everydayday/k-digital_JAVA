package edu;

import java.util.Scanner;

public class Test21 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("a값을 입력해주세요 :");
		int a = sc.nextInt();
		System.out.println("b값을 입력해주세요 :");
		int b = sc.nextInt();
		System.out.println("연산자를 입력해주세요 :");		
		char op = sc.next().charAt(0);
		
		
		
		System.out.println(a + b);
		System.out.println(op);
		
	}
	
	
	
}
