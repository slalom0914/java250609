package chat.step3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TalkServerThread extends Thread {
    TalkServer ts = null;
    Socket client = null;
    //주의 : Object 전달 할 수 없다.
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    //대화명은 전변으로 하나요?|지변으로 할까요?
    public TalkServerThread(TalkServer ts) {
        this.ts = ts;
        this.client = ts.socket;
        try {
            oos = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());
            //-> 100#닉네임
            String msg = (String)ois.readObject();
            ts.jta_log.append(msg + "\n");
        }catch(Exception e){

        }

    }//end of TalkServerThread
    //현재 입장해 있는 친구들 모두에게 메시지를 전송하기
    public void broadCasting(String msg){
        System.out.println("단톡방에 모든 이에게 전달");
        for(TalkServerThread tst:ts.globalList){
            tst.send(msg);
        }
    }//end of broadCasting

    private void send(String msg) {
        System.out.println("send() 호출 성공");
        try {
            oos.writeObject(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }//end of send
}
