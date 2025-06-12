package com.day4;

public class MemberSimulation {
    public static void main(String[] args) {
        Member member = new Member();
        System.out.println(member);
        //private통해서 외부에서 직접 접근을 강제로 막음.
        //member.name = "홍길동";//캡슐레이션 캡슐화
        //캡슐화로 된 변수에 값을 초기화 하는 방법은 setter사용함.
        member.setAge(30);
        member.setName("홍길동");
        member.setEmail("hong@hot.com");
        member.setEmail("kim@hot.com");
        System.out.println(member.getAge());//30
        System.out.println(member.getName());//홍길동
        System.out.println(member.getEmail());//hong@hot.com
        //member인스턴스는 사용자마다 깊은 복사됨.
        //사람수 만큼 만들어짐. -  전변
    }
}
