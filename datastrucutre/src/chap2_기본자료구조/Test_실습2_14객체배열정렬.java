package chap2_기본자료구조;

import java.util.Arrays;

// 구글링: comparator, comparable 차이가 무엇, 사용 예 파악
//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;
	
	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;		
	}

	
	@Override
	public String toString() {
		return "PhyscData [name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}
	
	@Override
	public int compareTo(PhyscData p) {
		int cmp1 = this.name.compareTo(p.name);
	
		if(cmp1 < 0) return -1;
		else if (cmp1 > 0) return 1;
		else {
			if (this.height < p.height) return -1;	// 내 키가 더 작으면
			else if (this.height > p.height) return 1; // 내 키가 더 크면
			else {
				if (this.vision < p.vision) return -1;
				else if (this.vision > p.vision) return 1;
				else return -1; // 모든 게 다 같으면 그냥 -1 return
			}
		}
			

	}
	public int equals(PhyscData p) {	// 모든 게 같아요 0 조건 만족하는 것으로
		int cmp1 = this.name.compareTo(p.name);
		
		if(cmp1 < 0) return -1;
		else if (cmp1 > 0) return 1;
		else {
			if (this.height < p.height) return -1;	// 내 키가 더 작으면
			else if (this.height > p.height) return 1; // 내 키가 더 크면
			else {
				if (this.vision < p.vision) return -1;
				else if (this.vision > p.vision) return 1;
				else return 0; // 모든 게 다 같으면 0 return
			}
		}

	}
}

public class Test_실습2_14객체배열정렬 {
	static void swap(PhyscData[]arr, int ind1, int ind2) {
		PhyscData a = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = a;
		
	}
	static void sortData(PhyscData []arr) {
		for(int i = 0; i < arr.length; i++)
			for(int j = i+1; j < arr.length; j++)
				if(arr[i].compareTo(arr[j]) > 0)
					swap(arr,i,j);
		
	}
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};
		showData(data);
		System.out.println("=".repeat(30));
		sortData(data);
		//Arrays.sort(null, null);//comparator가 필요하다 
		showData(data);
	}
	static void showData(PhyscData[]arr) {
		for(PhyscData data : arr) {
			System.out.println(data.toString());
		}

	}

}
