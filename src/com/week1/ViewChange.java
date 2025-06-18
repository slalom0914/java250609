package com.week1;
//화면변경 버튼을 클릭했을 때 새로운 화면 출력하기
//새로 들어갈 화면 클래스를 인스턴스화 하기
//위치와 생성자 결정
//화면 처리와 관련해서 전처리나 후처리 생각 - 경험

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JPanel1 extends JPanel {
    String[] cols = {"이메일","이름"};
    String[][] data = new String[1][3];
    //DataSet의 역할을 하는 DefaultTableModel
    DefaultTableModel model = new DefaultTableModel(data,cols);
    JTable table = new JTable(model);
    JScrollPane jsp = new JScrollPane(table);
    JPanel1(){
        initDisplay();
    }
    public void initDisplay(){
        this.setLayout(new BorderLayout());
        this.add("Center",jsp);
        this.setSize(300,300);
        this.setVisible(true);
    }
}


public class ViewChange extends JFrame implements ActionListener {
    JTextArea jta = new JTextArea();
    JButton btn = new JButton("화면변경");
    JPanel jp = new JPanel();
    //콜백메서드 다루기
    //파라미터에 객체를 외부에서 주입받는다.
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        System.out.println(obj);
        if(obj == btn){
           Container cont = getContentPane();
           if(jta !=null){
               cont.remove(jta);
           }
           JPanel1 panel1 = new JPanel1();
           this.add("Center",panel1);
           cont.revalidate();
        }
    }

    public void initDisplay(){
        btn.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jta.setBackground(Color.cyan);
        jp.setBackground(Color.red);
        this.add("North", btn);
        this.add("Center", jta);
        this.setSize(300,300);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        ViewChange vm = new ViewChange();
        vm.initDisplay();
    }
}
