package com.turkcell;

// ARAÇ klasmanına giren nesnelerin
// tüm ortak özellikleri
public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private Double pricePerDay;

      public void setPricePerDay(Double pricePerDay) {
        // this => sınıfın kendisi
        if(pricePerDay < 0)
        {
            System.out.println("Fiyat negatif olamaz. 0'a eşitleniyor..");
            pricePerDay = 0.0;
        }
        this.pricePerDay = pricePerDay;
    }
    public Double getPricePerDay() {
        return this.pricePerDay;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

}
