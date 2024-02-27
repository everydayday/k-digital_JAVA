package com.ruby.java.ch13;



class Bag<T>{
	private T thing;
	
	public Bag() {
		
	}
	
	
	public Bag(T thing) {
		// TODO Auto-generated constructor stub
		this.thing = thing;
	}

	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
	
	
}

class Book{}
class PencilCase{}
class Notebook{}


public class BagTest {
	
	public static void main(String[] args) {
		Bag<Book> bag  = new Bag<>(new Book());
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());
		
		bag.showType();
		bag2.showType();
		bag3.showType();
		
//		Bag<Book> bag = new Bag<>();	// 기본 생성자 추가해주면 에러 안 남
//		bag.setThing(new Book());
//		bag.showType();
		
		
		
	}

}
