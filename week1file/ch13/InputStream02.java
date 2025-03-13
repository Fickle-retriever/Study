package ch13;
import java.io.*;


//이 클래스는 try-catch가 아닌 throw절로 예외처리
//확실히 try-catch보다 throw가 좀 쉽긴하네
//throw는 예외를 위임하는 방식이지만 최종적으로는 try-catch를 사용해야함
//특히 사용자 입력,파일읽기,네트워크 연결 같은 경우는 try-catch가 필수(실시간 즉시 처리)

public class InputStream02 {

	public static void main(String[] args) throws IOException { //IOException이 File~Stream보다 상위
		InputStream is = new FileInputStream("D:\\javaStudy\\test02.db"); 
		//클래스명 참조변수 = new 클래스명();
		//부모 = 자식
		//조상 = 자식 모두가능! 이게바로 다형성
		//다형성 : 부모/조상 클래스 타입의 참조변수에는 자식클래스객체가 들어갈 수 있다.
		while(true) {
			int data = is.read(); //불러오기 
			if(data == -1) break; //더 불러올게없으면 반복그만
			System.out.println(data);
			is.close(); //프로그램 종료
		}
		
	}

}

//내가 지금까지 겪었던 오류 문장들을 역으로 프로그램에 입력시켜 프로그램이 잘 작동하고 멈출수있도록한다? => yes
//그럼.. 오류 케이스들을 앞으로는 저장해놓는게 좋겠네? => yes!