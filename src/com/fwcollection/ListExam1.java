package com.fwcollection;

import java.util.ArrayList;
import java.util.List;

//인스턴스화
//1.A a = new A();
//2.Parent p = new Child();권장 - 다형성
//3.Calendar cal = Calendar.getInstance() - 싱글턴
public class ListExam1 {
    public static void main(String[] args) {
        //생성부에는 제네릭 타입을 생략할 수 있다.- 다이어몬드연산자
        //제네릭에 String타입을 적으면 int는 담을수가 없다.
        List<String> nameList = new ArrayList<>();
        boolean isExist = nameList.add("kiwi");
        if(isExist){
            System.out.println("네가 말한 키위 장바구니에 담았어.");
        }
        nameList.add(1,"kiwi");
        //C# - 사용자가 입력받은 타입이 기본적으로 text - 문자열
        nameList.add(2,String.valueOf(5));
        nameList.add(3,String.valueOf(5.0));
        nameList.add(4,String.valueOf(true));
        for(int i=0;i<nameList.size();i++){
            String name = nameList.get(i);
            System.out.println(name);
        }
    }
}
