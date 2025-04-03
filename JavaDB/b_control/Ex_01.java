package b_control;
/*우리대학의 학번은 총 10자리로 되어 있습니다.
맨 앞의 4자리는 입학년도이고 다섯번째 문자는 단과대 번호입니다.
1 : 공대
2 : 사회대

2017111001 는 2017년도에 입학한 공대 학생입니다
2019211001 는 2019년도에 입학한 사회대 학생입니다
2018133001 는 2018년도에 입학한 공대 학생입니다  

*/
public class Ex_01 {
	
	public static void main(String[] args) {
	String id = "2017223456";
	char x = id.charAt(4);

	
	if(x == '1') {
		System.out.println(id + " 는 " + id.substring(0,4) + "년도에 입학한 공대 학생입니다.");
	}
	else if(x == '2'){
		System.out.println(id + " 는 " + id.substring(0,4) +"년도에 입학한 사회대 학생입니다.");
	}
	
	
	switch (x) {
	case '1' :
		System.out.println(id + " 는 " + id.substring(0,4) + "년도에 입학한 공대 학생입니다.");
	break;
	case '2' :
		System.out.println(id + " 는 " + id.substring(0,4) +"년도에 입학한 사회대 학생입니다.");
	break;
	}
}
}
