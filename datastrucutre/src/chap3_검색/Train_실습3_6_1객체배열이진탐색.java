package chap3_검색;

/*
 * Comparable 구현
 */
/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;
		
	public PhyscData2(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	@Override
	public String toString() {
		return "PhyscData2 [name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}
	@Override
	public int compareTo(PhyscData2 p) {
		
		
		
		if (vision > p.vision)
			return 1;
		else if(vision < p.vision)
			return -1;
		else return 0;
			
		
		
		
	}
	public int equals(PhyscData2 p) {	// name으로 비교해야지
		if(name.compareTo(p.name) == 0) return 0;
		else return -1;
	}
}
public class Train_실습3_6_1객체배열이진탐색 {
	
	public static void swap(PhyscData2[] arr,int i, int j) {
		PhyscData2 temp = arr[i]; arr[i] = arr[j] ; arr[j] = temp; 
	}
	
	public static void showData(String str,PhyscData2[] arr) {
		// 확장형 for문으로 할 시 인덱스가 없어서 swap() 처리 안 됨		
		System.out.println(str);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].toString());
		}
	}
	
	public static void sortData(PhyscData2[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					swap(arr, i, j);
				}
			}
		}
	}
	
	public static void reverse(PhyscData2[] arr) {
		for(int i = 0 ; i < arr.length / 2; i ++) {
			swap(arr, i, arr.length - 1 - i);
		}
	}
	
	public static int linearSearch(PhyscData2[] data, PhyscData2 key) {
		int i = 0;
		while(i <= data.length) {
			if(data[i].compareTo(key) == 0) return 0;
			i ++;
		}
		return -1;
	}

	
	public static int binarySearch(PhyscData2[] data, PhyscData2 key) {
		int pl = 0; int pr = data.length -1;
		while(pl <= pr) {
			int mid = (pl + pr) / 2;
			if(data[mid].compareTo(key) == 0) return mid;
			if(data[mid].compareTo(key) < 0) pl = mid + 1;
			if(data[mid].compareTo(key) > 0 ) pr = mid - 1;
			
			
		}
		return -1;
	}

	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("나동", 164, 1.3),
				new PhyscData2("최길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("박동", 182, 0.6),
				new PhyscData2("이동", 167, 0.2),
				new PhyscData2("길동", 167, 0.5),
		};
		//Arrays.binarySearch(data, key, new Comp()); // ???
		if (data[0].compareTo(data[1])>0)
			System.out.println();
		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		reverse(data);
		showData("역순 재배치후", data);
		Arrays.sort(data);//사용된다 그 이유는? => 내가 만들어 놓은 compareTo를 사용해서 비교한다
		showData("Arrays.sort() 정렬후", data);
		
		PhyscData2 key = new PhyscData2("길동", 167, 0.2);
		int resultIndex = linearSearch(data, key);
		System.out.println("\nlinearSearch(<길동,167,02>): result = " + resultIndex);
		
		key = new PhyscData2("박동", 182, 0.6);
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//comparable를 사용
		System.out.println("\nbinarySearch(<박동,182,0.6>): result = " + resultIndex);
		key = new PhyscData2("이동", 167, 0.6);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);//comparable를 사용 => 내가만든 comparable 사용한다.
		System.out.println("\nArrays.binarySearch(<이동,167,0.6>): result = " + resultIndex);
	}
	
	

}
