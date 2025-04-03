package a_basic;

class Book{
	private static int count = 0; // 클래스 명으로 호출 가능
	//int count = 0; -> new로 객체 만들어서 호출

	
	Book(){
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Book.count = count;
	}
	
	
}


//주석 습관 들이자
public class Ex04_Static {

	public static void main(String[] args) {
		//Book a = new Book();
		//Book b = new Book();
		//Book c = new Book();
		
		Book.setCount(5);
		//System.out.println(a.count); //1
		//System.out.println(b.count); //1
		//System.out.println(c.count);
		
		System.out.println(Book.getCount()); //Book 클래스에 있는 함수 count만! 그대로 호출
	}

}
