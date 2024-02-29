package com.ruby.java.ch14;

interface MyFunc<T>{
	T modify(T t);
}


public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFunc<String> mf1 = (str) -> str.toUpperCase() + ":" + str.length();
		System.out.println(mf1.modify("java"));
		System.out.println(mf1.modify("java programming"));
		
		MyFunc<Integer> mf2 = (n) -> n * 2;
		
		
		
		
	}

}
