package com.ruby.java.ch13;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test16 {
	
	public static void main(String[] args) {
		try (ObjectInputStream in =
				new ObjectInputStream(new FileInputStream("user.txt"))){
			UserBean user = (UserBean) in.readObject();	// 상속 관계에서 가능하지 않나
			System.out.println(user);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
;		}
		
	}

}
