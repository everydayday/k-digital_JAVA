package algorithm;

import java.util.Scanner;

public class Vowel33 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		//str = str.replaceAll(" ", "");	// 내부 공백 제거 => 안 해도 되게 수정함
		
		
		char[] arr = str.toCharArray();
		
		int consonant = 0;	// 자음
		int vowel = 0;		// 모음
		
		char[] vowels = new char[] {'A','E','I','O','U','a','e','i','o','u'};
		for(int i = 0; i < arr.length; i++) {
			char m = arr[i];
			boolean isVowel = false;
			
			// 알파벳 아닐 시 넘어가기
			if((m - 'A' >= 0 && m - 'Z' <= 0) || (m - 'a' >= 0 && m - 'z' <= 0)) {}
			else continue;
			
			for(int j = 0; j < vowels.length; j++) {
				if(m - vowels[j] == 0) {
					vowel ++;
					isVowel = true;
					break;
				}	
				
			}
			if(isVowel == false) consonant ++;	// 자음 증가
			
		}
		
		
		System.out.println("자음 " + consonant + "개, " + "모음 " + vowel + "개");
		
		
		
	}

}
