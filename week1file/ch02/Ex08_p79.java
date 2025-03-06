package ch02;
import java.util.Scanner;


public class Ex08_p79 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = scanner.nextInt();
		
		if(age>=20) {
			System.out.println("성인입니다");
		}
		else {
			System.out.println("학생입니다.");
		}
		
		String n;
		String s = "사인하세요.";
		String g = "부모님 대려와요.";
		n = (age >= 20) ? s : g ; 
		//(조건)이 맞니? 맞으면 왼쪽문장 아니면 오른쪽문장
		System.out.println(n);
		
		scanner.close();
	}
	
}
