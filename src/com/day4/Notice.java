package com.day4;
//공지사항을 구현하는데 필요한 변수를 선언하시오.
//n_no는 사용자로 부터 입력받는 값이 아니다.
public class Notice {
    private int     n_no;//공지글에 대한 식별자
    private String  n_title; //공지사항 제목
    private String  n_content;//공지사항 내용
    private String  n_date;//등록 일자
    public Notice() {}
    //생성자를 사용하면 setter메서드 없이도 전변에 대한 초기화 할 수 있다.
    public Notice(int n_no, String n_title, String n_content, String n_date) {
    //변수이름 앞에 this가 있으면 전변이다.
    //파라미터 자리에 변수는 지변이다.
    //즉 생성자가 호출될 때 파라미터 자리를 통해서 넘어온다.
    //실행부에서 this.변수명=지역변수를 적으면 전변에 대한 초기화를
    //생성자를 통해서 할수 있다.
    //조인관계나 여러 클래스가 관계형태를 가질 때 무한루프 빠질 수 있다.- 주의
        this.n_no = n_no;
        this.n_title = n_title;
        this.n_content = n_content;
        this.n_date = n_date;
    }
    public String getN_content() {
        return n_content;
    }

    public void setN_content(String n_content) {
        this.n_content = n_content;
    }

    public int getN_no() {
        return n_no;
    }

    public void setN_no(int n_no) {
        this.n_no = n_no;
    }

    public String getN_title() {
        return n_title;
    }

    public void setN_title(String n_title) {
        this.n_title = n_title;
    }

    public String getN_date() {
        return n_date;
    }

    public void setN_date(String n_date) {
        this.n_date = n_date;
    }

}
