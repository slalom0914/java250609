package com.day1;
//전역변수 보다는 지역변수를 많이 사용하세요.
//전역변수를 사용하면 사이드 이펙트가 발생된다.- 부수효과
//동시에 입장하는 사람이 2000명이다.
class Param{
    int ival;
}


public class Variable5 {
    //int x;
    public void effectParam(Param p){
        p = new Param();
        //오직 전변만이 인스턴스변수.변수명으로 호출이 가능하다.
        p.ival = 500;
        int x = 1;
        //System.out.println(this.x);
        System.out.println("sub ival : " + p.ival);
    }
    public static void main(String[] args) {
        Variable5 v = new Variable5();
        Param p = new Param();//0-> 100 -> 500
        p.ival = 100;
        v.effectParam(p);
        System.out.println("main ival : " + p.ival);
    }
}
