package e_dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeptUpdate {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url    = "jdbc:oracle:thin:@localhost:1521";
	static String user   = "scott";
	static String pass   = "tiger";
	
	public static void main(String[] args) {	
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			//드라이버 실행
			Class.forName(driver);
			
			//연결
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("연결 성공");
			
			//명령어 입력
			int dno = 50;
			String dname = "개발";
			String loc = "강남";
			
			String sql = "UPDATE dept"
					+ " SET dname =? ,loc = ?"
					+ " where deptno=?";
			
			//전송객체 얻어오기
			ps = con.prepareStatement(sql);
			ps.setString(1,dname);
			ps.setString(2,loc);
			ps.setInt(3,dno);
			
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
