package com.ruby.java.ch11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args)  {
		System.out.println("Start");
		
		try {
			test04();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Done");
	}
	
	private static void test04() throws Exception {
		
		int a = 10 / 0;
		FileInputStream fi = new FileInputStream("a1.txt");
		int c = fi.read();
		System.out.println((char)c);			

	
	}

}
