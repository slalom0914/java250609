package com.emp;

import com.vo.DeptVO;
import com.vo.EmpVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class EmpManager extends JFrame implements ActionListener {
    // 선언부
    EmpManagerDao emDao = new EmpManagerDao();
    EmpDialog empDialog = new EmpDialog(this);
    String header[] = { "사원번호", "사원명", "JOB", "입사일자" };
    String datas[][] = new String[0][4];
    DefaultTableModel dtm_emp = new DefaultTableModel(datas, header);// 생성자 호출
    JTable jtb_emp = new JTable(dtm_emp);
    JScrollPane jsp_dept = new JScrollPane(jtb_emp, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    // 버튼을 붙일 속지 선언
    JPanel jp_north = new JPanel();
    JButton jbtn_sel = new JButton("조회");
    JButton jbtn_ins = new JButton("입력");
    JButton jbtn_upd = new JButton("수정");
    JButton jbtn_del = new JButton("삭제");
    JButton jbtn_det = new JButton("상세보기");
    JPanel jp_detail = new JPanel();
    // 수정 메뉴나 수정 아이콘 선택시 작업을 정의합니다.
    public EmpVO updateActionPerformed() {
        int index[] = jtb_emp.getSelectedRows();
        EmpVO revo = new EmpVO();
        if(index.length == 0) {
            JOptionPane.showMessageDialog(this, "수정할 데이터를 선택하세요...", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } else if(index.length > 1) {
            JOptionPane.showMessageDialog(this, "데이터를 한건만 선택하세요...", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            try {
                Integer empno = Integer.parseInt
                        (dtm_emp.getValueAt(index[0], 0).toString());
                EmpVO pevo = new EmpVO();
                pevo.setEmpno(empno);
                List<EmpVO> list = emDao.empList(pevo);
                if(list !=null && list.size() > 0) {
                    revo = list.get(0);
                }
                empDialog.set("수정", true, revo, true);
                empDialog.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "수정중 에러가 발생했습니다111." + e,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return revo;
    }

    // 삭제 메뉴나 삭제 아이콘 선택시 작업을 정의합니다.
    private void deleteActionPerformed() {
        int index[]= jtb_emp.getSelectedRows();
        if (index.length == 0) {
            JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요..."
                    , "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            try {
                DeptVO vo = new DeptVO();
                // 테이블에서 선택된 row의 id에 대해 삭제 요청을 합니다.
                for(int i = 0; i < dtm_emp.getRowCount(); i++) {
                    if(jtb_emp.isRowSelected(i)) {
                        System.out.println("ddd : "+dtm_emp.getValueAt(i, 0).getClass().toString());
                        Integer empno = Integer.parseInt((String)dtm_emp.getValueAt(i, 0));
                        emDao.empDelete(empno);
                    }
                }
                refreshData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "삭제중 에러가 발생했습니다.\n" + e,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    // 생성자
    public EmpManager() {
        initDisplay();
    }

    // 화면그리기
    public void initDisplay() {
        jbtn_ins.addActionListener(this);
        jbtn_upd.addActionListener(this);
        jbtn_det.addActionListener(this);
        jbtn_sel.addActionListener(this);
        jbtn_del.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jbtn_sel.setBackground(new Color(158, 9, 9));
        jbtn_sel.setForeground(Color.WHITE);
        jbtn_ins.setBackground(new Color(19, 99, 57));
        jbtn_ins.setForeground(Color.WHITE);
        jbtn_upd.setBackground(new Color(54, 54, 54));
        jbtn_upd.setForeground(Color.WHITE);
        jbtn_del.setBackground(new Color(7, 84, 170));
        jbtn_del.setForeground(Color.WHITE);
        jp_north.add(jbtn_sel);
        jp_north.add(jbtn_ins);
        jp_north.add(jbtn_upd);
        jp_north.add(jbtn_del);
        jp_north.add(jbtn_det);
        this.add("North", jp_north);
        this.add("Center", jsp_dept);
        this.setTitle("부서관리시스템 Ver1.0");
        this.setSize(500, 400);
        this.setVisible(true);
    }

    public void refreshData() {
        System.out.println("refreshData 호출");
        List<EmpVO> list = new ArrayList<>();
        list = emDao.empList(null);
        // 입력,수정 전에 조회된 정보는 삭제함
        while (dtm_emp.getRowCount() > 0) {
            dtm_emp.removeRow(0);
        }
        if (list.size() <= 0) {
            JOptionPane.showMessageDialog(this, "조회결과가 없습니다.", "WARN", JOptionPane.WARNING_MESSAGE);
            return;// refreshData()탈출
        }
        // 벡터의 크기만큼 반복하면서 dtm_dept 데이터셋에 String[]추가함
        for (int i = 0; i < list.size(); i++) {
            EmpVO oneRow = list.get(i);
            Vector<Object> vone = new Vector<>();
            vone.add(oneRow.getEmpno());
            vone.add(oneRow.getEname());
            vone.add(oneRow.getJob());
            vone.add(oneRow.getHiredate());
            dtm_emp.addRow(vone);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        // 조회 할거야?
        if (obj == jbtn_sel) {
            refreshData();//전체 조회
        }
        // 너 입력 버튼 누른거야?
        else if (obj == jbtn_ins) {
            //4가지 파라미터 - set메서드는 EmpDialog 있다.
            //setTitle("입력")
            //두번째 파라미터는 JDialog를 보여줄지 아니면 숨길 지 결정
            //세번째 파라미터는 DB경유했을 때 만 값을 가짐
            //네번째 파라미터는 사용자가 입력할 수  있도록 true설정함.
            empDialog.set("입력", true, null, true);
        }
        // 너 수정 할려구?
        else if (obj == jbtn_upd) {
            EmpVO reVO = null;
            reVO = updateActionPerformed();
            empDialog.set("수정", true, reVO, true);

        }
        // 너 상세보기 원해?
        else if (obj == jbtn_det) {
            int index = jtb_emp.getSelectedRow();
            if (index == -1) {// -1은 end of file의미. 끝까지 다 찾았는데 없다
                JOptionPane.showMessageDialog(this, "상세보기 할 거를 선택해줘.");
                return;// actionPerformed탈출함
            }
            else{
                // 벡터안에서 사용자가 선택한 DeptVO를 찾아야 하니까..... 그러니까 선택하라구.
                EmpVO reVO = null;
                try {
                    Integer empno = Integer.parseInt
                            (dtm_emp.getValueAt(index, 0).toString());
                    EmpVO pevo = new EmpVO();
                    pevo.setDeptno(empno);
                    List<EmpVO> list = emDao.empList(pevo);
                    if(list !=null && list.size() > 0) {
                        reVO = list.get(0);
                    }
                    empDialog.set("상세보기", true, reVO, false);
                    empDialog.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "상세조회 중 에러가 발생했습니다." + ex,
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        // 너 삭제할거야?
        else if (obj == jbtn_del) {
            int index = jtb_emp.getSelectedRow();
            if (index == -1) {// -1은 end of file의미. 끝까지 다 찾았는데 없다
                JOptionPane.showMessageDialog(this, "삭제 할 거를 선택해줘.");
                return;// actionPerformed탈출함
            }
            else{
                try {
                    EmpVO dvo = new EmpVO();
                    for(int i = 0; i < dtm_emp.getRowCount(); i++) {
                        if(jtb_emp.isRowSelected(i)) {
                            System.out.println("ddd : "+dtm_emp.getValueAt(i, 0).getClass().toString());
                            Integer empno = Integer.parseInt(dtm_emp.getValueAt(i, 0).toString());
                            System.out.println("deptno : "+empno);
                            emDao.empDelete(empno);
                        }
                    }
                    refreshData();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "삭제실패.\n" + ex,
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }//end of 삭제
    }//end of actionPerformed

    public static void main(String[] args) {
        new EmpManager();//initDisplay()호출 가능함.
    }
}
