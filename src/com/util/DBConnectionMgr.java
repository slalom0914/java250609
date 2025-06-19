package com.util;

import java.sql.*;

//인스턴스화
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
