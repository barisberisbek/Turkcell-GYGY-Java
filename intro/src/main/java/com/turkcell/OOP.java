package com.turkcell;

public class OOP {
    public static void main(String[] args) {
        Car car1 = new Car(); // new Car(); 
        // yeni bir araba nesnesi örneği (instance) üret
        car1.setBrand("BMW"); // set işlemi (değer atama)
        car1.setModel("X5");
        car1.setYear(2020);
        car1.setPricePerDay(-500.0);

        String[] specs = {"Cam Tavan", "Bebek Koltuğu","Otonom Sürüş"};
        car1.setSpecs(specs);

        String[] x = car1.getSpecs();
        x[0] = "abc";

        System.out.println(car1.getSpecs()[0]); // Cam Tavan
        System.out.println(car1.getBrand()); // get işlemi (değer okuma)
        System.out.println(car1.getPricePerDay()); // private olduğu için erişilemez
    
        Bike bike1 = new Bike();

        Car car2 = new Car(true, "Mercedes");
        System.out.println(car2.getBrand());
    }
}
