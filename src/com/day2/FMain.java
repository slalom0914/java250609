package com.day2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class F implements ActionListener {
    JFrame f = new JFrame();
    String b1_label = "비활성화";
    JButton b1=new JButton(b1_label);
    JButton btnTitle=new JButton("제목변경");
    //화면을 그리는 메소드 입니다.
    void initDisplay(boolean isOk){
        System.out.println("initDisplay");
        String title = new String("숫자맞추기게임");
        b1.addActionListener(this);
        btnTitle.addActionListener(this);
        f.add("North", b1);
        f.add("South", btnTitle);
        f.setTitle(title);
        f.setSize(400,400);
        f.setVisible(isOk);
    }
    //콜백함수 - 버튼이 눌려졌을 때 JVM이 호출해줌.
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //너 비활성화 버튼 누른거야?
        if(obj==b1){

        }
        else if(obj==btnTitle){
            System.out.println("제목변경 버튼이 눌렸을 때");
            //여기로 진입이 일어남 - 흐름이 바뀐다.
            //f를 전변으로 했기때문에 전역에서 호출이 가능하다.
            //이미 JFrame생성된 상태이지만 setTitle활용하여
            //제목을 변경할 수 있었다.- 상태가 바뀐것을 즉시 반영해줌
            f.setTitle("야구게임") ;
        }

    }
}
public class FMain {
    public static void main(String[] args) {
        F f = new F();
        //자바는 같은 이름의 메소드를 여러개 선언할 수 있다.
        //메소드 오버로딩을 만족한다면 중복 선언 가능하다.
        //무조건 파라미터의 갯수가 다르거나 타입이 다르면
        f.initDisplay(true);
    }
}
