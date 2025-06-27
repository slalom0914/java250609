package com.emp;

import com.vo.EmpVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {
    private final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String _URL = "jdbc:oracle:thin:@localhost:1521:orcl11";
    private final String _USER = "scott";
    private final String _PASSWORD = "tiger";
    Connection conn = null;
    //동적쿼리는 변수자리에 물음표를 사용한다.
    //물음표 자리가 다른 것은 같은 쿼리로 인지 한다.
    //파싱과 실행계획을 생략하고 3단계부터 처리한다.
    PreparedStatement pstmt = null;//동적쿼리
    ResultSet rs = null;//커서를 조작한다.
    //commit과 rollback 대상이다.
    //사원등록 - insert -
    //post(파라미터 처리 방법이 다르다 - 단위테스트 방법이 다르다)
    //INSERT INTO emp(empno, ename, job,,,)
    //VALUES('8000','강감찬', '세일즈',,,,)
    //오라클 반환값 - 1row inserted
    public int empInsert(EmpVO evo){
        int result = 0;
        StringBuilder query = new StringBuilder();
        query.append("insert into emp(empno,ename,job,mgr,hiredate");
        query.append(",sal,comm, deptno)");
        query.append(" values(?,?,?,?,?,?,?,?)");
        int no = 1;
        try {
            Class.forName(_DRIVER);
            conn = DriverManager.getConnection(_URL, _USER, _PASSWORD);
            pstmt = conn.prepareStatement(query.toString());
            pstmt.setInt(no++, evo.getEmpno());
            pstmt.setString(no++, evo.getEname());
            pstmt.setString(no++, evo.getJob());
            pstmt.setInt(no++,evo.getMgr());
            pstmt.setString(no++,evo.getHiredate());
            pstmt.setDouble(no++,evo.getSal());
            pstmt.setDouble(no++,evo.getComm());
            pstmt.setInt(no++,evo.getDeptno());
            result = pstmt.executeUpdate();
            if(result == 1){//후처리
                System.out.println("사원카드 등록 성공");
            }else{
                System.out.println("사원카드 등록 실패");
            }

        }catch(SQLException se){
            System.out.println(query.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt!=null){ pstmt.close(); }
                if(conn!=null){ conn.close(); }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    //사원수정 - update - put
    //UPDATE emp SET ename=?, job=? WHERE empno=?
    public int empUpdate(EmpVO evo){
        int result = 0;
        StringBuilder query = new StringBuilder();
        query.append("UPDATE emp");
        query.append(" SET ename = ?");
        query.append("    ,job = ?");
        query.append("    ,mgr = ?");
        query.append("    ,hiredate = ?");
        query.append("    ,sal = ?");
        query.append("    ,comm = ?");
        query.append("    ,deptno = ?");
        query.append(" WHERE empno = ?");
        int no = 1;
        try{
            Class.forName(_DRIVER);
            conn = DriverManager.getConnection(_URL, _USER, _PASSWORD);
            pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(no++, evo.getEname());
            pstmt.setString(no++, evo.getJob());
            pstmt.setInt(no++,evo.getMgr());
            pstmt.setString(no++,evo.getHiredate());
            pstmt.setDouble(no++,evo.getSal());
            pstmt.setDouble(no++,evo.getComm());
            pstmt.setInt(no++,evo.getDeptno());
            pstmt.setInt(no++, evo.getEmpno());

            result = pstmt.executeUpdate();
            if(result == 1){//후처리
                System.out.println("사원카드 수정 성공");
            }else{
                System.out.println("사원카드 수정 실패");
            }

        }catch(SQLException se){
            System.out.println(se.toString());
            System.out.println(query.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt!=null){ pstmt.close(); }
                if(conn!=null){ conn.close(); }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    //사원삭제 - delete - rest api delete
    //DELETE FROM emp WHERE empno = 8000
    //메서드 설계시 파라미터를 쿼리문을 보고 결정할 수 있다.
    public int empDelete(int empno){
        int result = 0;
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM emp WHERE empno = ?");
        try{
            Class.forName(_DRIVER);
            conn = DriverManager.getConnection(_URL, _USER, _PASSWORD);
            pstmt = conn.prepareStatement(query.toString());
            pstmt.setInt(1, empno);

            result = pstmt.executeUpdate();
            if(result == 1){//후처리
                System.out.println("사원카드 삭제 성공");
            }else{
                System.out.println("사원카드 삭제 실패");
            }

        }catch(SQLException se){
            System.out.println(query.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt!=null){ pstmt.close(); }
                if(conn!=null){ conn.close(); }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    //사원조회 - select
    //하나의 메서드에서 전체 조회일 경우와 단 건 조회일 경우를 같이 쓴다.
    //if문
    public List<EmpVO> empList(EmpVO peVO){
        List<EmpVO> list = new ArrayList<>();
        StringBuilder query = new StringBuilder();

        query.append("select empno, ename, job, mgr");
        query.append("      ,hiredate, sal, comm, deptno");
        query.append(" from emp");
        //EmpVO empno = 0;
        if(peVO.getEmpno() > 0){
            query.append(" where deptno = ?");
        }
        try{
            Class.forName(_DRIVER);
            conn = DriverManager.getConnection(_URL, _USER, _PASSWORD);
            pstmt = conn.prepareStatement(query.toString());
            if(peVO.getEmpno() > 0) {
                pstmt.setInt(1, peVO.getEmpno());
            }
            rs = pstmt.executeQuery();
            EmpVO evo = null;
            //MyBatis를 사용하면 전체 JDBC코드의 30%정도가 줄어듦
            //아래 while문을 작성하지 않아도 MyBatis가 자료구조안에
            //자동으로 담아 준다.
            while(rs.next()){
                evo = new EmpVO();
                evo.setEmpno(rs.getInt("empno"));
                evo.setEname(rs.getString("ename"));
                evo.setJob(rs.getString("job"));
                evo.setMgr(rs.getInt("mgr"));
                evo.setHiredate(rs.getString("hiredate"));
                evo.setSal(rs.getDouble("sal"));
                evo.setComm(rs.getDouble("comm"));
                evo.setDeptno(rs.getInt("deptno"));
                list.add(evo);
            }//end of while
            //List - []
            //Map - {empno=7499}, json {empno:7499}
            System.out.println(list);//json과 비슷하지만 json아니다.
            //Gson g = new Gson();
            //String temp = g.toJson(list);
            //out.print(temp);
        }catch(SQLException se){
            System.out.println(query.toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (rs != null) { rs.close(); }
                if(pstmt!=null){ pstmt.close(); }
                if(conn!=null){ conn.close(); }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
/*
등록,수정,삭제,조회
공통점은 같은 오라클 서버에 같은 계정에 접속한다.
-> 반복되는 코드가 등장한다. - 관찰하기
-> 다른 부분도 존재한다.
select는 반환타입이 n건을 받아주는 타입이어야 한다.
1건 - VO, Map - 변수종류, 컬럼의 종류
n건 - List, Object[]
insert, update, delete : int가 반환타입이다.

insert는 8개 컬럼을 사용자로 부터 입력 받는다.
파라미터는 8개가 필요하다.
만일 8개를 한 번에 넘기고 한 번에 받아오는 방법은?
파라미터 타입 : Object -> EmpVO or Map
리턴 타입 : 1 row inserted - int
public int empInsert(EmpVO or Map)

update는 기존에 있는 값을 변경하는 것이다.
조건절에 사원번호가 온다.
수정시에도 화면으로 부터 8개의 정보를 받아온다.

public int empUpdate(EmpVO or Map)

delete는 기본에 있는 정보 중 한 개 로우를 삭제하는 것이다
조건절에는 사원번호가 온다.

public int empDelete(int empno)


[[[ 생각해 보기 ]]]
insert, update, delete는 실제 테이블 값에 변화가 있어서
commit과 rollback의 대상이다.
select는 실제 테이블에 있는 값을 읽기 이어서
테이블에 변화가 없다.
commit과 rollback대상이 아니다.

insert, update, delete 커서와는 무관하다.
ResultSet은 필요가 없다.
select는 조회 결과가 있어서 ResultSet 필요하다.

insert, update, delete 리턴값이 정수이다.
1row inserted, 1row updated, 1row deleted

int result = pstmt.executeUpdate();

ResultSet rs = pstmt.executeQuery();

pstmt.execute("CREATE or ALTER, DROP...")
 */











