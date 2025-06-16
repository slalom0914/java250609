package com.day11;
//Object VS class
public class Parameter1 {
    void methodA(int[] haps){
        if(haps == null){
            return;
        }
        for(int hap: haps){
            System.out.println(hap);//0 0 0
        }
    }
    int[] methodB(){
        return null;
    }
    public static void main(String[] args) {
        Parameter1 p1 = new Parameter1();
        p1.methodA(new int[]{1,2,3});
        p1.methodA(new int[]{2,4,6});
        p1.methodA(null);
    }
}
