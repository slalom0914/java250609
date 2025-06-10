package com.day2;
//0부터 9사이의 임의의 숫자를 채번한다.
//채번된 숫자를 정답이다.
//5번(반복문) 기회동안 그 숫자를 맞추는 게임이다.
import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //사용자가 exit입력하면 while문을 빠져나가도록 코딩하시오
        while (true) {//counter가 5가 되면 빠져나간다.
            System.out.println("0부터 9사이의 숫자를 입력하세요.");
            String userInput = sc.nextLine();
            if ("exit".equals(userInput)) {
                sc.close();
                break;//while 문 빠져 나감.
            }
            System.out.println("사용자가 입력한 값은 "+userInput);
        }//end of while - 반복문
        System.out.println("여기");
    }//end of main
}//end of Scanner1
