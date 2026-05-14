package com.turkcell;

import java.util.Arrays;

// Entrypoint
public class Main 
{
   
    public static void main(String[] args) 
    {
        System.out.println("Merhaba Turkcell, Java'ya hoş geldiniz!");

        // Programlama konseptleri

        // Scope Kavramı => {} kapsama alanı

        // Değişkenler (Variables)
        // Kodun akışında değer tutan isimli veriler.

        System.out.println(10);
        int X = 15; // Değişken tanımlandı. X ismine bir değer atandı.
        // Tanımlandıktan itibaren değişebilir, erişilebilir.
        System.out.println(X);
        X=20;
        System.out.println(X);

        // Değişken tipleri => int, double, boolean, char, String
        String name = "Halit";
        String age = "25";
        boolean isStudent = true;
        char grade = 'A';

        name = "Nurgül";


        // Diziler (Arrays)

        String[] names = { "Halit", "Ayşe", "Mehmet" };
        System.out.println(names[0]); // index, 0 dan başlar.
        //System.out.println(names[5]);

        // Primitive (ilkel) tipler -> int, double,boolean,char
        int a = 0;
        int b = a;
        a = 10;
        System.out.println(a); 
        System.out.println(b); 

        // Referans tipler -> String, Array, Object
        int[] c = {0,1,2,3};
        int[] d = c;
        d[3] = 30;
        System.out.println(c[3]); 
        System.out.println(d[3]); 


        System.out.println("******");

        System.out.println(a==b);
        System.out.println(c==d);


        int[] x = {0,1,2,3};
        int[] y = {0,1,2,3};
        System.out.println(y);
        System.out.println(x==y); 
        System.out.println(Arrays.equals(x, y));


        String s1 = "Merhaba";
        String s2 = "Merhaba";
        System.out.println(s1==s2); // String Pool 
        // (Aynı metinlerin bir havuzda toplanıp performans için birebir olanları aynı referansa ata.)

        // Yine de daha güvenli bir karşılaştırma için equals() kullanılır.
        System.out.println(s1.equals(s2));

        String s3 = "Turkcell";
        String s4 = s3.intern(); 
        // intern() metodu, s3'ün değerini String Pool'a ekler ve oradaki referansı döndürür.

        System.out.println(s3==s4);

        String str3 = "Turkcell";
        String str4 = new String("Turkcell"); // instance oluşturur, farklı referans

        System.out.println(str3==str4); // false, farklı referanslar

        System.out.println("Merhaba" + " " + "Dünya!");

        System.out.println(10 * 20);
        System.out.println(10 / 3);

        System.out.println(1 == 1);
        System.out.println(1 != 1);
        System.out.println(5 > 10);

        a = a + 5;
        a+=5;
        a++; // a = a + 1;

        // Döngüler

        // X işlemini birden fazla kez çalıştırmak.
        // iteration = yineleme
        // değişken, koşul, her iterasyon sonrası işlem
        for(int i=0; i<5; i++) {
            System.out.println(i);
        }

        String[] students = {"Halit", "Ayşe", "Mehmet"};
        for(int i=0; i<students.length; i++) {
            System.out.println(students[i]);    
        }
        for(String z: students) {
            System.out.println(z);
        }
        // iterasyon => koşul
        int whileDongusu = 0;
        while(whileDongusu < 5) {
            System.out.println("Sonsuz döngü");
            whileDongusu++;
        }

        String name2 = "Halit";
        System.out.println(name2);
        name2 = "Nurgül";
        System.out.println(name2);
        String name3 = name2.concat("abc"); 
        // String immutable (değiştirilemez) bir yapıya sahiptir. 
        // concat() gibi metotlar yeni bir String oluşturur, mevcut String'i değiştirmez.
        System.out.println(name3);


        // Karar Blokları & Döngüler 

        // Belirli 1+ kapsamdaki kod bloklarını belirli koşullara göre ateşlemek.
        // Karar bloğu = minimum 1 maksimum n adet karara göre farklı kodlar çalıştırabilir.
        // Koşul: true-false

        // Her koşul bloğu yalnızca maksimum 1 scope çalıştırır.
        // Kodlar yukarıdan aşağıya çalıştırılır.
        int age2 = 18;

        if (age2 >= 18) {
            System.out.println("Yetki verildi");
        }
        else if (age2 == 18) {
            System.out.println("Yaşınız tam 18, ay kontrolü yapılıyor.");
        }
        else {
            System.out.println("Yetki verilmedi");
        }

        String username = "halit";
        if(username.equals("tamer"))
        {
            System.out.println("Tamer hoş geldin..");
        } // Karar blokları illaki bir scope çalıştırma zorunluluğu barındırmaz.

        /// ..... öğrenci notu hesaplama
        /// 
        /// 
        /// 
        /// 
        /// 
        /// 
        /// 
        /// 
        /// 
        /// 
        /// ....... öğrenci notu hesaplama
        String result1 = calculateGrade(85); // konsola yaz
        String result2 = calculateGrade(70, "Ayşe"); // db'e yaz
        String result3 = calculateGrade(60); // email at..
        String result4 = calculateGrade(50, "Nurgül");
        String result5 = calculateGrade(30, "Tamer");

        System.out.println(result1);

        // result2 db'e yaz
        // result3 mail at..


        double toplam1 = sum(10.5, 20.3);
        System.out.println(toplam1);

        double toplam2 = sum(1,2,3,4,5,6,7);
        System.out.println(toplam2);
    }
    // Methodlar => belirli bir işi yapan kod bloklarıdır. Tekrar tekrar kullanılabilirler.
    // erişim-belirteci - static veya boş - dönüş tipi (void => boş) - method ismi - (parametreler) - {}
    // bir parametre tanımlıysa, null bile olsa göndermek zorundasın.
    public static String calculateGrade(int grade, String name) // required parameter
    {
        if(grade >= 85)
        {
            String result = name + " Notunuz: A";
            return result;
        }
        else if(grade >= 70)
        {
            return name + " Notunuz: B";
        }
        else if(grade >= 50)
        {
            return name + " Notunuz: C";
        }
        else
        {
            return name + " Notunuz: F";
        }
    }

    // Name gönderilmezse, "Öğrenci" olarak varsayılan değer alsın.
    // Method Overloading => Aynı isimde, farklı parametre sayısına sahip methodlar oluşturma.
    public static String calculateGrade(int grade)
    {
        return calculateGrade(grade, "Öğrenci");
    }
  
    public static double sum(double a, double b){
        return a + b;
    }

    public static double sum(double... numbers) { // varargs
        double total = 0;
        for(double num: numbers) {
            total += num;
        }
        return total;
    }
} 
// CTRL + SHIFT + P
// User Settings
// Compact
// Explorer: Compact Folders kapat
