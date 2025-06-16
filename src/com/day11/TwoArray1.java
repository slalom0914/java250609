package com.day11;

public class TwoArray1 {
    public static void main(String[] args) {
        //첫번째 인덱스는 로우 인덱스
        //두번째 인덱스는 컬럼 인덱스
        double[][] ds = new double[2][3];
        for(int i = 0; i < ds.length; i++) {
            for(int j = 0; j < ds[i].length; j++) {
                System.out.println(ds[i][j]);
            }//end of inner for
        }//end of outter for
    }
}
