package algorithm;

import java.util.Scanner;

public class weightNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		int num = sc.nextInt();
		
		int[] weight = {2, 3, 5};
		
		int cnt = chooCount(num, weight);		
		System.out.println("count : " + cnt);

	}
	
	public static int chooCount(int num, int[] weight) {		
		int cnt = 0;
		// 컴퓨터 속도 빠른만큼 최대값인 10까지로 해도 상관 없음
		for(int i = 1; i <= (num/weight[2]) ; i++) {	// 5kg 갯수.. 무거운 무게 먼저 .. 상관은 없을 듯
			int a = num - i*5;	// 5kg i 갯수 후 남은 무게
			for(int j = 1; j <= a/weight[1] ; j++ ) {	// 최대 3kg 갯수
				int b = a - j*3;	// 3kg j 갯수 후 남은 무게
				for(int k = 1; k <= b/weight[0]; k++) {	// 최대 2kg 갯수
					int sum = 5 * i + 3 * j + 2 * k; // i, j ,k 로 무게 합 구하기
					if(sum == num) {
						System.out.println("{" + k + "," + j + "," + i + "}");
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
