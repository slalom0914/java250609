package com.day5;

import javax.swing.*;

// 인스턴스화 -> 전변때문이다. -> 원본이 바뀐다. -> 사이드 이펙트
// 위치 -> NullPointerException
class B2{
    //선언과 생성이 분리 되어 있다면 NPE만날 수도 있다.
    JFrame jf = null;
    JButton b1 = new JButton("버튼1");
    B2(){
        jf = new JFrame();
    }
    B2(String s){
        jf.setTitle(s);
    }
    public void initDisplay(){
        jf.setSize(400,400);
        jf.setVisible(true);
        //창끝에 X버튼에 대한 처리를 하지 않아도 자동으로 자원 회수 해줌.
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
public class B2Main {
    public static void main(String[] args) {
        B2 b2 = new B2();
        b2 = new B2("SSSS");
        b2.initDisplay();
    }
}
