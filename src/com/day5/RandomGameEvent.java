package com.day5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//RandomGameEvent는 ActionListener구현체 클래스가 되어야 함.
public class RandomGameEvent implements ActionListener {
    RandomGameUI rgu = null;//원본을 사용하므로
    //변수 my가 변할 때 count도 같이 증가된다.
    //count에 대한 상태변화는 판정하기 가 아닌 이벤트 처리부에서 처리되고 있다.
    //그래서 이벤트 클래스에서 처리하는 것이 좋겠다.
    //게임이 진행되는 동안에는 유지가 되고 새게임이나 정답을 눌렀을 때는
    //초기화가 되어야 한다.
    int count = 0;
    //절대로 복사본을 만들지 않는다.
    //버튼에 접근하려면 RandomGameUI에 대한 인스턴스변수가 필요함.
    public RandomGameEvent(RandomGameUI rgu){
        //직접 인스턴스화 하는게 아니고 생성자 파라미터를 통해서
        //객체를 주입 받아야 원본을 쥐게 된다. - 내가 모르는 코드가 있어서는 안된다.
        this.rgu = rgu;
    }
    @Override
    public void actionPerformed(ActionEvent e){

        Object obj = e.getSource();
        if(obj == rgu.btnDap){
            rgu.rgl.nanSu();
            rgu.jta.append("정답은 " + rgu.rgl.dap + " 입니다. \n");
            count = 0;
        }
        else if(obj == rgu.btnNew){
            count = 0;
            rgu.rgl.nanSu();
            System.out.println("새로 채번된 숫자는 "+rgu.rgl.dap);
            rgu.jta.append("새게임이 시작되었습니다. \n");
        }
        else if (obj == rgu.btnClear) {
            rgu.jta.setText("");
        }
        else if(obj == rgu.btnExit){
            System.exit(0);
        }
        else if(obj==rgu.jtf){
            String msg = null;
            //System.out.println(jtf.getText());
            String s = rgu.jtf.getText();
            //파라미터에 문자열을 넣으면 정수로 바꿔주는 메소드가 있다.
            //변수 dap은 nanSu()메소드에서 재정의된다.
            //변수 my는 언제 재정의 되나요? - 사용자가 입력한 값 - 화면
            //JTextField에 작성된 값
            //my는 사용자가 입력할 때 마다 변경되고
            //또 my는 dap변수와 비교해야 한다.
            //클래스 분리한 상황에서도 my를 전변으로 해야 하나요?
            //아니면 지변으로 해도 될까요?
            //my는 jtf에 엔터를 쳤을 때 그 때 결정된다.
            //call by value, pass by value
            int my = Integer.parseInt(s);
            //나는 리턴타입을 받을 수 있다.
            msg = rgu.rgl.판정하기(my);

            //jta.append(++count+"회차 : "+s);
            //메소드 안에서 리턴타입이 있는 메소드 호출은 합법이다.
            rgu.jta.append(++count+"회차 : "+my+"-"+msg+"\n");
            rgu.jtf.setText("");
        }

    }
}
