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
            int[] selectedRows = table.getSelectedRows();

            if(selectedRows.length > 0) {
                // 색인 이동 문제를 피하기 위해 하강 순서로 지수를 정렬
                // 여러 행을 제거 할 때
                java.util.Arrays.sort(selectedRows);

                // 모델에서 행을 반대로 제거합니다
                for(int i = selectedRows.length - 1; i >= 0; i--) {
                    dtm.removeRow(selectedRows[i]);
                }

                // 현재 테이블 데이터와 일치하도록 데이터 배열 업데이트
                String[][] newDatas = new String[dtm.getRowCount()][cols.length];
                for(int i = 0; i < dtm.getRowCount(); i++) {
                    for(int j = 0; j < dtm.getColumnCount(); j++) {
                        newDatas[i][j] = (String)dtm.getValueAt(i, j);
                    }
                }
                // 원래 데이터 배열을 업데이트하십시오
                datas = newDatas;
                System.out.println("선택한 행이 삭제되었습니다.");
            } else {
                JOptionPane.showMessageDialog(frame, "삭제할 행을 선택해주세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    public void initDisplay(){
        btnDel.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
