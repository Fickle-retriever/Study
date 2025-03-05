package ch03;
import java.util.Scanner;

public class Ex08_p115 {
	public static void main(String[] args) {
		
		
		
		System.out.println("구구단 출력");
		for(int dan=2; dan<=9; dan++) {
			System.out.println(dan + "단 출력");
			for(int times=1; times<=9; times++) {
				System.out.println(dan+"x"+times+"="+dan*times);
			}
			System.out.println();
		}
		
		System.out.println("\n\n숫자를 입력하세요 구구단을 출력해줄게요");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		if(num>=1&&num<=10) {
		System.out.println("\n\n"+ num + "단 출력");
			for(int k=1; k<=9; k++) {
				System.out.println(num + "x" + k + "=" + num*k);
			}
		}
		else {
			System.out.println("1부터 10까지만 입력해주세요");
		}
		scanner.close();
	}
	
}
