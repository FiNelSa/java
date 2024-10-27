import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random number = new Random();
        Scanner bet = new Scanner(System.in);

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
        int[] eleventh = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};//odd
        int[] twelfth = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};//even
        int winnerNumber = number.nextInt(1 , 37);
        System.out.println(winnerNumber);


        System.out.println("How much money do you want to bet?");
        int betMoney = bet.nextInt();

        int sayiIndex = Array.getInt()
    }
}