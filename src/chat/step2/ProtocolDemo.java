package chat.step2;

import java.util.StringTokenizer;

public class ProtocolDemo {
    public static void main(String[] args) {
        String msg = "100#키위";
        String msg1 = "200#키위가#사과에게#오늘스터디할거야";
        StringTokenizer st = new StringTokenizer(msg, "#");
        String protocol = st.nextToken();
        String chatName = st.nextToken();
        System.out.println(protocol +", "+ chatName);
        StringTokenizer st1 = new StringTokenizer(msg1, "#");
        protocol = st1.nextToken();
        chatName = st1.nextToken();
        String youName = st1.nextToken();
        String message = st1.nextToken();
        System.out.println(protocol +", "+ chatName+", "+ youName+", "+ message);
    }
}
