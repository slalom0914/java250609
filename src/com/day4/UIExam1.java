package com.day4;

import javax.swing.*;
// -> Collection F/W -> List, Map, Set
// -> 제네릭을 지원함 -> 객체배열
// -> 데이터 수집 -> API
public class UIExam1 {
    public static void main(String[] args) {
        JButton btns[] = new JButton[4];//객체배열
        System.out.println(btns[0]);//null
        btns[0] = new JButton("첫번째버튼");//생성자
        System.out.println(btns[1]);//null
        System.out.println(btns[2]);//null
        System.out.println(btns[3]);//null
        String btn_labels[] = {"입력","수정","삭제","상세보기"};
        for (int i = 0; i < btn_labels.length; i++) {
            btns[i] = new JButton(btn_labels[i]);
        }
        JFrame frame = new JFrame("테스트");
        frame.add("North",btns[0]);
        frame.add("West",btns[1]);
        frame.add("South",btns[2]);
        frame.add("Center",btns[3]);
        frame.setSize(400,400);
        frame.setVisible(true);

    }
}
