package com.week1;

import javax.swing.*;
import java.awt.*;

public class BorderLayout1 {
    JFrame jf = new JFrame("객체배열연습");
    JButton[] btns = new JButton[5];
    String[] btn_labels = {"동쪽","북쪽","서쪽","남쪽","중앙"};
    public void initDisplay(){
        jf.setLayout(new FlowLayout(FlowLayout.RIGHT));
        for(int i=0;i<btn_labels.length;i++){
            btns[i] = new JButton(btn_labels[i]);
            jf.add(btns[i]);
        }
        jf.setSize(600,400);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        BorderLayout1 b = new BorderLayout1();
        b.initDisplay();
    }
}
