package chat.step1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
// Socket생성하면 ServerSocket접속 시도...-> waiting -> pending
// 그러면 화면을 그리는 메서드를 소켓통신을 하기 전에 먼저 호출해야 하나?
public class TalkClient extends JFrame implements ActionListener {
    Socket socket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    String chatName = null;
    public TalkClient() {
        System.out.println("TalkClient 생성자 호출 성공");
        //initDisplay();
    }
    //소켓 관련 초기화
    public void init(){
        System.out.println("init() 호출 성공");
        //지연이 발생하는 부분 - 대기
        //통신 채널연결되어야 OOS, OIS 객체 생성이 가능해짐
        //NullPointerException
        //내가 입장했다는 사실도 현재 단톡방에 있는 모든 이에게
        //전달하고자 한다.
        //그래서 내가 말하자마자 들을 준비를 바로 한다.
        TalkClientThread tct = new TalkClientThread(this);
        tct.start();
    }
    //말하기 - oos.writeObject()
    //NullPointerException발동할 가능성이 있는 구간
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("콜백메서드");//timeline연관
    }//end of actionPerformed
    public void initDisplay(){
        //init()메서드 먼저 호출하고 initDisplay()호출해야 하나요?
        //아니면 initDisplay()호출하고 init()메서드 호출해야 하나요?
        //아님 둘 다 상관없나요
        System.out.println("TalkClient화면 그리기");
    }
    public static void main(String[] args) {
        TalkClient tc = new TalkClient();
        tc.initDisplay();
        tc.init();//이 메서드에서 TalkClientThread인스턴스화 한다.
        //이 때 현재 생성된 TalkClient원본을 파라미터로 넘김.
        //NullPointerException방어한다.
    }
}//end of TalkClient
/*
내가 한 말도 서버를 경유해서 들어야 한다.
왜냐하면 서버를 경유해야 단톡방에 모든 이들에게 방송이 나간다.
 */