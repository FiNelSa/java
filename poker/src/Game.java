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

    boolean royalFlush;
    boolean straightFlush;
    int firstPairCount;
    int secondPairCount;
    int samePairCount;
    int flushCount;
    int straightCount;
    int firstBet;
    int secondBet;
    int thirdBet;
    int fourthBet;
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
        firstBet = rand.nextInt(15, 30);
        secondBet = rand.nextInt(15, 30);
        thirdBet = rand.nextInt(15, 30);
        fourthBet = rand.nextInt(15, 30);

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

        System.arraycopy(BankHand, 0, BankHandTry, 0, 5);

        System.out.print("Your cards are... ");
        System.out.print(UserHand[0] + " ");
        System.out.println(UserHand[1]);

        System.out.println("First player's bet is : " + Player(FirstPlayerHand, BankHandTry, 0, firstBet));
        System.out.println("Second player's bet is : " + Player(SecondPlayerHand, BankHandTry, 0, secondBet));
        System.out.println("Third player's bet is : " + Player(ThirdPlayerHand, BankHandTry, 0, thirdBet));
        System.out.println("Fourth player's bet is : " + Player(FourthPlayerHand, BankHandTry, 0, fourthBet));
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


        System.out.print("First player's bet is : ");
        System.out.println(Player(FirstPlayerHand, BankHandTry, 3, firstBet));
        System.out.print("Second player's bet is : ");
        System.out.println(Player(SecondPlayerHand, BankHandTry, 3, secondBet));
        System.out.print("Third player's bet is : ");
        System.out.println(Player(ThirdPlayerHand, BankHandTry, 3, thirdBet));
        System.out.print("Fourth player's bet is : ");
        System.out.println(Player(FourthPlayerHand, BankHandTry, 3, fourthBet));
    }

    public void FourthCard(){
        giveCard(Bank, 3);
        setCards(BankHand, 3, Bank[3]);
        System.out.println("Fourth Card is : " + BankHand[3]);

        System.out.println("First player's bet is : " + Player(FirstPlayerHand, BankHandTry, 4, firstBet));
        System.out.println("Second player's bet is : " + Player(SecondPlayerHand, BankHandTry, 4, secondBet));
        System.out.println("Third player's bet is : " + Player(ThirdPlayerHand, BankHandTry, 4, thirdBet));
        System.out.println("Fourth player's bet is : " + Player(FourthPlayerHand, BankHandTry, 4, fourthBet));
    }

    public void TheLastCard(){
        giveCard(Bank, 4);
        setCards(BankHand, 4, Bank[4]);
        System.out.println("The Last Card Is : " + BankHand[4]);

        System.out.println("First player's bet is : " + Player(FirstPlayerHand, BankHandTry, 5, firstBet));
        System.out.println("Second player's bet is : " + Player(SecondPlayerHand, BankHandTry, 5, secondBet));
        System.out.println("Third player's bet is : " + Player(ThirdPlayerHand, BankHandTry, 5, thirdBet));
        System.out.println("Fourth player's bet is : " + Player(FourthPlayerHand, BankHandTry, 5, fourthBet));
    }

    public int Calculation(int money, int bet){
        int firstValue = theAbsoluteTortureToMyself(BankHandTry, FirstPlayerHand);
        int secondValue = theAbsoluteTortureToMyself(BankHandTry, SecondPlayerHand);
        int userValue = theAbsoluteTortureToMyself(BankHandTry, UserHand);
        int thirdValue = theAbsoluteTortureToMyself(BankHandTry, ThirdPlayerHand);
        int fourthValue = theAbsoluteTortureToMyself(BankHandTry, FourthPlayerHand);

        int[] values = {firstValue, secondValue, userValue, thirdValue, fourthValue};

        System.out.println("First Player's hand is :");
        for (int j = 0; j<2; j++){
            System.out.println(FirstPlayerHand[j]);
        }
        System.out.println("Second Player's hand is :");
        for (int j = 0; j<2; j++){
            System.out.println(SecondPlayerHand[j]);
        }
        System.out.println("Third Player's hand is :");
        for (int j = 0; j<2; j++){
            System.out.println(ThirdPlayerHand[j]);
        }
        System.out.println("Fourth Player's hand is :");
        for (int j = 0; j<2; j++){
            System.out.println(FourthPlayerHand[j]);
        }

        int winner = userValue;
        for (int j = 0; j<5; j++){
            if (winner<values[j]){
                winner = values[j];
            }
        }

        if (winner == firstValue){
            System.out.println("First player has won");
        }else if (winner == secondValue){
            System.out.println("Second player has won");
        }else if (winner == thirdValue){
            System.out.println("Third player has won");
        } else if (winner == fourthValue){
            System.out.println("Fourth player has won");
        } else if (winner == userValue){
            System.out.println("You have won");
        }

        return money - bet;
    }

    public int theAbsoluteTortureToMyself(String[] bank, String[] user){
        for (int i = 0; i<4; i++){
            for (int ii = i+1; ii<5; ii++){
                System.arraycopy(BankHand, 0, bank, 0, 5);

                bank[i] = user[0];
                bank[ii] = user[1];

                for (int j= 0; j<4; j++){
                    for (int jj = j+1; jj<5; jj++){
                        if (Integer.parseInt(bank[jj].substring(1))<Integer.parseInt(bank[j].substring(1))){
                            String jjj = bank[j];
                            bank[j] = bank[jj];
                            bank[jj] = jjj;
                        }
                    }
                }

                if (Integer.parseInt(user[0].substring(1)) == Integer.parseInt(user[1].substring(1))){
                    for (int iii = 0; iii < 4; iii++){
                        for (int iiii = iii + 1; iiii < 5; iiii++){
                            if (Integer.parseInt(bank[iii].substring(1)) == Integer.parseInt(bank[iiii].substring(1))){
                                samePairCount++;
                            }
                        }
                    }

                    switch (samePairCount){
                        case 1:
                            if (deckValue<1){
                                deckValue = 1;
                            }
                            break;
                        case 3:
                            if (deckValue<3){
                                deckValue = 3;
                            }
                            break;
                        case 6:
                            if (deckValue<7){
                                deckValue = 7;
                            }
                            break;
                    }

                }else {
                    for (int iii = 0; iii < 4; iii++){
                        for (int iiii = iii + 1; iiii < 5; iiii++){
                            if (Integer.parseInt(bank[iii].substring(1)) == Integer.parseInt(bank[iiii].substring(1))){
                                if (Integer.parseInt(bank[iii].substring(1)) == Integer.parseInt(user[0].substring(1))){
                                    firstPairCount++;
                                } else if (Integer.parseInt(bank[iii].substring(1)) == Integer.parseInt(user[1].substring(1))){
                                    secondPairCount++;
                                }
                            }
                        }
                    }

                    switch (firstPairCount){
                        case 1:
                            switch (secondPairCount){
                                case 1:
                                    if (deckValue<2){
                                        deckValue = 2;
                                    }
                                    break;
                                case 3:
                                    if (deckValue<6){
                                        deckValue = 6;
                                    }
                                    break;
                                default:
                                    if (deckValue<1){
                                        deckValue = 1;
                                    }
                                    break;
                            }
                            break;
                        case 3:
                            switch (secondPairCount){
                                case 1:
                                    if (deckValue<6){
                                        deckValue = 6;
                                    }
                                    break;
                                default:
                                    if (deckValue<3){
                                        deckValue = 3;
                                    }
                                    break;
                            }
                            break;
                        default:
                            switch (secondPairCount){
                                case 1:
                                    if (deckValue<1){
                                        deckValue = 1;
                                    }
                                    break;
                                case 3:
                                    if (deckValue<3){
                                        deckValue = 3;
                                    }
                                    break;
                                case 6:
                                    if (deckValue<7){
                                        deckValue = 7;
                                    }
                            }
                    }
                }

                if (samePairCount == 0 && firstPairCount == 0){
                    for (int iii = 0; iii < 4; iii++){
                        for (int iiii = iii + 1; iiii < 5; iiii++){
                            if (bank[iii].charAt(0) == bank[iiii].charAt(0)){
                                flushCount++;
                            }
                        }
                    }
                }

                if (flushCount == 10){
                    if (deckValue<5){
                        deckValue = 5;
                    }
                }

                for (int j = 0; j<4; j++){
                    if (Integer.parseInt(bank[j].substring(1)) + 1 == Integer.parseInt(bank[j+1].substring(1))){
                        straightCount++;
                    }
                }

                if (straightCount == 4){
                    if (flushCount == 10){
                        if (Integer.parseInt(bank[4].substring(1)) == 14){
                            royalFlush = true;
                            if (deckValue<9){
                                deckValue = 9;
                            }
                        }
                        straightFlush = true;
                        if (deckValue<8){
                            deckValue = 8;
                        }
                    }
                    if (deckValue<4){
                        deckValue = 4;
                    }
                }

                flushCount = 0;
                samePairCount = 0;
                firstPairCount = 0;
                secondPairCount = 0;
                straightCount = 0;

                for (int iii = 0; iii<5; iii++){
                    System.out.println(bank[iii]);
                }
                System.out.println(" ");
            }
        }
        return deckValue;
    }

    public int Player(String[] player, String[] bank, int cardCount, int bet){
        switch (cardCount){
            case 0:
                if (player.length == 2){
                    if (player[0].charAt(0) == player[1].charAt(0)){
                        bet = bet + 20;
                    }else if (player[0].substring(1) == player[1].substring(1)){
                        bet = bet + 40;
                    }
                }
                break;
            case 3:
                for (int j = 0; j<cardCount; j++){
                    if (bank[j].charAt(0) == player[0].charAt(0)){
                        bet = bet + 0;
                    }
                    if (bank[j].charAt(0) == player[0].charAt(0)){
                        bet = bet + 0;
                    }
                    if (bank[j].substring(1) == player[0].substring(1)){
                        bet = bet + 35;
                    }
                    if (bank[j].substring(1) == player[1].substring(1)){
                        bet = bet + 35;
                    }
                }
                break;
            case 4:
                for (int j = 0; j<cardCount; j++){
                    if (bank[j].charAt(0) == player[0].charAt(0)){
                        bet = bet + 0;
                    }
                    if (bank[j].charAt(0) == player[0].charAt(0)){
                        bet = bet + 0;
                    }
                    if (bank[j].substring(1) == player[0].substring(1)){
                        bet = bet + 35;
                    }
                    if (bank[j].substring(1) == player[1].substring(1)){
                        bet = bet + 35;
                    }
                }
                break;
            case 5:
                for (int j = 0; j<cardCount; j++){
                    if (bank[j].charAt(0) == player[0].charAt(0)){
                        bet = bet + 0;
                    }
                    if (bank[j].charAt(0) == player[0].charAt(0)){
                        bet = bet + 0;
                    }
                    if (bank[j].substring(1) == player[0].substring(1)){
                        bet = bet + 35;
                    }
                    if (bank[j].substring(1) == player[1].substring(1)){
                        bet = bet + 35;
                    }
                }
                break;
        }
        return bet;
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
