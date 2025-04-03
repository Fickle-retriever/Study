package d_jdbc;

import java.sql.*;

/*
  	@전송객체
  	-Statement : SQL 문장이 완성된 경우
  	-PreparedStatement : SQL 문장이 비완성된 경우
 	-CallableStatement : 데이터베이스함수(function / procedure) 호출 할 때
 	
 	@전송
 	-executeUpdate() : INSERT, DELETE, UPDATE => 리턴 값이 인트
 	-ResultSet executeQuery() : SELECT 
 */

public class EmpSelectPrep {
	
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url    = "jdbc:oracle:thin:@localhost:1521";
	static String user   = "scott";
	static String pass   = "tiger";
	
	public static void main(String[] args) {
		//Statement stat = null;
		Connection con = null;
		
		try {
			//드라이버 실행
			Class.forName(driver);
			
			//연결
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("연결 성공");
			
			//명령어 입력
			String sql = "select * from emp";
			
			//전송객체 얻어오기
			PreparedStatement stat = con.prepareStatement(sql);
			
			//전송
			ResultSet rs = stat.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("empno")+"/");
				System.out.print(rs.getString("ename")+"/");
				System.out.print(rs.getInt("sal")+"/");
				System.out.print(rs.getString("job")+"/");
				System.out.println(rs.getString("hiredate"));
			}
			
			//결과 받고 처리
			
		}catch(Exception ex) {
			System.out.println("실패: " + ex.getMessage());
			ex.printStackTrace();
		}finally {
			//닫기
			try{
				con.close();
				
				System.out.println("연결 종료");
			}catch(Exception ex) {
				
			}
			
		}

	}

}
