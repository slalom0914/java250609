package com.emp;
import com.util.DBConnectionMgr;
import com.vo.EmpVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpManagerDao {
    DBConnectionMgr dbMgr = null;
    Connection conn = null;//인터페이스
    PreparedStatement pstmt = null;//sql문을 오라클 서버에게 전달하는 전달자
    ResultSet rs = null;//커서(cursor)를 구현한 인터페이스
    public EmpManagerDao() {
        dbMgr = DBConnectionMgr.getInstance();
    }
    public int empDelete(int empno) {
        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM emp WHERE empno = ?");
        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, empno);
            result = pstmt.executeUpdate();
        } catch (SQLException se){
            System.out.println(se.getMessage());
            System.out.println("[query]"+sql.toString());
        } catch (Exception e) {
            e.printStackTrace();//stack쌓인 에러 메시지와 라인번호 같이 출력
        }
        return result;
    }
    public int empUpdate(EmpVO peVO) {
        System.out.println("empUpdate 호출");
        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE emp ");
        sql.append("SET ename = ? ");
        sql.append(",hiredate = ?");
        sql.append(",job = ?");
        sql.append("WHERE empno = ? ");
        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, peVO.getEname());
            pstmt.setString(2, peVO.getHiredate());
            pstmt.setInt(3, peVO.getEmpno());
            result = pstmt.executeUpdate();
            System.out.println("DeptManagerDao result:"+result);
        } catch (SQLException se){
            System.out.println(se.getMessage());
            System.out.println("[query]"+sql.toString());
        } catch (Exception e) {
            e.printStackTrace();//stack쌓인 에러 메시지와 라인번호 같이 출력
        }
        return result;
    }
    public int empInsert(EmpVO peVO) {
        int result = 0;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO emp(empno, ename, job) VALUES (?, ?, ?)");
        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, peVO.getEmpno());
            pstmt.setString(2, peVO.getEname());
            pstmt.setString(3, peVO.getJob());
            result = pstmt.executeUpdate();
        } catch (SQLException se){
            System.out.println(se.getMessage());
            System.out.println("[query]"+sql.toString());
        } catch (Exception e) {
            e.printStackTrace();//stack쌓인 에러 메시지와 라인번호 같이 출력
        }
        return result;
    }
    public List<EmpVO> empList(EmpVO peVO) {
        List<EmpVO> elist = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        int empno = 0;
        if(peVO!=null){
            empno = peVO.getEmpno();
        }
        System.out.println("empno:"+empno);
        try {
            sql.append("SELECT empno, ename, job");
            sql.append("     , mgr, to_char(hiredate, 'YYYY-MM-DD') as hiredate, sal");
            sql.append("     , comm, deptno");
            sql.append(" FROM emp");
            if(empno > 0){
                sql.append(" WHERE empno = ?");
            }
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            if(empno > 0){
                pstmt.setInt(1, empno);
            }

            rs = pstmt.executeQuery();
            EmpVO evo = null;
            while (rs.next()) {
                evo = new EmpVO();
                //dvo.setDeptno(rs.getInt(1));
                evo.setEmpno(rs.getInt("empno"));
                evo.setEname(rs.getString("ename"));
                evo.setJob(rs.getString("job"));
                evo.setMgr(rs.getInt("mgr"));
                evo.setHiredate(rs.getString("hiredate"));
                evo.setSal(rs.getDouble("sal"));
                evo.setSal(rs.getDouble("comm"));
                evo.setDeptno(rs.getInt("deptno"));
                elist.add(evo);
            }
        } catch (SQLException se){
            System.out.println(se.getMessage());
            System.out.println("[query]"+sql.toString());
        } catch (Exception e) {
            e.printStackTrace();//stack쌓인 에러 메시지와 라인번호 같이 출력
        }
        return elist;
    }//end of deptList
}
