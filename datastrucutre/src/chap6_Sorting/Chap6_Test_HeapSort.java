package chap6_Sorting;

import java.util.Random;
import java.util.Scanner;
//*
interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // current size of MaxHeap
	private int MaxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {
		MaxSize = sz;
		n = 0;
		heap = new int[MaxSize+1];

	}

	public void display() {
		for(int i = 1; i <= n; i++) {
			System.out.printf("%d ",heap[i] );
		}

	}
	@Override
	public void Insert(int x) {
		if(n == MaxSize) HeapFull(); return;
		n ++;	//  x가 들어갈 첫번째 후보
		int i = n;
		for( ; i >= 1; i /= 2 ) {
			if(i == 1) break;
			if(heap[i/2] >= x) break;
			heap[i] = heap[i/2];	 // move from parent to i		
		}
		heap[i] = x;
	}
	@Override
	public int DeleteMax() {
		int i , j;
		if(n == 0) {HeapEmpty(); return 0;}
		int x = heap[1]; int k = heap[n]; n--;
		
		for(i = 1, j = 2; j <= n; ) {
			if(heap[j] < heap[j+1]) j++;
			
			if(k >= heap[j]) break; // ?
			heap[i] = heap[j];
			i = j; j *= 2;	
			
		}
		heap[i] = k;
		return x;

	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}
public class Chap6_Test_HeapSort {
	 static void showData(int[] d) {
	     for (int i = 0; i < d.length; i++)
	         System.out.print(d[i] + " ");
	     System.out.println();
	 }
	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 10;	//
	    int[] x = new int[count+1];
	    int []sorted = new int[count];

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:	
				System.out.println("input value: ");
				int num = stdIn.nextInt();
				heap.Insert(num);
				heap.display();
				
				break;
			case 2:
				heap.display();
				break;
			case 3:
				
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}
*/