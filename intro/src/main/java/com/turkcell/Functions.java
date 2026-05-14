package com.turkcell;

public class Functions 
{
  public static void main(String[] args) 
  {
    // primitive type => fonksiyon => fonksiyonun onu değiştirmesi orjinal değişkeni etkilemez.
    String name = "Barış";
    sayWelcome(name); // halit
    System.out.println(name); // çıktı? , barış

    // referans tip => fonksiyon => fonksiyonun onu değiştirmesi orjinal değişkeni etkiler.
    int[] numbers = {1,2,3,4,5};
    sum(numbers); // numbers[0] = 1
    System.out.println(numbers[0]); // 100
  }   
  // Pass by value => değer ile aktar.
  public static void sayWelcome(String name) // camelCase
  {
    name = "Halit"; // değişen şey değer.
    System.out.println("Hoş geldiniz, " + name); // çıktı?
  }
  // Pass by reference => referans ile aktar.
  public static void sum(int[] numbers)
  {
    int total = 0;
    for(int number : numbers){
        total += number;
    }
    System.out.println("Toplam: " + total);
    numbers[0] = 100; // dizinin ilk elemanını değiştirelim.
  }
}
