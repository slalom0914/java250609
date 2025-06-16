package com.network;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//1초에 한번씩 타임서버로 부터 청취한 내용을 담아야 한다.
public class TimeClient extends Thread{
    Socket socket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    //화면에 JLabel필요해 - > static으로 하지말고 생성자로 받아와
    JLabel jlb_timer = null;
    public TimeClient(JLabel jlb_timer){
        this.jlb_timer = jlb_timer;
    }
    @Override
    public void run(){
        //서버로 부터 읽어온 시간 정보 담기
        String timeMsg = null;
        try {
            socket = new Socket("127.0.0.1", 3000);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            while(true){
                try {
                    //타임서버에서 1초에 한 번씩 현재 시간 정보를 보내야 한다.
                    while((timeMsg = (String)ois.readObject()) !=null){
                        System.out.println(timeMsg);
                        jlb_timer.setText(timeMsg);
                    }//end of while
                    sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }//end of while
        }catch (Exception e){
            System.out.println("타임서버에 접속할 수 없습니다.");
        }finally {
            //사용한 자원 반납하기 - 명시적으로 해줌.
            try {
                if(oos != null){
                    oos.close();
                }
                if(ois != null){
                    ois.close();
                }
                if(socket != null){
                    socket.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//      TimeClient timeClient = new TimeClient();
        //Thread timeClient = new TimeClient();
        //timeClient.start();//run()호출됨.
    }
}
