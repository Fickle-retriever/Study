package ch05;

public class Person01 {
	private String fullName; //성명
	private double height; //키
	private int age; //나이
	
	Person01(){
		System.out.println("매개변수 없는 생성자");
	}
	//생성자 오버로딩
	Person01(String f){
		System.out.println("매개변수(String)있는 생성자 " + f);
	}
	
}
