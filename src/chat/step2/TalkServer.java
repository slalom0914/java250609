package chat.step2;

import javax.swing.*;
import java.awt.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TalkServer extends JFrame implements Runnable {
    List<TalkServerThread> globalList = null;
    ServerSocket server 		= null;
    Socket socket 		= null;
    JTextArea 				jta_log = new JTextArea(10,30);
    JScrollPane 			jsp_log = new JScrollPane(jta_log
            ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JPanel 		jp_north = new JPanel();
    JButton 	jbtn_log = new JButton("로그저장");
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
        jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
        jta_log.setBackground(Color.orange);
        jp_north.add(jbtn_log);
        this.add("North",jp_north);
        this.add("Center",jsp_log);
        this.setSize(500, 400);
        this.setVisible(true);
    }//end of initDisplay
    public static void main(String[] args) {
        TalkServer ts = new TalkServer();
        ts.initDisplay();
        Thread th = new Thread(ts);
        th.start();
    }//end of main
}











