package com.fwcollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExam1 {
    public static void main(String[] args) {
        //자바 컬렉션 프레임워크 - 읽기와 쓰기 관련된 메서드
        //clear(), isEmpty():boolean(if, for), size()
        Map<String, String> map = new HashMap<>();
        map.put("one", "kiwi");
        map.put("two", "apple");
        map.put("three", "tomato");
        System.out.println(map.get("one"));
        System.out.println(map.get("two"));
        System.out.println(map.get("three"));
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + ", "+map.get(key));//one, two, three
        }
    }
}
/*
    JDBC API 오라클 연동하기 > MyBatis(List,Map)
    > Spring Boot JPA - hibernate - 무한루프(DML없어-자동으로 생성해줌)-생략
    SQL - JOIN - RDBMS - 필수 - 여러개의 테이블 등장
    MemberVO, GoodsVO, OrderVO
 */
