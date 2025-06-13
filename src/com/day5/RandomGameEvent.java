package com.day5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//RandomGameEvent는 ActionListener구현체 클래스가 되어야 함.
public class RandomGameEvent implements ActionListener {
    RandomGameUI randomGameUI = null;//원본을 사용하므로
    //절대로 복사본을 만들지 않는다.
    //버튼에 접근하려면 RandomGameUI에 대한 인스턴스변수가 필요함.
    public RandomGameEvent(RandomGameUI randomGameUI){
        //직접 인스턴스화 하는게 아니고 생성자 파라미터를 통해서
        //객체를 주입 받아야 원본을 쥐게 된다. - 내가 모르는 코드가 있어서는 안된다.
        this.randomGameUI = randomGameUI;
    }
    @Override
    public void actionPerformed(ActionEvent e){

    }
}
