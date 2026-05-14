package com.turkcell;

// Vehicle'ın tüm özelliklerini yükle, üstüne 
// buraya yazacağım özellikleri de ekle => CAR

// subclass - superclass
public class Car extends Vehicle
{
    // Constructor => Yapıcı Metot => Yazmasanız bile bir tane var.
    // Yazarsam => Auto oluşanı override etmiş olursun.

    public Car(boolean hasSunroof, String brand) {
        super(); // Vehicle'ın constructor'ını çağırır.
        this.setHasSunroof(hasSunroof);
        super.setBrand(brand); // -> Super => Vehicle classını (kalıtım aldığım class)
    }
    public Car() {
    }

    private boolean hasSunroof;
    private String[] specs;

    // Encapsulation => Dışarıdan manipülasyona kapalı.
    public String[] getSpecs() {
        return specs.clone();
    }
    public void setSpecs(String[] specs) {
        this.specs = specs.clone();
    }
    // Değerlerini al, referansı alma.
    public boolean isHasSunroof() {
        return hasSunroof;
    }
    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }
}
