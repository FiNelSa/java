import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static int MarketState() {
        Random rand = new Random();
        int[] StateDefiner = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4};
        return StateDefiner[rand.nextInt(0, StateDefiner.length)];
    }

    public static Double[] StableRise(Double Gains,Double sugarPrice, Double sugarAmount, Double yeniSugar, Double eskiSugar) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Double> arr = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            System.out.println("Şeker Fiyatı: " + sugarPrice);
            eskiSugar = yeniSugar;
            arr.add(eskiSugar);
            sugarPrice *= rand.nextDouble(0.7, 1.8);
            yeniSugar = sugarPrice;
            arr.add(yeniSugar);
            double toplam = 0;
            for (double say : arr) {
                toplam = say;
            }
            Double nextSugar =(toplam/arr.size()+yeniSugar);
            System.out.println("Sonraki değer tahminlerime göre " + nextSugar + " olabilir.");
            System.out.println("\r Almak İstediğiniz Şeker Miktarını Giriniz:");
            sugarAmount += scanner.nextInt();
            Gains = sugarAmount * sugarPrice;
            System.out.println(Gains);
        }
        return new Double[]{Gains, sugarPrice, sugarAmount, yeniSugar,  eskiSugar};
    }

    public static Double[] StableFall(Double Gains,Double sugarPrice, Double sugarAmount, Double yeniSugar, Double eskiSugar) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Double> arr = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            System.out.println("Şeker Fiyatı: " + sugarPrice);
            eskiSugar = yeniSugar;
            arr.add(eskiSugar);
            sugarPrice *= rand.nextDouble(0.1, 1.2);
            yeniSugar = sugarPrice;
            arr.add(yeniSugar);
            double toplam = 0;
            for (double say : arr) {
                toplam = say;
            }
            Double nextSugar =(toplam/arr.size()+yeniSugar)/2;
            System.out.println("Sonraki değer tahminlerime göre " + nextSugar + " olabilir.");
            System.out.println("\r Almak İstediğiniz Şeker Miktarını Giriniz:");
            sugarAmount += scanner.nextInt();
            Gains = sugarAmount * sugarPrice;
            System.out.println(Gains);

        }
        return new Double[]{Gains, sugarPrice, sugarAmount, yeniSugar,  eskiSugar};
    }

    public static Double[] FastRise(Double Gains,Double sugarPrice, Double sugarAmount, Double yeniSugar, Double eskiSugar) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Double> arr = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.println("Şeker Fiyatı: " + sugarPrice);
            eskiSugar = yeniSugar;
            arr.add(eskiSugar);
            sugarPrice *= rand.nextDouble(0.8, 5);
            yeniSugar = sugarPrice;
            arr.add(yeniSugar);
            double toplam = 0;
            for (double say : arr) {
                toplam = say;
            }
            Double nextSugar =(toplam/arr.size()+yeniSugar)/2;
            System.out.println("Sonraki değer tahminlerime göre " + nextSugar + " olabilir.");
            System.out.println("\r Almak İstediğiniz Şeker Miktarını Giriniz:");
            sugarAmount += scanner.nextInt();
            Gains = sugarAmount * sugarPrice;
            System.out.println(Gains);

        }
        return new Double[]{Gains, sugarPrice, sugarAmount, yeniSugar, eskiSugar};
    }

    public static Double[] FastFall(Double Gains,Double sugarPrice, Double sugarAmount, Double yeniSugar, Double eskiSugar) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Double> arr = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.println("Şeker Fiyatı: " + Math.round(sugarPrice * 100.0) / 100.0);
            eskiSugar = yeniSugar;
            arr.add(eskiSugar);
            sugarPrice *= rand.nextDouble(0.01, 1.2);
            yeniSugar = sugarPrice;
            arr.add(yeniSugar);
            double toplam = 0;
            for (double say : arr) {
                toplam = say;
            }
            Double nextSugar =(toplam/arr.size()+yeniSugar)/2;
            System.out.println("Sonraki değer tahminlerime göre " + nextSugar + " olabilir.");
            System.out.println("\r Almak İstediğiniz Şeker Miktarını Giriniz:");
            sugarAmount += scanner.nextInt();
            Gains = sugarAmount * sugarPrice;
            System.out.println(Gains);

        }
        return new Double[]{Gains, sugarPrice, sugarAmount, yeniSugar,  eskiSugar};
    }

    public static Double[] Play(Double Gains,Double sugarPrice, Double sugarAmount, Double yeniSugar, Double eskiSugar) {

        Double[] RETURNARRAY = new Double[3];
        RETURNARRAY[1] = sugarPrice;RETURNARRAY[2] =sugarAmount;
        switch (MarketState()) {
            case 1:
                RETURNARRAY =StableRise(Gains, sugarPrice, sugarAmount, yeniSugar, eskiSugar);
                break;
            case 2:
                RETURNARRAY = StableFall(Gains, sugarPrice, sugarAmount, yeniSugar, eskiSugar);
                break;
            case 3:
                RETURNARRAY =FastRise(Gains, sugarPrice, sugarAmount, yeniSugar, eskiSugar);
                break;
            case 4:
                RETURNARRAY =FastFall(Gains, sugarPrice, sugarAmount, yeniSugar, eskiSugar);
                break;
        }
        return RETURNARRAY;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        Double sugarPrice = 10.0;
        Double yeniSugar = 0.0;
        Double eskiSugar = sugarPrice;
        Double sugarAmount = 0.0;
        Double Gains = 0.0;
        Double[] Values = {Gains,sugarPrice,sugarAmount, yeniSugar, eskiSugar};
        while (true) {
            //eklemeler yapılacak
            System.out.println("Hangi hisseye yatırım yapmak istersiniz: ");
            System.out.println("1-Şeker");
            System.out.println("2-Tuz");
            System.out.println("3-Ekmek");
            int VictimChoice = scanner.nextInt();
            switch (VictimChoice) {
                case 1:
                    Values = Play(Values[0],Values[1], Values[2], Values[3], Values[4]);
                    break;
            }
        }
    }
}
