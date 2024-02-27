package com.ruby.java.ch10.collection;

//구현과제로 실습
//hashset을 arraylist로 변환하여 정렬하기 구현

/*
* 로또 당첨 규칙:
* 꽝: 번호 2개, 1개
* 5등: 번호 3개 - 5000원
* 4등: 번호 4개 - 5만원
* 3등: 번호 5개 - 150만원 - 판매금액에 변동(판매금액의 12.5%)
* 2등: 3등번호 + 보너스번호 - 3000만원 - 판매 금액에 변동, 당첨 확률: 1,300,000분의1
* 1등: 6개 숫자 - 당첨 확률 8,000,000 분의 1, 10억 ~ 30억
*/
//hashset을 arraylist로 변환하여 정렬하기 구현
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
//class ListComparator implements Comparator<List<Integer>>{
//	@Override
//	public int compare(List<Integer> l1, List<Integer> l2) {
//		Iterator<Integer> ait = l1.iterator();
//		Iterator<Integer> bit = l2.iterator();
//		while (ait.hasNext()) {
//			int anum = ait.next();int bnum = bit.next();
//			if ( anum > bnum) return 1;
//			else if (anum < bnum) return -1;
//			
//		}
//		return 0;
//	}
//}
public class Test_ch10_lotto당첨처리2 {

	public static void main(String[] args) {

		lotto_generator(1000000);	// n = 로또 횟수

	}

	public static void lotto_generator(int n) {
		Random number = new Random();
		List<HashSet<Integer>> lotSet = new ArrayList<>();	// ArrayList로 해도 상관 없다 했나?
		HashSet<Integer> lotto = null;//복권 1장
		//List<List<Integer>> al = new ArrayList<>();
		/*
		 * [[35, 40, 27, 29, 14, 31, 15], [0, 1, 18, 38, 6, 24, 29],
		 *  [16, 32, 0, 18, 34, 22, 14], [32, 34, 40, 9, 12, 28, 14],
		 *  [0, 19, 6, 9, 42, 29, 13], [2, 3, 37, 43, 44, 29, 14],
		 *  [33, 1, 17, 22, 6, 8, 12], [34, 21, 9, 10, 27, 44, 45], [18, 34, 23, 9, 28, 29, 15],
		 *  [32, 6, 23, 24, 10, 27, 43]]
		 */
		
		
		// =================== 로또 번호 생성 =================
		for (int i = 0; i < n; i++) {

			lotto = new HashSet<>();
			//구현할 부분  // :  로또 번호 6개로 하기		// 보너스 번호는 당첨번호(winner) 생성할 때
			for (int j = 0; lotto.size()<6; j++) {	// 추가할 때마다 lotto.size 증가함
				int num = 1+number.nextInt(45);
				if(lotto.contains(num)) {			// 중복 제거
					j--; continue;
				}
				lotto.add(num);						// 중복 아닐 시 추가
			}
			lotSet.add(lotto);//복권 명부에 발행 복권을 추가
	
		}
		System.out.println("\nlot hashset을 출력\n");
		// 방법1. 확장 for문
		for (HashSet<Integer> eachLotto : lotSet) {
			System.out.println(eachLotto);	// 
			/*
			 * [33  1 17 22  6  8 ]
			 * [11  1 18 38  6 24 ]
			 */
			//구현할 부분
		}
		
		/*
		// 방법2. Iterator 인터페이스
		Iterator<HashSet<Integer>> iter = lotSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}*/
		
		
		//System.out.println("복권 정렬전::lot = " + al);
		
		//al.sort(new ListComparator());
		//System.out.println("복권 정렬후::lot = " + al);	// 왜 함?
		//hashset의 리스트를 정렬하는 알고리즘 개발
		//hashset를 arrayList로 변환
		
		
		//============당첨번호 추첨 ===============
		HashSet<Integer> win = new HashSet<>();
		for (int j = 0; win.size() < 6; j++) {//6개 번호와 보너스 번호
			int num = 1+number.nextInt(45);
			if(win.contains(num)) {			  // 중복 제거
				j--; continue;
			}
			win.add(num);
		}
		
		int bonus = 1+ number.nextInt(45);
		while(win.contains(bonus)) {		// 가지고 있는 동안은 계속 돌기
			bonus = 1+ number.nextInt(45);
		}
		
		System.out.println("당첨번호: " + win + " 보너스번호="+bonus);//6개의 당첨번호와 보너스번호
		// 6개를 맞힌 복권을 찾는다 
		System.out.println("===========================================");
		winnerLotto(win, bonus, lotSet);//1등을 찾는다
		
	}
	// 각각의 로또에 대해 조사하기
	static void winnerLotto(HashSet<Integer> w,int bn, List<HashSet<Integer>> lottoSet ) {
		// 당첨번호 w에 대하여 발행된 복권 리스트 al의 모든 원소 elem에 대하여 조사한다
		for (int i = 0; i < lottoSet.size(); i++) {
		//구현할 부분
			checkWinner(w, bn,lottoSet.get(i));	// w는 winner set
		}
	}
	// 각각의 로또 당첨 사실 확인하기 1 : 1
	static void checkWinner(HashSet<Integer> win,int bonus, HashSet<Integer> lot_nums) {	
		// 당첨번호 w의 각 숫자를 꺼내 복권 엔트리에 포함되어 있는지를 조사
		List<Integer> win_nums = new ArrayList<>(win);	// hashset 형태로 넘겨줘도 ArrayList로 바뀌나? // extends Integer 하는 아무 애나 생성자로 가능하다?
		int count = 0;
		for (int i = 0; i < win_nums.size()-1; i++)	// 왜 < win_nums.size()-1 ? 
		{
			/*
			 * 당첨번호 각 번호를 몇개 포함하는지를 elem에 대하여 조사
			 */
			//구현할 부분
			//System.out.println("win_nums.get(i) :" + win_nums.get(i));
			if(lot_nums.contains(win_nums.get(i))) {	// i 번재 숫자
				count++;
				//System.out.println("count 증가:" + count);
			}
			
			
		}
		// 보너스 번호
		if(lot_nums.contains(bonus)){	// int 와의 형 변환........ => 오토레핑
			count++;			
			
		}
		if(count>=4) {
		//System.out.println("count : " + count);
		}
		switch (count) {
		case 0:
		case 1:
		case 2:
			//System.out.println("꽝");
			break;
		case 3:
			//System.out.println("5등 복권 " + lot_nums + " 당첨번호:" + win);
			break;
		case 4:
			//System.out.println("4등 복권 " + lot_nums + " 당첨번호:" + win);
			break;
		case 5:
			if (lot_nums.contains(bonus)) { //보너스 번호가 일치하는 지를 조사 w는 arr, elem는 hashset / 보너스 번호 다르다 가정
				System.out.println("2등 복권 " + lot_nums + " 당첨번호:" + win);
				break;
			}
			else {
				System.out.println("3등 복권 " + lot_nums + " 당첨번호:" + win);
				break;
			}
			
		case 6:
			System.out.println("1등 복권 " + lot_nums + " 당첨번호:" + win);
			System.out.println("축하합니다!!!!");
			break;
		}


	}
}