package algorithm;

import java.util.Scanner;

public class Fibonacci35 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[]arr = new int[num];
		
		int p = 0;	// 넣을 값
		int q = 1;	// 다음 값
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = p;
			int sum = p + q;
			p = q;
			q = sum;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
