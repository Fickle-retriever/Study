package ch12;

import java.util.HashSet;
import java.util.Iterator;


public class HashSet02 {

	public static void main(String[] args) {
		//ArrayList객체생성
		//   클래스 참조변수 = new 클래스명()
		HashSet<Member01> set = new HashSet<Member01>(); 
		System.out.println("set="+set); //[]
		
		//Member01을 add(Object)
		//Member01(회원번호,회원명,나이)
		set.add(new Member01(1,"세종대왕",30));
		set.add(new Member01(2,"이순신",35));
		set.add(new Member01(3,"김9",40));
		set.add(new Member01(4,"유관순",15));
		set.add(new Member01(5,"현빈",60));
//		list.add(true); //boolean->Boolean
//		list.add('A');  //char	 ->Character

		

//		//모든 회원명단 출력
//		System.out.println("\n\n모든 회원명단 출력------");
//		for(int i=0;i<list.size();i++) {
//			Member01 mem = (Member01)list.get(i);
//			System.out.println("회원이름="+mem.getName());
//		}
		
		
		
		//저장된 개수확인
		System.out.println("\nsize()="+set.size());//6
		
		System.out.println("\n-향상된 for문이용하여 모든 요소꺼내기------------------");
		for(Object o : set) {
			System.out.println(o);
		}
		
		System.out.println("\n-향상된 for문이용하여 모든 요소꺼내기------------------");
		for(Member01 o : set) {
			System.out.println(o.getName());
		}
		
		System.out.println("=====iter 출력=====");
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			Member01 o = (Member01)iter.next(); // 형변환을 통해서 getAge불러오기
			System.out.println(o.getAge());
		}

	}

}
