package e_dept;
/*
 * 부서 번호가 20번 부서인 사원의 사번,이름,업무,월급,입사일을 출력하기
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpAndDept {
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
			String sql = "select d.deptno,e.empno,e.ename,e.sal,e.job,e.hiredate  "
					+ " from emp e"
					+ " join dept d on e.deptno = d.deptno"
					+ " where d.deptno = 20 AND d.deptno is not null";

			//전송객체 얻어오기
			stat = con.prepareStatement(sql);

			//전송
			rs = stat.executeQuery();
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
				rs.close();
				stat.close();
				con.close();
				

				System.out.println("연결 종료");
			}catch(Exception ex) {

			}

		}
	}
}
