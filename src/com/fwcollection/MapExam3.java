package com.fwcollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//Map은 충돌 이슈 - key값이 중복되지 않아야 한다.
//불변객체
public class MapExam3 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "kiwi");
        map.put(1001, "apple");
        map.put(1002, "tomato");
        //map.clear();
        //불변객체는 수정할 수는 없어서 기존 키값을 읽어오고
        //기존 키를 삭제 한 다음 새로운 키로 값을 추가한다.
        //Map 랜덤하게 처리한다.
        //키를 사용해서 원하는 정보를 찾는다. - 속도 잇점이다.
        Set<Integer> keys = map.keySet();
        map.remove(1000);
        map.put(2000, "kiwi");
        System.out.println(map.get(1000));
        System.out.println(map.containsKey(1000));//true, false
        System.out.println(map.containsKey(2000));//true, false
        System.out.println(map.get(2000));
        System.out.println(map.isEmpty());
    }
}
/*
    JDBC API 오라클 연동하기 > MyBatis(List,Map)
    > Spring Boot JPA - hibernate - 무한루프(DML없어-자동으로 생성해줌)-생략
    SQL - JOIN - RDBMS - 필수 - 여러개의 테이블 등장
    MemberVO, GoodsVO, OrderVO
 */
