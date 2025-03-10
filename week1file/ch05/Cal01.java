package ch05;


public class Cal01 {
	
	int sum(int a,int b) { //
		return a+b;
	}
	int min(int  a,int  b) { //
		return a-b;
	}
	int x(int  a,int  b) { //
		return a*b;
	}
	
	
	// 메소드 오버로딩:동일 클래스 안에서 이름은 같지만 매개변수의 개수,타입,순서가 다른 method
	int n(int a,int b) {
		if(b==0) {
			System.out.println("0으로 나눌수 없어요");
			return 0;
		}else {
		return a/b;
		}
	}
	double n(double a,double b) { //
		return a/b;
	}
	long n(long a,long b) { //
		return a/b;
	}
	
	
	
	
	public static void main(String[] args) {
		Cal01 cal = new Cal01();
		int result2 = cal.sum(4, 100);
		System.out.println(result2);
	}

}
