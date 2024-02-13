package ch06;

public class ThisTest252 {
	int i = 1;
	
	public void first() {
		int i = 2;
		int j = 3;
		this.i = i + 1;
	
		second(4);
	}
	
	public void second(int i) {
		int j = 5;
		this.i = i + j;
	}
	
	
	
	

	public static void main(String[] args) {
		ThisTest252 exam = new ThisTest252();
		exam.first();
		System.out.println(exam.i);
		System.out.println(exam.toString());
		
	}
	
	

}
