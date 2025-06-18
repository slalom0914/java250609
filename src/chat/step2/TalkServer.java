package chat.step2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TalkServer extends JFrame implements Runnable {
    List<TalkServerThread> globalList = null;
    @Override
    public void run() {
        System.out.println("run 호출 성공");
        globalList = new ArrayList<>();
        System.out.println(globalList.size());//0출력됨 - 사용자가 입장하면 증가됨
        TalkServerThread tst = new TalkServerThread(this);
        tst.start();
    }//end of run
//선언부

    //생성자
    public TalkServer() {

    }
    //화면처리기
    public void initDisplay(){
        System.out.println("TalkServer initDisplay호출 성공");

    }//end of initDisplay
    public static void main(String[] args) {
        TalkServer ts = new TalkServer();
        ts.initDisplay();
        Thread th = new Thread(ts);
        th.start();
    }//end of main
}











