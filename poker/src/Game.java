//♠ ♥ ♦ ♣
import java.util.Random;

public class Game {
    Random rand = new Random();

    int[] Deck = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52
    };

    int firstPairCount;
    int secondPairCount;
    int samePairCount;
    int flushCount;
    int deckValue;
    //0 High-Card
    //1 One pair
    //2 Two Pair
    //3 Three of a Kind
    //4 Straight
    //5 Flush
    //6 Full House
    //7 Four of a Kind
    //8 Straight Flush
    //9 Royal Flush

    int[] FirstPlayer = {0, 0};
    String[] FirstPlayerHand = {"0", "0"};
    int[] SecondPlayer = {0, 0};
    String[] SecondPlayerHand = {"0", "0"};
    int[] User = {0, 0};
    String[] UserHand = {"0", "0"};
    int[] ThirdPlayer = {0, 0};
    String[] ThirdPlayerHand = {"0", "0"};
    int[] FourthPlayer = {0, 0};
    String[] FourthPlayerHand = {"0", "0"};

    int[] Bank = {0, 0, 0, 0, 0};
    String[] BankHand = {"0", "0", "0", "0", "0"};
    String[] BankHandTry = {"0", "0", "0", "0", "0"};

    public void GameOpening(){

        System.out.println("Shuffling Cards");

        giveCard(FirstPlayer, 0);
        setCards(FirstPlayerHand, 0, FirstPlayer[0]);
        giveCard(SecondPlayer, 0);
        setCards(SecondPlayerHand, 0, SecondPlayer[0]);
        giveCard(User, 0);
        setCards(UserHand, 0, User[0]);
        giveCard(ThirdPlayer, 0);
        setCards(ThirdPlayerHand, 0, ThirdPlayer[0]);
        giveCard(FourthPlayer, 0);
        setCards(FourthPlayerHand, 0, FourthPlayer[0]);

        giveCard(FirstPlayer, 1);
        setCards(FirstPlayerHand, 1, FirstPlayer[1]);
        giveCard(SecondPlayer, 1);
        setCards(SecondPlayerHand, 1, SecondPlayer[1]);
        giveCard(User, 1);
        setCards(UserHand, 1, User[1]);
        giveCard(ThirdPlayer, 1);
        setCards(ThirdPlayerHand, 1, ThirdPlayer[1]);
        giveCard(FourthPlayer, 1);
        setCards(FourthPlayerHand, 1, FourthPlayer[1]);

        System.out.print("Your cards are... ");
        System.out.print(UserHand[0] + " ");
        System.out.println(UserHand[1]);
    }

    public void MidGame(){
        giveCard(Bank, 0);
        setCards(BankHand, 0, Bank[0]);
        System.out.println("First Card is : " + BankHand[0]);
        giveCard(Bank, 1);
        setCards(BankHand, 1, Bank[1]);
        System.out.println("Second Card is : " + BankHand[1]);
        giveCard(Bank, 2);
        setCards(BankHand, 2, Bank[2]);
        System.out.println("Third Card is : " + BankHand[2]);
    }

    public void FourthCard(){
        giveCard(Bank, 3);
        setCards(BankHand, 3, Bank[3]);
        System.out.println("Fourth Card is : " + BankHand[3]);
    }

    public void TheLastCard(){
        giveCard(Bank, 4);
        setCards(BankHand, 4, Bank[4]);
        System.out.println("The Last Card Is : " + BankHand[4]);
    }

    public void theAbsoluteTortureToMyself(){
        for (int i = 0; i<4; i++){
            for (int ii = i+1; ii<5; ii++){
                System.arraycopy(BankHand, 0, BankHandTry, 0, 5);

                BankHandTry[i] = UserHand[0];
                BankHandTry[ii] = UserHand[1];

                for (int j= 0; j<4; j++){
                    for (int jj = j+1; jj<5; jj++){
                        if (Integer.parseInt(BankHandTry[jj].substring(1))<Integer.parseInt(BankHandTry[j].substring(1))){
                            String jjj = BankHandTry[j];
                            BankHandTry[j] = BankHandTry[jj];
                            BankHandTry[jj] = jjj;
                        }
                    }
                }

                if (Integer.parseInt(UserHand[0].substring(1)) == Integer.parseInt(UserHand[1].substring(1))){
                    for (int iii = 0; iii < 4; iii++){
                        for (int iiii = iii + 1; iiii < 5; iiii++){
                            if (Integer.parseInt(BankHandTry[iii].substring(1)) == Integer.parseInt(BankHandTry[iiii].substring(1))){
                                samePairCount++;
                            }
                        }
                    }

                    switch (samePairCount){
                        case 1:
                            System.out.println("You have a pair");
                            if (deckValue<1){
                                deckValue = 1;
                            }
                            break;
                        case 3:
                            System.out.println("You have three of a kind");
                            if (deckValue<3){
                                deckValue = 3;
                            }
                            break;
                        case 6:
                            System.out.println("You have four of a kind");
                            if (deckValue<7){
                                deckValue = 7;
                            }
                            break;
                    }

                }else {
                    for (int iii = 0; iii < 4; iii++){
                        for (int iiii = iii + 1; iiii < 5; iiii++){
                            if (Integer.parseInt(BankHandTry[iii].substring(1)) == Integer.parseInt(BankHandTry[iiii].substring(1))){
                                if (Integer.parseInt(BankHandTry[iii].substring(1)) == Integer.parseInt(UserHand[0].substring(1))){
                                    firstPairCount++;
                                } else if (Integer.parseInt(BankHandTry[iii].substring(1)) == Integer.parseInt(UserHand[1].substring(1))){
                                    secondPairCount++;
                                }
                            }
                        }
                    }

                    switch (firstPairCount){
                        case 1:
                            switch (secondPairCount){
                                case 1:
                                    System.out.println("You have two pair");
                                    if (deckValue<2){
                                        deckValue = 2;
                                    }
                                    break;
                                case 3:
                                    System.out.println("You have Full House");
                                    if (deckValue<6){
                                        deckValue = 6;
                                    }
                                    break;
                                default:
                                    System.out.println("You have a pair");
                                    if (deckValue<1){
                                        deckValue = 1;
                                    }
                                    break;
                            }
                            break;
                        case 3:
                            switch (secondPairCount){
                                case 1:
                                    System.out.println("You have Full House");
                                    if (deckValue<6){
                                        deckValue = 6;
                                    }
                                    break;
                                default:
                                    System.out.println("You have three of a kind");
                                    if (deckValue<3){
                                        deckValue = 3;
                                    }
                                    break;
                            }
                            break;
                        default:
                            switch (secondPairCount){
                                case 1:
                                    System.out.println("You have a pair");
                                    if (deckValue<1){
                                        deckValue = 1;
                                    }
                                    break;
                                case 3:
                                    System.out.println("You have three of a kind");
                                    if (deckValue<3){
                                        deckValue = 3;
                                    }
                                    break;
                                case 6:
                                    System.out.println("You have four of a kind");
                                    if (deckValue<7){
                                        deckValue = 7;
                                    }
                            }
                    }
                }

                if (samePairCount == 0 && firstPairCount == 0){
                    for (int iii = 0; iii < 4; iii++){
                        for (int iiii = iii + 1; iiii < 5; iiii++){
                            if (BankHandTry[iii].charAt(0) == BankHandTry[iiii].charAt(0)){
                                flushCount++;
                            }
                        }
                    }
                }

                if (flushCount == 10){
                    System.out.println("You have a flush");
                    if (deckValue<5){
                        deckValue = 5;
                    }
                }



                flushCount = 0;
                samePairCount = 0;
                firstPairCount = 0;
                secondPairCount = 0;

                for (int iii = 0; iii<5; iii++){
                    System.out.println(BankHandTry[iii]);
                }
                System.out.println(" ");
            }
        }
        System.out.println("Your deck value is : " + deckValue);
    }

    public int checkRaise(int raise, int ante){
        if (raise<ante){
            System.out.println("You can't raise under ante! Your raise is set to 15.");
            raise = 15;
        }
        return raise;
    }

    public void giveCard(int[] player, int card){
        player[card] = rand.nextInt(0, 52);
        while(Deck[player[card]] == 0){
            player[card] = rand.nextInt(0, 52);
        }
        Deck[player[card]] = 0;
    }

    public void setCards(String[] player, int cardNumber, int cardID){
        switch (cardID){
            case 0:
                player[cardNumber] = "♣14";
                break;
            case 1:
                player[cardNumber] = "♣2";
                break;
            case 2:
                player[cardNumber] = "♣3";
                break;
            case 3:
                player[cardNumber] = "♣4";
                break;
            case 4:
                player[cardNumber] = "♣5";
                break;
            case 5:
                player[cardNumber] = "♣6";
                break;
            case 6:
                player[cardNumber] = "♣7";
                break;
            case 7:
                player[cardNumber] = "♣8";
                break;
            case 8:
                player[cardNumber] = "♣9";
                break;
            case 9:
                player[cardNumber] = "♣10";
                break;
            case 10:
                player[cardNumber] = "♣11";
                break;
            case 11:
                player[cardNumber] = "♣12";
                break;
            case 12:
                player[cardNumber] = "♣13";
                break;
            case 13:
                player[cardNumber] = "♦14";
                break;
            case 14:
                player[cardNumber] = "♦2";
                break;
            case 15:
                player[cardNumber] = "♦3";
                break;
            case 16:
                player[cardNumber] = "♦4";
                break;
            case 17:
                player[cardNumber] = "♦5";
                break;
            case 18:
                player[cardNumber] = "♦6";
                break;
            case 19:
                player[cardNumber] = "♦7";
                break;
            case 20:
                player[cardNumber] = "♦8";
                break;
            case 21:
                player[cardNumber] = "♦9";
                break;
            case 22:
                player[cardNumber] = "♦10";
                break;
            case 23:
                player[cardNumber] = "♦11";
                break;
            case 24:
                player[cardNumber] = "♦12";
                break;
            case 25:
                player[cardNumber] = "♦13";
                break;
            case 26:
                player[cardNumber] = "♥14";
                break;
            case 27:
                player[cardNumber] = "♥2";
                break;
            case 28:
                player[cardNumber] = "♥3";
                break;
            case 29:
                player[cardNumber] = "♥4";
                break;
            case 30:
                player[cardNumber] = "♥5";
                break;
            case 31:
                player[cardNumber] = "♥6";
                break;
            case 32:
                player[cardNumber] = "♥7";
                break;
            case 33:
                player[cardNumber] = "♥8";
                break;
            case 34:
                player[cardNumber] = "♥9";
                break;
            case 35:
                player[cardNumber] = "♥10";
                break;
            case 36:
                player[cardNumber] = "♥11";
                break;
            case 37:
                player[cardNumber] = "♥12";
                break;
            case 38:
                player[cardNumber] = "♥13";
                break;
            case 39:
                player[cardNumber] = "♠14";
                break;
            case 40:
                player[cardNumber] = "♠2";
                break;
            case 41:
                player[cardNumber] = "♠3";
                break;
            case 42:
                player[cardNumber] = "♠4";
                break;
            case 43:
                player[cardNumber] = "♠5";
                break;
            case 44:
                player[cardNumber] = "♠6";
                break;
            case 45:
                player[cardNumber] = "♠7";
                break;
            case 46:
                player[cardNumber] = "♠8";
                break;
            case 47:
                player[cardNumber] = "♠9";
                break;
            case 48:
                player[cardNumber] = "♠10";
                break;
            case 49:
                player[cardNumber] = "♠11";
                break;
            case 50:
                player[cardNumber] = "♠12";
                break;
            case 51:
                player[cardNumber] = "♠13";
                break;
        }
    }
}
