package com.day4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//이벤트 처리는 어떤 어플리케이션에서 사용되는지에 따라서
//기능이 달라질 수 있다.- 결정할 수 없다.
//결정할 수 없을 때 자바에서는 인터페이스나 추상클래스 설계 해둔다.
public class UISub1 implements ActionListener {
    JDialog jd = new JDialog();
    JScrollPane jsp = new JScrollPane();
    JButton btnClose = new JButton("닫기");
    public UISub1(){
        initDisplay();
    }
    //자바에서는 같은 이름의 메소드를 중복 정의할 수 있다.
    //단. 타입이 다르거나 갯수가 다르면 됨
    public void set(boolean isOk, String title){

    }
    public void set(String title, boolean isOk){
        jd.setTitle(title);
        jd.setVisible(isOk);
    }
    public void actionPerformed (ActionEvent e){
        Object obj = e.getSource();//이벤트 소스 가져옴.
        if(obj == btnClose){
            jd.dispose();
        }
    }
    public void initDisplay(){
        btnClose.addActionListener(this);
        jd.add("Center", jsp);
        jd.add("South", btnClose);
        jd.setTitle("입력|수정|상세보기");
        jd.setSize(400,400);
        //메모리에는 UISub클래스 로딩 중임.화면으로는 보이지 않음.
        jd.setVisible(false);
    }

    public static void main(String[] args) {
        new UISub1();
    }
}


