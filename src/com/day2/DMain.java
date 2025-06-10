package com.day2;

class D{
    int deptno=0;
}

public class DMain {
    D d=new D();
    //자바에서는 같은 이름의 메소드를 중복 선언 가능하다.
    //단 메소드 오버로딩의 규칙을 준수한다면....
    //무조건 파라미터의 갯수나 타입이 다르다 - 오버로딩 규칙준수했다.
    void methodA(){
        System.out.println("methodA() 호출");
        //원본이 20으로 변한거야?
        d.deptno = 20;
    }
    void methodA(D d){
        System.out.println("methodA(D d) 호출");
        //여기도 원본이 30으로 변한거야?
        //굳이 d를 복사본으로 처리해 보세요.
        //그래서 main메소드에서 20이 출력되도록 코드를 수정해부세요.
        d = new D();
        d.deptno = 30;
    }
    public static void main(String[] args) {
        //non-static 타입의 변수를 static영역에서 사용할 수 없다.
        //클래스 관계가 복잡하다.
        //클래스 갯수가 많다.
        //업무가 복잡하다. - 양이 많다
        DMain dm=new DMain();
        //주소번지를 두 번 접근해야 전변에 접근이 가능하다.
        dm.d.deptno = 10;
        System.out.println(dm.d.deptno);//10출력됨
        dm.methodA();
        dm.methodA(dm.d);
        System.out.println(dm.d.deptno);//?출력됨

    }
}
