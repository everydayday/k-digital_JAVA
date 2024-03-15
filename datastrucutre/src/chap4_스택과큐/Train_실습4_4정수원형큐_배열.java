package chap4_스택과큐;
/*
 * 큐에서는 예외 클래스를 만드는 연습
=========== 원형 ==========
 */
import java.util.Random;
/*
 * 큐 1번 실습 코드 - 정수들의 큐
 */
import java.util.Scanner;
// front 랑 rear가 같아지는 경우는 2 case 
// 1. 시작할 때
// 2. que가 가득 찼을 때
//int형 고정 길이 큐

import chap4_스택과큐.IntQueue3.EmptyIntQueue3Exception;

class IntQueue3 {
	private int[] que; // 큐용 배열
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	//private int num; // 현재 데이터 개수
	//boolean firsted = false; // isfull 사용 시 필요 없음
	boolean isfull = false;	// rear 랑 front가 같아졌을 시, 구분하기 위해서

//--- 실행시 예외: 큐가 비어있음 ---//
	class EmptyIntQueue3Exception extends Exception{
		public EmptyIntQueue3Exception(String message) {
			super(message);
		}
	}
	
//--- 실행시 예외: 큐가 가득 찼음 ---//
	class OverflowIntQueue3Exception extends Exception{
		public OverflowIntQueue3Exception(String message) {
			super(message);
		}
	}

//--- 생성자(constructor) ---//
	public IntQueue3(int maxlen) {
		front = rear = 0;
		capacity = maxlen;		
		que = new int[capacity];
	}

//--- 큐에 데이터를 인큐 ---//
	public int enque(int x) throws OverflowIntQueue3Exception {
		// 초기 상태 아니고 front == rear 인 경우
		if(isFull())
			throw new OverflowIntQueue3Exception("enque is overflow");
		//firsted = true; // 방문 했다 isfull 사용 시 필요 없음
		que[rear] = x;
		rear ++;
		if(rear >= capacity) // 값을 넣어주려는 index가 capacity 넘어섰을 시
			rear = 0;
		if(rear == front) isfull = true; //비어서 같아졌는지 가득 차서 같아졌는지 확인하기 위해
		System.out.print("All que :" );
		for(int i : que) System.out.print(i + "\t");
		return x;		

	}

//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyIntQueue3Exception {
		if (isEmpty())
			throw new EmptyIntQueue3Exception("deque is empty");
		int temp = que[front];  // 사라질 값
		front ++;
		if(front >= capacity ) { // front가 capacity 넘어섰을 시
			front = 0;
		}
		if(front == rear) isfull = false; // To know isempty and isfull
		
		System.out.print("All que :" );
		for(int i : que) System.out.print(i + "\t");
		System.out.println("front :" + front);
		return temp;	// 사라진 값 반환
	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntQueue3Exception {
		if (isEmpty())
			throw new EmptyIntQueue3Exception("peek is empty");
		return que[front];

	}

//--- 큐를 비움 ---//
	public void clear() {
		front = rear = 0; // 맨 처음 상황으로
		isfull = false;		
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	// 빈 큐에서 검색하는 경우 예외 발생
	public int indexOf(int x) {
		int length = size();
		for (int i = 0; i < length; i++) {
			int idx = (i + front) % capacity;
			if (que[idx] == x) // 검색 성공
				return idx;
		}
		return -1; // 검색 실패
	}

//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		int length;
		if(isEmpty()) return 0;
		if(front < rear) length = rear - front;
		else length = capacity - (front - rear);
		return length;
	}

//--- 원형 큐가 비어있는가? --- 수정 필요//
	public boolean isEmpty() {
		// full에 의해 같아지는 경우랑 구분해야 한다.
		return front == rear && !isfull ;
	}

//--- 원형 큐가 가득 찼는가? --- 수정 필요//
	public boolean isFull() {
		return front == rear && isfull;
	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() throws EmptyIntQueue3Exception{
		if(isEmpty()) throw new EmptyIntQueue3Exception("dump is empty");
		int length = size();
		for (int i = 0; i < length; i++) {
			int idx = (i + front) % capacity;
			//System.out.print("idx: "+ idx + "\t que[idx]:" + que[idx] + "\t");
			System.out.print(que[idx] + "\t");
		}
		System.out.println();	
		
	}

}

public class Train_실습4_4정수원형큐_배열 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue3 oq = new IntQueue3(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, p = 0;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(5)clear  (0)종료: ");
			int menu = stdIn.nextInt();
			switch (menu) {
			case 1: // 인큐
				rndx = random.nextInt(20);
				System.out.println("입력데이터: (" + rndx +")");
				try {
					oq.enque(rndx);
				} catch(IntQueue3.OverflowIntQueue3Exception e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (IntQueue3.EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (EmptyIntQueue3Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Peek is full");
					e.printStackTrace();
				}
				break;

			case 4: // 덤프
				try {
					oq.dump();
				} catch (IntQueue3.EmptyIntQueue3Exception e) {
					System.out.println("queue이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;
			case 5: //clear
				oq.clear();
				break;
			default:
				break;
			}
		}
	}

}