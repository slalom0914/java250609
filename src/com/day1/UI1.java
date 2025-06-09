package com.day1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI1 implements ActionListener {
    //선언부
    //아래 인스턴스화 코드들은 모두 UI1클래스의 전변이다.
    JFrame jf = new JFrame("숫자게임");
    //다중행
    JTextArea jta = new JTextArea(5,15);
    //단일행
    JTextField jtf = new JTextField();
    int count =0;//게임 회차를 표시하는 변수이다.
    //생성자 - static 아니라서 변수를 자유롭게 사용이 가능함
    public UI1(){
        //이벤트 소스와 이벤트 처리 객체 연결하기
        //this는 자기자신을 가리킴. UI1
        //UI1클래스가 화면도 그리고 이벤트 처리도 담당함.
        jtf.addActionListener(this);
        jta.setBackground(Color.cyan);
        jf.add("Center",jta);
        jf.add("South",jtf);
        jf.setSize(400,300);
        jf.setVisible(true);
    }
    //콜백함수의 파라미터 ActionEvent는 JVM주입해줌
    //이벤트 감지가 되었을 때 이벤트 소스 즉 주소번지를 얻음.
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj==jtf){
            //System.out.println(jtf.getText());
            String s = jtf.getText();
            //jta.append(++count+"회차 : "+s);
            //메소드 안에서 리턴타입이 있는 메소드 호출은 합법이다.
            jta.append(++count+"회차 : "+jtf.getText()+"\n");
            jtf.setText("");
        }
    }
    //메인메소드 - 외부에서 사용이 불가하다. - 최소한 코드만 작성함.
    public static void main(String[] args) {
        //인스턴스화를 하면 생성자가 호출됨.
        UI1 ui = new UI1();
    }
}
