package com.ruby.java.ch14;

import java.util.function.Function;


class Geometry{
	double radius;
	double width;
	double height;
}

class Circle extends Geometry{
	
	
	public Circle(int r) {
		// TODO Auto-generated constructor stub
		radius = r;
	}
	
}

class Rectangle extends Geometry{
	
	
	public Rectangle(int w, int h) {
		// TODO Auto-generated constructor stub
		width = w;
		height = h;
	}
}

class Triangle extends Geometry{
	int width;
	int height;
	
	public Triangle(int w, int h) {
		// TODO Auto-generated constructor stub
		width = w;
		height = h;
	}
}


public class Test14 {
	public static void main(String[] args) {
//		Function<String, Integer> func = (s) -> {		// 선언부가 없다는 건 자바에서 제공해주는 인터페이스라는 것
//			int cnt = 0;					
//			String[] word = s.split(" ");
//			cnt = word.length;
//			return cnt;			
//		};
//	
//	
//	int wordCnt = func.apply("고개를 들어 별들을 보라 당신 발만 내다 보지말고");
//	System.out.println("단어 수 : " + wordCnt);
		
		Function<Geometry, Double> func = (s) -> {	
			if(s instanceof Circle)
				return s.radius * s.radius * Math.PI;
			else if(s instanceof Rectangle)
				return s.width * s.height ;
			else if(s instanceof Triangle)
				return s.width * s.height * 0.5;
			return null;
			
			// getArea 추상메서드로 선언하고 자식에서 선언하면 한 줄에서 끝
					
	};
	
	Circle c = new Circle(3);
	Double a = func.apply(c);
	System.out.println(a);
		
	
	}
}
