package com.day5;

import java.util.Arrays;

public class ArrayCopy1 {
    public static void main(String[] args) {
        int[] ar = {11,21,31};
        int[] ar2 = ar;
        for(int i=0;i<ar.length;i++){
            System.out.println(ar2[i]);
        }
        ar2[2] = 55;
        System.out.println(ar==ar2);//true
        System.out.println(ar2[2]+", "+ar[2]);

        int[] ar3 = Arrays.copyOf(ar2,ar2.length);
        System.out.println("==========================");
        for(int i=0;i<ar2.length;i++){
            System.out.println(ar3[i]);
        }
        System.out.println(ar2==ar3);//false
        ar3[2] = 77;
        System.out.println(ar2[2]+", "+ar3[2]);// 55, 77

    }
}
