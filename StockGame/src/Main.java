import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int MarketState() {
        Random rand = new Random();
        int[] StateDefiner = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4};
        return StateDefiner[rand.nextInt(0, StateDefiner.length)];
    }

    public static Double[] StableRise(Double sugarPrice, Double sugarAmount) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Double Gains = 0.0;
        Double[] RETURNARRAY = {Gains, sugarPrice, sugarAmount};
        for (int i = 0; i <= 5; i++) {
            System.out.println("Şeker Fiyatı: " + sugarPrice);
            sugarPrice *= rand.nextDouble(0.7, 1.8);
            System.out.println("\r Almak İstediğiniz Şeker Miktarını Giriniz:");
            sugarAmount += scanner.nextInt();
            Gains = sugarAmount * sugarPrice;
            System.out.println(Gains);

        }
        return RETURNARRAY;
    }

    public static Double[] StableFall(Double sugarPrice, Double sugarAmount) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Double Gains = 0.0;
        Double[] RETURNARRAY = {Gains, sugarPrice, sugarAmount};
        for (int i = 0; i <= 5; i++) {
            System.out.println("Şeker Fiyatı: " + sugarPrice);
            sugarPrice *= rand.nextDouble(0.1, 1.2);
            System.out.println("\r Almak İstediğiniz Şeker Miktarını Giriniz:");
            sugarAmount += scanner.nextInt();
            Gains = sugarAmount * sugarPrice;
            System.out.println(Gains);

        }
        return RETURNARRAY;
    }

    public static Double[] FastRise(Double sugarPrice, Double sugarAmount) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Double Gains = 0.0;
        Double[] RETURNARRAY = {Gains, sugarPrice, sugarAmount};
        for (int i = 0; i < 2; i++) {
            System.out.println("Şeker Fiyatı: " + sugarPrice);
            sugarPrice *= rand.nextDouble(0.8, 5);
            System.out.println("\r Almak İstediğiniz Şeker Miktarını Giriniz:");
            sugarAmount += scanner.nextInt();
            Gains = sugarAmount * sugarPrice;
            System.out.println(Gains);

        }
        return RETURNARRAY;
    }

    public static Double[] FastFall(Double sugarPrice, Double sugarAmount) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Double Gains = 0.0;
        Double[] RETURNARRAY = {Gains, sugarPrice, sugarAmount};
        for (int i = 0; i < 2; i++) {
            System.out.println("Şeker Fiyatı: " + Math.round(sugarPrice * 100.0) / 100.0);
            sugarPrice *= rand.nextDouble(0.01, 1.2);
            System.out.println("\r Almak İstediğiniz Şeker Miktarını Giriniz:");
            sugarAmount += scanner.nextInt();
            Gains = sugarAmount * sugarPrice;
            System.out.println(Gains);

        }

        return RETURNARRAY;
    }

    public static Double[] Play(Double sugarPrice, Double sugarAmount) {

        Double[] RETURNARRAY = {sugarPrice, sugarAmount};
        switch (MarketState()) {
            case 1:
                StableRise(sugarPrice, sugarAmount);
                break;
            case 2:
                StableFall(sugarPrice, sugarAmount);
                break;
            case 3:
                FastRise(sugarPrice, sugarAmount);
                break;
            case 4:
                FastFall(sugarPrice, sugarAmount);
                break;
        }
        return RETURNARRAY;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        Double sugarPrice = 10.0;
        Double sugarAmount = 10.0;
        Double Gains = 0.0;
        while (true) {
            //eklemeler yapılacak
            System.out.println("Hangi hisseye yatırım yapmak istersiniz: ");
            System.out.println("1-Şeker");
            System.out.println("2-Tuz");
            System.out.println("3-Ekmek");
            int VictimChoice = scanner.nextInt();
            switch (VictimChoice) {
                case 1:
                    Play(sugarPrice, sugarAmount);
                    break;
            }
        }
    }
}