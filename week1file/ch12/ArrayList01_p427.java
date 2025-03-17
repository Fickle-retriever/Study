package ch12;

import java.util.ArrayList;

/*ArrayList(p427)
- 데이터의 저장공간으로 배열을 사용한다.(배열기반)

 */
public class ArrayList01_p427 {
	
	public static void main(String[] args) {
		//ArrayList객체생성
		//   클래스 참조변수 = new 클래스명()
		ArrayList list = new ArrayList(); 
		System.out.println("list="+list); //[]
	
		//isEmpty() : Returns true if this collection contains no elements.
		System.out.println("isEmpty()="+list.isEmpty()); //t

		//저장된 개수확인
		System.out.println("size()="+list.size());//0
		
		//다양한 타입을 add(Object)
		list.add("문자열");
		list.add(new String("wellcome"));
		list.add(100);	//int    ->Integer=>//자동박싱
		list.add(3.14); //double ->Double
		list.add(true); //boolean->Boolean
		list.add('A');  //char	 ->Character
		list.add(new int[5]);
		list.add(new int[]{1,10,100});
		
		System.out.println("\n-일반for문이용하여 모든 요소꺼내기------------------");
		for(int i=0;i<list.size();i++) {
			//Object o = list.get(i);
			System.out.println(list.get(i));
		}
		
		System.out.println("\n-향상된 for문이용하여 모든 요소꺼내기------------------");
		for(Object o : list) {
			System.out.println(o);
		}
		
		System.out.println("\n-get(int 인덱스번호)------------------------------");
		//Object get(int 인덱스번호): 검색
		Object o = list.get(0);
		System.out.println("list.get(0)="+o);//문자열
		String o1 = (String)list.get(1);
		System.out.println("list.get(1)="+o1);//wellcome
		System.out.println("String길이="+o1.length());//8
		System.out.println("toUpperCase()="+o1.toUpperCase());//WELLCOME
		System.out.println("charAt(0)="+o1.charAt(0));//w
		System.out.println("indexOf('c')="+o1.indexOf('c'));//4
		System.out.println("indexOf(come)="+o1.indexOf("come"));//4
		
		//삭제
		list.remove(0); // 인덱스번호0인 객체를 삭제
		
		//저장된 개수확인
		System.out.println("\n삭제후 size()="+list.size());//7  
		
		//전부삭제clear() : Removes all of the elements from this list.
		list.clear();
		
		//저장된 개수확인
		System.out.println("\n전부삭제 후 size()="+list.size());//0
	
	}
	
}


//기본 자료타입(primitive type)을 객체로 다루기 위해서 사용하는 클래스들을 래퍼 클래스(wrapper class)라고 합니다.
//JDK 1.5 부터는 박싱과 언박싱이 필요한 상황에 자바 컴파일러가 자동으로 처리
//boxing:기본타입->클래스
//unboxing:기본타입<-클래스
//int v=Integer.parseInt("100");
//double v3 = Double.parseDouble("3.141592");	
//boolean v2 = Boolean.parseBoolean("true");
