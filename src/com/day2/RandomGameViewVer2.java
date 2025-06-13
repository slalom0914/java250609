package com.day2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// 반드시 완성도 높일 필요는 없다.
// 클래스 한개를 - 나는 세개의 클래스 나누고 잘 동작하도록 할 수 있다.
// RandomGameUI.java, RandomGameEvent.java, RandomGameLogic.java

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
    int dap= -1;
    int my;
    //생성자
    public RandomGameViewVer2() {
        System.out.println("디폴트생성자 호출");
        //생성자에 있었던 채번하는 코드 2줄을 nanSu 메서드로 옮김
        //nanSu();
        System.out.println("정답 : " + dap);
        initDisplay();
    }
    //화면이 출력되면 무조건 채번하는 것인가?
    //아니면 새게임을 눌렀을 때 채번되게 하는 것인가?
    //고객님
    public void nanSu(){
        System.out.println("채번 메서드 호출");
        //정답채번하기- 초기화
        Random rand = new Random();
        dap =  rand.nextInt(10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == btnDap){
            nanSu();
            jta.append("정답은 " + dap + " 입니다. \n");
            count = 0;
        }
        else if(obj == btnNew){
            count = 0;
            nanSu();
            System.out.println("새로 채번된 숫자는 "+dap);
            jta.append("새게임이 시작되었습니다. \n");
        }
        else if (obj == btnClear) {
            jta.setText("");
        }
        else if(obj == btnExit){
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
    }//end of actionPerformed
    public void initDisplay(){
        System.out.println("화면 출력하기");
        jta.setEditable(false);// 수정모드를 끄기
        jp_east.setLayout(new GridLayout(4,1));
        jp_east.add(btnNew);//새게임
        jp_east.add(btnClear);//지우기
        jp_east.add(btnDap);//정답
        jp_east.add(btnExit);//종료
        btnClear.addActionListener(this);
        btnDap.addActionListener(this);
        btnNew.addActionListener(this);
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
