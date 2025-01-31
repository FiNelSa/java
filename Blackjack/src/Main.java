import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
        public class Main {
            public static void main(String[] args) {
                ArrayList<Integer> user  = new ArrayList<>();
                ArrayList<Integer> user2 = new ArrayList<>();
                ArrayList<Integer> bank  = new ArrayList<>();
                Scanner scan = new Scanner(System.in);
                Random rand = new Random();
                boolean g = true;
                int b;
                double money = 1000;
                double betm;
                int a;//Daha sonra kullanmak için değişkenler
                int[] f = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};  //Gelebilecek sayıların listesi
                while(g) {  //Tekrar oynanabilmesi için
                    int t = 0;
                    System.out.println("Paranız : " + money);
                    System.out.println("Ne kadar oynamak istiyorsunuz : ");
                    betm = scan.nextInt();
                    money -= betm;
                    user.clear();
                    bank.clear();   //Tekrar oynarken kartların yeniden dağıtalması için
                    for (int i = 0; i < 2; i++){   //Bu işlemi 2 kere tekrarlar
                        a = rand.nextInt(13);       //13 olmasının sebebi f arrayinin 13 elemanının olması
                        user.add(f[a]);                   //f arrayindeki a'nıncı elemanı alır ve oyuncunun kartlarına ekler
                        a = rand.nextInt(13);       //2 satır üstteki neden ile aynı
                        bank.add(f[a]);                   //f arrayindeki a'nıncı elemanı alır ve kurpiyerin eline ekler
                    }
                    System.out.println("Sizin eliniz      : " + user);   //Oyuncuya kendi kartlarını söyler
                    System.out.println("Kurpiyerin eliniz : " + bank.getFirst() + " * ");               //Kurpiyerin 1. kartını söyler ama 2. kartını söylemez
                    while (user.size() < 5 & t < 21) { //Oyuncunun elindeki kart 5'ten küçük iken ve toplamı 21'den küçük iken bu işlemleri uygular
                        System.out.println("\nDevam, tamam, bölmek ister misiniz? 1,2,3"); //Daha fazla kart isteyip istemediğini sorar
                        b = scan.nextInt(); //Oyuncunun cevabını alır
                        if (b==1){ //Eğer değer "true" ise
                            a = rand.nextInt(13);   //13 olmasının sebebi f arrayinin 13 elemanının olması
                            user.add(f[a]);                 //f arrayindeki a'nıncı elemanı alır ve oyuncunun kartlarına ekler
                            System.out.println(user);       //Oyuncuya kartlarını gösterir
                            t = 0;                          //Kartların toplamının düzgün sayılabilmesi için
                            for (Integer integer : user){
                                t += integer;               //Oyuncunun kartlarını toplar
                            }
                        }
                        if (b==2){    //Eğer değer "false" ise
                            break;  //Döngüyü kırar
                        }
                        if (b==3){
                            if (user.get(0) == user.get(1) & user.size()==2){
                                user2.add(user.get(1));
                                user.remove(1);
                                System.out.println("İlk eliniz :\n" + user + "İkinci eliniz :\n" + user2);
                            }else {
                                System.out.println("Şuanda kartlarınızı bölemezsiniz.");
                            }
                        }
                    }
                    t = 0;
                    int y = 0;  //Tekrar hesaplanırken sıkıntı olmaması için
                    for (Integer integer : user){
                        t += integer;   //Oyuncunun kartlarını toplar
                    }
                    for (Integer integer : bank){
                        y += integer;   //Bankanın kartlarını toplar
                    }
                    while (bank.size() < 5 & y <= t & y <= 16 & t <= 21) {   //Bankanın 5'ten az kartı var ve kartlarının toplamı 21'den küçük ise devam eder
                        a = rand.nextInt(13);   //13 olmasının sebebi f arrayinin 13 elemanının olması
                        bank.add(f[a]);     //f arrayindeki a'nıncı elemanı alır ve kurpiyerin eline ekler
                        y = 0;  //Kartların toplamının düzgün sayılabilmesi için
                        for (Integer integer : bank){
                            y += integer;   //Bankanın kartlarını toplar
                        }
                    }
                    System.out.println("Kurpiyer kart çeker... \n" + bank); //Kurpiyerin kartlarını gösterir
                    if (21 < t){//Oyuncu 21'i geçerse
                        System.out.println("Eliniz 21'i geçtiği için kaybettiniz!");
                    } else if (y < t){//Oyuncu 21'e bankadan daha yakınsa
                        System.out.println("Önde olduğunuz için kazandınız!");
                        money += 2*betm;
                    } else if (21 < y){//Banka 21'i geçerse
                        System.out.println("Banka patladığı için kazandınız!");
                        money += 2*betm;
                    } else if (t < y){//Banka 21'e oyuncudan daha yakınsa
                        System.out.println("Kurpiyer önde olduğu için kaybettiniz!");
                    } else if (t == y){
                        System.out.println("Berabere");
                        money += betm;
                    }
                    System.out.println("Tekrar oynamak ister misiniz?");
                    g = scan.nextBoolean();
                }
            }
        }