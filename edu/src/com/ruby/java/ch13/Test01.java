package com.ruby.java.ch13;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01 {
	
	public static void main(String[] args) {
		try {FileInputStream fi = new FileInputStream("a.txt");	// 기본 경로 base project에서 시작
				FileOutputStream fo = new FileOutputStream("b.txt");
			int c = 0;
			while((c = fi.read()) != -1) {
				fo.write(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
