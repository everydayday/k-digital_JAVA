// 객체 + 선형큐

package chap4_스택과큐;
//List를 사용한 선형 큐 구현  - 큐는 배열 사용한다 
import java.util.Random;
import java.util.Scanner;

import chap4_스택과큐.Queue4.EmptyQueueException;

/*
* Queue of ArrayList of Point
*/

class Point3 {
	private int ix;
	private int iy;

	public Point3(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
	@Override
	public boolean equals(Object p) {
		if ((this.ix == ((Point3)p).ix) && (this.iy == ((Point3)p).iy))
			return true;
		else return false;
	}
}

//int형 고정 길이 큐
class objectQueue2 {
  private Point3[] que;
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	//private int num; // 현재 데이터 개수

//--- 실행시 예외: 큐가 비어있음 ---//
	// 상속 받으므로 내부 클래스로 해야 한다
	public class EmptyQueueException extends Exception{
		private static final long serialVersionUID = 1L;
		public EmptyQueueException(String message) {
			super(message);
		}
		
	}


//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException{
		private static final long serialVersionUID = 1L;
		public OverflowQueueException(String message) {
			super(message);
		}
	}


//--- 생성자(constructor) ---//
public objectQueue2(int maxlen) {
	front = rear = 0;
	capacity = maxlen;
	que = new Point3[capacity];
}

//--- 큐에 데이터를 인큐 ---//
	public int enque(Point3 x) throws OverflowQueueException {
		// 데이터 가득 찼을 시
		if(rear == capacity) {
			throw new OverflowQueueException("enque is full.");
		}
		// 데이터 입력 하기
		que[rear++] = x;
		
		// 데이터 입력한 index 반환하기
		return rear-1;

	}

//--- 큐에서 데이터를 디큐 ---//
	public Point3 deque() throws EmptyQueueException {
		// 데이터 비었을 시
		if(front == rear) {
			throw new EmptyQueueException("deque is empty");
		}
		// 배열 => 데이터 삭제 안 됨. => front 값만 감소시켜줌
		// 객체 반환시켜 줌
		front ++;
		return que[front-1];

	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public Point3 peek() throws EmptyQueueException {
		// 데이터 비었을 시
		if(front == rear) {
			throw new EmptyQueueException("peek is empty");
		}
		
		return que[front];
		

	}

//--- 큐를 비움 ---peek처럼 구현//
	public void clear() {
		// 처음처럼 만들어 줌
		front = 0;
		rear = 0;
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(Point3 x) {
		// rear - front : 배열의 갯수
		for (int i = 0; i < rear - front ; i++) {
			int idx = (i + front) % capacity;
			if (que[idx].equals(x)) // 검색 성공
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
		//return num;	// num 쓰지 않고 반환 하기 : case 2가지 있음(원형일 때)
		return rear - front;
		
	}

//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		return rear - front <= 0;
	}

//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		return rear - front >= capacity;
	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		// 전체 출력 하면 안 됨
		// front 에서 rear -1 까지 출력
		for(int i = front; i < rear; i++) {
			System.out.println(que[i]);			
		}
		
	}

}
public class Train_실습4_4객체선형큐_배열 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		objectQueue2 oq = new objectQueue2(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point3 p = null;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(5)clear  (0)종료: ");
			int menu = stdIn.nextInt();
			if(menu == 0) break;
			switch (menu) {
			case 1: // 인큐

				rndx = random.nextInt(20);

				rndy = random.nextInt(20);
				System.out.print("입력데이터: (" + rndx + ", " + rndy + ")");
				p = new Point3(rndx,rndy);
				try {
					oq.enque(p);
				} catch(objectQueue2.OverflowQueueException e) {
					System.out.println("queue이 가득찼있습니다.");
					e.printStackTrace();
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (objectQueue2.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
					e.printStackTrace();
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (objectQueue2.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
					e.printStackTrace();
				}
				break;

			case 4: // 덤프
				oq.dump();
				break;
			case 5: //clear
				oq.clear();
		
				break;
			default:
				break;
			}
		}
		System.out.println("종료되었습니다.");
		
	}
}