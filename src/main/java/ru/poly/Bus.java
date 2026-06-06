package ru.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Едет");
    }

    @Override
    public void passengers(int countPeoples) {
        System.out.println(countPeoples);
    }

    @Override
    public int refuel(int countFuel) {
        return countFuel;
    }
}
