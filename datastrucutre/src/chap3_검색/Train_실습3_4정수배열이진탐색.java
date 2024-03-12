package chap3_검색;

import java.lang.reflect.Array;
import java.util.ArrayList;
//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
/*
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
public class Train_실습3_4정수배열이진탐색 {

	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);// 구현 반복 숙달 훈련

		showList("정렬 전 배열[]:: ", data);
		sortData(data);// 구현 반복 숙달 훈련
		//Arrays.sort(data);
		System.out.println();
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련
		
		System.out.println();

		int key = 13;
		int resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linear search는 없다
		if(resultIndex < 0) System.out.println("LinearSerach: No value in the array");
		else System.out.println("\nlinearSearch(13): result = " + resultIndex);

		key = 19;
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);
		if(resultIndex < 0) System.out.println("binarySearch :No value in the array");
		else System.out.println("\nbinarySearch(19): result = " + resultIndex);
		
		
		key = 10;
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);
		if(resultIndex < 0) System.out.println("Arrays.binarySearch : No value in the array");
		else System.out.println("\nArrays.binarySearch(10): result = " + resultIndex);

	}
	
	static void inputData(int[] data) {
		Random rnd = new Random();
		for(int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(100);
		}
	}
	
	static void showList(String info,int[] data) {
		System.out.println(info);
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i]+"\t");
		}
		
	}
	
	static void sortData(int[] data) {
		Integer[] integer_data = new Integer[data.length];		
		for(int i = 0 ; i < data.length; i++) {
			integer_data[i] = data[i];
		}
		
		
		ArrayList<Integer> alist = new ArrayList<>(Arrays.asList(integer_data));
		//alist.sort(new Comparator<int>() = (x1, x2) ->  x1 < x2 ? 1 : -1);
		alist.sort((x1, x2) -> -(x1.compareTo(x2)));
		//alist.sort(null);
		
//		alist.get(0).

		
		for(int i = 0; i < alist.size(); i++) {
			data[i] = alist.get(i);
		}
		
		
	}


	static int linearSearch(int[]item, int key) {
		int i = 0;	// 찾는 index
		while(true) {
			if(i == item.length)
				return -1;
			if(item[i] == key)
				return i;
			i++;			
		}

	}

	static int binarySearch(int[]item, int key) {
		int pl = 0;
		int pr = item.length-1;
		// 구간 확인
		if(item[pl] == key) return pl;
		if(item[pr] == key) return pr;		
		while(pl <= pr) {
			
			
			int mid = (pl + pr) /2;
			if(item[mid] == key) return mid;	// 값을 비교하는 방법은 mid로만 비교함
			else if(item[mid] > key) pr = mid-1;	// key 값이 pl, pr일 때는 비교 안 한게된다는 점 유의
			else pl = mid + 1;
			
			
		}
		return -1;
		
		

	}
}
