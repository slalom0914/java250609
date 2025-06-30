package com.emp;
import com.vo.EmpVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//입력과 수정 처리 - INSERT문과 UPDATE 처리 - 저장 클릭(if문)
//상세보기 처리
//하나의 화면으로 세 가지를 사용합니다.
public class EmpDialog extends JDialog implements ActionListener {
    // 선언부
    EmpManager empManager = null;
    JPanel jp_center = new JPanel();
    JScrollPane jsp_center = new JScrollPane(jp_center);
    JPanel jp_south = new JPanel();
    JLabel jlb_empno = new JLabel("사원번호");
    JTextField jtf_empno = new JTextField(10);
    JButton jbtn_check = new JButton("중복체크");
    JLabel jlb_ename = new JLabel("사원명");
    JTextField jtf_ename = new JTextField(20);
    JLabel jlb_job = new JLabel("JOB");
    JTextField jtf_job = new JTextField(20);
    JLabel jlb_hiredate = new JLabel("입사일자");
    JTextField jtf_hiredate = new JTextField(20);
    JLabel jlb_sal = new JLabel("급여");
    JTextField jtf_sal = new JTextField(20);
    JLabel jlb_comm = new JLabel("인센티브");
    JTextField jtf_comm = new JTextField(20);
    JLabel jlb_mgr = new JLabel("그룹코드");
    JTextField jtf_mgr = new JTextField(20);
    JLabel jlb_deptno = new JLabel("부서번호");
    JTextField jtf_deptno = new JTextField(20);

    // jp_south 속지
    JButton jbtn_save = new JButton("저장");
    JButton jbtn_close = new JButton("닫기");
    JButton jbtn_sample = new JButton("자동입력");
    // 왜 null을 주는지 설명할 수 있다
    EmpVO peVO = null;

    // 생성자
    public EmpDialog() {
    }

    public EmpDialog(EmpManager empManager) {
        //얕은 복사를 위해 생성자를 사용함 - 원본
        //입력에 대한 저장 버튼은 Dialog클래스에 있는데
        //처리는 EmpManagerDao에서 하고 - insert문 처리 - 오라클
        //리턴값이 1이면 입력 성공이고 0이면 실패이다.
        //리턴값이 1이면 부모목록테이블 새로고침해야 한다.
        //EmpDialog에서 EmpManager에 있는 메서드(refreshData)를 호출해야 한다.
        //그래야 새로고침이 일어난다.
        //actionPerformed메서드 안에서 empManager.refreshData호출해야 한다.
        this.empManager = empManager;
        initDisplay();
    }

    // 화면그리기
    public void initDisplay() {
        jbtn_save.addActionListener(this);
        jbtn_close.addActionListener(this);
        jbtn_sample.addActionListener(this);
        jbtn_check.addActionListener(this);
        jp_center.setLayout(null);
        jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jlb_empno.setBounds(20, 20, 100, 20);
        jtf_empno.setBounds(120, 20, 100, 20);
        jbtn_check.setBounds(220, 20, 120, 20);
        jlb_ename.setBounds(20, 45, 100, 20);
        jtf_ename.setBounds(120, 45, 150, 20);
        jlb_job.setBounds(20, 70, 100, 20);
        jtf_job.setBounds(120, 70, 150, 20);
        jlb_hiredate.setBounds(20,95, 100,20);
        jtf_hiredate.setBounds(120,95, 150,20);
        jlb_sal.setBounds(20,120, 100,20);
        jtf_sal.setBounds(120,120, 150,20);
        jlb_comm.setBounds(20,145, 100,20);
        jtf_comm.setBounds(120,145, 150,20);
        jlb_mgr.setBounds(20,170, 100,20);
        jtf_mgr.setBounds(120,170, 150,20);
        jlb_deptno.setBounds(20,195, 100,20);
        jtf_deptno.setBounds(120,195, 150,20);
        jp_center.add(jlb_empno);
        jp_center.add(jtf_empno);
        jp_center.add(jbtn_check);
        jp_center.add(jlb_ename);
        jp_center.add(jtf_ename);
        jp_center.add(jlb_job);
        jp_center.add(jtf_job);
        jp_center.add(jlb_hiredate);
        jp_center.add(jtf_hiredate);
        jp_center.add(jlb_sal);
        jp_center.add(jtf_sal);
        jp_center.add(jlb_comm);
        jp_center.add(jtf_comm);
        jp_center.add(jlb_mgr);
        jp_center.add(jtf_mgr);
        jp_center.add(jlb_deptno);
        jp_center.add(jtf_deptno);
        jp_south.add(jbtn_save);
        jp_south.add(jbtn_close);
        jp_south.add(jbtn_sample);
        this.add("Center", jsp_center);
        this.add("South", jp_south);
        this.setSize(400, 360);
        this.setVisible(false);
    }

    // 각 컬럼(부서집합-부서번호,부서명,지역)의 값들을설정하거나
    // 읽어오는 getter/setter메소드 임- 화면관련
    public String getEmpno() {
        return jtf_empno.getText();
    }
    public void setEmpno(String empno) {
        jtf_empno.setText(empno);
    }
    public String getEname() {
        return jtf_ename.getText();
    }
    public void setEname(String ename) {
        jtf_ename.setText(ename);
    }
    public String getJob() {
        return jtf_job.getText();
    }
    public void setJob(String job) {
        jtf_job.setText(job);
    }
    public String getHiredate() {
        return jtf_hiredate.getText();
    }
    public void setHiredate(String hiredate) {
        jtf_hiredate.setText(hiredate);
    }
    public String getSal() {
        return jtf_sal.getText();
    }
    public void setSal(String sal) {
        jtf_sal.setText(sal);
    }
    public String getComm() {
        return jtf_comm.getText();
    }
    public void setComm(String comm) {
        jtf_comm.setText(comm);
    }
    public String getMgr() {
        return jtf_mgr.getText();
    }
    public void setMgr(String mgr) {
        jtf_mgr.setText(mgr);
    }
    public String getDeptno() {
        return jtf_deptno.getText();
    }
    public void setDeptno(String deptno) {
        jtf_deptno.setText(deptno);
    }

    // 아래 메소드는 DeptTable7에서 호출됨
    // actionPerformed에서 이벤트(입력,수정,상세보기)가 발생되면 호출됨
    // 메소드의 파라미터 자리는 Call by Value에 의해서 결정됨
    public void set(String title, boolean isView, EmpVO peVO, boolean isEdit) {
        this.setTitle(title);
        this.setVisible(isView);
        this.peVO = peVO;
        setValue(peVO);
        setEditable(isEdit);
    }

    // 입력 혹은 수정일 때는 true로 처리하고
    // 상세보기일 때는 false를 주어서 얼림
    private void setEditable(boolean isEdit) {
        jtf_empno.setEditable(isEdit);
        jtf_ename.setEditable(isEdit);
        jtf_job.setEditable(isEdit);
        jtf_hiredate.setEditable(isEdit);
        jtf_sal.setEditable(isEdit);
        jtf_comm.setEditable(isEdit);
        jtf_mgr.setEditable(isEdit);
        jtf_deptno.setEditable(isEdit);
    }

    public void setValue(EmpVO peVO) {// 이런 공통코드를 나는 작성할 수 있다.
        // 입력을 위한 윈도우 설정 - 모든 값을 빈문자열로 셋팅함
        if (peVO == null) {
            setEmpno("");
            setEname("");
            setJob("");
            setHiredate("");
            setSal("");
            setComm("");
            setMgr("");
            setDeptno("");
        }
        // 상세조회, 수정시는 배열로 받은 값으로 셋팅함
        // 부모창에서 set메소드 호출시 파라미터로 넘겨준 값으로 초기화할것.
        else {
            setEmpno(String.valueOf(peVO.getEmpno()));
            setEname(peVO.getEname());
            setJob(peVO.getJob());
            setHiredate(peVO.getHiredate());
            setSal(String.valueOf(peVO.getSal()));
            setComm(String.valueOf(peVO.getComm()));
            setMgr(String.valueOf(peVO.getMgr()));
            setDeptno(String.valueOf(peVO.getDeptno()));
        }
    }// end of setValue

    // 메인
    public static void main(String[] args) {
        new EmpDialog(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == jbtn_close){
            this.dispose();
        }
        else if (obj == jbtn_save) {
            //select경유 - > EmpVO담기
            if(peVO !=null){//수정하기
                try{
                    //pevo는 EmpManager클래스에서 오라클 서버에 조회한 결과를 담은
                    //클래스이고 아래 evo는 사용자가 입력한 정보를 오라클서버에 보낼
                    //정보를 담음-> 화면에서 입력한 값 담김
                    EmpVO evo = new EmpVO();
                    //수정은 기존에 있는 정보를 변경하는 것임.
                    //update문 처리할 때 조건절에 사원번호를 비교해야 함. -pk
                    evo.setEmpno(peVO.getEmpno());//pk
                    evo.setEname(getEname());//사용자가 입력한 값
                    evo.setJob(getJob());//사용자가 입력한 값
                    evo.setHiredate(getHiredate());//사용자 입력한 값
                    evo.setSal(Double.parseDouble(getSal()));//사용자 입력한 값
                    evo.setComm(Double.parseDouble(getComm()));//사용자 입력한 값
                    int result = empManager.emDao.empUpdate(evo);
                    if(result == 1){
                        System.out.println("수정 성공");
                    }
                    empManager.refreshData();
                }catch(Exception e1){
                    e1.printStackTrace();
                }
                /*
                 * 아이디가 0보다 큰값이 아니면 입력모드 이다.
                 */
            }else{
                try {
                    EmpVO ndvo= new EmpVO();
                    ndvo.setEmpno(Integer.parseInt(jtf_empno.getText()));
                    ndvo.setEname(jtf_ename.getText());
                    ndvo.setJob(jtf_job.getText());
                    empManager.emDao.empInsert(ndvo);
                    empManager.refreshData();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(this, "입력중 에러가 발생했습니다." + e,
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            setVisible(false);
        } // end of save
        else if (obj == jbtn_sample) {
            setEmpno("8000");
            setEname("강감찬");
            setJob("SALESMAN");
        }
    }
}
