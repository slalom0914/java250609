package com.fwcollection.list;

import com.vo.DeptVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//DB
//number -> int, long
//varchar2(30) -> String
//데이터는 오라클 서버에 있다.
//화면은 html에 출력을 한다.- 배열,핸들바스
//json -> List, Map
//List, Map -> json
//DefaultTableModel -> DataSet -> UI/UX
//VO패턴, DTO패턴 - > getter/setter -> lombok라이브러리
//Table구조 - 로우 + 컬럼
//오라클 서버에서 SELECT 문으로 조회된 결과를 쓴다. -> json내보낸다. - DataSet
//DataSet -> List, Map지원


//보통 select문과 연계해서 목록을 처리할 때 사용된다.
public class ListTest1 {
    public static void main(String[] args) {
        List<Double> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<Boolean> list3 = new ArrayList<>();
        //목록을 처리하는 페이지- 하나의 테이블만 조회
        List<DeptVO> list4 = new ArrayList<>();
        //select문 join문을 사용한다면 아래 것.
        List<Map<String,String>> list5 = new ArrayList<>();
        //세션에 담기
        DeptVO dvo = new DeptVO();
        dvo.setDeptno(10);
        dvo.setDname("ACCOUNTING");
        dvo.setLoc("NEW YORK");
        list4.add(dvo);
        dvo = null;
        dvo = new DeptVO();
        dvo.setDeptno(20);
        dvo.setDname("RESEARCH");
        dvo.setLoc("DALLAS");
        list4.add(dvo);
        dvo = new DeptVO();
        dvo.setDeptno(30);
        dvo.setDname("SALES");
        dvo.setLoc("CHICAGO");
        list4.add(dvo);
        for(int i=0;i<list4.size();i++){
            DeptVO rdvo = list4.get(i);
            System.out.println(rdvo);//주소번지 3개 출력
            //전변 - 고유명사 - 캡슐레이션
            System.out.println(rdvo.getDeptno());
            System.out.println(rdvo.getDname());
            System.out.println(rdvo.getLoc());
        }
    }
}
