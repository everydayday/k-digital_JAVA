package chap2_기본자료구조;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리
 */

import java.util.Arrays;
import java.util.Random;
public class Train_실습2_6다차원배열 {

	public static void main(String[] args) {
		int [][]A = new int[2][3];
		int [][]B = new int[3][4];
		int [][]C = new int[2][4];

		inputData(A);inputData(B);
		int [][]D = A.clone();//교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData(A);
		System.out.println("D[2][3] = ");
		showData(D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData(B);
		int [][]E = addMatrix(A,D);
		System.out.println("E[2][3] = ");
		showData(E);
		C = multiplyMatrix(A,B);
		System.out.println("C[2][4] = ");
		showData(C);

		int [][]F = transposeMatrix(A);
		System.out.println("F[3][2] = ");
		showData(F);
		boolean result = equals(A, D);
		System.out.println(" equals(A,D) = " + result);
		
		System.out.println("F = " + Arrays.deepToString(F));//2차원 배열 처리 
	}
	static void inputData(int [][]data) {
		Random rand = new Random();
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				data[i][j] = rand.nextInt(5) + 1;
			}
		}

	}
	static void showData(int[][]items) {
		for (int[] item : items) {
			for(int i : item) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	static boolean equals(int[][]a, int[][]b) {
		if (a.length != b.length || a[0].length != b[0].length) 
			return false;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0 ; j < a[i].length; j++) {
				if(a[i][j] != b[i][j]) return false;
			}
		}

		return true;

	}
	static int[][] addMatrix(int [][]X, int[][]Y) {	// X, Y는 변경되지 말아야 한다.
		int rows = X.length;
		int cols = X[0].length;
		int [][]Z = new int[rows][cols];
		// Z = X + Y
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				Z[i][j] = X[i][j] + Y[i][j];
			}
		}
		return Z;
	}
	
	static int[][] multiplyMatrix(int [][]X, int[][]Y) {
		int rows = X.length;
		int cols = Y[0].length;
		int [][]Z = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				int sum = 0;
				for(int k = 0 ; k < X[0].length; k++) {
					sum += X[i][k] * Y[k][j];
				}
				Z[i][j] = sum;
			}
		}
		
		
		return Z;
		
	}
	static int[][] transposeMatrix(int [][]X) {
		int rows = X.length;
		int cols = X[0].length;
		int [][]Z = new int[cols][rows];
		
		for(int i = 0; i < cols; i++) {
			for(int j = 0; j < rows; j++) {
				Z[i][j] = X[j][i];
			}
		}

		return Z;
		
	}
}

