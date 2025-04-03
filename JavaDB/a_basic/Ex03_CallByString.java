package a_basic;

//call by reference ====> String 클래스 에외
//참조형(배열,클래스) 전달 
// => 주소가 복사 됨 값만 복사 ㄴㄴ
public class Ex03_CallByString {

	public static void main(String[] args) {
		
		String a = "안녕";
		String b = "ㅎㅇ";
		System.out.println(a);
		
		add(a,b);
		System.out.println("main"+a); // 스트링 빌더는 값이 바뀌니까? -> 변수 ㄴㄴ
	}
	static void add(String a,String b) {
		a+=b;
		System.out.println("add" +a); //안녕 ㅎㅇ 는 당연하고
	}
}

