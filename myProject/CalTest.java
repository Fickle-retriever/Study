package testPack;
import java.util.Scanner;

public class CalTest {
	static double sum(double a,double b) { //
		return a+b;
	}
	static double min(double a,double b) { //
		return a-b;
	}
	static double x(double a,double b) { //
		return a*b;
	}
	static double n(double a,double b) { //
		return a/b;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력하세요 : ");
		double num1 = scanner.nextDouble();
		System.out.print("연산자(+,-,*,/)를 입력하세요 : ");
		String c = scanner.next();
		System.out.print("두번째 숫자를 입력하세요 : ");
		double num2 = scanner.nextDouble();
		
		
			if(c.equals("+")) {
				double result = sum(num1,num2);
				System.out.println(num1 + "+" + num2 + "=" + result);
			}
			else if(c.equals("-")) {
				double result = min(num1,num2);
				System.out.println(num1 + "-" + num2 + "=" + result);
			}
			else if(c.equals("*")) {
				double result = x(num1,num2);
				System.out.println(num1 + "*" + num2 + "=" + result);
			}
			else if(c.equals("/")) {
				if(num2==0) {
					System.out.println("0으로는 나눌수 없어요! 다시 입력해주세요.");
				}
				else {
				double result = n(num1,num2);
				System.out.println(num1 + "/" + num2 + "=" + result);
				}
			}
			else {
				System.out.println("연산자가 잘못 입력 되었습니다.");
			}
		scanner.close();
	}
	
	
}
