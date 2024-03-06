package algorithm;

abstract class Drinks{
	void drink() {};
}

class Juice extends Drinks{
	void drink() {
		System.out.println("주스를 마십니다.");
	}
	
}

class Coffee extends Drinks{
	void drink() {
		System.out.println("커피를 마십니다.");
	}
	
}

class Beer extends Drinks{
	void drink() {
		System.out.println("소주를 마십니다.");
	}
	
}

class Water extends Drinks{
	void drink() {
		System.out.println("물을 마십니다.");
	}
	
}

class Tea extends Drinks{
	void drink() {
		System.out.println("차를 마십니다.");
	}
	
}


public class JuiceOrder45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열 안에 new를 통해 객체를 넣어주기
		Drinks[] drinks = new Drinks[]{new Juice(),new Coffee(),new Beer(),new Water(),new Tea()};
		
		for(int i = 0 ; i < drinks.length; i++)
			drinks[i].drink();

	}

}
