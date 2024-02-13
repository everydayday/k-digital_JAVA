package algorithm;

public class matrixMul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] A = new int[3][4];
		int [][] B = new int[4][3];
		//******** int 랑 차이.....??********* 
		Integer [][] mC = new Integer[3][3];
		
		// 대입
		int a = 1;
		int b = 1;
		
		for(int i = 0; i <A.length; i++) {
			for(int j= 0; j <A[i].length; j++) {
				A[i][j] = a;
				a ++;
			}
		}

		for(int i = 0; i <B.length; i++) {
			for(int j= 0; j <B[i].length; j++) {
				B[i][j] = b;
				b ++;
			}
		}
		
		
		// 곱 계산
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < B[i].length; j++) {
				int sum = 0;
				for(int k = 0; k < A[i].length; k++) {
					sum += A[i][k] * B[k][j];
				}
				mC[i][j] = sum;
			}
		}
		
		System.out.println("mC :");
		for(int i = 0; i <mC.length; i++) {
			for(int j= 0; j <mC[i].length; j++) {
				System.out.print(mC[i][j] + "\t");
			}
			System.out.println("\n");
		}
		
		
	
		

	}

}
