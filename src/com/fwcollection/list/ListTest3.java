package com.fwcollection.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest3 {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("키위");
        fruits.add("토마토");
        fruits.add("수박");
        boolean isExist = fruits.contains("키위");
        System.out.println(isExist);//false
        //fruits.clear();
        System.out.println(fruits.size());//0
    }
}
