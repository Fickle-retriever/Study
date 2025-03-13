package ch10;

public interface AcademicManagement {
	
	public abstract void enrollStudent(String stuName);
	
	void assignCourse(String profName, String courseName);
	
	void issueGrade(String stuName,String courseName,int grade);
	
	//default 메서드
	default void showMsg() {
		System.out.println("welcome");
	}
}

