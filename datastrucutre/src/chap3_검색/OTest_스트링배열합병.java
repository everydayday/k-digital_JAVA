package chap3_검색;

/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;	// merge 병합
import java.util.List;
public class OTest_스트링배열합병 {
    static void showList(String topic, String [] list) {
    	System.out.print(topic);
    	for(int i = 0; i < list.length; i++)
    		System.out.print(list[i] + "\t");   
    	System.out.println();

    }
    static String[] mergeList(String[]s1, String[] s2) {
    	int i = 0, j = 0,k =0;	// i 는 s3 index // j, k 는 s1, s2의 인덱스
    	String[] s3 = new String[10];
    	// s1 추가
    	for( ; j < s1.length ; i++, j++) {
    		s3[i] = s1[j];
    	}
    	
    	// s2 추가
    	for( ; k < s2.length; i++, k++) {
    		s3[i] = s2[k];
    	}
    	
    	
    	return s3;
    }
    
    
    
    public static void main(String[] args) {
	String[] s1 = { "홍길동", "강감찬", "을지문덕", "계백", "김유신" };
	String[] s2 = {"독도", "울릉도", "한산도", "영도", "우도"};
	Arrays.sort(s1);	// comparable, comparator도 없다 => comparable의 compareTo()사용
	Arrays.sort(s2);
	// 후속 코딩은 객체들의 정렬 : Students 클래스를 만들고 정렬
	showList("s1배열 = ", s1);
	showList("s2배열 = ", s2);

	String[] s3 = mergeList(s1,s2);
	showList("스트링 배열 s3 = s1 + s2:: ", s3);
}
}
