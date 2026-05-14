package com.turkcell;

// Implement ediyorsan imzaları birebir uygulamak zorundasın.
public class PgCarRepository implements CarRepository {
    public void add(Car car) // En az 300 yerde kullandın...
    {
        System.out.println("Araba nesnesi postgresql'e eklendi");
    }
}
