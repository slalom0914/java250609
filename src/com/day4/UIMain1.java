package com.day4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIMain1 implements ActionListener {
    UISub1 uiSub = new UISub1();
    @Override
    public void actionPerformed(ActionEvent e) {
        //생성된 버튼의 라벨 가져오기
       String command = e.getActionCommand();
       //입력버튼 누른거야?
        if(command.equals("입력")){
            System.out.println("입력 호출");
            uiSub.set(command, true);
        }
       //수정버튼 눌렀어?
       else if(command.equals("수정")){
            System.out.println("수정 호출");
            uiSub.set(command, true);
        }
       //상세보기 원해?
        else if(command.equals("상세보기")){
            System.out.println("상세보기 호출");
            uiSub.set(command, true);
        }
    }

    JFrame jf = new JFrame("CRUD");
    JPanel jp_north = new JPanel();
    JButton btnInsert = new JButton("입력");
    JButton btnUpdate = new JButton("수정");
    JButton btnDelete = new JButton("삭제");
    JButton btnDetail = new JButton("상세보기");
    public void initDisplay(){
        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDetail.addActionListener(this);
        btnDelete.addActionListener(this);
        jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp_north.add(btnInsert);
        jp_north.add(btnUpdate);
        jp_north.add(btnDelete);
        jp_north.add(btnDetail);
        jf.add(jp_north);
        jf.setSize(400,500);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        UIMain1 ui = new UIMain1();
        ui.initDisplay();
    }
}
