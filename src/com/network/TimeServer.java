package com.network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

//서버를 기동하고 클라이언트가 접속해 오기를 기다린다. - 대기-순서-처리
public class TimeServer extends Thread{
    Socket client;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    public TimeServer(Socket client){
        this.client = client;
    }
    //스레드 구현 메소드에서 서버소켓에 접속해온 클라이언트소켓을
    //run메서드에서 사용함.
    @Override
    public void run(){
        try {
            oos = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());
            while(true){
                oos.writeObject(getTime());
                try{
                    sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){

        }
    }//end of run
    public String getTime(){
        //Calendar - new사용하지 않고도 객체를 생성할 수 있다.
        //싱글톤(Singleton) - 가끔 전체에서 단 하나의 객체만 만들도록
        //보장해야 하는 경우가 있다.
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        return (hour < 10 ? "0"+hour : ""+hour) +":" +
                (min < 10 ? "0"+min : ""+min) + ":" +
                (sec < 10 ? "0"+sec : ""+sec);
        //return "12:50:47";
    }
    public static void main(String[] args) {
        //서버소켓 생성시 파라미터로 포트번호 요구함
        int port = 3000;
        //동시에 여러 사람이 접속을 시도함. - 접속만 받음
        ServerSocket serverSocket = null;
        //실제로 통신하는 소켓, IO, 서버소켓에 접속해온 클라이언트 소켓
        Socket client = null;
        try{
            serverSocket = new ServerSocket(port);
        }catch(Exception e){
            System.out.println("포트 바인딩 에러....");
            try {
                serverSocket.close();
            } catch (Exception ex) {
                System.exit(0);
            }
        }
        System.out.println("TimeServer started successfully");
        while(true){
            try {
                client = serverSocket.accept();
                System.out.println(client.getInetAddress());
                System.out.println("New client conncted...");
                //스레드 개입이 필요함 - 1초 마다 현재 시분초 정보를 출력함
                TimeServer ts = new TimeServer(client);
                ts.start();//run()호출
            }catch(Exception e){

            }
        }


    }
}
