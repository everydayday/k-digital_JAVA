package com.ruby.java.ch14;

import java.util.Arrays;

interface StringFunc2{
	String[] modify(String s) throws EmptyStringException;
}

class EmptyStringException extends Exception{
	public EmptyStringException() {
		// TODO Auto-generated constructor stub
		super("빈 문자열");
	}
}

public class Test08 {
	
	public static void main(String[] args) {
		
		String str = "Korea,Australia,China,Germany,Spain,Turkey";
		
		StringFunc2 sf = (s) -> {
			if(s.length() == 0)
				throw new EmptyStringException();
			return s.split(",");
		};
		
		try {
			String result[] = sf.modify(str);
			System.out.println(Arrays.toString(result));
			
			String str2 = "";
			String result2[] = sf.modify(str2);
			System.out.println(result2);
		} catch (EmptyStringException e) {	// 여기서 발생한 오류 catch해줌
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
