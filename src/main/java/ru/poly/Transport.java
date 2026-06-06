package ru.poly;

public interface Transport {
    void ride();

    void passengers(int countPeoples);

    default int refuel(int countFuel) {
        return 0;
    }
}
