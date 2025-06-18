package com.week1.baseball;

public class UserInput {
    int[] my = new int[3];
    //3자리 숫자를 한 번에 입력 받는다.
    public void inputValue(String user){
        System.out.println(user instanceof String );
        int temp = Integer.parseInt(user);
        my[0] = temp/100;//5
        //%나누기한 나머지를 반환함.
        my[1] = (temp%100)/10;//78-> 7.8 -> 7
        my[2] = temp%10;//몫은 57 나머지는 9
        System.out.println(my[0]+" "+my[1]+" "+my[2]);
    }
    public static void main(String[] args) {
        UserInput ui = new UserInput();
        ui.inputValue("578");
    }
}
