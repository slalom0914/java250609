package com.emp;

import java.util.Map;

public class JDBCDemo {
    //사원등록
    public int empInsert(EmpVO evo){
        int result = 0;
        return result;
    }
    //사원수정

    //사원삭제

    //사원조회

    public static void main(String[] args) {

    }
}
/*
등록,수정,삭제,조회
공통점은 같은 오라클 서버에 같은 계정에 접속한다.
-> 반복되는 코드가 등장한다. - 관찰하기
-> 다른 부분도 존재한다.
select는 반환타입이 n건을 받아주는 타입이어야 한다.
1건 - VO, Map - 변수종류, 컬럼의 종류
n건 - List, Object[]
insert, update, delete : int가 반환타입이다.

insert는 8개 컬럼을 사용자로 부터 입력 받는다.
파라미터는 8개가 필요하다.
만일 8개를 한 번에 넘기고 한 번에 받아오는 방법은?
파라미터 타입 : Object -> EmpVO or Map
리턴 타입 : 1 row inserted - int
public int empInsert(EmpVO or Map)

update는 기존에 있는 값을 변경하는 것이다.
조건절에 사원번호가 온다.
수정시에도 화면으로 부터 8개의 정보를 받아온다.

public int empUpdate(EmpVO or Map)

delete는 기본에 있는 정보 중 한 개 로우를 삭제하는 것이다
조건절에는 사원번호가 온다.

public int empDelete(int empno)




 */











