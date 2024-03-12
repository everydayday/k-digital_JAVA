package chap3_검색;

import java.util.ArrayList;
//comparator 구현 실습
/*
* 교재 121 실습 3-6 
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;
public class Train_실습3_6_0스트링배열정렬이진탐색 {
	
	static void swap(String[] data, int indx1, int indx2) {
		String temp = data[indx1]; data[indx1] = data[indx2]; data[indx2] = temp; 
	}
	
	static void showData(String topic, String[] data) {
		System.out.println(topic);
		for(String arr : data) {
			System.out.print(arr + "\t");			
		}
		
		System.out.println();
		
	}
	
	static void sortData(String[] data) {
		ArrayList<String> alist = new ArrayList<>(Arrays.asList(data));
		alist.sort((x1,x2)-> x1.compareTo(x2));
		
		for(int i = 0; i < alist.size(); i++) {
			data[i] = alist.get(i);
		}
	}
	
	static int linearSearch(String[] data,String key) {
		int i = 0;
		while(i < data.length) {
			if(data[i].compareTo(key) == 0) return i;
			i ++;
		}
		return -1;
		
	}
	
	static int binarySearch(String[] data, String key) {
		int pl = 0;
		int pr = data.length -1;
		
		while(pl <= pr) {
			int mid = (pl + pr)/2;
			if(data[mid].compareTo(key) == 0) return mid;
			if(data[mid].compareTo(key) < 0 ) pl = mid + 1;
			if(data[mid].compareTo(key) > 0) pr = mid - 1;
			
		}
		return -1;
		
	}


	static void reverse(String[] a) {//교재 67페이지
		for(int i = 0 ; i < a.length/2 ; i++)
			swap(a,i,a.length-1-i);		

	}
	public static void main(String[] args) {
		String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};//홍봉희 재배 과수

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		reverse(data);//역순으로 재배치
		showData("역순 재배치후", data);
		Arrays.sort(data);//Arrays.sort(Object[] a);
		showData("Arrays.sort()로 정렬후",data);
      
		String key = "포도";
		int resultIndex = linearSearch(data, key);
		if(resultIndex < 0) System.out.println("linearSearch("+key+"): No data");
		else System.out.println("\nlinearSearch(포도): result = " + resultIndex);

		key = "배";
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);
		if(resultIndex < 0) System.out.println("binarySearch("+key+"): No data");
		else System.out.println("\nbinarySearch(배): result = " + resultIndex);
		key = "산딸기";
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);
		if(resultIndex < 0) System.out.println("Arrays.binarySearch("+key+"): No data");
		else System.out.println("\nArrays.binarySearch(산딸기): result = " + resultIndex);

	}


}
