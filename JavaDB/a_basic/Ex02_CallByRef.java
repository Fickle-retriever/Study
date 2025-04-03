package a_basic;


//참조형(배열,클래스) 전달
// => 주소가 복사 됨 값만 복사 ㄴㄴ
public class Ex02_CallByRef {

	public static void main(String[] args) {
		
		StringBuilder a =new StringBuilder("안녕");
		StringBuilder b =new StringBuilder("ㅎㅇ");
		a.append(b);
		System.out.println(a);
		
		add(a,b);
		System.out.println("main"+a); // 스트링 빌더는 값이 바뀌니까? -> 변수 ㄴㄴ
	}
	static void add(StringBuilder a,StringBuilder b) {
		a.append(b);
		System.out.println("add" +a); //안녕 ㅎㅇ 는 당연하고
	}
}

