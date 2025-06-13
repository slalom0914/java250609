package com.day5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableExam implements ActionListener {
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
            for (int i=0;i<index.length;i++){
                System.out.println(index[i]);
            }
        }
    }
    public void initDisplay(){
        btnDel.addActionListener(this);
        frame.add("North", btnDel);
        frame.add("Center",jsp);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        JTableExam jte = new JTableExam();
        jte.initDisplay();
        //dtm은 데이터집합을 객체화 한것
        //table은 폼, 양식이다.


    }
}
