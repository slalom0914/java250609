package com.fwcollection.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest2 {
    public static void main(String[] args) {
        int[] ages = {20,30,40};
        System.out.println(ages.length);//3
        //원시형 타입은 List에 담을 수 없다.
        //int -> wrapper Integer
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(2,25);
        System.out.println(list.size());//0 -> 3
        for(Integer i:list){
            System.out.println(i);
        }
    }
}
