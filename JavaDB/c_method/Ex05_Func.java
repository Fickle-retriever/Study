package c_method;
import java.util.ArrayList;

public class Ex05_Func {

	public static void main(String[] args) {
		ArrayList<Object> result = method();
		
		System.out.println(result);
		
		for(Object str:result){ //ArrayList 출력은 향상된 for문
		    System.out.print(str+" ");
		}
	
	}
	
	static ArrayList<Object> method() {
		String a= "헬로우";
		StringBuilder b = new StringBuilder("홍길동");
		int age = 33;
		
		ArrayList<Object> list = new ArrayList<>(); 
		
		list.add(a);
		list.add(b);
		list.add(age);
		
		return list;
	}
}
