package ch03;
import java.util.Scanner;

public class Ex02_p75 {
	public static void main(String[] args) {
		
		// 연산자
		System.out.println("점수를 입력해주세요");
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		int cutline = 90;
		String a;
		
		System.out.println(score>cutline);  // a는 b보다 크다. 초과 f
		System.out.println(score<cutline);  // a는 b보다 작다. 미만 t
		System.out.println(score<=cutline); // a는 b보다 작거나 같다. 이하 t
		System.out.println(score>=cutline); // a는 b보다 크거나 같다. 이상 f
		System.out.println(score==cutline); // a와 b는 같다. f
		System.out.println(score!=cutline); // a와 b는 같지않다. t
		// and : && (두 조건이 둘다 참) , or : || (두 조건 중 하나만 참)  
		
//----------------------------------------------------------------------------------------------
		
		// 조건문
		
		if(score>=cutline) {
			System.out.println("ㅊㅋㅊㅋ 합격!");
		}
		else if(score >= 80) {
			System.out.println("예비 합격");
		}
		else {
			System.out.println("불합격.....");
		}
		
//---------------------------------------------------------------------------------------------
		
		//비교 연산자를 이용한 조건문
		
	if(score>=0&&score<=100) {
		System.out.print("당신의 성적은 ");
		if(score>=90&&score<=100) {
			a = ": A학점";
		}
		else if(score>=80&&score<90) {
			a = ": B학점";		
		}
		else if(score>=60&&score<80) {
			a = ": C학점";		
		}
		else {
			a = ": F학점";		
		}
		System.out.println(a);
	}
	else {
		System.out.println("성적이 오입력 되었습니다.");
	}
		
//----------------------------------------------------------------------------------------------		

		// 개인 연습
		
		if(score>=cutline) {
			System.out.println("점수 : " + score + " \n" + "축하합니다, 합격입니다.");
			if(score==100) {
				System.out.println("100점입니다.");
			}
			else if(score>=95) {
				System.out.println("높은 점수입니다.");
			}
			else {
				System.out.println("다음에는 더 높게");
			}
		}
		else if(score==89){
			System.out.println("점수 : " + score + " \n" + "1점 차이로 불합격입니다");
		}
		else {
			System.out.println("점수 : " + score + " \n" + "불합격 입니다");
		}
		
		scanner.close();
	
	}
	
	
}
