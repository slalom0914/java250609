package com.fwcollection;

import java.util.ArrayList;
import java.util.List;

public class ListExam3 {
    public static void main(String[] args) {
        //제네릭이 없으면 어떤 타입인지 알수가 없다.
        //대화명 리스트
        List<Object> nameList = new ArrayList<>();
        boolean isExist = nameList.add("kiwi");
        if(isExist){
            System.out.println("네가 말한 키위 장바구니에 담았어.");
        }
        //value자리에 Object-객체배열,List, Map
        nameList.add(1,"kiwi");
        nameList.add(2,5);
        nameList.add(3,new int[]{1,2,3});
        // api적용해보기 & 타입체크(CastingException) & instanceof
        // 화면(chart-도형으로)에 데이터 바인딩 하기 - 회의
        // Front - js - <h1>값</h1><td>값(int[])</td>
        // Back - int[] - res.json(result)
        for(int i=0;i<nameList.size();i++){
            Object name = nameList.get(i);
            System.out.println(nameList.get(i) instanceof String);//true
            System.out.println(name);
            for(Object obj:nameList){
                if(obj instanceof int[]){
                    int[] arr = (int[])obj;
                    for(int a: arr){
                        System.out.println(a);
                    }
                }
            }
        }
    }
}
