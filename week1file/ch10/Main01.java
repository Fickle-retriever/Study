package ch10;

public class Main01 {
	public static void main(String[] args) {
		Human h = new Human();
		Dog d = new Dog();
		
		h.write();
		System.out.println(h.sound());
		
		d.gard();
		System.out.println(d.sound());
	}

}
