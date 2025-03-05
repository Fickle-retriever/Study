package ch02;

public class Ex06_p51 {
	public static void main(String[] args) {
		char a = 'A'; // A
		char b = 'b'; // a
		char c = '1'; // 1
		char d = '!'; // !
		char e = 'B';
		
		int a1 = d; // java 내부적으로는 char를 정수화 시킨다.
		int e1 = e; // ASCII 코드 나중에 참고만 해볼 것!
		int d1 = d;
		
		System.out.println(a1); // 65
		System.out.println(e1);
		
		
		int result = d1 * 2;
		System.out.println((char)result); // 1의 정수값 49 x 2 = 98 = b의 정수값
		
	}
	
}
