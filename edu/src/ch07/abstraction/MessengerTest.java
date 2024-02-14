package ch07.abstraction;

public class MessengerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		iPhoneMessenger iphone = new iPhoneMessenger();
		GalaxyMessenger galaxy = new GalaxyMessenger();
		
		System.out.println("메신저 최소 문자 크기" + Messenger.MIN_SIZE);
		System.out.println("메신저 최대 문자 크기" + Messenger.MAX_SIZE);
		
		iphone.setLogin(true);
		iphone.getMessage();
		iphone.setMessage("hello");

	}

}
