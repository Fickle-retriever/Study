package b_control;

public class Ex04_for연습 {

	public static void main(String[] args) {
		
		// 1번문제
//		for(int i=0; i<26; i++) {
//			for(char a='A'; a<='A'+i; a++) {
//				System.out.print(a);
//			}
//			System.out.println();
//		}
//		
		
		//2번문제
//		for(int i=0; i<26; i++) {
//			for(char a='A'; a<='Z'-i; a++) {
//				System.out.print(a);
//			}
//			System.out.println();
//		}

		
		//4번문제		
//		for(int i=0; i<26; i++) {
//			for(char a='Z'; a>='Z'-i; a--) {
//				System.out.print(a);
//			}
//			System.out.println();
//		}
//		
		
		//3번문제
//		for(int i=0; i<26; i++) {
//			for(char a=(char)('A'+ i); a<='Z'; a++) {
//				System.out.print(a);
//			}
//			System.out.println();
//		}
		
		//5번문제
		for(int i=0; i<26; i++) {
			for(char a=(char)('A'+ i); a<='Z'; a++) {
				System.out.print(a);
			}
			System.out.println();
			for(char a='A'; a<='A'+i; a++) {
				System.out.print(" ");
			}
			
		
		}
		
	}

}
