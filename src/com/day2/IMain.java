package com.day2;
class I{
//홍길동의 중간고사 성적이 나왔다.
//HTML:90, Javascript:85, Java:80
// 정수+정수+정수=정수
// 정수+실수=실수
//홍길동의 평균을 구하는 프로그램을 작성하시오. - 실수
//총점을 구하는 메소드와 평균을 구하는 메소드 2개로 구현하시오. - total
// public int total(int j1, int j2, int j3)
//총점을 구하는 메소드의 파라미터 타입은?
//총점을 구하는 메소드의 리턴 타입은? //리턴타입이 반드시 필요한가?
//전변대신 지변중심으로 구현해 보시오.
//평균을 구하는데 총점이 필요하다|아니다.
//총점 구하는 메소드에는 반드시 리턴타입을 쓴다.- int, long, float, double
//평균을 구하는 메소드의 파라미터 타입은?    avg
// public double avg(총점:int)
//평균을 구하는 메소드의 리턴 타입은?

    /*************************************************************
     * 파라미터로 세 과목의 성적을 받아서 총점을 구한다.
     * @param jumsu1 - 첫번째 과목
     * @param jumsu2 - 두번째 과목
     * @param jumsu3 - 세번째 과목
     * @return jumsu1+jumsu2+jumsu3
     ************************************************************/
    public int total(int jumsu1, int jumsu2, int jumsu3){
        return jumsu1+jumsu2+jumsu3;
    }//end of total
    /*************************************************************
     * 파라미터로 총점을 받아서 3으로 나눈 평균을 구한다.
     * @param hap - total 메소드에서 구한 총점을 받는다.
     * @return hap/3.0 -> 정수/정수=정수, 정수/실수=실수 실수/정수=실수
     ************************************************************/
    public double avg(int hap){
        return hap/3.0;
    }//end of average

}

public class IMain {
    public static void main(String[] args) {
        I i = new I();
        //리턴타입을 활용하면 클래스 밖에서 또는 메소드 밖에서도
        //처리 결과를 사용할 수 있다.
        int hap = i.total(90,85,82);
        System.out.println("총점은 "+hap + " 입니다.");
        double avg = i.avg(hap);
        System.out.println("평균은 "+avg + " 입니다.");
    }
}
