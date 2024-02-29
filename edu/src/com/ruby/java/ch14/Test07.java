package com.ruby.java.ch14;

interface StringFunc{
	String modify(String s);
}

public class Test07 {
	
	static String test(StringFunc sf, String s) {
		return sf.modify(s);
	}
	
	public static void main(String[] args) {
		
		String str = "Korea,Australia,China,Germany,Spain,Turkey";
		StringFunc sf1 = (s) -> {
			String result = "";
			char c;
			for(int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if(c == ',')
					result += " ";
				else
					result += c;
			}
			return result;			
		};
		
		String s1 = test(sf1, str);
		System.out.println(s1);
		
		//String s2 = test()
		
		
	}
	
	
	
	
	

}
