package b_control;
import java.util.Arrays; // 정렬 클래스 임포트


public class Ex02_Lotto {

	public static void main(String[] args) {
		
		int[] lotto = new int[6];
		
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45) + 1; //1부터 45까지 랜덤값
		}
		
		System.out.println();
		Arrays.sort(lotto); // 배열 정렬
		
		for(int i = 0; i<lotto.length; i++) {
			System.out.print(lotto[i] + "/");
		}
		
		
		System.out.println();
		System.out.println(Arrays.toString(lotto)); //배열 스트링으로 출력
		

	}

}
