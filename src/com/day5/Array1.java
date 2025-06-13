package com.day5;

public class Array1 {
    void print1(int is[]){
        //insert here
        for(int j=0;j<is.length;j++){
            System.out.println(is[j]);
        }
    }
    public static void main(String[] args) {
        int is[] = new int[3]; // 0 0 0
        int is2[] = {1,2,3};//1 2 3
        Array1 a = new Array1();
        a.print1(is);
        System.out.println("===============================");
        a.print1(is2);
    }
}
