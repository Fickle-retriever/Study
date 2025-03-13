package ch08;

public class Super01_p254 {

}

class father01{
	int a = 100;
	void swimming() {
		
	}
	void sing() {
		System.out.println("hi");
	}
	
}

class sun01 extends father01{
	
	String b = "필드추가";
	
	void test() {
		this.a = 200;
		super.a = 300;
		this.swimming();
		super.swimming();
		
	}
	@Override
	public void sing() {
		System.out.println("hi + bye");
	}
	
}