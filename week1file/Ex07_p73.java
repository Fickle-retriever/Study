package ch02;

public class Ex07_p73 {
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("-----------------------");
		x++;
		++x;
		System.out.println("x=" + x);	//?	

		System.out.println("-----------------------");		
		y--;
		--y;
		System.out.println("y=" + y);	//	

		System.out.println("-----------------------");		
		z = x++;
		System.out.println("z=" + z);	//
		System.out.println("x=" + x);	//
		
		System.out.println("-----------------------");		
		z = ++x;
		System.out.println("z=" + z);	//
		System.out.println("x=" + x);	//
		
		System.out.println("-----------------------");				
		z = ++x + y++;
		System.out.println("z=" + z);	//
		System.out.println("x=" + x);	//
		System.out.println("y=" + y);	//
	}

}
