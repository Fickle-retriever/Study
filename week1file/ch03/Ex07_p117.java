package ch03;

public class Ex07_p117 {
	public static void main(String[] args) {

		int num = 0;
		int i;
		for(i=1; i<=10; i++) {
			if(i%2==0) {
				continue;
			}
			num += i;
			System.out.println("i가" + i + "일 때의 num=" + num);
		}
		System.out.println("1 부터 " + "" + (i-1) + " 까지의 홀수의 합은 : " + num);
		
		
		
		System.out.println("===continue사용===");
		for(int j=1; j<=10; j++) {
			if(j==6) {
				continue;
			}
			System.out.print(j + " ");
		}
		
		
		
		
	
		}
	}


