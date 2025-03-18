package ch10;

public class Dog implements Animal {

	@Override
	public String sound() {
		// TODO Auto-generated method stub
		return "멍멍";
	}

	public void gard() {
		System.out.println("강아지는 집을 지켜요");
	}
	
}
