package com.day5;

public class Array2 {
    void print1(int is[]){
        //insert here
        for(int j=0;j<is.length;j++){
            System.out.println(is[j]);
        }
        for(int j=0;j<is.length;j++){
            is[j] = j*10;//0, 10, 20
        }
        System.out.println("==========[[after]]===========");
        for(int j=0;j<is.length;j++){
            System.out.println(is[j]);
        }
    }
    public static void main(String[] args) {
        int is2[] = {1,2,3};//1 2 3
        Array2 a = new Array2();
        a.print1(is2);
        System.out.println("===========[[main]]===========");
        for(int j=0;j<is2.length;j++){
            System.out.println(is2[j]);
        }
    }
}
