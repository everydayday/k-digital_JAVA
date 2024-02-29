package com.ruby.java.ch14;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.function.Consumer;

import javax.xml.crypto.Data;

public class Test16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer<Date> date = (d) -> {
			String s = new SimpleDateFormat("YY-MM-dd").format(d);
			System.out.println(s);
		};	// ; 잊지말기

		
		date.accept(new Date());
	}

}
