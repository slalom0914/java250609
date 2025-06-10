package com.day2;
class Emp{
    int empno;//사원번호
    String ename;//사원명
    double salary;//급여
}
public class EmpSimulation {
    //객체배열
    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.empno = 7566;
        emp.ename = "SCOTT";
        emp.salary = 2500;

        System.out.println(emp.empno);//7566
        System.out.println(emp.ename);//SCOTT
        System.out.println(emp.salary);//2500

        emp = new Emp();
        emp.empno = 7499;
        emp.ename = "TIGER";
        emp.salary = 3100;

        System.out.println(emp.empno);//7499
        System.out.println(emp.ename);//TIGER
        System.out.println(emp.salary);//3100.0

        emp = new Emp();
        emp.empno = 7977;
        emp.ename = "JOHN";
        emp.salary = 2300;
        System.out.println(emp.empno);//0
        System.out.println(emp.ename);//null
        System.out.println(emp.salary);//0.0
    }
}
/*
7566 SCOTT 2500
7499 TIGER 3100
7977 JOHN 2300
 */