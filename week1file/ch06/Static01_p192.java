package ch06;

public class Static01_p192 {

	int a = 100; //필드. 전역변수. 인스턴스변수.
	static int b = 1000; //필드. 전역변수. 클래스변수. static필드. 정적변수
	
	void test() { //메모리에 아직 안올라와 있고 인식할때 로딩되기때문에 에러 x
		a=500;
		b=5000;
	}
	static void test2() { //바로가능
		
	}
	
	
	public static void main(String[] args) {
		Static01_p192 c = new Static01_p192(); //메모리에 올려서 인식하게 하기
		c.a = 400;
		//a=500; //static으로 바꾸던가 위처럼 정의하던가 둘중하나는 하자
		b=5000; //static이 정의되면 같은 시기에 메모리 로딩이되니 바꿀수있음
		test2();
		
	}

}
