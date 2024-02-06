package edu;

import java.util.Scanner;

public class Problem_prime2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
		int a = 1;
		int b = 1;
		
		// 범위 구하기
		for(int i = 1; i <num; i++)
			a *= 10;
		for(int i = 1; i <=num; i++ )
			b *= 10;
		
		// find the prime
		for(int i = a; i < b; i++) {
			boolean prime = true;
			
			for(int p = 2; (p*p) < i; p++) {
				if(i % p == 0) {
					prime = false;
					break;
				}
			}
			if(prime == true) System.out.println(i);
			
			
		}
		

	}

}
