package ch12;

import java.util.HashSet;
import java.util.Iterator;

/*ArrayList(p427)
- 데이터의 저장공간으로 배열을 사용한다.(배열기반)

 */
public class HashSet01 {
	
	public static <E> void main(String[] args) {
		//ArrayList객체생성
		//   클래스 참조변수 = new 클래스명()
		HashSet set = new HashSet(); 
		System.out.println("set="+set); //[]
	
		//isEmpty() : Returns true if this collection contains no elements.
		System.out.println("isEmpty()="+set.isEmpty()); //t

		//저장된 개수확인
		System.out.println("size()="+set.size());//0
		
		//다양한 타입을 add(Object)
		set.add("문자열");
		set.add(new String("welcome"));
		set.add(100);	//int    ->Integer=>//자동박싱
		set.add(100);
		set.add(3.14); //double ->Double
		set.add(true); //boolean->Boolean
		set.add('A');  //char	 ->Character
		set.add(new int[5]);
		set.add(new int[]{1,10,100});
		
		System.out.println("\n-일반for문이용하여 모든 요소꺼내기------------------");
		for(int i=0;i<set.size();i++) {
			//Object o = list.get(i);
//			System.out.println(set.get(i));
		}
		
		System.out.println("\n-향상된 for문이용하여 모든 요소꺼내기------------------");
		for(Object o : set) {
			System.out.println(o);
		}
		
		
		System.out.println("=====iter 출력=====");
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			Object o = iter.next();
			System.out.println(o);
		}
		
		//삭제
		set.remove(0); // 인덱스번호0인 객체를 삭제
		
		
		
		//저장된 개수확인
		System.out.println("\n삭제후 size()="+set.size());//7  
		
		//전부삭제clear() : Removes all of the elements from this list.
		set.clear();
		
		//저장된 개수확인
		System.out.println("\n전부삭제 후 size()="+set.size());//0
	
	}
	
}


//기본 자료타입(primitive type)을 객체로 다루기 위해서 사용하는 클래스들을 래퍼 클래스(wrapper class)라고 합니다.
//JDK 1.5 부터는 박싱과 언박싱이 필요한 상황에 자바 컴파일러가 자동으로 처리
//boxing:기본타입->클래스
//unboxing:기본타입<-클래스
//int v=Integer.parseInt("100");
//double v3 = Double.parseDouble("3.141592");	
//boolean v2 = Boolean.parseBoolean("true");
