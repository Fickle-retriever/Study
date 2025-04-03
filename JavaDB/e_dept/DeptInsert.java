package e_dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * 부서분호 : 50
 * 부서명 : IT
 * 부서위치 : 신촌
 */


public class DeptInsert {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url    = "jdbc:oracle:thin:@localhost:1521";
	static String user   = "scott";
	static String pass   = "tiger";
	public static void main(String[] args) {
		//Statement stat = null;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//드라이버 실행
			Class.forName(driver);
			
			//연결
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("연결 성공");
			
			//명령어 입력
			int dno = 60;
			String dname = "IT";
			String loc = "신촌";
			
			
			String sql = "INSERT"
					+ " INTO dept(deptno,dname,loc)"
					+ " VALUES(?,?,?)";
			
			//전송객체 얻어오기
			ps = con.prepareStatement(sql);
			ps.setInt(1,dno);
			ps.setString(2,dname);
			ps.setString(3,loc);
			
			//전송
			int result = ps.executeUpdate();
			System.out.println(result + " 개 업데이트 완료");
			
			//결과 받고 처리
			
		}catch(Exception ex) {
			System.out.println("실패: " + ex.getMessage());
			ex.printStackTrace();
		}finally {
			//닫기
			try{
				ps.close();
				con.close();
				System.out.println("연결 종료");
			}catch(Exception ex) {
				
			}
			
		}
	}

}
