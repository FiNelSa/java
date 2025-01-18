import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

        public class Main {
            public static void main(String[] args) {
                ArrayList<Integer> user = new ArrayList<>();
                ArrayList<Integer> bank = new ArrayList<>();
                Scanner scan = new Scanner(System.in);
                Random rand = new Random();
                int a;
                boolean b;
                int t = 0;
                int y = 0;  //Daha sonra kullanmak için değişkenler
                int[] f = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};  //Gelebilecek sayıların listesi
                for (int i = 0; i < 2; i++) {   //Bu işlemi 2 kere tekrarlar
                    a = rand.nextInt(13);       //13 olmasının sebebi f arrayinin 13 elemanının olması
                    user.add(f[a]);                   //f arrayindeki a'nıncı elemanı alır ve oyuncunun kartlarına ekler
                    a = rand.nextInt(13);       //2 satır üstteki neden ile aynı
                    bank.add(f[a]);                   //f arrayindeki a'nıncı elemanı alır ve kurpiyerin eline ekler
                }
                System.out.println("Sizin eliniz      : " + user);   //Oyuncuya kendi kartlarını söyler
                System.out.println("Kurpiyerin eliniz : " + bank.getFirst() + " * ");               //Kurpiyerin 1. kartını söyler ama 2. kartını söylemez
                while (user.size() < 5 & t<21) { //Oyuncunun elindeki kart 5'ten küçük iken ve toplamı 21'den küçük iken bu işlemleri uygular
                    System.out.println("\nDevam mı tamam mı?"); //Daha fazla kart isteyip istemediğini sorar
                    b = scan.nextBoolean(); //Oyuncunun cevabını alır
                    if (b) { //Eğer değer "true" ise
                        a = rand.nextInt(13);   //13 olmasının sebebi f arrayinin 13 elemanının olması
                        user.add(f[a]);                 //f arrayindeki a'nıncı elemanı alır ve oyuncunun kartlarına ekler
                        System.out.println(user);       //Oyuncuya kartlarını gösterir
                        t = 0;                          //Kartların toplamının düzgün sayılabilmesi için
                        for (Integer integer : user) {
                            t += integer;               //Oyuncunun kartlarını toplar
                        }
                    }
                    if (!b){    //Eğer değer "false" ise
                        break;  //Döngüyü kırar
                    }
                }
                t = 0;  //Tekrar hesaplanırken sıkıntı olmaması için
                for (Integer integer : user) {
                    t += integer;   //Oyuncunun kartlarını toplar
                }
                for (Integer integer : bank) {
                    y += integer;   //Bankanın kartlarını toplar
                }
                while (bank.size()<5 & y<=t & y<=21){   //Bankanın 5'ten az kartı var ve kartlarının toplamı 21'den küçük ise devam eder
                    a = rand.nextInt(13);   //13 olmasının sebebi f arrayinin 13 elemanının olması
                    bank.add(f[a]);     //f arrayindeki a'nıncı elemanı alır ve kurpiyerin eline ekler
                    y = 0;  //Kartların toplamının düzgün sayılabilmesi için
                    for (Integer integer : bank) {
                        y += integer;   //Bankanın kartlarını toplar
                    }
                }
                System.out.println("Kurpiyer kart çeker... \n" + bank); //Kurpiyerin kartlarını gösterir
                if (21<t){//Oyuncu 21'i geçerse
                    System.out.println("Eliniz 21'i geçtiği için kaybettiniz!");
                } else if (y<t) {//Oyuncu 21'e bankadan daha yakınsa
                    System.out.println("Önde olduğunuz için kazandınız!");
                } else if (21<y) {//Banka 21'i geçerse
                    System.out.println("Banka patladığı için kazandınız!");
                } else if (t<y) {//Banka 21'e oyuncudan daha yakınsa
                    System.out.println("Kurpiyer önde olduğu için kaybettiniz!");
                }
            }
        }