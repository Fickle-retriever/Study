package ch13;
import java.io.*;


public class InputStream01 {

	public static void main(String[] args) throws IOException {
		InputStream is = null;
		try {
			is = new FileInputStream("D:\\javaStudy\\test02.db"); //찾아라
			while(true){
				int data = is.read();
				if(data==-1) break;
				System.out.println(data);
			}
			
		}catch(IOException e) {
			System.out.println("io" + e.getMessage());
		}finally { //무조건 여기를 try-catch를 끝내기전에 들러야함
			System.out.println("finally");
			is.close();
		}
		
	}

}

//내가 지금까지 겪었던 오류 문장들을 역으로 프로그램에 입력시켜 프로그램이 잘 작동하고 멈출수있도록한다?