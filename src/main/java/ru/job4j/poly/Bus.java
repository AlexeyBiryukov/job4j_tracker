package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public String move() {
        return null;
    }

    @Override
    public int passenger(int num) {
        return 0;
    }

    @Override
    public int car(int fuel) {
        int cost = 50;
        int price = cost * fuel;
        return price;
    }
}
