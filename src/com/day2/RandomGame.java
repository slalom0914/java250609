package com.day2;

import java.util.Random;
import java.util.Scanner;

public class RandomGame {
    public static void main(String[] args) {
        //채번하기
        //제공하는 클래스임
        Random rand = new Random();
        int dap =  rand.nextInt(10);
        int my = -1;//내가 입력한 숫자를 담는 변수
        System.out.println("채번된 숫자는 "+dap+ " 입니다.");
        Scanner sc = new Scanner(System.in);
        boolean isOk = false;
        //내가 생각하는 것을 표현할 수 있도록 훈련해보자
        while (!isOk) {
            System.out.println("0부터 9사이의 숫자를 입력하세요.");
            my = sc.nextInt();
            //정답인 경우
            if(dap == my){
                System.out.println("축하합니다. 정답입니다.");
                sc.close();
                break;
            }else if(dap> my){
                System.out.println("높여라");
            }else if(dap < my){
                System.out.println("낮춰라");
            }
        }//end of while
    }//end of main
}//end of RandomGame
