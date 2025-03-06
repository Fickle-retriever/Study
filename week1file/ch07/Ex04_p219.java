package ch07;
import java.util.Arrays;
import java.util.ArrayList;

public class Ex04_p219 {
	public static void main(String[] args) {
		int [][] arr = {{1,2,3,4,5},{6,7,8,9,10}};
		int [] arr2 = {90,91,92,93,94};
		int [][] arr3 = {{90,91,92,93,94},{80,81,82,83,84},{71,72,73,74,75}};
		int [][] arr4 = {{1,2,3,4,5},{1,2},{1,2,3}};
		
		
		for(int o=0; o<arr4.length; o++) {
			for(int p=0; p<arr4[o].length; p++) {
				System.out.print(arr4[o][p]+" ");
			}
		}
		
		
		String dot = "점";
		
		System.out.println(arr2); //[I@3d012ddd
		
		for(int k=0; k<arr2.length; k++) {
			System.out.print(arr2[k]+" ");
		}
		System.out.println();
		
		for(int d : arr2) {
			System.out.print(d);
		}
		System.out.println();
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print("[" + arr[i][j] + "]" + " " );
				
			}
		}
		System.out.println();
		
		System.out.println(Arrays.deepToString(arr));
		
		
		for(int t=0; t<arr3.length; t++) {
			for(int y=0; y<arr3[t].length; y++) {
				System.out.print(arr3[t][y]+" ");
			}
		}
		
		System.out.println("\n"+Arrays.deepToString(arr3));
		System.out.println(arr3[1][3]);
		
	}
	
}



// 3차원 배열
/*	for(int a=0; a<arr3.length; a++) {
System.out.println(a+1);
for(int b=0; b<arr3[a].length; b++) {
	System.out.println(b+1);
	for(int c=0; c<arr3[b].length; c++) {
		System.out.println(arr3[a][b][c]);
	}
}
}
*/	