package ch02;

public class Ex04_p49 {
	public static void main(String[] args) {
		
		//형변환 연습
		
		byte b = 127;
		double v = 3.14;
		
		double a4;
		a4 = 4/3d;
		System.out.println(a4);
	
		int c = b+1; //자동 형변환
		float d1 = b; //자동 형변환
		double d2 = b; //자동 형변환
		
		float f = (float)d2; //강제 형변환
		short s = (short)c; //강제 형변환
		int v2 = (int)v; // 자동으로 실수에서 정수를 변환할수없기때문에 '인트'로 정의
		
		double a = 1.0123456789D; //리터럴 형변환
		float a1 = 1.0123456789F; //리터럴 형변환 기본형 double이 아닌 float 정의		
		long a2 = 1000L; //리터럴 형변환 기본형 인트가 아닌 long으로 정의
		
		System.out.println(b);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(f);
		System.out.println(s);
		System.out.println(v2);
		System.out.println(a);
		System.out.println(a1);
		System.out.println(a2);
		
		// -----------------------------------------------------
		
		// if 조건문 연습
		
		String g = "";
		
		if (g.length()>=6) {
			System.out.println("문자가 너무 깁니다.");
		}
		else if (g.length()<1) {
			System.out.println("아무것도 입력이 되지 않았습니다.");
		}
		else {
			System.out.println(g);
		}
		
	}
}
