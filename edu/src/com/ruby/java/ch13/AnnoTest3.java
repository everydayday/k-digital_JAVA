package com.ruby.java.ch13;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Service{
	
}


@Service
public class AnnoTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnoTest3 obj = new AnnoTest3();
		try {
			Class<?> c = obj.getClass();
			if(c.isAnnotationPresent(Service.class))
				System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}

}
