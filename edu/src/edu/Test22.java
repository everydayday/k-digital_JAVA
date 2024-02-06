package edu;

import java.util.Scanner;

public class Test22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.print("a값을 입력해주세요 :");
		int a = sc.nextInt();
		System.out.print("b값을 입력해주세요 :");
		int b = sc.nextInt();
		System.out.print("연산자를 입력해주세요 :");		
		char op = sc.next().charAt(0);
		
		switch(op) {
		case '+':
			System.out.println(a+b);
		case '-':
			System.out.println(a-b);
		case '*':
			System.out.println(a*b);
		case '/':
			System.out.println(a/b);
		default :
			System.out.println("아무것도 없넹!!");
		}
		
		
		
		
	}

}
