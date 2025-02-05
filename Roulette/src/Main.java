import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        double money = 1000;
        boolean playAgain = true;

        while (playAgain) {
            boolean validInput = false;
            int winnerNumber = rand.nextInt(1, 37);

            System.out.println("How much money do you want to bet?");
            double betMoney = scan.nextDouble();

            // Ensure the player has enough money to bet
            if (betMoney > money) {
                System.out.println("You do not have enough money to place this bet.");
                continue;
            }

            money -= betMoney;

            System.out.println("In where you want to bet? \n 1 Red \n 2 Green \n 3 First Half \n 4 Second Half \n 5 First Line \n 6 Second Line \n 7 Third Line \n 8 First Twelve \n 9 Second Twelve \n 10 Third Twelve \n Or enter 11 if you want to play on a number");
            int betGroup = scan.nextInt();

            Machine machine = new Machine(betGroup, betMoney, money, winnerNumber);
            machine.play();

            System.out.println("Do you want to play again? (true/false)");

            while (!validInput) {
                String response = scan.next();
                if (response.equalsIgnoreCase("true")) {
                    validInput = true;
                    playAgain = true;
                } else if (response.equalsIgnoreCase("false")) {
                    validInput = true;
                    playAgain = false;
                } else {
                    System.out.println("Please enter a valid input (true/false).");
                }
            }
        }
    }
}
