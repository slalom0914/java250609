package com.network;

import javax.swing.*;
import java.awt.*;

public class TimeClientView extends JFrame {
    JLabel jlb_timer = new JLabel("현재 시간", JLabel.CENTER);
    Font f = new  Font("굴림체", Font.BOLD, 46);
    public TimeClientView(){
        initDisplay();
    }
    public void initDisplay(){
        Thread th = new TimeClient(jlb_timer);
        th.start();
        jlb_timer.setFont(f);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add("Center", jlb_timer);
        this.setSize(500,400);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        TimeClientView view = new TimeClientView();
    }
}
