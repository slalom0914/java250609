package com.util;

import java.sql.*;
//공통코드 - 공통팀, 유지보수팀,  DevOps, 형상관리팀,Q/C팀
//인스턴스화 - 생성자 - 메서드 오버로딩 룰
//파라미터가 없는 생성자를 디폴트 생성자 라고 하고 생략하면 JVM제공해줌.
//자바가 제공하는 클래스는 생성자의 숫자도 정해져 있다.
//인스턴스화를 한 줄컷보다는 두 줄컷으로 연습하기
//게으른 생성(주입) - 당장 필요할 때 생성해 줄께
// 과 이른 생성(주입) - 미리 말해주면 내가 미리 메모리에 띄워놓을께
//A a = new A();
//Parent p = new Child();// 다형성
//싱글톤 Calendar cal = Calendar.getInstance()
public class DBConnectionMgr {
    private static DBConnectionMgr dbMgr = null;
    private final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String _URL = "jdbc:oracle:thin:@localhost:1521:orcl11";
    private final String _USER = "scott";
    private final String _PASSWORD = "tiger";
    private DBConnectionMgr() {
        try {
            Class.forName(_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Can't load JDBC driver");
        }
    }//end of 디폴트 생성자 - 접근제한자를 private함
    //어떻게 하나의 인스턴스로 여러 사람을 서비스 할 수 있을까?
    //스레드 - 경합, 지연발생, 지속적인 서비스
    //한정된 자원을 여러 사람이 공정하고 공평하게 누리기 위해서 필요하다.
    //메서드의 리턴타입이 객체인것을 더 연습해 보자 - 사용자 정의 클래스
    //동기와 비동기
    //인터셉터를 당하지 않도록 방어 코드를 작성한다.
    //객체마다 lock flag
    //어떤 객체가 아래 메서드 진입을 하면 잠긴다.- 스레드 안전 - 속도 느리다.
    public static synchronized DBConnectionMgr getInstance() {
        //조건부로 인스턴스화 함. - 싱글톤
        if (dbMgr == null) {
            dbMgr = new  DBConnectionMgr();
        }
        return dbMgr;
    }//외부에서 객체 주입을 받을 때 호출하는 메서드
    //물리적으로 떨어져 있는 외부DB서버와 커넥션 맺기
    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(_URL, _USER, _PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }//end of getConnection
    //사용한 자원에 대해서는 반납하기
    //자원을 반납시 생성된 역순으로 한다.
    public void freeConnection(Connection conn, PreparedStatement pstmt, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(pstmt != null){
                pstmt.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void freeConnection(Connection conn, Statement stmt, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
