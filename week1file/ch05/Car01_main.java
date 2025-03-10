package ch05;

//실행하기위한 클래스
//문법:참조변수.메서드명();
//예:car.drive();
public class Car01_main {
	public static void main(String[] args) {
		//클래스 불러오기
		Car01 car = new Car01();
		Engine01 engine = new Engine01();
		Tier01 tier = new Tier01();
		
		//객체 생성
		car.drive(); //클래스에서 출력이 되어있기때문에 바로 출력
		car.stop(); //클래스에서 출력이 되어있기때문에 바로 출력
		car.showInfo(); //클래스에서 출력이 되어있기때문에 바로 출력
		
		//출력
		System.out.println(car); // 주소 
		System.out.println(car.toString()); //주소 -> hashCode
		System.out.println(engine.company); //객체 출력
		System.out.println(tier.company); //객체 출력
		
	}
	void m() {System.out.println("m()");}
	void m1() {System.out.println("m1()");}
	void m2() {System.out.println("m2()");}
	
	//@annotation => 1.공지 2.검사
	
	
	
}
