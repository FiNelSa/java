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

            while (urStonks<10000) {//Değer değişiminin sürekli olması ve ne zamana kadar devam etmesini bildirmek amacıyla döngüye alıyoruz

                sugar = prices.nextDouble(sugar * 0, sugar * 3);//Önceki değerinin kaç ile çarpılacağı
                salt = prices.nextDouble(salt * 0, salt * 3);
                bread = prices.nextDouble(bread * 0, bread * 3);
                uvLight = prices.nextDouble(uvLight * 0, uvLight * 3);
                
                urStonks = (sugar*sugarPieces + salt*saltPieces + bread*breadPieces + uvLight*uvPieces - totalValue);//Yeni toplam değer ile eskisinin farkı
                System.out.println("Your things' total value after delay is " + urStonks);//kullanıcıya bildirimi

                System.out.println("Value of sugar = " + sugar + "\n Total pieces of your Sugar = " + sugarPieces);//Değerlerinin kullanıcıya bildirilmesi
                System.out.println("Value of salt = " + salt + "\n Total pieces of your Salt = " + saltPieces);
                System.out.println("Value of bread = " + bread + "\n Total pieces of your Bread = " + breadPieces);
                System.out.println("Value of UV Lights = " + uvLight + "\n Total pieces of your UV Lights = " + uvPieces);

                System.out.println("If you want to buy or sell enter one, else enter zero.");//Bir şey alıp ya da satmak istediğini soruyoruz
                int cont = piece.nextInt();
                if (cont==1){//Eğer cont 1 ise devam ediyo
                    System.out.println("How much Sugar do you want to buy or sell?");
                    int newSugar = piece.nextInt();//Ne kadar alıp sattığını öğreniyoruz
                    sugarPieces = sugarPieces+newSugar;//Aldığı ya da sattığı adeti ana miktara ekliyoruz
                    totalValue = totalValue + (newSugar*sugar);//Parası artıyor ya da azalıyor

                    System.out.println("How much Salt do you want to buy or sell?");//Aynı
                    int newSalt = piece.nextInt();
                    saltPieces = saltPieces+ newSalt;
                    totalValue = totalValue + (newSalt*salt);

                    System.out.println("How much Bread do you want to buy or sell?");
                    int newBread = piece.nextInt();
                    breadPieces = breadPieces+newBread;
                    totalValue = totalValue + (newBread*bread);

                    System.out.println("How much UV Lights do you want to buy or sell?");
                    int newUv = piece.nextInt();
                    uvPieces = uvPieces+newUv;
                    totalValue = totalValue + (newUv*uvLight);
                }
            }
    }
}