package d_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
  	@전송객체
  	-Statement : SQL 문장이 완성된 경우
  	-PreparedStatement : SQL 문장이 비완성된 경우
 	-CallableStatement : 데이터베이스함수(function / procedure) 호출 할 때
 	
 	@전송
 	-executeUpdate() : INSERT, DELETE, UPDATE => 리턴 값이 인트
 	-ResultSet executeQuery() : SELECT 
 */

public class EmpUpdatePrep {
	
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
			int sabun=7900;
			String samyung = "아무개";
			int wolgub = 5000;
			String upmu = "IT";
			
			String sql = "UPDATE emp"
					+ " SET ename=? , sal=? , job=? "
					+ " WHERE empno = ?";
			
			//전송객체 얻어오기
			ps = con.prepareStatement(sql);
			ps.setString(1,samyung);
			ps.setInt(2,wolgub);
			ps.setString(3,upmu);
			ps.setInt(4,sabun);
			
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
