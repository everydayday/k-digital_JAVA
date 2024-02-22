package algorithm;


class Matrix{
	private double [][] arr; // 👍👍	
	private int r;
	private int c;
	
	public Matrix(int[] array, int s, int r,int c) {	// s : start  r: row c :column
		arr = new double[r][c];
		this.r = r;
		this.c = c;
		int num = s;
		for(int i = 0; i < r; i ++) {
			for(int j = 0; j < c; j++) {
				arr[i][j] = array[num];
				num ++;
			}
		}
	}
	
	public void printMatrix() {
		for(int i = 0 ; i < r ; i ++) {
			for(int j = 0; j < c; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println(" ");
		}
	}
	
	public void hello() {}
	
//	public static Matrix sum(Matrix mA, Matrix mB) {
//		Matrix mC;
//		
//	}
	
}




public class Matrix59 {
	
	public static void main(String[] args) {
		int[] array = {1, 2, 19, 3, 4, 5, 6, 7, 13, 8, 9, 10, 11, 12, 14, 22, 15, 16, 17, 18,  20, 21, 23, 24};
		// 1. print
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println("\n");
		
		// 1. 오름차순 : 제일 작은 수 찾고 두 수 바꾸어서 출력 : 선택 정렬
		for(int i = 0; i < array.length; i++) {	// 크기 만큼 반복 , i 번재와 min_index 위치 변경
			int min = array[i];
			int min_index = i;	// 위치 바꿀 index
			for(int j = i; j < array.length; j++) {	// j번재와 와 i번재 비교
				if(min>array[j]) {
					min_index = j;
					min = array[j];
				}
			}
			int num = array[i];
			array[i] = array[min_index];
			array[min_index] = num;
			System.out.print(array[i] + "\t");
		}
		
		int[] array1 = {1, 2, 19, 3, 4, 5, 6, 7, 13, 8, 9, 10, 11, 12, 14, 22, 15, 16, 17, 18,  20, 21, 23, 24};
		Matrix mA = new Matrix(array1, 0, 3, 4);			
		mA.printMatrix();
		
		
		
	}
	
	


	
	
}
