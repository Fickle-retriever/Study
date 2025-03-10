package ch05;

public class Car02_main {
	
	public static void main(String[] args) {
		Car02 car = new Car02();
		System.out.println(car);
        //System.out.println(car.company);
		//은닉화 => private
		
		System.out.println(car.max_Speed);
		car.max_Speed = 800;
		System.out.println(car.max_Speed);
		
		car.m();
		car.m2("m2 user");
		int result1 = car.m3(); 
		char result2 = (char)car.m3();
		System.out.println("m3의 리턴값 = "+result1);
		System.out.println(result2);
		String result3 = car.m4("계란","밀가루");
		System.out.println(result3);
		car.sum(1,2);
		
	}
	

}
