package com.day11;

public class ForExam1 {
    public static void main(String[] args) {
        int[] is = {1,2,3,4,5};
        //for(배열안에 타입:배열 주소번지)개선된 for문
        for( int xx : is ){
            System.out.println(xx);
        }
        String[] names = {"강감찬","이순신","김유신"};
        for(String name:names){
            System.out.println(name);
        }
    }
}
