package com.emp;

import com.vo.EmpVO;

public class JDBCDemoTest {
    public static void main(String[] args) {
        JDBCDemo jdbcDemo = new JDBCDemo();
        //입력 - 9000
        EmpVO ievo = new EmpVO();
        ievo.setEmpno(9000);
        ievo.setDeptno(40);
        int result = jdbcDemo.empInsert(ievo);
        System.out.println(result);
        //수정

        //삭제

        //조회
    }
}
