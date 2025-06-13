package com.day5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableExam2 implements ActionListener {
    JFrame frame = new JFrame("테이블예제");
    String[] cols = {"번호","제목","작성자"};
    String[][] datas = {
            {"1","제목1","내용1"},
            {"2","제목2","내용2"},
            {"3","제목3","내용3"},
            {"4","제목4","내용4"},
    };
    JButton btnDel = new JButton("삭제");
    DefaultTableModel dtm = new DefaultTableModel(datas, cols);
    JTable table = new JTable(dtm);
    JScrollPane jsp = new JScrollPane(table);
    @Override
    public void actionPerformed(ActionEvent e){
        //이벤트가 감지된 삭제 버튼의 주소번지를 가져온다. -getSource()
        Object source = e.getSource();
        //너 삭제버튼 누른거야
        if(source == btnDel){
            System.out.println("삭제버튼 클릭 성공");
            //몇번째 로우를 삭제할거야?
            int index[] = table.getSelectedRows();
            Object[][] newDatas = new Object[datas.length-1][];
            int newIndex = 0;
            for(int i=0;i<datas.length;i++){
                if(i != index[0]){
                    newDatas[newIndex++]=datas[i];
                }
            }
            for(int i=0;i<newDatas.length;i++){
                for(int j=0;j<newDatas[i].length;j++){
                    System.out.println(newDatas[i][j]);
                }
            }
            getList(newDatas);
        }
    }
    public void initDisplay(){
        btnDel.addActionListener(this);
        frame.add("North", btnDel);
        frame.add("Center",jsp);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    public void getList(Object[][] newDatas){
        Container con = frame.getContentPane();
        if(jsp!=null) con.remove(jsp);
        dtm = new  DefaultTableModel(newDatas, cols);
        table = new JTable(dtm);
        jsp = new JScrollPane(table);
        frame.add("Center", jsp);
        con.revalidate();
    }
    public static void main(String[] args) {
        JTableExam2 jte = new JTableExam2();
        jte.initDisplay();
        //dtm은 데이터집합을 객체화 한것
        //table은 폼, 양식이다.
    }
}
