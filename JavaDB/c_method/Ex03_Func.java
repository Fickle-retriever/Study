package c_method;

public class Ex03_Func {
	public static void main(String[] args) {
		
		String a= "헬로우";
		StringBuilder b = new StringBuilder("홍길동");
		int c = 33;
		
		method(a,b,c);
	}
	
	static void method(String a , StringBuilder b , int c) {
		System.out.println("인삿말 : " + a);
		System.out.println("이름 : " + b);
		System.out.println("나이 : " + c);
	}

}
