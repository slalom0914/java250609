package com.day1;
//원시형 타입이 8가지 -  int
//특히나 byte, short  자동으로 int로 형전환되어서 계산함
//c언어에서 넘어온 예약어 이다.
public class Parameter1 {
    int i;
    //static void methodA(int i) {//파라미터 자리도 지변이다.
    //파라미터 변수는 초기화 되지 않았다.
    //파라미터 자리가 아닌 j는 에러가 발생하지만 파라미터자리 i는
    //에러가 발생하지 않았다.
    //pass by value - 값에 의한 호출이다.(call by value) <-> ref by value
    void methodA(int i) {//파라미터 자리도 지변이다.
        int j;
        System.out.println("지변 i = "+i);//1, 지변 i라면 에러 발생
        System.out.println("this.i = "+this.i);//0, 지변 i라면 에러 발생
        //System.out.println(j);//0, 지변 i라면 에러 발생
    }
    public static void main(String[] args) {
        Parameter1 parameter1 = new Parameter1();
        parameter1.methodA(1);
    }
}
