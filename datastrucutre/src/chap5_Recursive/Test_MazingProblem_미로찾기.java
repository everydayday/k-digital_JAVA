package chap5_Recursive;

import java.util.ArrayList;
import java.util.List;

enum Directions2 {N, NE, E, SE, S, SW, W, NW}

// ===== Class : Items3 =====
class Items3 {
	int x; int y; int dir;
	public Items3(int x, int y, int d) {
		this.x = x; this.y = y; this.dir = d;
	}
	@Override
	public String toString() {
		return "x = " + x + ", y = " + y + ", dir = " + dir;
	}
}
//===== Class : Offsets3 =====
class Offsets3 {
	public int a;
	public int b;
	public Offsets3(int a, int b) {
		this.a = a; this.b = b;
	}
}

// ==== Class : StackList ====
	class StackList {
	private List<Items3> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터
	
	

	// --- 실행시 예외 : 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public EmptyIntStackException() {
		}
	}

	// --- 실행시 예외 : 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public OverflowIntStackException() {
		}
	}

	// --- 생성자(constructor) ---//
	public StackList(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<>(0); // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public void push(Items3 p) throws OverflowIntStackException {
		if (top >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException();
		data.add(p);top++;
		return;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Items3 pop() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data.remove(--top);
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Items3 peek() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data.get(top - 1);
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(벌견하지 못하면 –1)를 반환 ---//
	public int indexOf(Items3 x) {
		for (int i = top - 1; i >= 0; i--) // 정상 쪽에서 선형검색
			if (data.get(i).equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	// --- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
		if (top <= 0)
			System.out.println("스택이 비어있습니다.");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}
	
	
	// ============= public class ================
	public class Test_MazingProblem_미로찾기 {
		// Offsets => Offsets3 로 변경 (Offsets3가 선언되어 있음)
		static Offsets3[] moves = new Offsets3[8];//static을 선언하는 이유를 알아야 한다

		public static void path(int[][] maze, int[][] mark, int ix, int iy) {

			for(int i = 0; i < mark.length; i++) {
				mark[i][0] = i;
			}
			
			mark[1][1] = 1;
			StackList st = new StackList(50);
			Items3 temp = new Items3(0, 0, 0); //N :: 0
			
			temp.x = 1;	
			temp.y = 1;	
			temp.dir = 2;//E:: 2 


			mark[temp.x][temp.y] = 2;//미로 찾기 궤적은 2로 표시   
			
			st.push(temp);
			
			boolean isflag = false;
			boolean isfirst = true;
			
			
			// ====== start ========= //
			while (!st.isEmpty()) // stack not empty
			{
				
//				if(isfirst) isfirst = false;
//				else mark[temp.x][temp.y] = 1;   //backtracking 궤적은 1로 표시
			
				
				// 현재 위치
				Items3 tmp = st.pop(); // unstack
				int i = tmp.x;
				int j = tmp.y;
				int d = tmp.dir;
//				System.out.println("i : " + i);
//				System.out.println("j : " + j);
				
				mark[tmp.x][tmp.y] = 1; 
				

//				System.out.println("size = top : " + st.size());
				
//				System.out.println("st.dump : ");
//				st.dump();
				// peek 및 pop 수정
				System.out.println("i: " + i + " j:" + j);
				while (d < 8) // moves forward
				{
					// 다음 위치 
					
					int g = i + moves[d].a;
					int h = j + moves[d].b;					
					
					
					System.out.println("g: " + g + " h:" + h + " d:" + d);
					// 원하는 지점에 도착
					if ((g == ix) && (h == iy)) { // reached exit // output path							
						mark[i][j] = 2;	
						System.out.println("wanted path");
						isflag = true;
						break;
					}				
					if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position => 갈 수 있고 한 번도 안 가본 곳
						
						
						// 현재 좌표, 방향 stack에 넣어주기
						// temp랑 tmp 다르다 => 새로 생성하는 객체 vs 이미 메모리에 한번 저장된 객체
//						temp.dir = d;
//						System.out.print("temp: ");
//						System.out.println(temp.toString());
//						System.out.println("before st.push :");
						// 현재값 넣어주기
						Items3 itm3 = new Items3(i,j,d);
						st.push(itm3);
						mark[i][j] = 2;//미로 찾기 궤적은 2로 표시
						// 업데이트
						i = g; j = h; 
//						// pop 을 위해 존재 temp
//						temp.x = g;	
//						temp.y = h;		
						// 초기화
						d = 0;						
						

					} else {						
						d++;
					}

				}
				if(isflag) break;	// 원하는 위치 도달 시 break
				mark[i][j] = 1;
//				System.out.println("last here");
				
			}
			
			System.out.println("no path in maze ");
		}
		
		
		static void showMatrix(int[][]d, int row, int col) {
			for(int i = 0; i <= col; i++) System.out.print(i + "\t");
			System.out.println();
			System.out.println("-".repeat(130));
//			System.out.println("=".repeat(50));
			for (int i = 0; i <= row; i++) {
				for (int j = 0; j <= col; j++) {
					System.out.print(d[i][j] + "\t");

				}
				System.out.println();
			}
		}
		
		
		public static void main(String[] args) {
			int[][] maze = new int[14][17];
			int[][] mark = new int[14][17];

			int input[][] = { // 12 x 15
					{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
					{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
					{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
					{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
					{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
					{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
					{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
					{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
					{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
			
			int input1[][] = { // 12 x 15
					{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
					{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
					{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
					{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
					{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
					{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
					{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
					{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
					{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
			
			
			for (int ia = 0; ia < 8; ia++)
				moves[ia] = new Offsets3(0, 0);//배열에 offsets 객체를 치환해야 한다.
			moves[0].a = -1;	moves[0].b = 0;
			moves[1].a = -1;	moves[1].b = 1;
			moves[2].a = 0;		moves[2].b = 1;
			moves[3].a = 1;		moves[3].b = 1;
			moves[4].a = 1;		moves[4].b = 0;
			moves[5].a = 1;		moves[5].b = -1;
			moves[6].a = 0;		moves[6].b = -1;
			moves[7].a = -1;	moves[7].b = -1;
			//Directions d;
			//d = Directions.N;
			//d = d + 1;//java는 지원안됨
			for (int i = 0; i < 14; i++) {
				for (int j = 0; j < 17; j++) {
					if(i == 0 || j == 0 || i == 13 || j == 16) maze[i][j] = 1;
					else maze[i][j] = input[i-1][j-1];
					// input[][]을 maze[][]로 변환
				}
			}
			System.out.println("maze[12,15]::");
			showMatrix(maze, 13, 16);
		
			System.out.println("mark::");
			showMatrix(mark, 13, 16);

			path(maze, mark, 13, 15);
			System.out.println("mark::");
			showMatrix(mark, 13, 16);
			
		}
	}

