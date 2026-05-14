package com.turkcell;

public class Interfaces {
    public static void main(String[] args) {
        CarRepository carRepository = new MsCarRepository(); // Sol taraf => Bana CarRepository kurallarına uyan somut bir class ver.

        carRepository.add(new Car(true,"BMW"));
        carRepository.add(new Car(true,"Mercedes"));
        carRepository.add(new Car(false,"Ford"));
    }
}

// Yeni bir proje oluşturmak (aynı klasör içinde olabilir)
// isim: BankingApplication 

// Bir Bankacılık uygulaması => İçerik tamamen size ait.
// Min. 3+ özellik.

// In-Memory Repository => Veriler RAM'de değişkende tutulabilir.

// Tek bir main classda simülasyon yeterli.