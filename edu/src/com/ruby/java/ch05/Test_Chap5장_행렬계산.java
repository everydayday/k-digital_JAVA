package com.ruby.java.ch05;

import java.util.Random;

/*
 * 하나의 자바 파일에서 함수 구현 실습
 */
public class Test_Chap5장_행렬계산 {
	/*
	 * 행렬 덧셈, 곱셈 연산 메소드 정의
	 * 1차버젼: 덧셈후 바로 출력
	 * 2차버젼: 덧셈후 return 값으로 결과 행렬 반환
	 */
	static void showMatrix(int [][]X) {
		//2차원 모습으로 출력
		int r = X.length;
		int c = X[0].length;
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(X[i][j] + "\t");
			}
			System.out.print("\n");
		}
		System.out.println("=".repeat(50));
	}
	
	static void getData(int[][]b){
		Random rnd = new Random();
		int r = b.length;
		int c = b[0].length;
		for(int i = 0; i < r ; i++) {
			for(int j = 0; j < c; j++) {
				b[i][j] = rnd.nextInt(100);
			}
		}
		
		
	}
	
	static int[][] addMatrix(int[][] B, int[][] C){
		
		int r = B.length;
		int c = B[0].length;
		int m[][] = new int[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0 ; j < c; j++) {
				m[i][j] = B[i][j] + C[i][j];
			}
		}
		
		return m;
	}
	static int[][] multiplyMatrix(int[][]B , int[][]E){
		int r = B.length;
		int c = E[0].length;
		int[][] D = new int[r][c];
		
		for(int i = 0 ; i < r; i++) {	// B의 행까지
			for(int j = 0; j < c; j++) { // E의 열까지
				int sum = 0;	// D 대입값
				for(int k = 0; k < B[i].length; k++ ) {	// B의 열 or E의 행까지 더하기
					sum += B[i][k] * E[k][j];
				}					
					D[i][j] = sum;
			}
		}
		
		return D;
		
	}
	static int[][] transposeMatrix(int[][] B){
		int[][]m;
		int r = B.length;
		int c = B[0].length;
		m = new int[c][r];
		for(int i = 0 ; i < c ; i++) {
			for(int j = 0; j < r; j++) {
				m[i][j] = B[j][i];
			}
		}
		
		
		return m;
		
	}
	public static void main(String[] args) {
		/*
		 * 난수 생성으로 초기화
		 * A[3][4] = B[3][4] + C[3][4]; D[3][5] = B[3][4] * E[4][5];
		 * F[4][3] = B[3][4]의 전치 행렬
		 */
		
		// 1. 행렬 더하기
		int[][]B = new int[3][4];
		int[][]C = new int[3][4];
		int[][]A = new int[3][4];
		
		// 2. 행렬 곱
		int [][]D = new int[4][4];
		int [][]E = new int[4][5];
		
		// 3. 행렬 전치
		int [][]F = new int[4][3];
		
		Test_Chap5장_행렬계산 x = new Test_Chap5장_행렬계산();
		System.out.println("행렬 더하기: A[3][4] = B[3][4] + C[3][4]");
		getData(B);getData(C);getData(E);
		A = addMatrix(B, C);
		showMatrix(B);showMatrix(C);showMatrix(A);
		
		System.out.println("행렬 곱하기: D[3][5] = B[3][4] * E[4][5]");
		D = multiplyMatrix(B,E);
		showMatrix(B);showMatrix(E);showMatrix(D);
		
		System.out.println("행렬 전치: F[4][3] = B[3][4]의 전치 행렬");
		System.out.println("B[3][4] 행렬 :");
		
		F = transposeMatrix(B);
		showMatrix(B);showMatrix(F);

	}

}
