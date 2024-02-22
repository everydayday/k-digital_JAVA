package com.ruby.java.ch08;

class Node3 {
	int data;
	Node3 link; // 다음 class 주소

	public Node3(int data) { // 생성자 생성 시 데이터 지정
		this.data = data;
		link = null;
	}
}

class LinkedList3 {
	Node3 first; // head 역할인 듯

	public LinkedList3() {
		first = null;
	}

	void append(int data) {
		/*
		 * //== 교수님 ver == 
		 * Node3 p = first, q = null; 
		 * Node3 newNode = new Node3(data);
		 * if(p == null) 
		 * { first = newNode; 
		 * return; // return 해줘야 끝남 
		 * }else 
		 * { while (p !=null)
		 *  { q = p; 
		 *  p = p.link; } 
		 *  q.link = newNode; 
		 *  }
		 * 
		 * // =======
		 */
		Node3 p = first, q = null; // p 현재 Node , q 과거 Node
		Node3 newNode = new Node3(data);
		if (first == null) {
			first = newNode;
			
		} else {			
			
			while (p != null) {	// 현재까지
				q = p; // 과거 Node q -> 현재 p 로 업데이트
				p = p.link; // 현재 Node p -> 다음 노드 p로 업데이트
			}
			q.link = newNode;	// 현재 값: null 과거 값  newNode와 ㅏ연결
		}
		
		// ====== 개인 연습 ======= //
		
		Node3 nd = new Node3(data);
		if(first == null) {
			first = nd;
		}
		else {
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

	void showList() {
		System.out.println();
		Node3 p = first;
		int num = 1;
		while(p != null) {
			System.out.println(num + "번째 data 값 :" + p.data);
			p = p.link;
			num ++;
		}

	}

	void insert(int data) {
		Node3 newNode = new Node3(data);
		if(first == null) {	// 아무것도 없는 경우
			first = newNode;
			return;
		}
		Node3 p = first, q = null;	// p 현재 q 과거
		while(data > p.data) {		// 부등호 방향 주의: while 문 안
			q = p; 				// 과거에 현재 넣어주기
			p = p.link;			// 현재에 미래 넣어주기
		}
		// 현재 노드에 값 넣을거다
		if(p == first) {	// 첫번재 입력
			q = newNode;	// q에 newnode
			q.link = first;	// q는 first 가리킴
			first = q;		// q가 시작 부분
		}else {
			q.link = newNode;
			newNode.link = p;
		}
	}
}

// ########### for part1

public class Test_ch08_연결리스트와배열 {

	// static count 반환하는 메소드 => what is count : 배열의 총 갯수
	// ========= getList 메소드
	static int getList(int[] data) {
		int count = 0;
		int mid = data.length / 2;
		for (int i = 0; i <= mid; i++) { // 왜 절반만 넣어주지? => 값 넣어주려고 임의 지정했네
			data[i] = i * 5;
			count++;
		}
		return count;
	}

	// static list 보여주는 메소드
	// ======= showList 메소드
	static void showList(int[] data) {
		System.out.println();
		for (int i = 0; i < data.length; i++)
			System.out.print(" " + i + " ");
		System.out.println();
		System.out.println("-".repeat(30));
		for (int i = 0; i < data.length; i++) {
			if (data[i] < 10)
				System.out.print(" ");
			System.out.print(data[i] + " ");
		}
		System.out.println("\n");
	}

	// static insertList 메소드
	static int insertList(int[] data, int count, int x) {	// 오름차순으로 넣기
		int indx = 0; 
		// ==== 교수님 ver ========
		/*
		while(indx < count) {
			if(x < data[i]) {
				while(indx < count) {
					int temep = data[i];
					data[indx] = x;
					x = data[++indx];
				}
				break;
			}
			else {
				indx ++;
				}
		}
		*/
		// ==================
		
		while(indx < count) {
			if(x > data[indx]) {	// x를 기준으로 코딩하는게 좋아
				indx ++;
				continue;			// while문 바로 돌아가도록
			}
			else {
				// 이동 시켜 줌
				while(indx <= count) {	// indx 는 숫자를 집어넣는 곳 까지
					int tmp = data[indx];
					data[indx] = x;	// x는 집어 넣을 값
					x = tmp; 
					indx ++;
				}
				break;
			}
			
		}		
		
		//count++;
		return ++count;
	}

	// =========== main ====================
	public static void main(String[] args) {
		// *************** part 1 ok
		int[] list = new int[10];
		int count = 0;
		System.out.println("배열로 리스트::");
		count = getList(list);
		showList(list);
		count = insertList(list, count, 3);
		showList(list);
		count = insertList(list, count, 7);
		showList(list);

		// *************** part 2
		LinkedList3 ll = new LinkedList3();
		ll.append(5);
		ll.append(10);
		ll.append(15);
		ll.append(20);
		ll.append(25);
		ll.showList();
		ll.insert(3);
		ll.showList(); // data 값 크기 순으로 배열하기
		ll.insert(7);
		ll.showList();
		
		
	}
}
