package com.ruby.java.ch14;

interface NumberFunc {
	int func(int n, String str);
}

public class Test05 {

	public static void main(String[] args) {
//		NumberFunc sum = (n) -> {	// interface 내에 매개변수에 선언된 int로 자료형 선언되어있음
//			int result = 0;
//			for(int i = 0; i <= n; i++) {
//				result += i;
//			}
//			return result;			
//		};
//		
//		NumberFunc even_sum = (n) -> {
//			int result = 0;
//			for(int i = 0; i <= n; i+=2) {
//				result += i;
//			}
//			return result;			
//		};
//		
//		NumberFunc odd_sum = (n) -> {
//			int result = 0;
//			for(int i = 1; i <= n; i+=2) {
//				result += i;
//			}
//			return result;			
//		};
//		
		
		NumberFunc odd_even_sum = (n,str) -> {	// 홀 , 짝 하나로 합치고 싶을 때
			int result = 0;
			if(str.equals("짝")) {
				for(int i = 0; i <= n; i+=2) {
					result += i;
				}
			}else {
				for(int i = 1; i <= n; i+=2) {
				result += i;
				}
			}
			
			return result;			
		};
		
//		System.out.println("1부터 10까지의 합 :" + sum.func(10));
//		System.out.println("1부터 10까지의 짝수 합 :" + even_sum.func(10));
//		System.out.println("1부터 10까지의 홀수 합 :" + odd_sum.func(10));
//		System.out.println("1부터 100까지의 짝수 합 :" + even_sum.func(100));
//		System.out.println("1부터 100까지의 홀수 합 :" + odd_sum.func(100));
//		System.out.println("1부터 100까지의 합 : "  + sum.func(100));
		System.out.println("1부터 100까지의 합 : "  + odd_even_sum.func(300, "짝"));
		
	}
	
	
	
}
