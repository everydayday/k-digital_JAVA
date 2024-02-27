package com.ruby.java.ch13.study;



class Bag{
	private Object thing;
	
	public Bag() {
		
	}
	
	
	public Bag(Object thing) {
		// TODO Auto-generated constructor stub
		this.thing = thing;
	}

	public Object getThing() {
		return thing;
	}

	public void setThing(Object thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
	
	
}

class Book{}
class PencilCase{}
class Notebook{}


public class BagTest2 {
	
	public static void main(String[] args) {
		Bag bag  = new Bag(new Book());
		Bag bag2 = new Bag(new PencilCase());
		Bag bag3 = new Bag(new Notebook());
		
		bag.showType();
		bag2.showType();
		bag3.showType();
		
		bag = bag2;
		
//		Bag<Book> bag = new Bag<>();	// 기본 생성자 추가해주면 에러 안 남
//		bag.setThing(new Book());
//		bag.showType();
//		
		
		
	}

}
