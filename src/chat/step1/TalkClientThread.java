package chat.step1;

//경합이 벌어진다. - 스레드
//순서가 있다. - 스레드
//timeline도 포함
public class TalkClientThread extends Thread {
    TalkClient tc = null;
    public TalkClientThread(TalkClient tc) {
        this.tc = tc;//관전포인트
        System.out.println("TalkClientThread 호출 성공");
    }
    @Override
    public void run() {
        System.out.println("run메서드 호출 성공");
    }
}
