package edu;

import java.util.Scanner;

public class Test25 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("값을 입력하세요:");
		int num = sc.nextInt();
		
		int sum1 = 0;	// 홀수 합
		int sum2 = 0;	// 짝수 합
		
		for(int i=0; i < num; i++) {
			if(i % 2 == 1) {	// 홀수
				sum1 += i;
			}
			else {	// 짝수
				sum2 += i;
			}
			System.out.print("sum1 : " + sum1);
			System.out.print(" sum2 : " + sum2 );
			System.out.print('\n');
		}
		System.out.println("OK");
		sc.close();
		
	}

}
