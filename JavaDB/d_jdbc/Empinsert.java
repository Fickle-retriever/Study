package d_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Empinsert {

	// JDBC 필요한 변수
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url    = "jdbc:oracle:thin:@localhost:1521";
	static String user   = "scott";
	static String pass   = "tiger";
	
	public static void main(String[] args) {
		
		//드라이버를 메모리에 로딩
		try {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pass);
		System.out.println("연결 성공");
		
		//문장쓰기
		String sql = "DELETE FROM EMP"
				+ " WHERE job IS NULL " ;
 
		
		
		//전송객체 얻어오기
		Statement ps = con.createStatement();
		int rowsAffected = ps.executeUpdate(sql);
		
		//전송
		ps.executeUpdate(sql);
		//업데이트 된 개수 출력
		int row = ps.executeUpdate(sql);
		if(row == 0) {
			System.out.println("업데이트 된 항목이 없습니다");
		}else {
			System.out.println(rowsAffected + " 개 업데이트 완료");
		}
		
		//결과처리
		
		//닫기*****
		ps.close();
		con.close();
		
		System.out.println("실행 종료");
		
		}catch(Exception ex) {
			System.out.println("실패: " + ex.getMessage());
		}

	}

}
