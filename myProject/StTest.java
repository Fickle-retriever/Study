package testPack;
import java.util.Scanner;

public class StTest {
	public static void main(String[] args) {
		System.out.println("인사해보세요");
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine(); // nextLine은 문장을 받고 next는 단어까지
		
		String[] b = {"ㅎㅇ","하이","안녕","반가워"};
		
		for(String c : b) { // for-each -> : 를 이용해서 c에 b배열에 있는 것들을 가져와서 저장해본다
			
			a = a.replaceAll(c,"**"); // 일반 단어 필터링
			a = a.replaceAll(c.replaceAll("", "[\\s\\-]*"), "**"); 
			//중첩을 통해 c에 적용된 단어중공백이나 특수문자도 잡아냄
			
		
		}
		System.out.println(a);
		scanner.close();
	}

}
