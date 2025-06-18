package chat.step2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
        TalkClientThread tct = new TalkClientThread(this);
        tct.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("콜백메서드");//timeline연관
    }//end of actionPerformed
    public void initDisplay(){
        System.out.println("TalkClient화면 그리기");
    }
    public static void main(String[] args) {
        TalkClient tc = new TalkClient();
        tc.initDisplay();
        tc.init();
    }
}//end of TalkClient
