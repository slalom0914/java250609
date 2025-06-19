package com.jdbc;

import com.util.DBConnectionMgr;
import com.vo.DeptVO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DB서버(1521)와 연동하기 - Back-End
public class JDBCDept {
    public static void main(String[] args) {
        DBConnectionMgr dbMgr = null;
        Connection conn = null;//인터페이스
        String sql = "SELECT deptno, dname, loc FROM dept ORDER BY deptno desc";
        Statement stmt = null;//sql문을 오라클 서버에게 전달하는 전달자
        ResultSet rs = null;//커서(cursor)를 구현한 인터페이스
        try{
            dbMgr = DBConnectionMgr.getInstance();
            //dbMgr = new DBConnectionMgr();
            conn = dbMgr.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            List<DeptVO> deptList = new ArrayList<DeptVO>();
            DeptVO dvo = null;//선언과 생성을 분리해야 한다.
            while(rs.next()){
                dvo = new DeptVO();
                int deptno = rs.getInt("deptno");
                dvo.setDeptno(deptno);
                String dname = rs.getString("dname");
                dvo.setDname(dname);
                String loc = rs.getString("loc");
                dvo.setLoc(loc);
                deptList.add(dvo);
            }
            //사용한 자원 반납하기
            dbMgr.freeConnection(conn,  stmt, rs);
            System.out.println(deptList.size());//0->4
            for(DeptVO rdvo: deptList){
                System.out.println(rdvo.getDeptno()+"\t"+rdvo.getDname()+"\t"+rdvo.getLoc());
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