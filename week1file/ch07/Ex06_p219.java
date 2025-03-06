package ch07;
import java.util.Arrays;

public class Ex06_p219 {
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = new int[10];
		int[] arr3 = arr1; // arr3를 가르키는 주소가 arr1과 주소가 동일해짐
		
		System.out.println(arr1); // [I@3d012ddd
		System.out.println(arr3); 				
		
		for(int a : arr3) {
			System.out.print(a + " ");
		}
		
		System.out.println();
		
//		arr1[0] = 11111; // 주소가 동일하기때문에 바뀐다.
//		arr2[4] = 44444; // 주소가 동일하기때문에 바뀐다.
		
		int[] deepCopyArr1 = arr1.clone(); // 복사본(deep copy)은 값만 복사
		
		System.out.println(deepCopyArr1);
		System.out.println(Arrays.toString(deepCopyArr1));
		
		for(int a : arr3) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		for (int b : arr1) {
			System.out.print(b+ " ");
		}
		System.out.println();
	}
}
