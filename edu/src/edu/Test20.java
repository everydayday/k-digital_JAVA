package edu;

import java.util.Scanner;

public class Test20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("점수를 입력해주세요 : ");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		char grade;
		
		if(score>=90) {
			grade = 'A';
		} else if(score >= 80) {
			grade = 'B';
		} else if(score >=70){
			grade = 'C';
		} else if(score >=60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		
		System.out.println("당신의 점수는 " + score + "이기 때문에 " + grade + "학점입니다.");
		
		sc.close();

	}

}
