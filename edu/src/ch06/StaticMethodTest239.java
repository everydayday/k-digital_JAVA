package ch06;

public class StaticMethodTest239 {
	public static void main(String[] args) {
		StaticMethodTest239.print1();
		StaticMethodTest239 str = new StaticMethodTest239();
		str.print2();
		System.out.println(str.num);
	}
	
	int num = 3;
	public static void print1() {
		System.out.println("hello");
	}
	
	public void print2() {
		int num2 = num;
		System.out.println("java");
	}
	

}
