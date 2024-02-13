package com.ruby.java.ch04;

import java.util.Random;

public class Test38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		
		int arr[][] = new int[5][5];
		
		for(int i = 0; i < arr.length ; i++) {
			for(int j = 0; j < arr[i].length ; j++) {
				arr[i][j] = rnd.nextInt(30);
				
			}
		}
		
		for(int i = 0; i < arr.length ; i++) {
			for(int j = 0; j < arr[i].length ; j++) {		
				if(i >= j)
					System.out.print(arr[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		
		
		
	}

}
