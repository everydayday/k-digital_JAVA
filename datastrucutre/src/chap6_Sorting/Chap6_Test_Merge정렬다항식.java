package chap6_Sorting;
/*
 * 6장 구현과제1
 */

class Polynomial3 implements Comparable<Polynomial3>{
    double coef;           // 계수
    int    exp;            // 지수

    Polynomial3(){}
    //--- 생성자(constructor) ---//
    Polynomial3(double coef, int exp) {
        this.coef = coef;  this.exp = exp; 
    }

    //--- 신체검사 데이터를 문자열로 반환 --//
    @Override
	public String toString() {
        return coef + "x**" + exp + " ";
    }
    @Override
    public int compareTo(Polynomial3 d2) { //지수가 같으면 계수로 비교
    	//System.out.println("d2: " + d2);
    	if(d2.exp - exp == 0) return (int) (d2.coef - coef);
    	return d2.exp - exp;
    }
}
public class Chap6_Test_Merge정렬다항식 {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(Polynomial3[] a, int lefta, int righta, int leftb, int rightb ) {
		 //body를 지우고 작성 훈련 연습이 도움이 된다 
		Polynomial3 temp[] = new Polynomial3[30];
		//구현코드
		int i = lefta; int j = leftb; int p = 0;
//		System.out.println(i + "a[i] : " + a[i]);
//		System.out.println(j + "a[j] : " + a[j]);
		while(i <= righta & j <= rightb) {
			if(a[i].compareTo(a[j]) < 0) {
				temp[p++] = a[i++];
			}
			else if(a[i].compareTo(a[j]) > 0) {
				temp[p++] = a[j++];
			}
			else {
				temp[p++] = a[i++];
				temp[p++] = a[j++];
			}
		}
		if(i > righta)
			while(j <= rightb) {
				temp[p++] = a[j++];
 			}
		else {
			while(i <= righta) {
				temp[p++] = a[i++];
			}
		}
		
		for(int m = 0; m < p; m++) {
			a[lefta+ m] = temp[m];
		}
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Polynomial3[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		//System.out.println("mid:" + mid);
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		//System.out.println("left,mid,right" + left + mid + right);
		merge(a, left, mid, mid+1, right);
		return;
	}
	static void ShowPolynomial(String str, Polynomial3[] x, int count) {
		//str 변수는 다항식 이름으로 스트링이다
		//count가 -1이면 다항식 x의 length로 계산하고 -1이면 count가 다항식 항의 숫자이다 
		//정렬후 다항식 x = 2.5x**7  + 3.8x**5  + 3.1x**4  + 1.5x**3  + 3.3x**2  + 4.0x**1  + 2.2x**0 
		int n = 0;
		if (count < 0)
			n = x.length;
		else
			n = count;
		//구현코드
		System.out.print(str + " ");
		for(int i = 0; i < n; i++) {			
			System.out.print(x[i]);
			// + 를 어떻게...
		}
		System.out.println();
	}
	static int AddPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
		//z = x + y, 다항식 덧셈 결과를 z로 주고 z의 항의 수 terms을 리턴한다 
		int p=0,q=0,r=0;
		int terms = 0;	// 항의 수
		
		//구현코드		
		while(p < x.length & q < y.length) {			
			if(x[p].compareTo(y[q]) < 0) {				
				z[r++] = x[p++];
				terms++;
			}
			else if(x[p].compareTo(y[q]) > 0) {
				z[r++] = y[q++];
				terms++;
			}
			else {
				z[r++] = x[p++]; 
				q++; 
				terms++;
			}
		}
		
		if(p < x.length) {
			while(p < x.length) {
				z[r++] = x[p++];
				terms++;
			}
		}else {
			while(q < y.length) {
				z[r++] = x[q++];
				terms++;
			}
		}		
		return terms;		
	}
	static int addTerm(Polynomial3[]z, Polynomial3 term, int terms) {
		//다항식 z에 새로운 항 term을 추가한다. 지수가 같은 항이 있으면 계수만 합한다
		//추가된 항의 수를 count하여 terms으로 리턴한다.
		//구현코드
		for(int i = 0; i < terms; i++) {
//			System.out.println("terms:" + terms);
//			System.out.println("z[i].exp:"+ z[i].exp);
			if(z[i].exp == term.exp) {
				z[i].coef += term.coef;				
				return terms;
			}
		}
		// 추가
		z[terms] = term;
		
		return ++terms;
			
	}
	static int MultiplyPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
		//z = x * y, 다항식 z의 항의 수는 terms으로 리턴한다 
		//terms = addTerm(z, term, terms);사용하여 곱셈항을 추가한다.
		int p=0,q=0,r=0;	// p : x
		int terms = 0;
		for( ; p < x.length ; p++) {
			for( ; q < y.length ; q++)
			{
				
				Polynomial3 newTerm = new Polynomial3();
				newTerm.coef = x[p].coef * y[p].coef;
				newTerm.exp = x[p].exp + y[p].exp;
				terms = addTerm(z, newTerm, terms);
				z[r++] = newTerm;
			}
			
		}
		//구현코드
		
		return terms;
	}
	static double EvaluatePolynomial(Polynomial3[]z, int zTerms, int value) {
		//zTerms는 다항식 z의 항의 수, value는 f(x)를 계산하기 위한 x 값
		//다항식 계산 결과를 double로 리턴한다 
		double result = 0.0;
		
		//구현 코드
		int i = 0;
		while(i < zTerms) {
			
			result += z[i].coef * Math.pow(value, z[i].exp);
			i++;
		}
		
		return result;
	}
	public static void main(String[] args) {
		Polynomial3[] x = {
		         new Polynomial3(1.5, 3),
		         new Polynomial3(2.5, 7),
		         new Polynomial3(3.3, 2),
		         new Polynomial3(4.0, 1),
		         new Polynomial3(2.2, 0),
		         new Polynomial3(3.1, 4),
		         new Polynomial3(3.8, 5),
		     };
		Polynomial3[] y = {
		         new Polynomial3(1.5, 1),
		         new Polynomial3(2.5, 2),
		         new Polynomial3(3.3, 3),
		         new Polynomial3(4.0, 0),
		         new Polynomial3(2.2, 4),
		         new Polynomial3(3.1, 5),
		         new Polynomial3(3.8, 6),
		     };
		int nx = x.length;


		ShowPolynomial("다항식 x = ", x, -1);
		ShowPolynomial("다항식 y = ", y, -1);
		//System.out.println("x.length -1 : " + (x.length-1));
		MergeSort(x, 0, x.length-1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length-1); // 배열 x를 퀵정렬 // 인덱스로 접근하니 -1해줘야
		ShowPolynomial("정렬후 다항식 x = ", x, -1);
		ShowPolynomial("정렬후 다항식 y = ", y, -1);
		
		Polynomial3[] z = new Polynomial3[20];
		
		for (int i =0; i < z.length; i++)
			z[i] = new Polynomial3();
	
		int zTerms = AddPolynomial(x,y,z);//다항식 덧셈 z = x + y : 덧셈 후 항의 갯수
		ShowPolynomial("덧셈후 다항식 z = ", z, zTerms);
		System.out.println();
		
		zTerms = MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y  => z 항의 개수
		MergeSort(z, 0, zTerms); // 배열 x를 퀵정렬 ... zTerms - 1 이여하지 않나?
		ShowPolynomial("곱셈후 다항식 z = ", z, zTerms);
		
		double result = EvaluatePolynomial(z, zTerms, 1);//다항식 값 계산 함수 z(10) 값 계산한다 
		System.out.println(" result = " + result );
	}
}
