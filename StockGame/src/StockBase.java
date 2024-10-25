import java.util.Random;
import java.util.Scanner;

public class StockBase {
    public Double stockPrice = 10.0;
    public Double TotalStockAmount = 1000.0;

    public  Double GetStockValue(Double stockPrice,Double TotalStockAmount){
        return stockPrice * TotalStockAmount;
    }
    public  int MarketState() {
        Random rand = new Random();
        int[] StateDefiner = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4};
        return StateDefiner[rand.nextInt(0, StateDefiner.length)];
    }

    public  Double[] StableRise(Double Gains,Double sugarPrice, Double sugarAmount) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        for (int i = 0; i <= 5; i++) {
            System.out.println("Şeker Fiyatı: " + sugarPrice);
            sugarPrice *= rand.nextDouble(0.7, 1.8);
            System.out.println("\r Almak İstediğiniz Şeker Miktarını Giriniz:");
            sugarAmount += scanner.nextInt();
            Gains = sugarAmount * sugarPrice;
            System.out.println(Gains);
        }
        return new Double[]{Gains, sugarPrice, sugarAmount};
    }

    public static Double[] StableFall(Double Gains,Double sugarPrice, Double sugarAmount) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        for (int i = 0; i <= 5; i++) {
            System.out.println("Şeker Fiyatı: " + sugarPrice);
            sugarPrice *= rand.nextDouble(0.1, 1.2);
            System.out.println("\r Almak İstediğiniz Şeker Miktarını Giriniz:");
            sugarAmount += scanner.nextInt();
            Gains = sugarAmount * sugarPrice;
            System.out.println(Gains);

        }
        return new Double[]{Gains, sugarPrice, sugarAmount};
    }

    public  Double[] FastRise(Double Gains,Double sugarPrice, Double sugarAmount) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        for (int i = 0; i < 2; i++) {
            System.out.println("Şeker Fiyatı: " + sugarPrice);
            sugarPrice *= rand.nextDouble(0.8, 5);
            System.out.println("\r Almak İstediğiniz Şeker Miktarını Giriniz:");
            sugarAmount += scanner.nextInt();
            Gains = sugarAmount * sugarPrice;
            System.out.println(Gains);

        }
        return new Double[]{Gains, sugarPrice, sugarAmount};
    }

    public  Double[] FastFall(Double Gains,Double sugarPrice, Double sugarAmount) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        for (int i = 0; i < 2; i++) {
            System.out.println("Şeker Fiyatı: " + Math.round(sugarPrice * 100.0) / 100.0);
            sugarPrice *= rand.nextDouble(0.01, 1.2);
            System.out.println("\r Almak İstediğiniz Şeker Miktarını Giriniz:");
            sugarAmount += scanner.nextInt();
            Gains = sugarAmount * sugarPrice;
            System.out.println(Gains);

        }
        return new Double[]{Gains, sugarPrice, sugarAmount};
    }

    public  Double[] Play(Double Gains,Double sugarPrice, Double sugarAmount) {

        Double[] RETURNARRAY = new Double[3];
        RETURNARRAY[1] = sugarPrice;RETURNARRAY[2] =sugarAmount;
        switch (MarketState()) {
            case 1:
                RETURNARRAY =StableRise(Gains,sugarPrice, sugarAmount);
                break;
            case 2:
                RETURNARRAY = StableFall(Gains,sugarPrice, sugarAmount);
                break;
            case 3:
                RETURNARRAY =FastRise(Gains,sugarPrice, sugarAmount);
                break;
            case 4:
                RETURNARRAY =FastFall(Gains,sugarPrice, sugarAmount);
                break;
        }
        return RETURNARRAY;
    }
}
