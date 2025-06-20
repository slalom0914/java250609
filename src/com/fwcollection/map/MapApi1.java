package com.fwcollection.map;

import java.util.HashMap;

public class MapApi1 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(100, "빨강");
        map.put(200, "초록");
        map.put(300, "파랑");
        System.out.println(map.size());//3
        //map.clear();
        System.out.println(map.size());//0
        Object obj = map.clone();
        System.out.println(obj instanceof HashMap);//true
        HashMap map1 = (HashMap) obj;
        System.out.println(map1.get(100));
        boolean isOk = map.containsKey(200);
        System.out.println(isOk);//true
        System.out.println(map.get(200));//초록
        System.out.println(map1.isEmpty());
    }
}
