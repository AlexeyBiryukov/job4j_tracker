package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println(calc(-1));
    }

    public static int calc(int n) {
        int rsl = -1;
        if (n < 0) {
            throw new IllegalArgumentException("метод вызывается с некорректными параметрами.");
        }
        for (int index = 0; index <= n; index++) {
            rsl += index;
        }
        return rsl;
    }
}


//    java.lang.IllegalArgumentException - метод вызывается с некорректными параметрами.
//    java.lang.IllegalStateException - метод вызывается с объекта в не корректном состоянии.
//    java.lang.NullPointerException - методы вызывается у переменной, которая инициализирована null ссылкой.

