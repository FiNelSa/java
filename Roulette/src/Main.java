import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random number = new Random();
        Scanner scan = new Scanner(System.in);
        int money = 1000;
        boolean a = true;

        int[] first = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};//red
        int[] second = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};//green
        int[] third = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};//first half
        int[] fourth = {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};//second half
        int[] fifth = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};//first line
        int[] sixth = {2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35};//second line
        int[] seventh = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};//third line
        int[] eighth = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};//first twelfth
        int[] nineth = {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};//second twelfth
        int[] tenth = {25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};//third twelfth

        while (a){

        int winnerNumber = number.nextInt(0, 37);

        System.out.println("How much money do you want to bet?");
        int betMoney = scan.nextInt();
        money -= betMoney;

        System.out.println("In where you want to bet? \n 1 Red \n 2 Green \n 3 First Half \n 4 Second Half \n 5 First Line \n 6 Second Line \n 7 Third Line \n 8 First Twelve \n 9 Second Twelve \n 10 Third Twelve \n Or enter 11 if u want to play on a number");
        int betGroup = scan.nextInt();

        switch (betGroup){
            case 1:
                for (int i = 0; i < 18; i++){
                    if (first[i] == winnerNumber){
                        money += 2*betMoney;
                        System.out.println("You won, money : " + money);
                        break;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 18; i++){
                    if (second[i] == winnerNumber){
                        money += 2*betMoney;
                        System.out.println("You won, money : " + money);
                        break;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < 18; i++){
                    if (third[i] == winnerNumber){
                        money += 2*betMoney;
                        System.out.println("You won, money : " + money);
                        break;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < 18; i++){
                    if (fourth[i] == winnerNumber){
                        money += 2*betMoney;
                        System.out.println("You won, money : " + money);
                        break;
                    }
                }
                break;
            case 5:
                for (int i = 0; i < 12; i++){
                    if (fifth[i] == winnerNumber){
                        money += 3*betMoney;
                        System.out.println("You won, money : " + money);
                        break;
                    }
                }
                break;
            case 6:
                for (int i = 0; i < 12; i++){
                    if (sixth[i] == winnerNumber){
                        money += 3*betMoney;
                        System.out.println("You won, money : " + money);
                        break;
                    }
                }
            case 7:
                for (int i = 0; i < 12; i++){
                    if (seventh[i] == winnerNumber){
                        money += 3*betMoney;
                        System.out.println("You won, money : " + money);
                        break;
                    }
                }
            case 8:
                for (int i = 0; i < 12; i++){
                    if (eighth[i] == winnerNumber){
                        money += 3*betMoney;
                        System.out.println("You won, money : " + money);
                        break;
                    }
                }
                break;
            case 9:
                for (int i = 0; i < 12; i++){
                    if (nineth[i] == winnerNumber){
                        money += 3*betMoney;
                        System.out.println("You won, money : " + money);
                        break;
                    }
                }
                break;
            case 10:
                for (int i = 0; i < 12; i++){
                    if (tenth[i] == winnerNumber){
                        money += 3*betMoney;
                        System.out.println("You won, money : " + money);
                        break;
                    }
                }
                break;
            case 11:
                System.out.println("Enter the number you want to bet on");
                int betNumber = scan.nextInt();
                if (betNumber==winnerNumber){
                    money += 36*betMoney;
                    System.out.println("You won, money : " + money);
                }
                break;
            }

            System.out.println("Do you want to play again");
            a = scan.nextBoolean();
        }
    }
}