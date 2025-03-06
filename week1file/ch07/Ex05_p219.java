package ch07;

public class Ex05_p219 {
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = new int[10];
		
		for(int i : arr1) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		//(arr1 값을,0부터,arr2에,0부터,5 or arr1.length까지)
//		System.arraycopy(arr1, 0, arr2, 1, arr1.length);
//		System.arraycopy(arr1, 0, arr2, 1, arr1.length);
//		System.arraycopy(arr1, 0, arr2, 1, arr1.length);
		System.arraycopy(arr1, 1, arr2, 1, 4);
		//시작값이 0이 아니라 1이상이면 length로 하면 값이 시작값 이상이 되어버리기 때문에 오류
		
		
		
		
		for(int a : arr2) {
			System.out.print(a + " ");
		}
		
	}
	
	
}




