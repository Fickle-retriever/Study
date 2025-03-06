package ch07;
import java.util.Arrays;

public class Ex02_p211 {
	public static void main(String[] args) {
		
		
		boolean[] b = {true,false,false,true};
		int blen = b.length;
		
		for(int k=0; k<blen; k++) {
			System.out.print(b[k]+ " / ");
		}
		
		System.out.println();
		
		
		
//================================================================================================			
		//배열 생성 및 선언
		
		double[] numbers = {1.2,1.3,1.4,1.5,1.6};
		int numlen = numbers.length;
		
		for(int j=0; j<numlen; j++) {
			System.out.print(numbers[j]+ " / ");
		}
		
		System.out.println(); // 줄바꿈
		
		for(double num : numbers) {
			System.out.print(num+ " / ");
		}
		
		System.out.println(); // 줄바꿈
		
//================================================================================================		
		
		String[] str = {"안녕","하세요!","저는","사람","입니다"};
		int len = str.length;
		
		for(int i=0; i<len; i++) {
			System.out.print(str[i]);
		}
		
		System.out.println(); // 줄바꿈
		
		for(String c : str) { //향상된 for 문
			System.out.print(c);
		}
		System.out.println("\n" + Arrays.toString(str));
		System.out.println(Arrays.toString(numbers));
	}
	
}
