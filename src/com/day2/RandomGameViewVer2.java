package com.day2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomGameViewVer2 implements ActionListener {
    //선언부
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
    int count =0;//게임 회차를 표시하는 변수이다.
    int dap;
    int my;
    //생성자
    public RandomGameViewVer2() {
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
        if(obj == btnExit){
            System.exit(0);
        }
        else if(obj==jtf){
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
        jp_east.setLayout(new GridLayout(4,1));
        jp_east.add(btnNew);//새게임
        jp_east.add(btnClear);//지우기
        jp_east.add(btnDap);//정답
        jp_east.add(btnExit);//종료
        jtf.addActionListener(this);
        btnExit.addActionListener(this);
        jta.setBackground(Color.cyan);
        jf.add("Center",jsp);
        jf.add("South",jtf);
        jf.add("East",jp_east);
        jf.setSize(400,300);
        jf.setVisible(true);

    }

    //메인메소드
    public static void main(String[] args) {
        System.out.println("main메소드 호출");
        RandomGameViewVer2 rgv = new RandomGameViewVer2();
    }
}
