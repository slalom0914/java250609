package com.day5;
// 클래스 설계 - 업무에 이해 기반
// 결합도를 낮추고 단위테스트가 가능한 그런 구조
// 결합도를 낮추는 방법은 인터페이스 또는 추상클래스 중심 코딩을 전개함.
import javax.swing.*;
// implements ActionListener(인터페이스-추상메서드)
// 인터페이스는 단독으로 인스턴스화를 할 수 없다.
// 반드시 구현체 클래스가 있을 때만 인스턴스화 가능하다.
// extends JDialog(클래스)
public class NoticeDialog extends JDialog {
    public NoticeDialog() {
        //main에서는 static있어서 반드시 인스턴스화를 해야 함.
        //그런데 생성자 안에서는 인스턴스화 없이도 호출이 가능함.
        initDisplay();
    }
    public NoticeDialog(String title) {
        this.setTitle(title);//다이얼로그
        initDisplay();
    }
    private void initDisplay() {
        this.setSize(300, 300);
        //this.setVisible(true);
        this.setVisible(false);
    }
}
/*
NoticeDialog는 NoticeApp를 통해서 화면이 열리고
또는 닫히고 제어를 받아야 한다.
main메소드를 가질 필요가 없다.

화면을 출력하려면 XXX.setVisible(true)
false : 메모리에는 상주하지만 화면 미출력
true: 화면 출력

화면을 그리는 메서드를 initDisplay()했을 때
main메소드가 없는 상태에서 어떻게 메서드 호출할 것인가?




 */
