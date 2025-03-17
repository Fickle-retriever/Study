package ch12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//map - key,value 의 한쌍
//key - 중복허용x 코드 키값이 다르면 서로 다른키
//value - 중복허용
public class HashMap01 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		System.out.println(map.size());
		
		//다양한 타입을 put(key,value)
		map.put(1, "문자열"); //-> put(Integer,String)
		map.put(2,new String("welcome"));
		map.put(3.14, "문자열");
		map.put('A', new int[5]);
		
		System.out.println(map.size());
		
		System.out.println("=====요소 체크=====");
		Object o = map.get(1);
		System.out.println(o);
		
		o = map.get(2);
		System.out.println(o);
		
		o = map.get(3.14);
		System.out.println(o);
		
		o = map.get('A');
		System.out.println(o);
		
//		map.remove('A');
//		System.out.println(map.size());
		
		System.out.println("\n=====모든 요소=====");
		
		//Set keySet(): 모든 키 가져오기
		//Set keys = map.keySet();
		//System.out.println(keys);
		
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
		
		
	}
}
