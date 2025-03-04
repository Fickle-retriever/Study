package ch03;
import java.util.Scanner;

public class Ex03_p98 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("월 입력");
		int month = scanner.nextInt();
		String a;
		System.out.println("메달을 영어로 입력하세요");
		String medal = scanner.next();
		String result;
		
		
		switch(medal) { // 문자열
		case "gold" : 
		result = "금";
		break;
		case "silver" :
		result = "은";
		break;
		case "bronze" :
		result = "동";
		break;
		default :
		result = "?";
		}
		System.out.println(result);
		
		
		switch(month){ // 숫자
			case 1 : case 2 : case 12 : 
			a = "겨울";
			break;
			case 3 : case 4 : case 5 : 
			a = "봄";
			break;
			case 6 : case 7 : case 8 : 
			a = "여름";
			break;
			case 9 : case 10 : case 11 : 
			a = "가을";
			break;
			default : a = "입력이 이상함";
		}
		
		System.out.println(a);
		
		scanner.close();
		
	}

}
