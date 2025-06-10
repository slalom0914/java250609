package com.day2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
//RandomGameView안에 ActionListener 인터페이스가 선언해 둔
//actionPerformed메소드를 구현하는 구현체 클래스 다.
public class RandomGameView implements ActionListener {
    //선언부
    JFrame jf = new JFrame("숫자게임");
    //다중행
    JTextArea jta = new JTextArea(5,15);
    JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    //단일행
    JTextField jtf = new JTextField();
    int count =0;//게임 회차를 표시하는 변수이다.
    int dap;
    int my;
    //생성자
    public RandomGameView() {
        System.out.println("디폴트생성자 호출");
        //정답채번하기- 초기화

        Random rand = new Random();
        dap =  rand.nextInt(10);
        System.out.println("정답 : " + dap);
        initDisplay();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj==jtf){
            String msg = null;
            //System.out.println(jtf.getText());
            String s = jtf.getText();
            //파라미터에 문자열을 넣으면 정수로 바꿔주는 메소드가 있다.
            my = Integer.parseInt(s);

            //정답인 경우
            if(dap == my){
                msg = "축하합니다. 정답입니다.";//초기화
                //System.exit(0);//JVM연결고리 강제로 끊어낸다.
            }else if(dap> my){
                msg = "높여라";
            }else if(dap < my){
                msg = "낮춰라";
            }

            //jta.append(++count+"회차 : "+s);
            //메소드 안에서 리턴타입이 있는 메소드 호출은 합법이다.
            jta.append(++count+"회차 : "+my+"-"+msg+"\n");
            jtf.setText("");
        }
    }
    public void initDisplay(){
        System.out.println("화면 출력하기");

        jtf.addActionListener(this);
        jta.setBackground(Color.cyan);
        jf.add("Center",jsp);
        jf.add("South",jtf);
        jf.setSize(400,300);
        jf.setVisible(true);

    }

    //메인메소드
    public static void main(String[] args) {
        System.out.println("main메소드 호출");
        RandomGameView rgv = new RandomGameView();
    }
}
