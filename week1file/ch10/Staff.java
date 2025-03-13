package ch10;

//하나의 클래스는 단일상속, 다중인터페이스의 구현체가 될 수 있다. 

//이 클래스는 Academic인터페이스의 구현 클래스이다.
//class 클래스명 extends 상위클래스 implements 인터페이스명
public class Staff implements AcademicManagement{

	@Override
	public void enrollStudent(String stuName) {
		System.out.println(stuName);

	}

	@Override
	public void assignCourse(String profName, String courseName) {
		System.out.printf("%s교수님에게 %s할당",profName,courseName);
		System.out.println();
	}

	@Override
	public void issueGrade(String stuName, String courseName, int grade) {
		System.out.printf("%s학생 %s과목 성적 : %d",stuName,courseName,grade);
		System.out.println();
	}
	
	
	
	
}
