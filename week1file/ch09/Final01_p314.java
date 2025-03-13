package ch09;

//final(p314) - 마지막의, 변경될 수 없는
//class, method, 변수앞에서 사용될 수 있다

public class Final01_p314 {
	
	int a = 10;
	final int b = 10; 

	
	void m1() {
		a = 100;
		//b = 500; final로 인해 값은 변경 될수 없어요!!!
		
		int a1 = 10;
		final int b1 = 10; 

	}
}

final class Father01{ //이렇게하면 자식클래스 상속 불가
	
	
}

class Son extends Mother01{
	
	
}


class Mother01{
	void dancing() {
		System.out.println("엄마 dancing()");
	}
	final void running() {
		
	}
	
}


class Daughter01 extends Mother01{
	@Override
	void dancing() {
		System.out.println("딸 dancing()");
	}
//	@Override
//	void running() {}
	
	
}