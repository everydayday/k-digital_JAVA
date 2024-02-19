package com.ruby.java.ch08;

class Node3 {
	int data;
	Node3 link;
	public Node3(int data) {	// 생성자 생성 시 데이터 지정
		this.data = data; link = null;
	}
}
class LinkedList3 {
	Node3 first;
	void append(int data) {
		Node3 p = first, q = null;


	}
	void showList() {
		System.out.println();
		Node3 p = first;

	}
	void insert(int data) {
		Node3 newNode = new Node3(data);
		Node3 p = first, q = null;


	}
}

// ########### for part1

	public class Test_ch08_연결리스트와배열 {
		// count 반환하는 메소드 => what is count? 배열의 총 갯수..? 
		static int getList(int[]data) {
			int count = 0;
			int mid = data.length/2;
			for (int i = 0; i <= mid; i++) {	// ?왜 절반만 넣어주지?
				data[i] = i * 5; count++;
			}
			return count;
		}
		// list 보여주는 메소드
		static void showList(int[]data) {
			System.out.println();
			for (int i=0; i < data.length; i++)
				System.out.print(" " + i + " ");
			System.out.println();
			System.out.println("-".repeat(30));
			for (int i = 0; i < data.length; i++) {
				if (data[i] < 10)
					System.out.print(" ");
				System.out.print(data[i]+ " ");
			}
			System.out.println("\n");
		}
		static int insertList(int[] data, int count, int x) {
			int indx = 0;	//?
			
			data[count] = x;
			count ++;
			
			return count;
		}
		
		// =========== main ====================
		public static void main(String[] args) {
			// *************** part 1 
			int[]list = new int[10];		
			int count = 0;
			System.out.println("배열로 리스트::");
			count = getList(list);
			showList(list);
			count = insertList(list, count, 3);
			showList(list);
			count = insertList(list, count, 7);
			showList(list);
			
			// *************** part 2
			LinkedList3 ll = new LinkedList3();	// 생성자 없이 하는 ll..?
			ll.append(5);ll.append(10);ll.append(15);ll.append(20);ll.append(25);
			ll.showList();
			ll.insert(3);ll.showList();	//? 3에 어떤 데이터 값을..?
			ll.insert(7);ll.showList();
			
		}
	}
