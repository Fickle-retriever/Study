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

public class EmpInsertPrep {
	
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
			int sabun=1004;
			String samyung = "박길동";
			int wolgub = 4000;
			String upmu = "IT";
			
			String sql = "INSERT"
					+ " INTO emp(empno,ename,sal,job)"
					+ " VALUES(?,?,?,?)";
			
			//전송객체 얻어오기
			ps = con.prepareStatement(sql);
			ps.setInt(1,sabun);
			ps.setString(2,samyung);
			ps.setInt(3,wolgub);
			ps.setString(4,upmu);
			
			//전송
			ps.executeUpdate();
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
