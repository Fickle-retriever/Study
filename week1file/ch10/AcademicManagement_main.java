package ch10;


//실행클래스
public class AcademicManagement_main {

	public static void main(String[] args) {
		Staff staff = new Staff();
		Student student = new Student();
		Professor professor = new Professor();
		
		
		
		System.out.println("=====교직원=====");
		student.showMsg();
		staff.enrollStudent("길동");
		staff.assignCourse("동길", "수학");
		staff.issueGrade("길동", "수학", 90);
		
		
		System.out.println("=====학생=====");
		student.showMsg();
		student.enrollStudent("길동");
		
		
		System.out.println("=====교수=====");
		student.showMsg();
		professor.assignCourse("동길", "국어");
		professor.issueGrade("길동", "국어", 80);
	}

}
