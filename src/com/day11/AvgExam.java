package com.day11;

public class AvgExam {
    String[] subject = {"JAVA", "ORACLE", "REACT"};
    String[][] data = {
            {"이순신","80","90","75"}, //이름은 숫자로 바꿀 수 없다.
            {"강감찬","70","80","70"},
            {"김춘추","85","60","55"}
    };
    //총점을 담을 배열을 선언하시오.
    int[] haps = new int[data.length];
    //평균을 담을 배열을 선언하시오.
    double[] avgs = new double[data.length];
    //총점을 구하는 메서드 구현하기
    void totAccount(){
        int hap = 0;
        for(int j=0;j<data.length;j++){//사람이 바뀐다.
            hap = 0;//초기화 위치
            for(int i=1;i<data[j].length;i++){//과목이 바뀌는 for문
                hap = hap + Integer.parseInt(data[j][i]);
                //
            }//end of inner for - 과목 수
            //
            haps[j] = hap;
            System.out.println(hap);
        }//end of outter for - 수험자 수
    }
    //평균을 구하는 메서드 구현하기
    void avgAccount(){
        for(int j=0;j<data.length;j++){
            avgs[j] = haps[j]/(double)3;
        }
    }
    public static void main(String[] args) {
        AvgExam avgExam = new AvgExam();
        avgExam.totAccount();
        avgExam.avgAccount();
        for(int i=0;i<avgExam.haps.length;i++){
            System.out.println("총점은 "+avgExam.haps[i]+", 평균은 "+avgExam.avgs[i]);
        }
    }
}
