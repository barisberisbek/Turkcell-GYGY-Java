package com.turkcell;

public class Bike extends Vehicle
{
    private boolean hasIntercom;

    public boolean isHasIntercom() {
        return hasIntercom;
    }

    public void setHasIntercom(boolean hasIntercom) {
        this.hasIntercom = hasIntercom;
    }
}

// Inheritance => Kalıtım
// Ben bir nesnenin tüm özelliklerini 
// taşıyorum, ekstra özellik de taşıyorum.

// extends (genişletmek)

