package chat;

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
        initDisplay();
    }
    //소켓 관련 초기화
    public void init(){
        System.out.println("init() 호출 성공");
        //지연이 발생하는 부분 - 대기
        //통신 채널연결되어야 OOS, OIS 객체 생성이 가능해짐
        //NullPointerException
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
    }
}//end of TalkClient
