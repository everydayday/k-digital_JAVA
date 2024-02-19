package com.ruby.java.ch08.innerclass;




public class MessengerTest {
	public static void main(String[] args) {
		
		Messenger test = new Messenger(){
			System.out.println("test에서 메시지를 설정합니다 : " + msg);
		}
		
		public String getMessage() {
			return "test";
		}
	};
		
		
		test.setMessage(null);
		
		
		
		
	}

}
