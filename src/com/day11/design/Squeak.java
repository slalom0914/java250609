package com.day11.design;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("삑삑");
    }
}
