package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) {
        final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
        final String _URL = "jdbc:oracle:thin:@192.168.0.41:1521:orcl11";
        final String _USER = "scott";
        final String _PASSWORD = "tiger";
        Connection conn = null;
        String sql = "SELECT deptno, dname, loc FROM dept ORDER BY deptno desc";
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName(_DRIVER);
            conn = DriverManager.getConnection(_URL, _USER, _PASSWORD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                System.out.println(deptno + "\t" + dname + "\t" + loc);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }//end of main
}
/*
1. 각 벤더가 제공하는 드라이버 클래스 로딩한다.

2. 물리적으로 떨어져 있는 오라클 서버에 연결 통로 확보한다.
Connection con=null;
반복되는 코드가 많다.
라이브러리 처리를 하게 되는 것 같다.
테이블명, 컬럼명
JPA - 객체를 자동으로 테이블로 전환하기

3. 해당 SQL 요청하기(INSERT, UPDATE, DELETE)
Statement - 정적쿼리 - 안씀
PreparedStatement - 동적쿼리(속도)
CallableStatement - 저장 프로시저(프로그램-대용량데이터베이스 솔루션)

4. SELECT의 경우 - ResultSet
1)parsing
2)RDBMS - 실행계획 - 옵티마이저(룰, 비용)
3)OPEN-Cursor-yes- Fetch - CLOSE
 */