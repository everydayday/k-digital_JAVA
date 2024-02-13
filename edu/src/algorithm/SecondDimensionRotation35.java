package algorithm;

import java.util.Scanner;

public class SecondDimensionRotation35 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		double angle = sc.nextInt();
		
		double [][] mat = {{Math.cos(angle),-Math.sin(angle),0},
				        {Math.sin(angle), Math.cos(angle), 0},
				        {0, 0, 1} };
		
		
		
	}
	

}
