package com.ruby.java.ch09.기본API;

//구현 실습 코드
import java.util.Scanner;
public class Test_String배열검색 {
	static void getData(String[] arr) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}

	}
	static void showData(String[] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	/*
	 * 교재 407 Test02: if (s1 == s2)
	 * 교재 409 Test02: if (s1.equals(s2))
	 * compareTo() 사용 
	 */
	static boolean findString(String[] arr, String st) {
		for (int i = 0; i < arr.length; i++) {
			// 
			//if(arr[i] == st)
			
			// String으로 arr 되도 똑같다. 어차피 arr[0]으로 접근되니.. 메소드 똑같을 듯
			
			if (arr[i]==(st)) {
				System.out.println("있다");
			}
			//if(arr[i].compareTo(st) == 0)
		}
		System.out.println(st + "배열에 없다");
		return false;
	}
	public static void main(String[] args) {
		String[]arr= new String[5];
		//화면에서 입력
		getData(arr);
		showData(arr);
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 문자열 입력:");
		String st = sc.next();
		boolean result = findString(arr, st);
		if (result)
			System.out.println();

	}
}
