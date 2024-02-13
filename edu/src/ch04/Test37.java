package com.ruby.java.ch04;
import java.util.Random;

public class Test37 {
	public static void main(String[] args) {
		Random rnd = new Random();	// Random : 난수 생성된 클래스
		int [] score = new int[20];
		int sum = 0;
		int max = 0;
		int min = 20;
		double avg = 0.0;
		for(int i = 0; i < score.length; i++) {
			score[i] = rnd.nextInt(20);

		}
		for(int num : score) {
			System.out.println(num);
		}
		
		for(int i = 0; i < score.length; i++) {
			if(i % 4 == 0)
				System.out.println();
			if(score[i] < 10)
				System.out.print(" ");
			System.out.println(score[i]);
			
			
		}
		
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
			if(score[i] > max)
				max = score[i];
			if(score[i] < min)
				min = score[i];
		}
		
		avg = sum / score.length;
		System.out.println("총 점 :" + sum);
		System.out.println("최대 :" + max);
		System.out.println("최소 :" + min);
		System.out.println("평균 :" + avg);
		
	}
}
