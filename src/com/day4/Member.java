package com.day4;
//접근제한자 - public > protected > friendly > private
// access modifier
// private이면 외부에서 접근이 불가하다.
//집합 - Table설계 - SQL응용/SQL활용 - DML, 저장프로시저, 함수, JOIN
public class Member {
    private String name;
    private int age;
    private String email;
    public String getName() {//Read
        return name;
    }
    public void setName(String name) {//setter Write, Save
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
