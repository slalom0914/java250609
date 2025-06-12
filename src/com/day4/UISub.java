package com.day4;

import javax.swing.*;

public class UISub {
    JDialog jd = new JDialog();
    public UISub(){
        initDisplay();
    }
    public void initDisplay(){
        jd.setTitle("입력|수정|상세보기");
        jd.setSize(400,400);
        jd.setVisible(true);
    }
}


