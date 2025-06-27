package com.emp;

import com.vo.EmpVO;

import java.util.List;

public class JDBCDemoTest {
    public static void main(String[] args) {
        JDBCDemo jdbcDemo = new JDBCDemo();
        //입력 - 9000
        EmpVO ievo = new EmpVO();
        ievo.setEmpno(9000);
        ievo.setDeptno(40);
        int result = jdbcDemo.empInsert(ievo);
        System.out.println(result);//성공 1 실패 0
        //수정
        result = 0;
        EmpVO uevo = new EmpVO();
        uevo.setEmpno(9000);
        uevo.setEname("홍길동");
        uevo.setDeptno(40);
        result = jdbcDemo.empUpdate(uevo);
        System.out.println(result);//성공 1 실패 0
        //삭제
        result = 0;
        result = jdbcDemo.empDelete(9000);
        System.out.println("삭제 : "+result);//성공 1 실패 0
        //조회
        List<EmpVO> list = jdbcDemo.empList(new  EmpVO());
        System.out.println(list.size());//14
    }
}
