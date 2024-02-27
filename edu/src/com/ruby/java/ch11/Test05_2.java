package com.ruby.java.ch11;

public class Test05_2 {

	int battery = 0;
	public void charge(int time) throws NagativeNumberException{
		
		battery += time;
		System.out.println("현재 배터리 : " + battery);
		if(time < 0) {
			time = 0;			
			throw new NagativeNumberException();
		}
		
		
	}
	
	public static void main(String[] args) {
		Test05 test = new Test05();
		try {
			//test.charge(30);
			//test.charge(20);
			test.charge(-10);
		} catch (NagativeNumberException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
