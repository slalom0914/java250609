package com.day5;

public class TwoArray1 {
    public static void main(String[] args) {
        //1차 배열이 인덱스 하나로 구분함.
        //2차 배열은 인덱스가 두 개 필요함.
        //전체 메모리 공간은 3*4=12개가 한번에 선언되었다.
        int is[][] = new int[3][4];
        //공간은 어렵다. - 잘 안씀
        int is2[][][] = new int[2][3][4];//공간 - 2개의 공간
        System.out.println(is[0].length);//4 컬럼의 수
        System.out.println(is[1].length);//4 컬럼의 수
        System.out.println(is[2].length);//4 컬럼의 수
        System.out.println(is.length);//3 로우의 수
        is[0] = new int[]{1,2,3,4};
        is[1] = new int[]{10,20,30,40};
        is[2] = new int[]{100,200,300,400};
        for(int x=0;x<is.length;x++){
            for(int y=0;y<is[x].length;y++){
                System.out.println(is[x][y]);//12번 호출이 된다.
            }//end of inner for 컬럼의 수
        }//end of outter for 로우 수
    }
}
