package chap5_Recursive;

import java.util.Scanner;
import java.util.Stack;

public class Recur {

	
	static void recur(int n) {
		Stack<Integer> s = new Stack<Integer>();
		
		while(true) {	// if (n > 0)
			if(n > 0) {
				s.push(n);
				n = n-1;
				continue;
			}
			if(s.isEmpty() != true)
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		int x = stdIn.nextInt();
		
		recur(x);
	}
}
