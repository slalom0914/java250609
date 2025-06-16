package com.day11;

import javax.swing.*;

public class JFrameTest1 {
    //선언부
    JFrame frame = null;
    String title = null;
    //생성자
    public JFrameTest1() {
        initDisplay();
        frame = new JFrame("화면");
    }
    public JFrameTest1(String title) {
        this.title = title;
        frame = new JFrame(title);
        initDisplay();
    }
    //화면그리기
    public void initDisplay(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    //메인메소드
    public static void main(String[] args) {
        //JFrameTest1 jtf = new JFrameTest1("제목");
        JFrameTest1 jtf = new JFrameTest1();
        //jtf.initDisplay();
    }
}
