package com.day1.up;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class B implements ActionListener {
    JFrame f = new JFrame();
    //문자열은 ""나타냄.
    JButton b = new JButton("로그인");
    //파라미터가 없는 생성자를 디폴트 생성자 부름
    public B(){// B클래스의 생성자 이다.
        System.out.println("클래스 B의 디폴트 생성자 호출");
        //여기서 this는 B를 가리킨다.
        b.addActionListener(this);
        int width = 500;
        int height = 700;
        f.add("North",b);
        f.setSize(width,height);
        width = 700;
        f.setVisible(true);
    }
    //버튼에 클릭이벤트를 처리하기 위해서 ActionListener라는
    //인터페이스를 implements하였다.
    //이것은 B클래스가 Button에 이벤트 처리를 담당하는 클래스 이다.
    //를 말한다.
    //따라서 이벤트가 감지 되었을 때 호출되는 콜백함수가 필요하다.
    //이것을 JVM이 정해 두었다.
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        System.out.println("클릭한 버튼의 라벨 : "+label);//로그인 글자
        //너 로그인 버튼 누른거야?
        if("로그인" == label){
            System.out.println("로그인버튼을 눌렀다.");
        }
    }
    public static void main(String[] args) {
        B b = new B();
    }
}
