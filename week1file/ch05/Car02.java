package ch05;

/* method유형 4가지
 1.매개변수없고 리턴값없는 메서드
 문법 > void 메서드명(매개변수리스트){
 	}
 2.매개변수있고 리턴값없는 메서드
 문법 > void 메서드명(매개변수리스트){
 	}
  
 3.매개변수없고 리턴값있는 메서드
 문법 > 리턴타입 메서드명(){
 		return 표현식;
 	}
 
 4.매개변수있고 리턴값있는 메서드
 문법 > 리턴타입 메서드명(매개변수리스트){
 		return 표현식;
  }
*/
public class Car02 {
	
	private String company = "현대";//제조사 = 현대
	int max_Speed = 300; //최대속도 = 300km/h
	char grade = 'A';
	void m() {
		System.out.println("m()"+company); 
		// 이런식으로 인해서 private무시하고 company 호출, 하지만 여전히 직접호출은 불가
	}
	void m2(String user) {
		System.out.println(user);
	}
	int m3() {
		char n = 'A';
		return n+1; //표현식:값,변수,수식
	}
	String m4(String s1, String s2) {
		String food = "";
		if(s1.equals("계란") && s2.equals("밀가루")) { 
			//문자열 비교할때는 .equals() 로 만들자, 만약 영어라면 대소문자 모두 일치
			food="계란빵";
		}
		else{
			food = s1+s2+"섞였음";
		}
		return food;
	}
	int sum(int a,int b) {
		return a+b;
	}

}
