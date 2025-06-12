package com.day4;
class A8{
    //String sungjuk[][] = new String[3][4];
    String sungjuk[][] = {
            {"강감찬","80","90","70"},
            {"홍길동","70","60","80"},
            {"김유신","50","60","70"},
    };
}
public class A8Main {
    public static void main(String[] args) {
        A8 a8 = new A8();
        System.out.println(a8.sungjuk[0][0]);
        System.out.println(a8.sungjuk[0][1]);
        System.out.println(a8.sungjuk[0][2]);
        System.out.println(a8.sungjuk[0][3]);
        System.out.println(a8.sungjuk[1][0]);
        System.out.println(a8.sungjuk[1][1]);
        System.out.println(a8.sungjuk[1][2]);
        System.out.println(a8.sungjuk[1][3]);
        System.out.println(a8.sungjuk[2][0]);
        System.out.println(a8.sungjuk[2][1]);
        System.out.println(a8.sungjuk[2][2]);
        System.out.println(a8.sungjuk[2][3]);
        for(int i=0;i<a8.sungjuk.length;i++){//3바퀴
            for(int j=0;j<a8.sungjuk[i].length;j++){//4바퀴
                System.out.print(" "+a8.sungjuk[i][j]);
            }//end of inner for
            System.out.println();//줄바꿈
        }//end of outter for
    }
}
