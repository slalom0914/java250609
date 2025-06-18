package chat.step1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TalkServer extends JFrame implements Runnable {
    //인스턴스화를 분리해서 두 줄로 작성하면 선언 위치가 달라서
    //NullPointerException빠지기 쉽다.
    //대화명 목록을 담기
    List<TalkServerThread> globalList = null;
    @Override
    public void run() {
        System.out.println("run 호출 성공");
        globalList = new ArrayList<>();
        System.out.println(globalList.size());//0출력됨 - 사용자가 입장하면 증가됨
        //여기 까지 에러 없이 진행이 되었다면 스레드 연결한다.
        //TalkServerThread에는 main메서드가 없어요.
        TalkServerThread tst = new TalkServerThread(this);
        tst.start();
    }//end of run
//선언부

    //생성자
    public TalkServer() {
        //왜? 생성자에서 호출할 때는 인스턴스화를 안해도 되는가?
        //initDisplay();
    }
    //화면처리기
    public void initDisplay(){
        System.out.println("TalkServer initDisplay호출 성공");

    }//end of initDisplay
    public static void main(String[] args) {
        TalkServer ts = new TalkServer();
        ts.initDisplay();
        //상속이 아니라 Runnable implements하면 스레드 생성한 다음
        //파라미터에 구현체 클래스 인스턴스 변수를 넘겨야 한다.
        Thread th = new Thread(ts);
        th.start();//th.start()호출 해야 run()호출 된다.
    }//end of main
}
/*
화면 그리는 메서드 호출은 1)반드시 main에서 한다. 2)상관없다.
3) 생성자 에서 호출하는 것이 더 좋겠다.

순서
1. 서버소켓을 생성하여 사용자가 입장하기를 기다린다.(TalkServer)

2. TalkClient에서 대화명을 입력받으면 서버소켓에 접속을 시도한다.

3. 서버소켓을 접속해온 클라이언트 소켓을 정보를 받아서 실제
일하는 client에게 정보를 넘긴다.

4. 이 때 접속이 성공하면 TalkServerThread를 호출한다.
단 여기서는 최초 입장한 정보는 TalkServerThread에서
입장에 대한 처리를 한다.

 */










