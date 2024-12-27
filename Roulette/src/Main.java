import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int money = 1000;

        int[] red =             {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36};
        int[] green =           {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
        int[] firstHalf =       {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        int[] secondHalf =      {19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
        // Üsttekilerin 18 elemanı varken alttakilerin 12, bu yüzden ayrı for döngülerinde çalışacaklar.
        int[] firstLine =       {1,4,7,10,13,16,19,22,25,28,31,34};
        int[] secondLine =      {2,5,8,11,14,17,20,23,26,29,32,35};
        int[] thirdLine =       {3,6,9,12,15,18,21,24,27,30,33,36};
        int[] firstTwelve =     {1,2,3,4,5,6,7,8,9,10,11,12};
        int[] secondTwelve =    {13,14,15,16,17,18,19,20,21,22,23,24};
        int[] thirdTwelve =     {25,26,27,28,29,30,31,32,33,34,35,36};

        System.out.println("In where you want to bet? \n 1 Red \n 2 Green \n 3 First Half \n 4 Second Half \n 5 First Line \n 6 Second Line \n 7 Third Line \n 8 First Twelve \n 9 Second Twelve \n 10 Third Twelve");
        int betGroup = scan.nextInt();
        System.out.println("How much money do you want to bet?");
        int betMoney = scan.nextInt();
        money -= betMoney;

            int winNumber = rand.nextInt(0, 36);

            if (betGroup == 1 & betGroup == 2 & betGroup == 3 & betGroup == 4){
                for (int i = 0; i < 18; i++){
                    if (betGroup == 1){
                        if (red[i] == winNumber){
                            System.out.println("You won");
                            money += betMoney * 2;
                            System.out.println(money);
                            break;
                        }
                    }
                    if (betGroup == 2){
                        if (green[i] == winNumber){
                            System.out.println("You won");
                            money += betMoney * 2;
                            System.out.println(money);
                            break;
                        }
                    }
                    if (betGroup == 3){
                        if (firstHalf[i] == winNumber){
                            System.out.println("You won");
                            money += betMoney * 2;
                            System.out.println(money);
                            break;
                        }
                    }
                    if (betGroup == 4){
                        if (secondHalf[i] == winNumber){
                            System.out.println("You won");
                            money += betMoney * 2;
                            System.out.println(money);
                            break;
                        }
                    }
                }
            }else {
                for (int i = 0; i < 12; i++){

                    if (betGroup == 5){
                        if (firstLine[i] == winNumber){
                            System.out.println("You won");
                            money += betMoney * 2;
                            System.out.println(money);
                            break;
                        }
                    }
                    if (betGroup == 6){
                        if (secondLine[i] == winNumber){
                            System.out.println("You won");
                            money += betMoney * 2;
                            System.out.println(money);
                            break;
                        }
                    }
                    if (betGroup == 7){
                        if (thirdLine[i] == winNumber){
                            System.out.println("You won");
                            money += betMoney * 2;
                            System.out.println(money);
                            break;
                        }
                    }
                    if (betGroup == 8){
                        if (firstTwelve[i] == winNumber){
                            System.out.println("You won");
                            money += betMoney * 2;
                            System.out.println(money);
                            break;
                        }
                    }
                    if (betGroup == 9){
                        if (secondTwelve[i] == winNumber){
                            System.out.println("You won");
                            money += betMoney * 2;
                            System.out.println(money);
                            break;
                        }
                    }
                    if (betGroup == 10){
                        if (thirdTwelve[i] == winNumber){
                            System.out.println("You won");
                            money += betMoney * 2;
                            System.out.println(money);
                            break;
                        }
                    }
                }
            }
    }
}