package com.day5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 공지사항 목록 처리
// 공지사항 수정 화면
// 공지사항 삭제 처리
// 공지사항 입력 화면/처리
// 자바는 단일 상속만 지원함
// 단일 상속의 단점을 보완하기 위해 인터페이스를 지원함.
public class NoticeApp extends JFrame implements ActionListener {
    //선언
    //생성자를 호출 -> 생성자 안에서 initDisplay()호출함.
    NoticeDialog nd =  new NoticeDialog("다이얼로그");
    JMenuBar jmb = new JMenuBar();
    JMenu jm_edit = new JMenu("편집");
    JMenuItem jmi_ins = new JMenuItem("입력");
    JMenuItem jmi_upd = new JMenuItem("수정");
    JMenuItem jmi_del = new JMenuItem("삭제");
    JMenuItem jmi_det = new JMenuItem("상세보기");
    JMenuItem jmi_all = new JMenuItem("전체조회");
    JSeparator sep = new JSeparator();
    JMenuItem jmi_exit = new JMenuItem("종료");
    JPanel jp_north = new JPanel();
    JButton btnIns = new JButton("입력");
    JButton btnUpd = new JButton("수정");
    JButton btnDel = new JButton("삭제");
    JButton btnAll = new JButton("전체조회");
    JButton btnDet = new JButton("상세조회");
    JButton btnExit = new JButton("종료");
    //공지사항 목록 처리
    String[] cols = {"번호","제목","작성자"};
    DefaultTableModel md_notice = new DefaultTableModel(cols, 0);
    JTable tb_notice = new JTable(md_notice);
    JScrollPane jsp_notice = new JScrollPane(tb_notice);
    //입력, 수정, 삭제, 전체조회, 상세조회, 종료
    public NoticeApp() {
        //화면을 출력하는 메소드를 main호출하기
        //생성자에서 호출할 때 차이점은?
        initDisplay();
    }

    public void noticeList(){
        Object[][] datas = new Object[][]{
                {1,"공지제목1", "공지내용1"},
                {2,"공지제목2", "공지내용3"},
                {3,"공지제목3", "공지내용3"},
        };
        //기존에 화면은 없애고 새로 그린다.
        Container con = getContentPane();
        if(jsp_notice !=null){
            con.remove(jsp_notice);
        }
        md_notice = new  DefaultTableModel(datas, cols);
        tb_notice = new JTable(md_notice);
        jsp_notice = new JScrollPane(tb_notice);
        this.add("Center", jsp_notice);
        con.revalidate();
    }//end of 전체 조회(새로고침 역할수행)

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        System.out.println(obj);

        if(obj == jmi_all || obj == btnAll){
            noticeList();
        }
        else if(obj == jmi_del || obj == btnDel){
            int index[] = tb_notice.getSelectedRows();
            //아무 것도 선태하지 않았다.
            if(index.length == 0){
                JOptionPane.showMessageDialog(this, "삭제할 데이터 로우를 선택하세요.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }//
            else{
                for(int i = 0; i < md_notice.getRowCount(); i++){
                    if(tb_notice.isRowSelected(i)){
                        System.out.println(md_notice.getValueAt(i, 0));
                    }
                }
            }
        }
    }

    public void initDisplay(){
        jp_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jm_edit.add(jmi_ins);
        jm_edit.add(jmi_upd);
        jm_edit.add(jmi_del);
        jm_edit.add(jmi_det);
        jm_edit.add(jmi_all);
        jm_edit.add(sep);
        jm_edit.add(jmi_exit);
        jmb.add(jm_edit);
        this.setJMenuBar(jmb);
        jp_north.add(btnIns);
        jp_north.add(btnUpd);
        jp_north.add(btnDel);
        jp_north.add(btnAll);
        jp_north.add(btnDet);
        jp_north.add(btnExit);
        btnIns.addActionListener(this);
        btnUpd.addActionListener(this);
        btnDel.addActionListener(this);
        btnAll.addActionListener(this);
        btnDet.addActionListener(this);
        btnExit.addActionListener(this);
        jmi_ins.addActionListener(this);
        jmi_upd.addActionListener(this);
        jmi_del.addActionListener(this);
        jmi_det.addActionListener(this);
        jmi_all.addActionListener(this);
        jmi_exit.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add("North", jp_north);
        this.add("Center", jsp_notice);
        this.setTitle("공지사항 게시판 구현");
        this.setLocation(100,100);
        this.setSize(700,500);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new NoticeApp();//생성자 호출하기 - 초기화
    }
}
