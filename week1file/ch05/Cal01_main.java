package ch05;

public class Cal01_main {
	
	public static void main(String[] args) {
		Cal01 cal = new Cal01();
		int result = 0;
		result = cal.sum(10,2);
		System.out.println(result);
		result = cal.min(10,2);
		System.out.println(result);
		result = cal.x(10,2);
		System.out.println(result);
		result = cal.n(5,0);
		System.out.println(result);
		
		System.out.println();
		double result1 = cal.n(5,2);
		long result3 = cal.n(9, 3);
		System.out.println(result1);
		System.out.println(result3);
		
	}
}
