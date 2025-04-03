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

public class EmpInsertStat {
	
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url    = "jdbc:oracle:thin:@localhost:1521";
	static String user   = "scott";
	static String pass   = "tiger";
	
	public static void main(String[] args) {
		Statement stat = null;
		Connection con = null;
		
		try {
			//드라이버 실행
			Class.forName(driver);
			
			//연결
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("연결 성공");
			
			//명령어 입력
			int sabun=2300;
			String samyung = "이무기";
			int wolgub = 4000;
			String upmu = "IT";
			
			String sql = "INSERT INTO EMP(empno,ename,sal,job)"
					+ " VALUES("+sabun+",'"+samyung+"',"+wolgub+",'"+upmu+"')";
			//전송객체 얻어오기
			stat = con.prepareStatement(sql);
			
			//전송
			stat.executeUpdate(sql);
			//업데이트 된 개수 출력
			int row = stat.executeUpdate(sql);
			if(row == 0) {
				System.out.println("업데이트 된 항목이 없습니다");
			}else {
				System.out.println(row + " 개 업데이트 완료");
			}
			
			
			//결과 받고 처리
			
		}catch(Exception ex) {
			System.out.println("실패: " + ex.getMessage());
			ex.printStackTrace();
		}finally {
			//닫기
			try{
				con.close();
				stat.close();
				
				System.out.println("연결 종료");
			}catch(Exception ex) {
				
			}
			
		}

	}

}
