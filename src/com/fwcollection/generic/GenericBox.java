package com.fwcollection.generic;
//제네릭 적용(T는 type parameter)
public class GenericBox<T> {
    private T item;
    public void set(T item) {
        this.item = item;
    }
    public T get() {
        return item;
    }

    public static void main(String[] args) {
        Box box = new Box();
        box.set("키위");
        String fruit = (String)box.get();
        System.out.println(fruit);//키위
        GenericBox<String> genericBox = new GenericBox<>();
        genericBox.set("사과");
        String fruit2 = genericBox.get();
        System.out.println(fruit2);//사과
    }
}
