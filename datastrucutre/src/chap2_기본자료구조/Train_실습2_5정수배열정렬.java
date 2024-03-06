package chap2_기본자료구조;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
import java.util.Set;
public class Train_실습2_5정수배열정렬 {

	public static void main(String[] args) {
		int []data = new int[10];
		System.out.println("원본 데이터 :");
		inputData(data, 10);
		showData(data);
		
		System.out.println("배열 데이터 :");
		sortData(data);
		showData(data);
		
		System.out.println("역순 데이터 :");
		reverse(data);//역순으로 재배치 - 정렬 아님 
		showData(data);

		System.out.println("재배치 데이터 :");
		reverseSort(data);//역순으로 재배치 - 정렬 아님 
		showData(data);
		
		System.out.println("원본 데이터 :");
		Arrays.sort(data);
		showData(data);
	}
	static void showData(int[]data) {
		for(int i : data) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	static void inputData(int []data, int count) {
		Random rnd = new Random();
		
		Set<Integer> d = new HashSet<Integer>();
		
		while(d.size() < count) {
			d.add(rnd.nextInt(20)+1);
		}
		
		// 방법 1
//		Iterator<Integer> it = d.iterator();
//		int index = 0;
//		while(it.hasNext()) {
//			data[index] = it.next();
//			index ++;
//		}
		
		// 방법 2
		int index = 0;
		for(Integer i : d) {
			data[index++] = i;
		}
		
		
//		Random rndm = new Random();
//		for(int i = 0; i < data.length; i++)
//			data[i] = rndm.nextInt(15) + 1;
	}
	static void swap(int[]arr, int ind1, int ind2) {//교재 67페이지 // i , j index 변경
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	static void sortData(int []arr) {	// 오름차순 정렬
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {	// j가 초과되지 않나,,? => 범위 벗어나면 작동 안 되겠네
				if(arr[i] > arr[j])	swap(arr, i, j);
			}
		}

	}
	// 배열 a의 요소를 역순으로 정렬
	// sort 먼저 되니 정렬되어 있다 봐야겠네
	static void reverse(int[] a) {//교재 67페이지
		for(int i = 0 ; i < a.length/2 ; i++) {
			swap(a, i, a.length-1-i);
		}

	}
	static void reverseSort(int []arr) {	// 내림차순 정렬
		for(int i = 0; i < arr.length; i ++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] < arr[j]) swap(arr, i, j);
			}
		}
	}

}
