package com.fwcollection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapApi2 {
    public static void main(String[] args) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("빨강");
        list.add("초록");
        list.add("파랑");
        map.put(100, list);
        //얕은 복사 확인 코드 - clone
        HashMap<Integer, List<String>> map2
                = (HashMap<Integer, List<String>>) map.clone();
        //map2에서 수정하기
        map2.get(100).set(0,"노랑");
        System.out.println(map.get(100));//노랑, 초록, 파랑
        System.out.println(map2.get(100));//노랑, 초록, 파랑
    }
}
/*
정리
- clone은 맵 자체만 새로 만들고 내부 객체는 동일한 주소 참조한다.
- 값이 String이나 원시형 타입은 문제 없지만
만일 값이 List, VO, 배열 등 참조형이면 반드시 깊은 복사를 직접 구현해야 한다.

 */