package com.turkcell;


// Sistemimde Araba veritabanı olarak
// çalışmak isteyen her nesne
// bu interface'i implement etmek zorunda.
public interface CarRepository {
   // Bir car repository'si nasıl davranmalı? Net kalıp ve kurallar ile tanımla.
   // Soyut => içi boş, yalnızca imzası olan methodlar tanımlamak.

   void add(Car car);
}

// Böylelikle PostgreSqlCarRepository, MySqlCarRepository gibi farklı
//  veri tabanları için farklı implementasyonlar yapabiliriz. 
// Bu sayede kodumuz daha esnek ve genişletilebilir olur.
