package com.day2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class E implements ActionListener {
    JFrame f = new JFrame();
    String b1_label = "비활성화";
    JButton b1=new JButton(b1_label);
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
            //insert here
        }

    }
}
public class EMain {
    public static void main(String[] args) {
        //insert here
        E e = new E();
        e.initDisplay();
    }
}
