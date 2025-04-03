package b_control;
/*
 * 우리대학의 학번은 총 10자리로 되어 있습니다.
맨 앞의 4자리는 입학년도이고 다섯번째 문자는 단과대 번호입니다.
     1 : 공대
     2 : 사회대
그 뒤의 2자리는 각 학과번호입니다.

  공과대학인 경우는
     11 : 컴퓨터학과       12 : 소프트웨어학과          13 : 모바일학과
     22 : 자바학과         33 : 서버학과
     
사회대학인 경우는
	 11 : 사회학과         12 : 경영학과          13 : 경제학과


 2017111001 는 2017년도에 입학한 공대 컴퓨터학과 학생입니다
 2019211001 는 2019년도에 입학한 사회대 사회학과 학생입니다
 2018133001 는 2018년도에 입학한 공대 서버학과 학생입니다   
 */

public class Ex_02 {
	public static void main(String[] args) {
		String id = "2017112456";
		
		char b = id.charAt(4);
		String x = id.substring(5,7);
		System.out.println("단과대 번호 : "+b);
		System.out.println("학과 번호 : "+x);
		
		if(b == '1') {
			if(x.equals("11")) {
				System.out.println(id + " 는 " + id.substring(0,4) +"년도에 입학한 공대 컴퓨터학과학생입니다.");
			}
			else if(x.equals("12")) {
				System.out.println(id + " 는 " + id.substring(0,4) +"년도에 입학한 공대 소프트학과학생입니다.");
			}
			else if(x.equals("13")) {
				System.out.println(id + " 는 " + id.substring(0,4) +"년도에 입학한 공대 모바일학과학생입니다.");
			}
		}
		else if(b == '2'){
			if(x.equals("11")) {
				System.out.println(id + " 는 " + id.substring(0,4) +"년도에 입학한 사회대 사회학과학생입니다.");
			}
			else if(x.equals("12")) {
				System.out.println(id + " 는 " + id.substring(0,4) +"년도에 입학한 사회대 경영학과학생입니다.");
			}
			else if(x.equals("13")) {
				System.out.println(id + " 는 " + id.substring(0,4) +"년도에 입학한 사회대 경제학과학생입니다.");
			}
		}
		
		
	}

}
