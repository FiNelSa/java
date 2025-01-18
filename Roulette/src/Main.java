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
        int t;
        int y = 0;
        int[] f = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        for (int i = 0; i < 2; i++) {
            a = rand.nextInt(13);
            user.add(f[a]);
            a = rand.nextInt(13);
            bank.add(f[a]);
        }
        System.out.println("Sizin eliniz      : " + user.getFirst() + " " + user.get(1));
        System.out.println("Kurpiyerin eliniz : " + bank.getFirst() + " * ");
        while (user.size() < 5) {
            System.out.println("\nDevam mı tamam mı?");
            b = scan.nextBoolean();
            if (b) {
                a = rand.nextInt(13);
                user.add(f[a]);
                System.out.println(user);
                t = 0;
                for (Integer integer : user) {
                    t += integer;
                    if (21 < t) {
                        System.out.println("Eliniz 21'i geçtiği için kaybettiniz!");
                        break;
                    }
                }
            }
            if (!b){
                break;
            }
        }
        t = 0;
        for (Integer integer : user) {
            t += integer;
        }
        for (Integer integer : bank) {
            y += integer;
        }
        while (bank.size()<5 & y<=t){
            a = rand.nextInt(13);
            bank.add(f[a]);
            y = 0;
            for (Integer integer : bank) {
                y += integer;
            }
        }

        System.out.println("Kurpiyer kart çeker... \n" + bank);

        if (21<t){
            System.out.println("Eliniz 21'i geçtiği için kaybettiniz!");
        } else if (y<t) {
            System.out.println("Önde olduğunuz için kazandınız!");
        } else if (21<y) {
            System.out.println("Banka patladığı için kazandınız!");
        } else if (t<y) {
            System.out.println("Kurpiyer önde olduğu için kaybettiniz!");
        }
    }
}