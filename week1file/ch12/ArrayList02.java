package ch12;

import java.util.ArrayList;


public class ArrayList02 {

	public static void main(String[] args) {
		//ArrayList객체생성
		//   클래스 참조변수 = new 클래스명()
		ArrayList<Member01> list = new ArrayList<Member01>(); 
		System.out.println("list="+list); //[]
		
		//Member01을 add(Object)
		//Member01(회원번호,회원명,나이)
		list.add(new Member01(1,"세종대왕",30));
		list.add(new Member01(2,"이순신",35));
		list.add(new Member01(3,"김9",40));
		list.add(new Member01(4,"유관순",15));
		list.add(new Member01(5,"현빈",60));
		list.add(new Member01(6,"현빈",70));
//		list.add(true); //boolean->Boolean
//		list.add('A');  //char	 ->Character

		
		//모든 회원명단 출력
		System.out.println("\n\nMember모든 회원명단 출력------");
		for(int i=0;i<list.size();i++) {
			Member01  m = list.get(i);
			System.out.println(m.getName());
			//System.out.println("Member01회원이름="+list.get(i).getName());
		}
		

		//인덱스0에 위치한 회원정보 출력
		//Object get(int 인덱스번호): 검색
		Object obj = list.get(0);
		System.out.println("\nlist.get(0)="+obj);//Member01클래스의 객체

		//인덱스0에 위치한 회원이름 출력
		Member01 member = (Member01)obj;
		System.out.println("\n인덱스0에 위치한 회원이름="+member.getName());
		
		//모든 회원명단 출력
		System.out.println("\n\n모든 회원명단 출력------");
		for(int i=0;i<list.size();i++) {
			Member01 mem = (Member01)list.get(i);
			System.out.println("회원이름="+mem.getName());
		}
		
		
		
		
		//저장된 개수확인
		System.out.println("\nsize()="+list.size());//7
		
		System.out.println("\n-향상된 for문이용하여 모든 요소꺼내기------------------");
		for(Object o : list) {
			System.out.println(o);
		}
		
		System.out.println("\n-향상된 for문이용하여 모든 요소꺼내기------------------");
		for(Member01 o : list) {
			System.out.println(o.getName());
		}

	}

}
