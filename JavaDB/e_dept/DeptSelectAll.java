package e_dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * 부서테이블의 모든 정보를 콘솔에 출력하기
 */

public class DeptSelectAll {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url    = "jdbc:oracle:thin:@localhost:1521";
	static String user   = "scott";
	static String pass   = "tiger";
	public static void main(String[] args) {
			Connection con = null;
			PreparedStatement stat = null;
			ResultSet rs = null;

			try {
				//드라이버 실행
				Class.forName(driver);

				//연결
				con = DriverManager.getConnection(url, user, pass);
				System.out.println("연결 성공");

				//명령어 입력
				//int deptno = 1004;
				String sql = "select * "
						+ " from dept "
						+ " order by deptno asc";

				//전송객체 얻어오기
				stat = con.prepareStatement(sql);


				//전송
				rs = stat.executeQuery();
				while(rs.next()) {
					System.out.print(rs.getInt("deptno")+"/");
					System.out.print(rs.getString("dname")+"/");
					System.out.print(rs.getString("loc")+"/");
					System.out.println();
				}

				//결과 받고 처리

			}catch(Exception ex) {
				System.out.println("실패: " + ex.getMessage());
				ex.printStackTrace();
			}finally {
				//닫기
				try{
					rs.close();
					stat.close();
					con.close();
					

					System.out.println("연결 종료");
				}catch(Exception ex) {

				}

			}
	}
}
