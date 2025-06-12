package com.day4;

public class NoticeSimulation {
    public static void main(String[] args) {
        //하나의 클래스에 4가지 종류 정보를 담는다.
        Notice notice = new Notice();
        notice.setN_no(1);
        notice.setN_title("공지제목 1");
        notice.setN_content("공지내용 1");
        notice.setN_date("2025-06-12");
        System.out.println(notice.getN_title());
        System.out.println(notice.getN_date());
        //생성자의 기본적인 역할은 전변에 대한 초기화를 담당함.
        notice = new Notice(2,"공지제목2","공지내용2", "2025-06-13");
        System.out.println(notice.getN_title());
        System.out.println(notice.getN_content());
        System.out.println(notice.getN_date());
        System.out.println(notice.getN_no());
    }
}
