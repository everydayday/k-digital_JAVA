package baekjoon;


/*
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
*/



// ===================================================================== //
// 다른 분 꺼

import java.io.*;
import java.util.StringTokenizer;

public class Baek2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        
        
        int[] num = new int[3];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] arr = howManySame(num);
        if (arr[0] == 0) {
            int maxNum = findMax(num);
            System.out.println(maxNum * 100);
        } else if (arr[0] == 2) {
            System.out.println(1000 + arr[1] * 100);
        } else if (arr[0] == 3) {
            System.out.println(10000 + arr[1] * 1000);
        }
        
        br.close();
    }
    
    public static int[] howManySame(int[] num) {	// 갯수, 같은 숫자 가지는 arr 반환
    	//  갯수, 같은 숫자 가지는 arr 선언
    	//int[] arr = new int[2];
    	int[] arr = {0, 0};	// 자료형 선언 후 바로 값 넣어 주기
    	int same_number = 0; // 주사위에 없는 값으로 초기화
    	// 3C2 만큼 비교 for문
    	for(int i = 0; i < num.length-1; i++) {	// 갯수 보다 한 칸 적은 idx 까지
    		int cnt = 1; 	// i 랑 같은 애 갯수
    		
    		for(int j = i+1; j < num.length; j++) {
    			if(num[i] == num[j]) {
    				cnt ++;
    				same_number = num[i];
    			}
    		}
    		if(cnt > 1) {
    			arr[0] = same_number;
    			arr[1] = cnt;
    			return arr;
    		}
    		
    		
    	}
    	return arr;
    	
    	
    	
    	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    	/*
        int[] arr = {0, 0};							// 같은 거 갯수, 숫자
        int count = 0;
        int sameNum = 0;
        for (int i = 0; i < num.length; i++) {
            count = 1;								// 같은 거 하나 찾으면 같은 거 갯수가 2로 됨
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] == num[j]) {
                    count++;						
                    sameNum = num[i];
                }
            }
            if (count > 1) {
                arr[0] = count;
                arr[1] = sameNum;
                return arr;
            }
        }
        return arr;
        */
    }
    
    public static int findMax(int[] num) {
        int maxNum = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > maxNum) {
                maxNum = num[i];
            }
        }
        return maxNum;
    }
}







