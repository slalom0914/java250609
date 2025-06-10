package com.day2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class E implements ActionListener {
    //윈도우 API 활용해서 창 제공하는 클래스이다.
    JFrame f = new JFrame();
    String b1_label = "비활성화";
    JButton b1=new JButton(b1_label);
    //화면을 그리는 메소드 입니다.
    void initDisplay(){
        System.out.println("initDisplay");
        String title = new String("숫자맞추기게임");
        //여기서 this는 클래스 E를 가리킨다.
        //E클래스는 actionPerformed콜백메소드를 구현하고 있는
        //이벤트 구현 클래스 입니다.- 이벤트 핸들러 클래스 이다.
        b1.addActionListener(this);
        f.add("North", b1);
        f.setTitle(title);
        f.setSize(400,400);
        //true이면 화면이 출력됨, false이면 화면이 출력되지 않음.
        //intellij에서는  false이면 자원을 회수해 버림
        f.setVisible(true);
    }
    //콜백함수 - 버튼이 눌려졌을 때 JVM이 호출해줌.
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed 호출");
        //이벤트가 발생한 클래스 주소번지를 가져온다.
        Object obj = e.getSource();
        //너 비활성화 버튼 누른거야?
        if(obj==b1){
            //insert here - 여기가 학습목표
            f.setVisible(false);
            //자바가상머신과의 연결고리가 끊어진다.
            //자원회수가 일어난다.
            //어플리케이션이 종료되었다.
            System.exit(-1);
            //f.dispose();
        }

    }
}
public class EMain {
    public static void main(String[] args) {
        //insert here
        //여기가 학습목표이다.
        E e = new E();
        e.initDisplay();
    }
}
