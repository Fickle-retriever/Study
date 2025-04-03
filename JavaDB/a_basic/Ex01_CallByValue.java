package a_basic;
/*
 * call by value-> 값만 복사
 */
public class Ex01_CallByValue {
	
	public static void main(String[] args) {
		int a = 10, b=20;
		add(a,b);
		System.out.println(a +"and"+ b); 
	}
	static void add(int a,int b) {
		a+=b;
		
	}
}
