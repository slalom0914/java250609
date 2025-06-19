package com.vo;

public class DeptVO{
    //전변만 앞에 this사용가능함.
    private int deptno;//number
    private String dname;//varchar, varchar2
    private String loc;
    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;//지변으로 받은 값을 전변 초기화
    }
    public int getDeptno() {
        return deptno;
    }
    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
    public String getLoc() {
        return loc;
    }
    public void setLoc(String loc) {
        this.loc = loc;
    }
}
