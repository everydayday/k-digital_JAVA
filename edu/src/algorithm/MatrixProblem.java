package algorithm;

import java.util.Random;
import java.util.Arrays;

public class MatrixProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = new int[3][4]; // 난수 입력
		int B[][] = new int[4][5]; // 난수 입력
		int C[][] = new int[3][5];
		int D[][] = new int[3][4]; // 난수 입력
		int E[][] = new int[3][4];
		int F[][] = new int[4][3];
		// C  = A * B 행렬 곱
		// E = A + D 행렬 합
		// F = A의 전치 행렬
		
		Random rnd = new Random();
		
		// 난수 입력
		// 임의 값 지정
		int a = 1;
		int b = 3;
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[i].length; j++) {
				//A[i][j] = rnd.nextInt(200);
				A[i][j] = a;
				a++;
			}
		}
		for(int i = 0; i < B.length; i++) {
			for(int j = 0; j < B[i].length; j++) {
				B[i][j] = b;
				b++;
			}
		}
		for(int i = 0; i < D.length; i++) {
			for(int j = 0; j < D[i].length; j++) {
				D[i][j] = rnd.nextInt(200);
			}
		}
		System.out.println("Matrix A:");
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[i].length; j++) {
				System.out.print(A[i][j] + "\t");				
			}
			System.out.println("\n");
		}
		
		System.out.println("Matrix B:");
		for(int i = 0; i < B.length; i++) {
			for(int j = 0; j < B[i].length; j++) {
				System.out.print(B[i][j] + "\t");				
			}
			System.out.println("\n");
		}

		
		
		// 행렬 곱 계산 C = A * B
		// A[3][4] B[4][5] C[3][5]
		for(int i = 0; i < A.length; i++) {	// 범위가 A까지 맞나?
			for(int j = 0; j < B[i].length; j++) {	// 열은 B로
				int sum = 0; // 곱 합
				// A열 or B 행 부분까지 곱 하기 (= m)
				for(int m = 0; m < A[i].length; m++) {
					// 행, 열 위치 주의
					sum += A[i][m] * B[m][j];
				}				
				C[i][j] = sum; 					
			}
		}
		
		
		System.out.println("Matrix C:");
		for(int i = 0; i < C.length; i++) {
			for(int j = 0; j < C[i].length; j++) {
				System.out.print(C[i][j] + "\t");				
			}
			System.out.println("\n");
		}
		
		
		// 행렬 합 E = A + D 행렬 합
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[i].length; j++) {
				E[i][j] = A[i][j] + D[i][j];
			}
		}
		
		// E 출력
		System.out.println("Matrix E:");
		for(int i = 0; i < E.length; i++) {
			for(int j = 0; j < E[i].length; j++) {
				System.out.print(E[i][j] + "\t");				
			}
			System.out.println("\n");
		}
		
		// 전치 행렬
		for(int i = 0; i < F.length; i++) {
			// 절반만 다루기
			for(int j = 0; j < F[i].length; j++) {
				F[i][j] = A[j][i];
				
			}
		}
		
		// F 출력
		System.out.println("Matrix F:");
		for(int i = 0; i < F.length; i++) {
			for(int j = 0; j < F[i].length; j++) {
				System.out.print(F[i][j] + "\t");				
			}
			System.out.println("\n");
		}
		
		
		

	}

}
