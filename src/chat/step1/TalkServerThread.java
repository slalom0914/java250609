package chat.step1;

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
        System.out.println(ts);
        this.ts = ts;
        System.out.println("TalkServerThread 생성자 호출성공");

    }
    //현재 입장해 있는 친구들 모두에게 메시지를 전송하기
    public void broadCasting(String msg){
        System.out.println("단톡방에 모든 이에게 전달");
        for(TalkServerThread tst:ts.globalList){
            //왜 여기서 말하지 않고 send메서드를 분리했는가?
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
