package algorithm;

import java.util.Scanner;

public class yunYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		String str;
		if(year % 4 == 0) {	// 1. 4로 떨어지냐
			if(year % 100 == 0) { // 2. 100으로 나누어 떨어지느냐
				if(year % 400 == 0) str = "윤년";	// 3. 400으로
				else str = "평년";			
			}else str = "윤년";		// 2. 100으로 안 나누어 떨어짐
		
		}else str = "평년";	// 1. 4로 안 떨어짐
		
		System.out.println(str);
	}

}
