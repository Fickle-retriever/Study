package ch02;

/*
 * 	변수 : 메모리 공간에 붙여진 이름
 * 	변수선언
 * 	ㄴ문법(데이터타입) 변수명 = 값; -> EX) double a = 10.5;
 */

public class Ex02_p43 {
	

	public static void main(String args[]) {
		
		//변수선언
		boolean a = true; //boolean 논리형 참,거짓
		boolean a2 = false; //중복되지않게 선언
		char b = 'a'; // character는 한글자!
		String b2 = "a"; // string은 char와 다름
		double c = 3.14; // float,double 차이는 데이터 크기
		float c1 = 1; // 소수점 출력
		int c2 = 1000000000; // long이 제일 데이터 크기가 크다.
		String d = "현빈";
		String e = "김영재";
		e = "정준영";
		
		//결과출력
		System.out.println(a);
		System.out.println(a2); 
		System.out.println(b);
		System.out.println(b2);
		System.out.println(c);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(d + "님, 환영" + c2);
		System.out.println("현재 변수 e은 : " + e);
		
	}
	
}
