package ch03;

public class Ex06_p110 {
	public static void main(String[] args) {
		// do-while : do->동작을 해라, while->여기까지
		// while과 다르게 조건 충족이 안되어도 무조건 한번은 실행은 가능
		 
		int j = 1;
		do {
			System.out.println(j);
			j++;
		} while (j<=5);
		
		
		// while
		int i = 1;
		while(i<=5) { //출력 후 증가
			System.out.println(i);
			i++;
		}
		
		int[] numbers = {1,2,3,4,5};
		for(int k=0; k<numbers.length; k++) {
			System.out.print(numbers[k]);
		}
		
	}
	
}
