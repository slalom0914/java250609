package com.day11;
class DeptVO{
    private int deptno;
    private String dname;
    private String loc;
    DeptVO(int deptno, String dname, String loc){
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
    public int getDeptno() {
        return deptno;
    }
    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }
    public String getLoc() {
        return loc;
    }
    public void setLoc(String loc) {
        this.loc = loc;
    }
}
//객체 안에 객체가 들어있는 유형 연습
public class ForExam2 {
    public static void main(String[] args) {
        DeptVO[] dvos = new DeptVO[3];
        dvos[0] = new DeptVO(10,"인사부","서울");
        dvos[1] = new DeptVO(20,"총무부","인천");
        dvos[2] = new DeptVO(30,"개발부","부산");

        for(DeptVO dvo:dvos){
            System.out.println(dvo.getDeptno()+", "+dvo.getDname()+", "+dvo.getLoc());
        }
        System.out.println("==========================================================");
        for(int i=0;i<dvos.length;i++){
            System.out.println(dvos[i].getDeptno()+", "+dvos[i].getDname()+", "+dvos[i].getLoc());
        }
    }
}
