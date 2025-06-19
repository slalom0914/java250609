package com.fwcollection.list;

import com.google.gson.Gson;
import com.util.DBConnectionMgr;
import com.vo.DeptVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DeptList2 extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(btnSelect == src){
            System.out.println(model.getRowCount());//0

            List<DeptVO> dlist = getList();
            //이미 테이블에 조회된 정보가 있는 경우 모두 삭제하고
            //새로 읽어온 데이터를 다시 출력한다. - 초기화
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            for(int i=0;i<dlist.size();i++){//데이터가 들어 있는거야?
                DeptVO rdvo = dlist.get(i);
                Vector<Object> v = new Vector<>();
                v.add(rdvo.getDeptno());
                v.add(rdvo.getDname());
                v.add(rdvo.getLoc());
                model.addRow(v);//데이터셋에 데이터를 추가하는 코드를 어디에 써야하나
            }

        }
    }//end of actionPerformed

    JButton btnSelect = new JButton("조회");
    String[] cols = {"deptno", "dname", "loc"};
    Object[][] data = new Object[0][3];
    //생성자도 메서드 오버로딩의 규칙을 준수하므로 파라미터 타입, 갯수 반드시 일치
    DefaultTableModel model = new DefaultTableModel(data, cols);
    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);
    DBConnectionMgr dbMgr;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    public void initDisplay(){
        btnSelect.addActionListener(this);
        this.add("North", btnSelect);
        this.add("Center", scrollPane);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
    }

    public DeptList2() {
        dbMgr = DBConnectionMgr.getInstance();
        initDisplay();
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
            System.out.println(list.size());
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
        new DeptList2();
        //initDisplay();
    }
}
