package com.fwcollection.list;

import com.vo.DeptVO;

import java.util.List;

public class DeptListTest {
    public static void main(String[] args) {
        DeptList deptList = new DeptList();
        List<DeptVO> list = deptList.getList();
        for (DeptVO deptVO : list) {
            System.out.println(deptVO);
        }
        System.out.println("===================================");
        String temp = deptList.getJSONList();
        System.out.println(temp);
    }
}
