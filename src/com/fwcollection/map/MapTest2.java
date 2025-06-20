package com.fwcollection.map;

import java.util.*;

// List<DeptVO> - SELECT * FROM dept;
// List<Map> - SELECT * FROM dept, emp WHERE dept.deptno = emp.deptno
// DeptVO - 한 개로우만 담을 수 있다. 그러나 컬럼은 여러개 담을 수 있다.
// 클래스 안에는 전변을 여러개 선언할 수 있다.
public class MapTest2 {
    public static void main(String[] args) {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("deptno",10);
        map.put("dname","인사부");
        map.put("loc","서울");
        list.add(map);
        map = new HashMap<>();
        map.put("deptno",20);
        map.put("dname","총무부");
        map.put("loc","인천");
        list.add(map);
        map = new HashMap<>();
        map.put("deptno",30);
        map.put("dname","개발부");
        map.put("loc","제주");
        list.add(map);
        Object[] keys = map.keySet().toArray();
        //컬럼명 출력
        for(Object key:keys){
            System.out.println(key);
        }
        for(Map<String,Object> map1:list){
            Object[] objs = map1.keySet().toArray();
            for(int i=0;i<objs.length;i++){
                System.out.println(map1.get(objs[i]));
            }
        }
    }
}
