package chap3_검색;

// Arrays.sort
// collections.sort
// list.sort
// 내가 구현


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Train_스트링리스트정렬 {

	    public static String[] removeElement1(String[] arr, String item) {
	    	// 배열로 바꾸고
	    	// for loop 돌림
	    	
	    	// 현재 배열에서 중복 제거할려고 하면 코드가 길어진다
	    	// 배열을 리스트 변환 > list.remove();
	    	// 삭제된 리스트를 배열로 변환하여 리턴
	    	
	    	ArrayList<String> alist = new ArrayList<>(Arrays.asList(arr));
	    	alist.remove(item);
	    	
	    	return alist.toArray(String[]::new);
	    	
	    }
	    
	    static void getList(List<String> list) {	// 자료형은 list 이나 가리키는 객체는 arraylist이다.
			list.add("서울");	list.add("북경");
			list.add("상해");	list.add("서울");
			list.add("도쿄");	list.add("뉴욕");


			list.add("런던");	list.add("로마");
			list.add("방콕");	list.add("북경");
			list.add("도쿄");	list.add("서울");

			list.add(1, "LA");
	    }
	    static void showList(String topic, List<String> list) {
	    	System.out.println(topic + "  ");
	    	for (String st : list) {
	    		System.out.print(st + "\t");
	    	}

	    }
	    static List<String> sortList(List<String> list) {
	    	// 방법 1: list.sort(null);
	    	//list.sort((x1, x2) -> x1.compareTo(x2));	// comparator 안 줘도 내부적으로 구현되어 있음
	    	
	    	//list.sort(null);
	    	
	    	// 할 필요 없다. => 이미 list 자료형으로 받으므로
//	    	ArrayList<String> lst = new ArrayList<String>(list); 	// ArrayList comparator 구현 방법?
//	    	lst.sort(null);
	    	
	    	// 방법 2: 리스트를 스트링 배열로 변환 >
	    	String cities[] = new String[0]; // String[0] 하는 이유? => List를 String[] 으로 만들겠다. :: 메모리 할당
	    	cities = list.toArray(cities);	// 크기는 상관 없나봐.... 그냥 객체 할당만 하면 되는 듯..?
	    	
	    	int count = cities.length;
	    	for(int i = 0 ; i < count; i++) {
	    		for(int j = i+1; j < count; j++) {
	    			if(cities[i].compareTo(cities[j]) > 0) {
	    				// swap
	    				String temp = cities[i];
	    				cities[i] = cities[j];
	    				cities[j] = temp;
	    			}
	    		}
	    	}	    	
	    	
	    	list = new ArrayList<>(Arrays.asList(cities));	// list 는 매개변수 일 뿐일. 원본이 아니다.  왜 = 대입하면 안 될까.
	    	// 원본 바꾸는 방법 1
	    	/*
	    	list.clear();
	    	list.addAll((Arrays.asList(cities)));
	    	*/
	    	// 원본 바꾸는 방법 2
//	    	for(int i = 0; i < list.size(); i++) {
//	    		list.set(i,cities[i]);
//	    	}
	    	
	    	System.out.println("list:"+ list);
	    	return list;
	    	
	    }	
	    
	    static String[] removeDuplicateList(List<String> list) {	
	    	/*
	    	 *  리스트를 배열로 변환 > 배열에서 중복을 찾는다
	    	 */
		    String cities[] = new String[0];	// 디폴트로 String 메모리 잡음
		    cities = list.toArray(cities);		/// String[] 배열로 바꾸는 느낌인 듯(생성자로 넣어줘서)
		    
		    // 1. list를 배열로 바꾸고
		    // 2. 배열의 사이즈를 체크해서 사이즈 부족 시, 새롭게 공간 할당 함(list 사이즈로)
		    // list를 배열 cities[] 로 변환
		    // for문으로 도시가 중복인 것을 체크 : compareTo를 사용해서 
		    // removeElement(cities, city) 호출
		    // arr를 list로 변경 Arrays.asList(arr) => 다시 arr로 변경
		    
		    int count = cities.length;
		    for(int i =  0; i < cities.length; i ++) {
		    	for(int j = i + 1; j < cities.length; j++ ) {
			    	if (cities[i].compareTo(cities[j])==0) { // 배열에서 중복 검사하여 참이면
				    	String city = cities[j];
			    		cities = removeElement1(cities, city);	// 배열에서 중복 제거		    
			    		j --;  // 같은 위치에서 다시 비교해야 할 수도 있어
				    
			    	}
		    	
		    	}
		    	
		    }
		    
		    
		    
		    
		    
		    return cities;
	    }
	    
	    
	    
		public static void main(String[] args) {
			ArrayList<String> list = new ArrayList<>();
			getList(list);
			showList("입력후", list);
			//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩

//		    Collections.sort(list);

//배열의 정렬
			List<String> l = sortList(list);
		    System.out.println();
		    showList("정렬후", l);
// 배열에서 중복제거
		    System.out.println();
		    System.out.println("중복제거::");
		  
		    String[] cities = removeDuplicateList(list);
		    
	        ArrayList<String> lst = new ArrayList<>(Arrays.asList(cities));
		    showList("중복제거후", lst);
		}
	}

