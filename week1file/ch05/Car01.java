package ch05;
import java.util.Date;

//field-데이터=>명사
	//[접근제한자][제한자] 타입 변수명 [=초기값]
	
	//constructor(생성자)
	
	//method - 기능,동작 => 동사
	//public static void 메서드이름(매개변수리스트->외부와 내부를 연결해줌) {}	
	//void : 리턴타입. public : 제한자. public과 static은 생략가능

public class Car01 {
	
	String company = "현대";//제조사 = 현대
	String model = "세단"; //종류 = 세단
	Date dateOfManu = new Date();//연식(제조일자)
	int weight = 1; //중량 = 1000kg = 1t
	int cylinder = 2000; //배기량 = 2000cc
	int max_Speed = 300; //최대속도 = 300km/h
	int speed = 0; //속도 초기화
	char grade = 'A';
	double fuelEffi = 10.5;
	boolean usedCar = false;
	
	Engine01 engine = null; //엔진 = 현대엔진
	Tier01 tier = null; //바퀴 = 현대바퀴
		
	
	void showInfo() {
		System.out.println(company+ " / " +dateOfManu+ " / " +grade);
	}
	void drive() {
		System.out.println("drive() 호출성공");
	}
	void stop() {
		System.out.println("stop() 호출성공");
	}
	@Override
	public String toString() {
		return "Car01 [company=" + company + ", model=" + model + ", dateOfManu=" + dateOfManu + ", weight=" + weight
				+ ", cylinder=" + cylinder + ", max_Speed=" + max_Speed + ", speed=" + speed + ", grade=" + grade
				+ ", fuelEffi=" + fuelEffi + ", usedCar=" + usedCar + ", engine=" + engine + ", tier=" + tier + "]";
	}
	
}
