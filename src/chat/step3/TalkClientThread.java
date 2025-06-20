package chat.step3;

import java.util.StringTokenizer;
import java.util.Vector;

public class TalkClientThread extends Thread {
    TalkClient tc = null;
    public TalkClientThread(TalkClient tc) {
        this.tc = tc;//관전포인트
        System.out.println("TalkClientThread 호출 성공");
    }
    @Override
    public void run() {
        System.out.println("run메서드 호출 성공");
        boolean isStop = false;
        while (!isStop) {
            try{
                String msg = "";// 100#키위
                msg = (String)tc.ois.readObject();
                StringTokenizer st = null;
                int protocol = 0; //100|200|300|500
                if(msg !=null){
                    st = new StringTokenizer(msg, "#");
                    protocol = Integer.parseInt(st.nextToken());
                }
                switch(protocol){
                    case 100:{
                        String chatName = st.nextToken();
                        tc.jta_display.append(chatName+"님이 입장하였습니다.\n");
                        Vector<String> v = new Vector<>();
                        v.add(chatName);
                        tc.dtm.addRow(v);
                    }break;
                    case 200:{
                        String chatName = st.nextToken();
                        String message = st.nextToken();
                        tc.jta_display.append("["+chatName+"]"+message+"\n");
                        tc.jta_display.setCaretPosition(tc.jta_display.getDocument().getLength());
                    }break;
                    case 300:{
                        String chatName = st.nextToken();
                        String afterName = st.nextToken();
                        String message = st.nextToken();
                        //테이블에 대화명 변경하기
                        for(int i=0;i<tc.dtm.getRowCount();i++){
                            String imsi = tc.dtm.getValueAt(i, 0).toString();
                            if(chatName.equals(imsi)){
                                tc.dtm.setValueAt(afterName,i,0);
                                break;
                            }
                        }
                        //채팅창에 타이틀바에도 대화명을 변경처리한다.
                        if(chatName.equals(tc.chatName)){
                            tc.setTitle(afterName+"님의 대화창");
                            tc.chatName=afterName;
                        }
                        tc.jta_display.append(message+"\n");
                    }break;
                }//end of switch
            }catch(Exception e){

            }
        }//////////// end of while
    }//////////////// end of run
}
