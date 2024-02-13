package algorithm;

public class Matrix59 {
	public static void main(String[] args) {
		int[] array = {1, 2, 19, 3, 4, 5, 6, 7, 13, 8, 9, 10, 11, 12, 14, 22, 15, 16, 17, 18,  20, 21, 23, 24};
		// 1. print
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println("\n");
		
		// 1. 오름차순
		int[] array2 = new int[99999];
		for(int i = 0; i < array.length; i++) {	// 크기 만큼 반복
			int min = array[i];
			int min_index = i;
			for(int j = i+1; j < array.length; j++) {
				if(min>array[j]) {
					min_index = j;
				}
			}
			System.out.print(min + "\t");
		}
	}

}
