package com.ruby.java.ch06;

import java.util.Random;

/*
 * 클래스 메소드 구현 실습 목적
 */
class Matrix {
	int rows;
	int cols;
	int[]data;
	public Matrix(int rows, int cols) {
		this.rows = rows; this.cols = cols;
		data = new int[rows * cols];
	}
	void getData() {
		// 난수로 입력
		Random rnd = new Random();
		for(int i = 0; i < rows * cols ; i++) {			
				data[i] = rnd.nextInt(100);			
		}
	}
	Matrix addMatrix(Matrix b) {
		Matrix m = new Matrix(rows, cols);
		for(int i = 0 ; i < rows * cols; i++) {	// 1차원으로 더하기
			m.data[i] = data[i] + b.data[i];
		}
		return m;
	}
	// 애매하고 어렵다!
	Matrix multiplyMatrix(Matrix b) {
		Matrix m = new Matrix(rows, b.cols);
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < b.cols; j++) {
				int sum = 0;
				// this의 열까지, b의 행까지 계산
				for(int k = 0; k < cols; k++) {
					//  cols 증가시만큼 다음 행으로 갈 수 있음
					// this.data : 행 고정 , 열 증가
					// b. dta : 행 움직임, 열 고정
					sum += data[i*cols + k] * b.data[j + b.cols * k]; 
					
				}
				m.data[i*b.cols + j] = sum;	// 범위 주의 하기... i * cols 했었어
			}
			
		}
		
		return m;	
	}
	
	// ********* 못 품 //
	Matrix transposeMatrix() {
		// this.cols 안 하고 그냥 cols 해도 되나?
		Matrix m = new Matrix(cols, rows);
		for(int i = 0 ; i < rows ; i++) {
			for(int j = 0 ; j < cols; j++) {
				m.data[i*rows + j] = data[i * cols + j ];
			}
		}
		
		
		return m;
	}
	void showMatrix(String str) {
		System.out.println(str);
		//2차원 배열 모양으로 출력하는 코드 작성
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(data[i*cols+j] + "\t") ;
			}
			System.out.println(" ");
		}
		System.out.println("=".repeat(30));
	}
}
public class Test_Chap06_행렬클래스 {

	public static void main(String[] args) {
		/*
		 * 난수 생성으로 초기화
		 * A[3][4] = B[3][4] + C[3][4]; D[3][5] = B[3][4] * E[4][5];
		 * F[4][3] = B[3][4]의 전치 행렬
		 */
		Matrix B = new Matrix(3,4);
		Matrix C = new Matrix(3,4);
		Matrix A, D, F;
		Matrix E = new Matrix(4,5);

		System.out.println("행렬 더하기: A[3][4] = B[3][4] + C[3][4]");
		B.getData();C.getData();E.getData();
		
		A = B.addMatrix(C);
		B.showMatrix("B[3][4]");C.showMatrix("C[3][4]");A.showMatrix("A[3][4]");
		System.out.println("*".repeat(50));
		
		System.out.println("행렬 곱하기: D[3][5] = B[3][4] * E[4][5]");
		D = B.multiplyMatrix(E);
		B.showMatrix("B[3][4]");E.showMatrix("E[4][5]");D.showMatrix("D[3][5]");
		System.out.println("*".repeat(50));
		
		System.out.println("행렬 전치: F[4][3] = B[3][4]의 전치 행렬");
		F = B.transposeMatrix();
		B.showMatrix("B[3][4]"); F.showMatrix("F[4][3]");

	}

}
