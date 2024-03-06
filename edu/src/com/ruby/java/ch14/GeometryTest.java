package com.ruby.java.ch14;

import java.util.function.Function;

// 최상위 추상 클래스 Geometry 생성 => 추상 메서드로 면적 구하는 메서드 선언
abstract class Geometry1{
	abstract double getArea();
}

// 자식 클래스를 생성 =>  Circle, Rectangel, Triangle
class Circle1 extends Geometry1{	// 추상 클래스 상속 받아서 반드시 구현해야 함
	
	int radius;
	
	public Circle1(int radius) {
		// TODO Auto-generated constructor stub
		this.radius = radius;
	}
	@Override
	double getArea() {
		return Math.PI * radius * radius;
	}
}

class Rectangle1 extends Geometry1{
	
	int h;
	int w;
	
	public Rectangle1(int n, int w) {
		this.h = h;
		this.w = w;
	}
	
	@Override
	double getArea() {
		return (double) (h * w);	// 형 변환 해주어야 한다는 거 놓치지 말기
	}
	
}

class Triangle1 extends Geometry1{
	
	int h;
	int w;
	
	public Triangle1(int n, int w) {
		this.h = h;
		this.w = w;
	}
	
	@Override
	double getArea() {
		return (double) (h * w * 0.5);
	}
	
}



public class GeometryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Function 람다 생성
		Function<Geometry1, Double> func = (g) ->{	// 인터페이스 공통 부분 메서드 해주면 구현 클래스에서 타입캐스팅 안 해줘도 실행
			return g.getArea();
			
		};
		
		// 출력
		System.out.println(func.apply(new Circle1(5)));
		System.out.println(func.apply(new Triangle1(5,3)));

	}

}
