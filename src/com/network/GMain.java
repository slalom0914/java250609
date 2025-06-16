package com.network;
class G{
    int ival;
}

public class GMain {
    public static void main(String[] args) {
        G g1 = new G();
        g1.ival = 1;
        G g2 = new G();
        g2.ival = 3;
        G g3 = new G();
        g3.ival = 5;
        System.out.println(g1.ival);//1
        System.out.println(g2.ival);//3
        System.out.println(g3.ival);//5
    }
}
