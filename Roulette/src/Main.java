import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random number = new Random();
        Scanner bet = new Scanner(System.in);

        int[] red = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
        int[] green = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
        int[] firstHalf = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        int[] secondHalf = {19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
        int[] firstLine = {1,4,7,10,13,16,19,22,25,28,31,34};
        int[] secondtLine = {2,5,8,11,14,17,20,23,26,29,32,35};
        int[] thirdLine = {3,6,9,12,15,18,21,24,27,30,33,36};
        int[] firstTwelve = {1,2,3,4,5,6,7,8,9,10,11,12};
        int[] secondTwelve = {13,14,15,16,17,18,19,20,21,22,23,24};
        int[] thirdTwelve = {25,26,27,28,29,30,31,32,33,34,35,36};
        int[] odd = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
        int[] even = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};

        System.out.println("How much money do you want to bet?");
        int betMoney = bet.nextInt();
        System.out.println("In where you want to bet? \n 1 Red \n 2 Green \n 3 First Half \n 4 Second Half \n 5 First Line \n 6 Second Line \n 7 Third Line \n 8 First Twelve \n 9 Second Twelve \n 10 Third Twelve \n 11 Odd \n 12 Even");
        int group = bet.nextInt();
        if (0 < group < 12){
            System.out.println("How much money do you want to bet?");
        }
    }
}