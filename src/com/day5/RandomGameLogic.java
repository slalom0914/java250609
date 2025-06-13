package com.day5;
// 클래스 사이의 관계를 static으로 처리하지 않고
// 생성자로 처리하는 방법
import java.util.Random;

public class RandomGameLogic {
    int dap;
    RandomGameUI rgui = null;
    public RandomGameLogic(RandomGameUI rgui) {
        //전변에 대한 초기화 처리
        //NullPointerException피할 수 있다. 왜냐면 선언부에는 null되어 있음.
        this.rgui = rgui;
    }

    public void nanSu(){
        System.out.println("채번 메서드 호출");
        //정답채번하기- 초기화
        Random rand = new Random();
        dap =  rand.nextInt(10);
    }
    //front와 back 만나는 부분
    //dap은 전변으로 하고 my는 지변으로 해결하였다.
    //게임의 룰이 있다.- 업무 처리영역
    //call by value, pass by value
    //my는 어디서 결정 되나요? - JTextField에 엔터쳤을 때
    //이제 나는 어디로 가지? - RandomGameEvent
    //엔터를 쳤을 때 나는 판정하기 메소드를 호출한다.
    public String 판정하기(int my){
        String msg = null;
        //정답인 경우
        if(dap == my){
            msg = "축하합니다. 정답입니다.";//초기화
            //System.exit(0);//JVM연결고리 강제로 끊어낸다.
        }else if(dap> my){
            msg = "높여라";
        }else if(dap < my){
            msg = "낮춰라";
        }
        return msg;
    }
}
