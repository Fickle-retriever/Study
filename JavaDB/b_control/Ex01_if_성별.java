package b_control;


public class Ex01_if_성별 {

	public static void main(String[] args) {
		
		String id = "980709-3234567";
		
		char sung = id.charAt(7);
		System.out.println(sung);
		String a = "";
		
		if(sung == '1' || sung == '3') {
			a = "if 남자";
		}else if(sung == '2' || sung == '4') {
			a = "if 여자";
		}else {
			System.out.println("?");
		}
		
		System.out.println(a);
		
		switch (sung) {
		case '1' :
		case '3' :
		System.out.println("switch 남자");
		break;
		
		case '2' :
		case '4' :
		System.out.println("switch 여자");
		break;
		
		}
		
	
			
	}

}
