package baekjoon;

import java.util.Scanner;

public class Baek2480 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int money = 0;
		
		if(a != b && b != c && c != a) { // 모두 다른 경우 case 5
			money = findBiggest(a, b, c) * 100;				
		}else if(a == b && b == c) {	// 모두 같은 경우 case 4 식 2개만 있으면 됨
			money = 10000 + a * 1000;				
		}else {
			if(a== b) {	// case 1
				money = 1000 + a * 100;
			}else if(b == c) {	// case 3
				money = 1000 + b * 100;
			}else if(c == a) {	// case 2
				money = 1000 + c * 100;
			}
			
		}
		
		System.out.println(money);
		
		sc.close();
		
		
		
	}
	
	
	public static int findBiggest(int a, int b, int c) {
		int arr[] =  {a, b, c};
		int big = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(big < arr[i]) {
				big = arr[i];
			}
		}
		
		return big;
		
		
		
	}

}
