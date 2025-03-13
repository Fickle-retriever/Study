package ch10;

public class Professor implements AcademicManagement {

	@Override
	public void enrollStudent(String stuName) {
		System.out.println(stuName);
		
	}

	@Override
	public void assignCourse(String profName, String courseName) {
		System.out.printf("%s담당 %s교수",courseName,profName);
		System.out.println();
		
	}

	@Override
	public void issueGrade(String stuName, String courseName, int grade) {
		System.out.printf("%s학생 %s과목 %d성적 입력",stuName,courseName,grade);
		System.out.println();
	}

}
