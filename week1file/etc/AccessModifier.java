package etc;
/*접근 제한자 사용 이후
  -외부로 부터 데이터 보호
  -외부에는 불필요한 내부적으로만 사용되는 부분을 감춰 실수 방지 및 복잡성 줄이기
  
  종류
  -public : 접근 제한 x
  -protected : 같은 패키지, 그리고 다른패키지의 자손클래스에서 접근가능
  -default : 같은 패키지 내에서만(생략)
  -private : 동일 클래스 내에서만
 
*/


public class AccessModifier {

	public int pub = 100;
	protected int pro = 200;
	int pack = 300;
	private int pri = 400;
	
	void test() {
		pub = 110;
		pro = 220;
		pack = 330;
		pri = 440;
	}
	
}
