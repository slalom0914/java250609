package com.week1;
class Member1{
    //아래 변수에 저장된 값을 읽기 또는 쓰기 위해 설계된 클래스 이다.
    private String mem_id;
    private String mem_pw;
    private String mem_name;
    Member1(String mem_id,String mem_pw,String mem_name){
        this.mem_id = mem_id;
        this.mem_pw = mem_pw;
        this.mem_name = mem_name;
    }
    //공통사항은 setter/getter 모두 public 선언한다.
    //getter - lombok사용하면 필요없다.
    //getter는 파라미터는 필요가 없지만 리턴타입은 필요하다.
    //setter는 save/write이니까 파라미터가 필요하다.
    //리턴타입은 필요없다.
    //setter호출하면 전변에 저장된다.
    //getter호출하면 전변에 저장된 값을 읽어온다.
    public String getMem_id() {
        return mem_id;
    }
    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }
    public String getMem_pw() {
        return mem_pw;
    }
    public void setMem_pw(String mem_pw) {
        this.mem_pw = mem_pw;
    }
    public String getMem_name() {
        return mem_name;
    }
    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }
}
public class MemberTest {
    Member1[] mems = new Member1[3];
    public static void main(String[] args) {
        MemberTest mt1 = new MemberTest();
        mt1.mems[0] = new  Member1("kiwi","123","키위나무");
        mt1.mems[1] = new  Member1("kiwi2","124","키위나무2");
        mt1.mems[2] = new  Member1("kiwi3","125","키위나무3");
        System.out.println(mt1.mems[1].getMem_name());//키위나무2
        System.out.println(mt1.mems[2].getMem_pw());//125
    }
}
