package com.fwcollection.list;

import com.google.gson.Gson;
import com.util.DBConnectionMgr;
import com.vo.DeptVO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeptList extends JFrame {
    DBConnectionMgr dbMgr;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    public DeptList() {
        dbMgr = DBConnectionMgr.getInstance();
    }
    public List<DeptVO> getList(){
        String sql = "SELECT deptno, dname, loc FROM dept";
        List<DeptVO> list = new ArrayList<>();
        try {
            conn = dbMgr.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            DeptVO dvo;
            while(rs.next()){
                dvo = new DeptVO();
                dvo.setDeptno(rs.getInt("deptno"));
                dvo.setDname(rs.getString("dname"));
                dvo.setLoc(rs.getString("loc"));
                list.add(dvo);
            }
        }catch(SQLException se){
            //select문에 대한 디버깅은 오라클 전용도구 사용함.
            System.out.println(sql);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }// end of getList

    public String getJSONList(){
        String sql = "SELECT deptno, dname, loc FROM dept";
        List<DeptVO> list = new ArrayList<>();
        try {
            conn = dbMgr.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            DeptVO dvo;
            while(rs.next()){
                dvo = new DeptVO();
                dvo.setDeptno(rs.getInt("deptno"));
                dvo.setDname(rs.getString("dname"));
                dvo.setLoc(rs.getString("loc"));
                list.add(dvo);
            }
        }catch(SQLException se){
            //select문에 대한 디버깅은 오라클 전용도구 사용함.
            System.out.println(sql);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Gson gson = new Gson();
        String temp = gson.toJson(list);
        return temp;
    }// end of getList

    public static void main(String[] args) {

    }
}
