package com.ruby.java.ch14;

import java.util.function.Function;

interface Geometry2{
	Double showArea();
	
}

class Circle2 implements Geometry2{
	int r;
	Circle2(int r){
		this.r = r;
	}
	
	@Override
	public Double showArea() {	// 꼭 public으로?
		return r * r * Math.PI;
		
	}
}

class Rectangle2 implements Geometry2{
	int w;
	int h;
	public Rectangle2(int w, int h) {
		// TODO Auto-generated constructor stub
		this.w = w;
		this.h = h;
	}
	
	@Override
	public Double showArea() {
		// TODO Auto-generated method stub
		return (double)w * h;
	}
}

class Square2 implements Geometry2{
	int w;
	int h;
	public Square2(int w, int h) {
		// TODO Auto-generated constructor stub
		this.w = w;
		this.h = h;
	}
	
	@Override
	public Double showArea() {
		// TODO Auto-generated method stub
		return (double)w * h;
	}
	
	
	
}


public class GeometryPractice {
	public static void main(String[] args) {
		Function<Geometry2, Double> func = (s) ->{	// class 타입으로 선언해야 함 ... 
			return s.showArea(); 
			
			
//			if(s instanceof Circle2) {
//				Circle2 c = (Circle2) s; 	// Geometry형으로 받은 것이므로 타입 캐스팅 해 주어야 함
//				return c.r * c.r * Math.PI;
//			}
//			else if(s instanceof Rectangle2) {
//				Rectangle2 r = (Rectangle2) s;
//				return r.h * r.w * 0.5;
//			}else if(s instanceof Square2) {
//				Square2 q = (Square2) s;
//				return (double)q.w * q.h;
//			}
//				
//			return 0.0;

		};
		
		Square2 sq = new Square2(9,9);		
		System.out.println(func.apply(sq));
		
	}
	
	
	
	
}
