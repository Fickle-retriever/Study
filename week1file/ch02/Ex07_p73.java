package ch02;

public class Ex07_p73 {
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z;
		
		//++x -> 전위 연산자 값이 들어가기전에 증가시킨후 들어감
		//x++ -> 후위 연산자 값이 들어가고 그후에 증가
		
		System.out.println("-----------------------"); 
		x++;
		++x;
		System.out.println("x1=" + x);	//12	

		System.out.println("-----------------------");		
		y--;
		--y;
		System.out.println("y1=" + y);	//8

		System.out.println("-----------------------");		
		z = x++;
		System.out.println("z1=" + z);	//12
		System.out.println("x2=" + x);	//13
		
		System.out.println("-----------------------");		
		z = ++x;
		System.out.println("z2=" + z);	//14
		System.out.println("x3=" + x);	//14
		
		System.out.println("-----------------------");				
		z = ++x + y++;
		System.out.println("z3=" + z);	//23
		System.out.println("x4=" + x);	//15
		System.out.println("y2=" + y);	//9
	}

}
