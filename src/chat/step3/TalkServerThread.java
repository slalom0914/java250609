package chat.step3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {
    TalkServer ts = null;
    Socket client = null;
    //주의 : Object 전달 할 수 없다.
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    String chatName = null;
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
            StringTokenizer st = new StringTokenizer(msg,"#");
            st.nextToken();//100
            chatName = st.nextToken();
            //나 이전에 입장해 있는 친구들 정보 받아내기
            for(TalkServerThread tst: ts.globalList){
                this.send(100+"#"+tst.chatName);
            }
            //현재 서버에 입장한 클라이언트 스레드 추가하기
            ts.globalList.add(this);
            this.broadCasting(msg);
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
    @Override
    public void run() {
        String msg = null;
        boolean isStop = false;
        try {
            run_start:
            while(!isStop){
                msg = (String)ois.readObject();
                ts.jta_log.append(msg + "\n");//서버 로그남김
                ts.jta_log.setCaretPosition(ts.jta_log.getDocument().getLength());
                //NullPointerException예방하려면 반드시 선언과 생성을 분리함.
                StringTokenizer st = null;
                int protocol = 0;
                if(msg !=null){
                    st = new StringTokenizer(msg,"#");
                    protocol = Integer.parseInt(st.nextToken());
                }
                switch(protocol){
                    //나가기 구현
                    case Protocol.EXIT:{
                        String chatName = st.nextToken();
                        //tst, this
                        ts.globalList.remove(this);
                        broadCasting(Protocol.EXIT+"#"+chatName);
                    }break run_start;
                    //대화명 변경하기
                    case Protocol.CHANGE:{
                        String chatName = st.nextToken();
                        String afterName = st.nextToken();
                        this.chatName = afterName;
                        broadCasting(Protocol.CHANGE+"#"+chatName
                                +"#"+afterName+"#"+chatName+"님의 대화명이 "
                                +afterName+"으로 변경");
                    }break;
                    //다자간 대화하기
                    case Protocol.MESSAGE:{//200#키위#점심 뭐 먹을까?
                        String chatName = st.nextToken();
                        String message = st.nextToken();
                        broadCasting(Protocol.MESSAGE
                                +"#"+chatName
                                +"#"+message);
                    }break;
                }//end of switch
            }

        }catch(Exception ex){

        }
    }
}
