package ch10;

public class Student implements AcademicManagement {

	@Override
	public void enrollStudent(String stuName) {
		System.out.println(stuName + "님 환영합니다");
	
	}

	@Override
	public void assignCourse(String profName, String courseName) {
	
		
	}

	@Override
	public void issueGrade(String stuName, String courseName, int grade) {
	
		
	}

}
