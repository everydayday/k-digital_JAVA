package edu;

import java.util.Scanner;

public class Problem_prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		boolean prime = true;
		
		for(int i = 2; (i*i) < num; i++) {
			if(num % i == 0) {
				prime = false;
				break;
			}
		}
		
		sc.close();
		// 새로운 표기방법!!
		System.out.println(prime?"소수입니다." : "소수가 아닙니다.");
		
		// 새로운 판별법
		int i = 2;
		for(i = 2; i < num; i++) {
			if(num % 2 == 0) break;
		}
		System.out.println((i < num)? "소수가 아닙니다." : "소수입니다.");
		
	}

}




