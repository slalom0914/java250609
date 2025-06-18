package com.week1;
class V{

}
public class Variable4 {
    public static void main(String[] args) {
        V v = new V();
        System.out.println(v);//주소번지
        V[] vs = new V[3];
        vs[0] = new V();//복사본
        System.out.println(vs[0]);//null
        vs[0] = v;//원본
        System.out.println(vs[0]);//null
        System.out.println(vs[1]);//null
        System.out.println(vs[2]);//null
    }
}
