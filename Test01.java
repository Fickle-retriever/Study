package test;

public class Test01 {
	public static void main(String[] args) {

		int total = cal(30);
		System.out.println();
		System.out.println("총 짝 횟수 : " + total);
	}

	static int cal(int a) {
		int count = 0; //손뼉횟수
		
		for (int i = 1; i <= a; i++) { //for문을 통해서 반복
			String numresult = String.valueOf(i); //i값 string으로 변환
			boolean clap = false; //손뼉 치나요?
			int clapcount = 0; //손뼉 횟수
			
			for (char c : numresult.toCharArray()) { //char로 변환해서 한글자씩 본다음에 3,6,9확인
				if (c == '3' || c == '6' || c == '9') {
					clap = true;
					clapcount++;
					break;
				}
			}
			if(clap==true) { // 3,6,9가 있어서 clap이 true가 되었을때 짝 출력
				System.out.print(i+"(짝) / ");
				count += clapcount; // 박수 횟수 증가
			}else {
				System.out.print(i+" / ");
			}

		}
		return count; //박수 횟수 보내기
	}
}