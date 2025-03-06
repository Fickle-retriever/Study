package ch07;
import java.util.Arrays;


public class Ex03_p211 {
	public static void main(String[] args) {
		
		
		// 인트 타입의 10,20,30,99,100 을 출력하세용
		// arr2 = stack 영역 , 10/20/30/99/100 = heap 영역
		// 만약에 선언 및 초기화면 stack = null , heap = 0
		int[] arr2 = {10,20,30,99,100};
		System.out.println(arr2); //[I@3d012ddd
		
		for(int l=0; l<arr2.length; l++) {
			System.out.print(arr2[l] + " ");
		}
		System.out.println();
		for(int temp : arr2) {
			System.out.print(temp + " ");
		}
		System.out.println();
		
		
		
//=======================================================================================		
		
		char[] arr1 = {'a','b','c'};
		for (int i=0; i<arr1.length; i++) {
			System.out.print(arr1[i]);
		}
		char[][] arr0 = {{'a','b','c'},{'d','e','f'}};
		
		for(int j=0; j<arr0.length; j++) {
			for(int k=0; k<arr0[j].length; k++) {
				System.out.print(arr0[j][k] + " ");
			}
		}
		System.out.println("\n" + Arrays.deepToString(arr0));
		
	}

}
