package com.fwcollection.map;

import java.util.*;

// List<DeptVO> - SELECT * FROM dept;
// List<Map> - SELECT * FROM dept, emp WHERE dept.deptno = emp.deptno
// DeptVO - 한 개로우만 담을 수 있다. 그러나 컬럼은 여러개 담을 수 있다.
// 클래스 안에는 전변을 여러개 선언할 수 있다.
public class MapTest1 {
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
        for(int i=0;i<list.size();i++){//로우수
            Map<String,Object> map1 = list.get(i);
            Set<String> keys = map1.keySet();
            Object objs[] = keys.toArray();
            for(Object key:objs){//키값의 수
                //MyBatis, Hibernate
                System.out.println(key);//deptno, dname, loc
            }
        }
        for(Map<String,Object> map1:list){
            Object objs[] = map1.keySet().toArray();
            for(Object key:objs){//키값의 수
                for(int i=0;i<objs.length;i++){
                    String skey = (String)objs[i];//deptno, dname, loc
                    System.out.print(map1.get(skey)+" ");
                }
                System.out.println();
            }//end of inner for
        }//end of outter for
    }
}
