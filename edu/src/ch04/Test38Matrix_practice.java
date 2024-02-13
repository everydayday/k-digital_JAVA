package ch04;

public class Test38Matrix_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = new int[3][4];
		int B[][] = new int[4][5];
		int C[][] = new int[3][5];
		
		int a = 1;
		int b = 3;
		
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[i].length; j++) {
				A[i][j] = a;
				a ++;
			}
		}
		
		for(int i = 0; i < B.length; i++) {
			for(int j = 0; j < B[i].length; j++) {
				B[i][j] = b;
				b ++;
			}
		}
		
		for(int i= 0; i < A.length; i++) {
			for(int j = 0; j < B[i].length; j++) {
				int sum = 0;
				for(int k = 0; k < 4; k++) {
					sum += A[i][k] * B[k][j]; 
				}
				C[i][j] = sum;
				
			}
		}
		
		// 출력
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(C[i][j]+"\t");
			}
			System.out.println("\n");
		}

	}

}
