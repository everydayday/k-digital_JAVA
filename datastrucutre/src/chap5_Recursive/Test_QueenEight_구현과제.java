package chap5_Recursive;

//해가 256개 확인 필요 23.12.12
import java.util.ArrayList;
import java.util.List;

import chap5_Recursive.Stack4.EmptyGenericStackException;


//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking
//모든 해가 나오는 버젼 만들기 
/*
 * 체스판은 8 x 8 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
 * Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
 * pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능 체스판 최대 배치 문제 : king/16,
 * Queen/8, rook/8, bishop/?, knight/? rook 2개/a, h, knight 2개/b, g, bishop
 * 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
 */
class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
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
		if ((this.ix == ((Point) p).ix) && (this.iy == ((Point) p).iy))
			return true;
		else
			return false;
	}
}

// ============== point =============

class Stack4 {
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		private static final long serialVersionUID = 1L;

		public EmptyGenericStackException(String message) {
			super(message);
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException(String message) {
			super(message);
		}
	}

	private List<Point> data; // 스택용 배열
	// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 생성자(constructor) ---//
	public Stack4(int capacity) {		
		top = -1;
		data = new ArrayList<Point>();
		
		try {	// 음수 들어오는 case
			this.capacity = capacity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// --- 스택에 x를 푸시 ---//
	public void push(Point x) throws OverflowGenericStackException {
		if(isFull())
			throw new OverflowGenericStackException("Push is full");
		// x, y 입력
		data.add(x);		
		top ++;		

	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		if(isEmpty())
			throw new EmptyGenericStackException("Pop is empty");		
		data.remove(top);
		top --; 
		Point temp = data.get(top);		
		return temp;

	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		if(isEmpty()) {
			throw new EmptyGenericStackException("peek is empty");
		}
		return data.get(top-1);
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = -1;	// top은 가장 마지막에 들어있는 자료값
	}

	// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
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

	// --- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() throws EmptyGenericStackException{
		if (top < 0)
			throw new EmptyGenericStackException("stack:: dump - empty");
		else {
			for (int i = 0; i <= top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}

public class Test_QueenEight_구현과제 {
	/// 배치할 수 있는 모든 case 출력?
	public static void EightQueen(int[][] d) {
		int count = 0;// 퀸 배치 갯수
		int numberSolutions = 0;
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack4 st = new Stack4(100); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
		st.push(p);// 스택에 현 위치 객체를 push	 ... top도 증가함
		d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
		count++; 	// 다음 행으로 이동		
		/// 175 p. 참조
		// 코드에 주석으로 알고리즘 로직을 작성
		while (true) {
			/*
			if(int newCol = nextMove(d, ix, iy)!= -1){
			}
			else { }
			*/
			if(count == 8)	break; // 가득 찼을 때 // 본인 넣고 다음 이동하므로 count가 7일 때
			if(nextMove(d, ix, iy)!= -1) { // 체스판의 다음 행에 퀸을 배치할 수 있으면
				// 다음 행으로 ix, iy 업데이트
				int next_col = nextMove(d, ix, iy);				
				iy = next_col;
				ix ++;
				
				// pt에 현재 값 넣기
				Point pt = new Point(ix, iy);	
				st.push(pt);
				// 다음 행에 대해 1 넣어주기
				d[ix][iy] = 1;
				count ++;									
				continue;
			}			
		
		if(nextMove(d, ix, iy)== -1) {	// 존재하지 않는다
			Point pt = null;
			try {
				pt = st.pop();
			} catch (EmptyGenericStackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	// 끝 좌표 나온다
			count --;
			
			// pop()한 위치를 사용해서 다음 열을 조사하고 더 이상 없으면 이전 행으로 돌아가기
			ix = pt.getX();
			iy = pt.getY() + 1;
			if(iy == 8) iy = 0;
			while(nextMove(d, ix, iy) == -1) {
				iy ++;
				if(iy >= 8) iy = 0; // 체스판 벗어날 때
				if(iy == pt.getY()) {	// 한 바퀴 돌아갔을 때
					Point pt2 = null;
					try {
						pt = st.pop();
					} catch (EmptyGenericStackException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ix = pt.getX();
					iy = pt.getY() + 1 ;	// 다시 이전 행으로 돌아가기
				}
			}
			
			continue;	// nextMove != -1 만족하는 ix, iy 찾았다.
		}

	}
		showQueens(d);
}

	// 배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
	// S : south W : west
	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		// 조사할 시작 부분 : 북동으로 한칸
		int x1 = cx -1; int y1 = cy + 1;	
		while(x1 >= 0 & y1 < d[0].length) {
			if(d[x1][y1] == 1) return false;
			x1 --; y1 ++;
		}
		
		// 남서로 확인
		int x2 = cx + 1; int y2 = cy -1;	
		while(x2 < d.length & y2 >= 0) {
			if(d[x2][y2] == 1) return false;
			x2 ++; y2 --;
		}		
		return true;		
	}

	// 배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
		// 북서 확인
		int x1 = cx -1; int y1 = cy -1;	
		while(x1 >= 0 & y1 >= 0) {
			if(d[x1][y1] == 1) return false;
			x1 --; y1 --;
		}
		
		// 남동 확인
		int x2 = cx + 1; int y2 = cy + 1;	
		while(x2 < d.length & y2 < d[0].length) {
			if(d[x2][y2] == 1) return false;
			x2 ++; y2 ++;
		}		
		return true;

	}

	// 배열 d에서 (x,y)에 퀸을 배치할 수 있는지 조사
	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if(checkRow(d,x,y) & checkCol(d,x,y) & checkDiagSE(d,x,y) & checkDiagSW(d,x,y)) return true;
		return false;
	}
	
	public static boolean checkRow(int[][] d, int x, int y) {
		for(int j = 0; j < d[0].length; j++) {
			if(y == j) continue; 	// 자기 자신은 pass
			if(d[x][j] == 1) return false;	// 같은 걸 발견하면 false
		}
		return true;		
	}
	public static boolean checkCol(int[][] d, int x, int y) {
		for(int i = 0; i < d.length; i++) {
			if(x == i) continue;	// 자기 자신일 때는 continue
			if(d[i][y] == 1) return false;
		}
		return true;
		
	}

	// 배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
	public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
		// 1칸 증가된 row에 대하여 col 값 리턴
		for(int j = 0 ; j < d[0].length; j++) {
			if(checkMove(d, row + 1, j))
				return j;
		}
		return -1;
	}

	static void showQueens(int[][] data) {// 배열 출력
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + "\t");
			}
			System.out.println();
		}	

	}

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[8][8];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;
		showQueens(data);
		EightQueen(data);

	}
}
	