package com.ruby.java.ch05;

class Armor {
	private String name = "홍길동";
	private int height = 180;
	private int weigth = 100;
	String color = "Red";
	
	void takeoff() {
		System.out.println("Take off");
	}
	void land() {
		System.out.println("Land");
	}
	void shootLaser() {
		System.out.println("Shoot Laser");
	}
	
	// Armor class 안에 main 메서드가 있을 수 있네

}

public class ArmorTest{
	public static void main(String[] args) {
		Armor armor = new Armor();
		
		armor.takeoff();
	}
	
	
}