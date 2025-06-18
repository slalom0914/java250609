package com.week1.baseball;

public class Nansu {
    int[] com = new int[3];
    public void nanSu(){
        com[0] = (int)(Math.random()*10);
        do{
            com[1] = (int)(Math.random()*10);
        }while(com[0]==com[1]);//첫번째숫자와 두번째 숫자가 같으면 다시 해줘
        do{
            com[2] = (int)(Math.random()*10);
        }while((com[1]==com[2]) || (com[2]==com[0]));
    }//end of nanSu
    public static void main(String[] args) {
        Nansu n = new Nansu();
        for(int i=0;i<10;i++){
            n.nanSu();
            System.out.println(n.com[0]+" "+n.com[1]+" "+n.com[2]);
        }
    }
}
