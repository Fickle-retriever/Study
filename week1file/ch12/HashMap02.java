package ch12;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

//map - key,value 의 한쌍
//key - 중복허용x 코드 키값이 다르면 서로 다른키
//value - 중복허용
public class HashMap02 {
	public static void main(String[] args) {
		//HashMap map = new HashMap();
		Map<String,Member01> map = new Hashtable<String,Member01>();
		//HashMap<String,Member01> map = new HashMap<String,Member01>();
		
		//다양한 타입을 put(key,value)
		map.put("m001", new Member01(1,"세종대왕",10)); //-> put(String,Member01)
		map.put("m002", new Member01(2,"이순신",20));
		map.put("m003", new Member01(3,"김구",30));
		map.put("m004", new Member01(4,"홍길동",40));
		map.put("m005", new Member01(5,"현빈",50));
		map.put("m001", new Member01(5,"현빈",50)); 
		//키는 중복 허용 안됨 뒤에 추가한게 바꿨다고 인식
		//근데 값은 중복해도 허용 'ㅅ'
		

		//한개의 키 가져오기
		System.out.println("\n=====한개씩 가져오기=====");
		Iterator iter = map.keySet().iterator();//메서드 체이닝
		while(iter.hasNext()) {
			Object key = iter.next();
			//System.out.println(key);
			
			Object value = map.get(key);
			//System.out.println(value);
			
			System.out.println(key+"="+value);
			
		}
		
		System.out.println(map.get("m005")); // 한 키값에 들어있는 값 모두 출력
		Member01 m = map.get("m001"); //형변환을 통해 이름만 가져오기
		System.out.println(m.getName());
		
	}
}
