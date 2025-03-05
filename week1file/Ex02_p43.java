package ch02;

//변수(p43)
/*변수(variable)란? 메모리 공간에 붙여진 이름. 변하는 값
 *변수선언 
 *	문법>데이터타입 변수명 = 값;
 *변수사용
 */
public class Ex02_p43 {

	public static void main(String[] args) {
		boolean v = true; //boolean타입의 변수v선언 및 true값 초기화
		System.out.println(v);//boolean. 논리형
		//boolean v = false;//에러발생. 
		//에러발생원인. Duplicate local variable v
		//변수명 v가 중복
		//해결방법 : 중복되지않은 변수명 선언
		boolean v2 = false;
		System.out.println(v2);//boolean
		
		char v3 = 'a'; //변수를 선언하여 a값 초기화
		System.out.println(v3); //character.1글자 ''감싸야한다
		
		String v4 = "a"; //String변수선언 및 초기화
		System.out.println(v4); //문자열(String.1글자 이상의 문자)
		
		double v5 = 3.14;//double타입변수선언해서 출력
		System.out.println(v5);//숫자-실수(float, double)
		
		int v10 = 1234;//int변수선언 및 초기화
		System.out.println(v10); //숫자-정수(byte,short,int,long)

		String v20 = "현빈";//변수선언 및 초기화
		System.out.print("잘생긴 "+v20+"님, 환영"+v10); //+는 연결연산자

		System.out.println("-------------------"); //
		String name = "김영재";
		System.out.println(name); //문자열(String.1글자 이상의 문자) ""감싸야한다
		System.out.println("님, 환영");
		name = "세종대왕";
		System.out.println("변수name: "+name);
		
	}

}





