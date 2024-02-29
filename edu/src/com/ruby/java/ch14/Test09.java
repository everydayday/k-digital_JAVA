package com.ruby.java.ch14;

interface Calculator{
	int func();
}

public class Test09 {
	
	static int num1 = 10;
	int num2 = 20;
	
	public static void main(String[] args) {
		Test09 test = new Test09();
		int num3 = 30;
		
		Calculator calc = () -> {
			int num4 = 40;
			Test09.num1++;		// test는 수정 x. test 안의 필드는 수정 o
			// test = new Test09();  는 불가. test 또한 지역 변수이기 때문에
			
			test.num2++;
			
			num4++;
			return num4;
		};
		
	}
	
	

}
