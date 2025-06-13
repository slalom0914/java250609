package com.day5;

import javax.swing.*;
import java.awt.*;

public class RandomGameUI {
    //선언부
    //객체 주입시 순환구조가 되지 않도록 주의할 것.
    RandomGameEvent rge = new RandomGameEvent(this);
    RandomGameLogic rgl = new RandomGameLogic(this);
    JFrame jf = new JFrame("숫자게임-Ver2");
    JPanel jp_center    = new JPanel();
    JPanel jp_east      = new JPanel();
    JButton btnNew      = new JButton("새게임");
    JButton btnClear    = new JButton("지우기");
    JButton btnDap      = new JButton("정답");
    JButton btnExit     = new JButton("나가기");
    //다중행
    JTextArea jta = new JTextArea(5,15);
    JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    //단일행
    JTextField jtf = new JTextField();


    //화면그리기
    public void initDisplay(){

        System.out.println("화면 출력하기");
        jta.setEditable(false);// 수정모드를 끄기
        jp_east.setLayout(new GridLayout(4,1));
        jp_east.add(btnNew);//새게임
        jp_east.add(btnClear);//지우기
        jp_east.add(btnDap);//정답
        jp_east.add(btnExit);//종료
        jta.setBackground(Color.cyan);
        //내 안에 actionPerformed가 있지 않다. - 외부에 있다.
        //외부에 객체 사용할 때는 인스턴스화
        btnClear.addActionListener(rge);
        btnDap.addActionListener(rge);
        btnNew.addActionListener(rge);
        jtf.addActionListener(rge);
        btnExit.addActionListener(rge);

        jf.add("Center",jsp);
        jf.add("South",jtf);
        jf.add("East",jp_east);
        jf.setSize(400,300);
        jf.setVisible(true);

    }
    //메인메소드
    public static void main(String[] args) {
        RandomGameUI rgui = new RandomGameUI();
        rgui.initDisplay();
    }
}

/*
세 개 클래스 중에서 어떤 클래스에 main메서드를 두면 되나요?
세 개 클래스 중에서 어느에 actionPerformed를 오버라이딩 하면 되나요?
하나의 클래스를 세 개로 쪼개었을 때 클래스 사이의 의존관계를
정하는 인스턴스화 구문은 어디에 어떤 클래스를 인스턴스화 해야 하나요?
단 static사용하지 않고 처리해 보세요.
 */