package com.network;

import java.util.Calendar;

//서버를 기동하고 클라이언트가 접속해 오기를 기다린다. - 대기-순서-처리
public class TimeServer extends Thread{
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


    }
}
