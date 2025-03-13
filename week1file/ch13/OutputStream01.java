package ch13;
import java.io.*;

public class OutputStream01 {
	
	public static void main(String[] args) throws FileNotFoundException,IOException {
//		OutputStream os = new FileOutputStream("D:\\javaStudy\\test01.db"); 
//		
//		byte a = 10;
//		byte b = 20;
//		byte c = 30;
//		
//		os.write(a);
//		os.write(b);
//		os.write(c);
//		
//		os.flush();
//		os.close();
		
		OutputStream os = new FileOutputStream("D:\\javaStudy\\test02.db"); 
		
		byte[] arr = {10,20,30,40,50,60,70};
		//os.write(arr);
		os.write(arr,1,3);
		
		os.flush();
		os.close();
			
		System.out.println("완료");
	}

}
