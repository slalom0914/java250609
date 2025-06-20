package chat.step3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class TalkClient extends JFrame implements ActionListener {
    Socket socket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    //대화명은 한 사람에 대해서 계속 유지된다. - 전변으로 했다.
    String chatName = null;
    JPanel jp_second	  = new JPanel();
    JPanel jp_second_south = new JPanel();
    JButton jbtn_one	  = new JButton("1:1");
    JButton jbtn_change	  = new JButton("대화명변경");
    JButton jbtn_font	  = new JButton("글자색");
    JButton jbtn_exit	  = new JButton("나가기");
    String cols[] 		  = {"대화명"};
    String data[][] 	  = new String[0][1];
    DefaultTableModel dtm = new DefaultTableModel(data,cols);
    JTable			  jtb = new JTable(dtm);
    JScrollPane       jsp = new JScrollPane(jtb);
    JPanel jp_first 		= new JPanel();
    JPanel jp_first_south 	= new JPanel();
    JTextField jtf_msg = new JTextField(20);//south속지 center
    JButton jbtn_send  = new JButton("전송");//south속지 east
    JTextArea jta_display = null;
    JScrollPane jsp_display = null;
    public TalkClient() {
        System.out.println("TalkClient 생성자 호출 성공");
        //input type=text
        jtf_msg.addActionListener(this);
        jbtn_change.addActionListener(this);//대화명 변경
        jbtn_exit.addActionListener(this);//나가기
        //initDisplay();
    }
    //소켓 관련 초기화
    public void init(){
        System.out.println("init() 호출 성공");
        try{
            socket = new Socket("192.168.0.41", 3000);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            oos.writeObject(100+"#"+chatName);
            TalkClientThread tct = new TalkClientThread(this);
            tct.start();
        }catch(Exception e){

        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("콜백메서드");//timeline연관
        Object source = e.getSource();
        String msg = jtf_msg.getText();
        if(jbtn_exit == source){
            try {
                oos.writeObject(Protocol.EXIT+"#"+this.chatName);
                System.exit(0);//자바가상머신 연결 끊김
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(jbtn_change == source){//대화명 변경 버튼을 누른거야
            String afterName = JOptionPane.showInputDialog("변경할 대화명을 입력하세요.");
            //만일 변경할 대화명을 입력하지 않았다면
            if(afterName == null || afterName.trim().length() == 0)
            {
                JOptionPane.showMessageDialog(this,
                        "변경할 대화명을 입력하세요.","INFO",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            try {
                oos.writeObject(Protocol.CHANGE+"#"+chatName+"#"+afterName);
            }catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        else if(jtf_msg == source){//Enter이벤트
            try{
                oos.writeObject(Protocol.MESSAGE
                        +"#"+chatName
                        +"#"+msg);
                jtf_msg.setText("");//이런걸 챙김
            }catch(Exception ex){

            }
        }
    }//end of actionPerformed
    public void initDisplay(){
        System.out.println("TalkClient화면 그리기");
        //사용자의 닉네임 받기
        chatName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
        this.setLayout(new GridLayout(1,2));
        jp_second.setLayout(new BorderLayout());
        jp_second.add("Center",jsp);
        jp_second_south.setLayout(new GridLayout(2,2));
        jp_second_south.add(jbtn_one);
        jp_second_south.add(jbtn_change);
        jp_second_south.add(jbtn_font);
        jp_second_south.add(jbtn_exit);
        jp_second.add("South",jp_second_south);
        jp_first.setLayout(new BorderLayout());
        jp_first_south.setLayout(new BorderLayout());
        jp_first_south.add("Center",jtf_msg);
        jp_first_south.add("East",jbtn_send);
        jta_display = new JTextArea();
        jta_display.setLineWrap(true);
        jta_display.setOpaque(false);
        Font font = new Font("돋움",Font.BOLD,25);
        jta_display.setFont(font);
        jsp_display = new JScrollPane(jta_display);
        jp_first.add("Center",jsp_display);
        jp_first.add("South",jp_first_south);
        this.add(jp_first);
        this.add(jp_second);
        this.setTitle(chatName);
        this.setSize(800, 550);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        TalkClient tc = new TalkClient();
        tc.initDisplay();
        tc.init();
    }
}//end of TalkClient
