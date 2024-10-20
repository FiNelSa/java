import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random prices = new Random();
        Scanner piece = new Scanner(System.in);


            double sugar = prices.nextDouble(0 , 10);
            double salt = prices.nextDouble(0 , 10);
            double bread = prices.nextDouble(0 , 10);
            double uvLight = prices.nextDouble(0 , 10);
            // Sugar, Salt, Bread ve UV Light'ın değerinin belirlenmesi

            System.out.println("The price of sugar = " + sugar);//Değerlerinin kullanıcıya bildirilmesi
            System.out.println("The price of salt = " + salt);
            System.out.println("The price of bread = " + bread);
            System.out.println("The price of UV Lights = " + uvLight);


            System.out.println("How much Sugar do you have?");
            int sugarPieces = piece.nextInt();//Kaç tane Sugar olduğunun kullanıcıdan alınması
            System.out.println("You have " + sugarPieces + " Sugar");
            double totalSugarValue = sugarPieces * sugar;//Sugar*Adet yani toplam değeri
            System.out.println("The total value of your Sugar is " + totalSugarValue);

            System.out.println("How much Salt do you have?");
            int saltPieces = piece.nextInt();
            System.out.println("You have " + saltPieces + " Salt");
            double totalSaltValue = saltPieces * salt;
            System.out.println("The total value of your Salt is " + totalSaltValue);//Sugar ile aynı

            System.out.println("How much Bread do you have?");
            int breadPieces = piece.nextInt();
            System.out.println("You have " + breadPieces + " Bread");
            double totalBreadValue = breadPieces * bread;
            System.out.println("The total value of your Bread is " + totalBreadValue);//Sugar ile aynı

            System.out.println("How many UV Lights do you have?");
            int uvPieces = piece.nextInt();
            System.out.println("You have " + uvPieces + " UV Lights");
            double totalUvValue = uvPieces * uvLight;
            System.out.println("The total value of your UV Lights is " + totalUvValue);//Sugar ile aynı

            double totalValue = totalBreadValue + totalUvValue + totalSaltValue + totalSugarValue;//Hepsinin değerlerinin toplamı
            System.out.println("Total value of your Salt, Sugar, Bread and UV Lights is " + totalValue);//Kullanıcıya bildirilmesi

            double urStonks = 0;//Değer değişiminden sonraki fark

            while (urStonks<100*totalValue) {//Değer değişiminin sürekli olması ve ne zamana kadar devam etmesini bildirmek amacıyla döngüye alıyoruz

                sugar = prices.nextDouble(sugar * 0, sugar * 3);//Önceki değerinin kaç ile çarpılacağı
                salt = prices.nextDouble(salt * 0, salt * 3);
                bread = prices.nextDouble(bread * 0, bread * 3);
                uvLight = prices.nextDouble(uvLight * 0, uvLight * 3);
                
                urStonks = (sugar + salt + bread + uvLight - totalValue);//Yeni toplam değer ile eskisinin farkı
                System.out.println("Your things' total value after delay is " + urStonks);//kullanıcıya bildirimi
            }

        System.out.println("Total value of your sugar = " + sugar);//Değerlerinin kullanıcıya bildirilmesi
        System.out.println("Total value of your salt = " + salt);// Ayrıca bunları while döngünün dışına almamın sebebi bir kere yazılmasını istemem
        System.out.println("Total value of your bread = " + bread);
        System.out.println("Total value of your UV Lights = " + uvLight);
    }
}