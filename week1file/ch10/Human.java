package ch10;

public class Human implements Animal {
	
	@Override
	public String sound() {
		return "말소리";
	}
	public void write() {
		System.out.println("글쓰기");
	}
	
}
