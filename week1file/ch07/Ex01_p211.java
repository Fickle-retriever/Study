package ch07;
import java.util.Arrays;

public class Ex01_p211 {
	public static void main(String[] args) {
	
		
		//기본값은 0,long의 기본값은 0L(출력은 0으로)
		int[] idx = {0,1,2,3,4,5,6,7,8,9};
		int len = idx.length;
		
		System.out.print(idx[0]+ " ");
		System.out.print(idx[1]+ " ");
		System.out.print(idx[2]+ " ");
		System.out.print(idx[3]+ " ");
		System.out.print(idx[4]+ " ");
		System.out.print(idx[len-1]+ " " + "\n\n");// 배열의 인덱스 번호를 넘기면 오류, 마지막 값
		
		idx[0] = 10;
		idx[1] = 20;
		idx[2] = 30;
		idx[3] = 40;
		idx[4] = 50;
		
		Arrays.sort(idx); // 배열 정렬
		
		for(int i=0; i<len; i++) { //배열 순회
			System.out.print(idx[i] + " ");
		}
		System.out.println("\n\n" + Arrays.toString(idx)); // 배열 그대로 문자열 출력
	}
}
