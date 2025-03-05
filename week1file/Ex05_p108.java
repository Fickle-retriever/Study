package ch03;

public class Ex05_p108 {
	public static void main(String[] args) {
		
		System.out.println("=====while=====");
	// 2 3 4 5 6
		int k = 1;
		while(k<=5) {
			k++; //증가 후 출력
			if(k==3) {
				continue;	
			}
			System.out.println(k);
		}
		
		
		System.out.println("=====while2=====");
		int j = 1;
		while(j<=5) { //출력 후 증가
			System.out.println(j);
			j++;
		}
		
		System.out.println("=====for=====");
		int i = 1;
		for( ;true; ) { //이러한 방법도있어요!
			if(1<=5) {
				System.out.println(i);
			}
			i++;
			if(i==6) {
				break;
			}

			//System.out.println("if끝");
		}
		
		//System.out.println("for끝");
	}

}		
