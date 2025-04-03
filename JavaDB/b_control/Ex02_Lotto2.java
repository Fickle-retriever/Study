package b_control;
import java.util.Arrays; // 정렬 클래스 임포트

public class Ex02_Lotto2 {

	public static void main(String[] args) {
		
		int[][] lotto = new int[5][6];
		
		for(int i=0; i<lotto.length; i++) {
			for(int j=0; j<lotto[i].length; j++) {
				lotto[i][j] = (int)(Math.random() * 45) + 1;
			}
		}
		
		//System.out.println();
		
		for(int i=0; i<lotto.length; i++) {
			Arrays.sort(lotto[i]); // 각 행을 배열 정렬
		}
		

		
		
		//System.out.println();
		
		for(int i=0; i<lotto.length; i++) {
			System.out.println();
			for(int j=0; j<lotto[i].length; j++){
				System.out.print(lotto[i][j] + "/");//배열 출력
			}
		}

	}

}
