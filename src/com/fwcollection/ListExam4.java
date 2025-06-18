package com.fwcollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListExam4 {
    //타입 자리에 인터페이스가 왔다.
    void methodA(List<String> list){

    }
    //타입 자리에 구현체 클래스가 왔다.
    void methodA(ArrayList<String> list){

    }
    //타입 자리에 구현체 클래스가 왔다.
    void methodA(Vector<String> list){

    }
    //아래 중복 선언이므로 컴파일 에러 입니다.
    //제네릭타입이 다른것은 메소드 오버로딩에 영향이 없다.
//    void methodA(List<Object> list){
//    }
    public static void main(String[] args) {
        List<String>        list1 = new ArrayList<>();
        ArrayList<String>   list2 = new ArrayList<>();
        Vector<String>      list3 = new Vector<>();

    }
}
