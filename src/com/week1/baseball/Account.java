package com.week1.baseball;

public class Account {
    int[] com = {3,5,7};
    int[] my = {1,3,7};//1스 1볼
    public String 판정하기(String input){
        int strike = 0;
        int ball = 0;
        for(int i=0;i<input.length();i++){
            for(int j=0;j<input.length();j++){
                //일단 볼은 확보됨 - 숫자가 존재함.
                if(com[i] == my[j]){
                    if(i == j){//같은 숫자가 자리까지 일치하면 스트라이크
                        strike++;
                    }else{//볼 확정
                        ball++;
                    }
                }
            }
        }
        return strike+"스 "+ball+"볼";
    }
    public static void main(String[] args) {

    }
}
/*
사용자가 숫자를 입력하고 엔터하면 1스 1볼 이라고 출력해준다.
strike, ball 전변으로 한다.
아니다. 지변으로 해야 한다.
사용자가 숫자를 새로 입력할 때 마다 카운트 숫자는 달라져야 한다.
그러면 지역변수로 한다.
 */