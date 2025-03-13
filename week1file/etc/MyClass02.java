package etc;

/*상속
 * 부모클래스 = super(상위)클래스
 * 자식클래스 = sub(하위)클래스
 */

public class MyClass02 extends AccessModifier{

	void test() {
		
		AccessModifier am  = new AccessModifier();
		
		am.pub = 110;
		am.pro = 220;
		am.pack = 330;
//		am.pri = 440;
	}
	
	void test2() {
		
		AccessModifier am  = new AccessModifier();
		
		pub = 110;
		pro = 220;
		pack = 330;
		//pri = 440;

	}
	
}
