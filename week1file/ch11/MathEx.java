package ch11;
import java.util.Arrays; //Arrays는 변수로 직접호출 불가능
import java.util.Random;

public class MathEx { // math는 static 클래스 이기때문에 변수로 직접호출 가능
					  // static 메서드는 객체 생성없이 클래스이름.메서드이름()으로 호출 가능
	
	public static void main(String[] args) {
		System.out.println(""+Math.PI);
		//올림
		System.out.println(Math.ceil(0.60));
		System.out.println(Math.ceil(0.40));
		System.out.println(Math.ceil(5));
		System.out.println(Math.ceil(5.1));
		System.out.println(Math.ceil(-5.1));
		System.out.println(Math.ceil(-5.9));
		System.out.println(Math.floor(2.9));
		for(int i=1; i<=6; i++) {
			System.out.println((int)(Math.random()*(6-1+1)+1)); // 로또번호 자동생성기 같은 랜덤값이 필요할때
		}
		
		for(int i=1; i<=6; i++) {
			System.out.println((int)(Math.random()*101)+1); // 로또번호 자동생성기 같은 랜덤값이 필요할때
			//math.random()*최대값+1 <- +1하는 이유는 값이 0이 나오지 않게하기위해
		}
		int v;
		Random rand = new Random();
		for(int i = 0; i<5; i++) {
			v = rand.nextInt(10000);
			System.out.println(rand.nextBoolean());
			System.out.println(rand.nextDouble(4));
			System.out.println(rand.nextGaussian(2,3));
		}
		
		
	}
	
}
