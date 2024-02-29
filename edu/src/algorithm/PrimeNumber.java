package algorithm;

import java.util.ArrayList;

public class PrimeNumber {

	public boolean PrimeNumber(int num) { // num이 소수인지 판단
		int i = 2;
		while((i * i) < num) {
			if(num % i == 0) return false;
			i ++;
		}
		return true;
		
		
	}

	public ArrayList<Integer> PrimeNumber2(int num) {
		int s = (int) Math.pow(10.0, (double) (num - 1));
		int e = (int) Math.pow(10.0, (double) (num)) - 1;
		
		ArrayList<Integer> al = new ArrayList<>();
		
		
		for(int i = s; i <= e; i++) {
			if(PrimeNumber(i)) al.add(i);
		}
		
		return al;

	}
	
	public ArrayList<Integer> PrimeNumber3(int num) {	
		
		ArrayList<Integer> al = PrimeNumber2(num);	// num 자리 수 소수 받아오기
		ArrayList<Integer> answers = new ArrayList<Integer>(); // 정답 arrayList 들
		
		for(int i = 0; i < al.size(); i++) {
			int n = al.get(i);	// n 은 후보
			int test_num = al.get(i) / 10;	//  원본 값은 소수일 테니
			while(test_num > 0) {
				if(PrimeNumber(test_num)) // 자리 수 값이 소수인가
					test_num /= 10;					
				else 
					break;					// 소수 아닐 시 벗어나기	
			}
			if(test_num == 0)
				answers.add(n);
			
		}
		
		return answers;		
	}

}
