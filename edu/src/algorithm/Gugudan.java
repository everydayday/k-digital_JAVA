package algorithm;

public class Gugudan {
	private int p;
	
	
	
	
	public void print(int i) {
		System.out.println(i + "단");
		for(int p = 1; p <= 9; p++) {
			System.out.println(i + "*" + p + "= " + i*p);
		}
		System.out.println(i+"단 구구단 출력 끝");
			
		
	}
	
	public void print_horizontal() {
		for(int i = 1; i <= 9 ; i ++) {	// i 는 행
			for(int j = 2; j <= 9; j++) { // j는 열
				System.out.print(j + "*" + i + "=" + j*i + "\t");
			}
			System.out.println(" ");
		}
		
		
	}
	
	public void printColum(int col) {
		
		for(int i = 2; i <= 9; i+= col) {	// i 는 단	다음 행은 cols 만큼 증가해야 함
			for(int j = 1; j <=9; j++) {	// j는 열
				int x = i;
				int y = j;					// x는 각각의 증가 열
				for(int k = 1; k <= col ; k++) {	//k는 col수
					System.out.print(x + "*" + y + "=" + x*y +"\t");
					x++;
					if(x >= 10) break;
				}
				System.out.println(" ");			
				
			}
			System.out.println("=".repeat(20));
			
			
			
		}
		
		
		
		
	}
	

}
