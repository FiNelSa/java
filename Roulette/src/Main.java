import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int money = 1000;
        boolean a = true;

        while (a){
            boolean validInput = false;
            int winnerNumber = rand.nextInt(1, 37);
            System.out.println(winnerNumber);

            System.out.println("How much money do you want to bet?");
            int betMoney = scan.nextInt();
            money -= betMoney;

            System.out.println("In where you want to bet? \n 1 Red \n 2 Green \n 3 First Half \n 4 Second Half \n 5 First Line \n 6 Second Line \n 7 Third Line \n 8 First Twelve \n 9 Second Twelve \n 10 Third Twelve \n Or enter 11 if u want to play on a number");
            int betGroup = scan.nextInt();

            Machine machine = new Machine(betGroup, betMoney, money, winnerNumber);
            machine.getMoney();

            System.out.print("Do you want to play again?\n");
            while (!validInput) {
                a = Boolean.parseBoolean(scan.next().trim());
                if (a){
                    validInput = true;
                }else if (!a){
                    validInput = true;
                }else {
                    System.out.println("Please enter a valid input");
                }
            }
        }
    }
}