import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        StockBase stockbase = new BoeingStock();

        Double stockprice =stockbase.stockPrice;
        Double stockAmount = 0.0;
        Double Gains = 0.0;
        Double[] Values = {Gains,stockprice,stockAmount};
        while (true) {
            //eklemeler yapılacak
            System.out.println("Hangi hisseye yatırım yapmak istersiniz: ");
            System.out.println("1-Boeing");
            System.out.println("2-Tuz");
            System.out.println("3-Ekmek");
            int VictimChoice = scanner.nextInt();
            switch (VictimChoice) {
                case 1:
                    Values = stockbase.Play(Values[0],Values[1], Values[2]);
                    break;
            }

        }
    }
}