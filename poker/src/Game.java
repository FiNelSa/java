//♠ ♥ ♦ ♣
//Spades, Hearts, Diamonds, Clubs
import java.util.ArrayList;
import java.util.Random;

public class Game {
    Random rand = new Random();

    //Defining cards
    card nullCard = new card(card.suits.Zero, 0 , "Null");
    card[] deck = {
            nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard,
            nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard,
            nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard,
            nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard, nullCard
    };

    public void getDeck(){
        for (int i = 0; i<52; i++){//Selecting a card
            card.suits tempSuit;
            String tempSuitWriting;
            int tempNumber;
            String tempNumberWriting;
            String tempWriting;

            if (i<13){//If first suit
                tempSuit = card.suits.Clubs;
                tempSuitWriting = "♣";
            }else if (i<26){//Second suit
                tempSuit = card.suits.Diamonds;
                tempSuitWriting = "♦";
            }else if (i<39){//Third suit
                tempSuit = card.suits.Hearts;
                tempSuitWriting = "♥";
            }else{//Fourth suit
                tempSuit = card.suits.Spades;
                tempSuitWriting = "♠";
            }
            if (i%13 == 0) {//If its remainder is zero it's an ACE
                tempNumber = 14;
            }else {
                tempNumber = (i%13) + 1;
            }
            tempNumberWriting = switch (i % 13) {//Same as before
                case 0 -> "A";
                case 1 -> "2";
                case 2 -> "3";
                case 3 -> "4";
                case 4 -> "5";
                case 5 -> "6";
                case 6 -> "7";
                case 7 -> "8";
                case 8 -> "9";
                case 9 -> "10";
                case 10 -> "J";
                case 11 -> "Q";
                case 12 -> "K";
                default -> "null";
            };
            tempWriting = tempSuitWriting + tempNumberWriting;//Uniting writings of suit and number
            deck[i] = new card(tempSuit, tempNumber, tempWriting);//Creating a new card with these variables and adding to the deck
        }
    }

    //Adding the user as a player
    player user = new player(true, "User");
    ArrayList<player> players = new ArrayList<>();
    public void addingPlayers(int playerCount){
        for (int i = 1; i<playerCount+1; i++){
            players.add(new player(true, ("Player " + i)));
        }
        players.add(user);
    }

    //Creating bank
    player bankHand = new player(true, "bank");
    //Defining copy of bank, to use while trying to figure out players' decks' values
    card[] bankHandTry = {nullCard, nullCard, nullCard, nullCard, nullCard};

    int thisDeckValue;
    int winningValue;
    int highestBet;
    int totalBet;

    public void gameOpening(){
        highestBet = 0;

        //Placing blind bets
        betSetter();

        //Setting the call bet
        System.out.println("Shuffling Cards");

        //Giving cards
        for (player player : players) {
            player.setFirstCard(giveCard());
        }

        for (player player : players) {
            player.setSecondCard(giveCard());
        }

        //Looking for who has a pair in their hand
        findingStatsForAll();

        cardWriter(user, 2);

        betSetter();
    }

    public void midGame(){
        //Opening first three cards
        bankHand.setFirstCard(giveCard());
        bankHand.setSecondCard(giveCard());
        bankHand.setThirdCard(giveCard());
        System.out.println("Bank's hand is :");
        cardWriter(bankHand, 3);

        findingStatsForAll();

        betSetter();
    }

    public void fourthCard(){
        bankHand.setFourthCard(giveCard());
        cardWriter(bankHand, 4);

        findingStatsForAll();

        betSetter();
    }

    public void theLastCard(){
        bankHand.setFifthCard(giveCard());
        cardWriter(bankHand, 5);

        for (player player : players) {
            cardWriter(player, 2);
        }

        findingStatsForAll();

        betSetter();
    }

    public int calculation(int money, int bet){
        for (player player : players) {
            totalBet += player.getBet();
        }

        winningValue = 0;

        for (player player : players) {
            if (winningValue < player.getDeckValue()) {
                winningValue = player.getDeckValue();
            }
        }

        for (player player : players) {
            if (player.getDeckValue() == winningValue) {
                tieBreaker(player);
            } else {
                player.setDeckValue(0);
            }
        }

        winningValue = 0;

        for (player player : players) {
            if (winningValue < player.getDeckValue()) {
                winningValue = player.getDeckValue();
            }
        }

        for (player player : players) {
            if (winningValue == player.getDeckValue()) {
                System.out.println(player.getPlayerName() + " has won");
            }
        }
        if (user.getDeckValue() == winningValue){
            return totalBet;
        }else {
            return money - bet;
        }
    }

    public void pairSeeker(card i1, player player){
        if (player.getFirstCard().getNumber() == player.getSecondCard().getNumber()){
            if (i1.getNumber() == player.firstCard.getNumber()){
                player.increaseSamePairCount();
            }
        }else{
            if (i1.getNumber() == player.firstCard.getNumber()){
                player.increaseFirstPairCount();
            }else if (i1.getNumber() == player.secondCard.getNumber()){
                player.increaseSecondPairCount();
            }
        }
    }

    public void straightSeeker(card i1, card i2, player player){
        if (i1.getNumber() + 1 == i2.getNumber()){
            player.increaseStraightCount();
        }
    }

    public void deckStatFinder(card[] bank, player player){
        valueSetter(bank, player);
        for (int i = 0; i< bank.length-1; i++){
            for (int i2 = i+1; i2<bank.length; i2++){//Two cards are selected as I and I2
                for (int i3 = 0; i3 < 5; i3++){//I3 is the five possibility of two cards arrangement with the middle cards

                    deckArranger(bank, player, i3, i2, i);//Placing user's cards in the bank's hand and arranging in order

                    for (int i4 = 0; i4 < bank.length-1; i4++){
                        pairSeeker(bank[i4], player);
                        straightSeeker(bank[i4], bank[i4+1], player);
                    }
                    valueSetter(bank, player);

                    player.setSamePairCount(0);
                    player.setFirstPairCount(0);
                    player.setSecondPairCount(0);
                    player.setStraightCount(0);
                    player.setFlush(false);
                }
            }
        }
    }

    public void findingStatsForAll(){
        for (player player : players) {
            deckStatFinder(bankHandTry, player);
        }
    }

    public void deckArranger(card[] bank, player player, int cards, int card2Number, int card1Number){
        //Copying the bank's hand
        bank[0] = bankHand.getFirstCard();
        bank[1] = bankHand.getSecondCard();
        bank[2] = bankHand.getThirdCard();
        bank[3] = bankHand.getFourthCard();
        bank[4] = bankHand.getFifthCard();
        switch (cards){
            case 0://Replacing card 1 with first card
                bank[card1Number] = player.getFirstCard();
                break;
            case  1://Replacing card 2 with first card
                bank[card2Number] = player.getFirstCard();
                break;
            case 2://Replacing card 1 with second card
                bank[card1Number] = player.getSecondCard();
                break;
            case 3://Replacing card 2 with second card
                bank[card2Number] = player.getSecondCard();
                break;
            case 4://Replacing both cards with user's cards
                bank[card1Number] = player.getFirstCard();
                bank[card2Number] = player.getSecondCard();
                break;
        }
        //Placing cards in number order
        for (int j= 0; j<bank.length-1; j++){
            for (int j2 = j+1; j2<bank.length; j2++){
                if (bank[j2].getNumber() < bank[j].getNumber()){
                    card j3 = bank[j];
                    bank[j] = bank[j2];
                    bank[j2] = j3;
                }
            }
        }
    }

    public void valueSetter(card[] bank, player player){
        switch (player.getSamePairCount()){
            case 2:
                setValue(1, player);//One Pair
                break;
            case 3:
                setValue(3, player);//Three of a Kind
                break;
            case 4:
                setValue(7, player);//Four of a Kind
        }
        switch (player.getFirstPairCount()){
            case 2:
                switch (player.getSecondPairCount()){
                    case 2:
                        setValue(2, player);//Two Pairs
                        break;
                    case 3:
                        setValue(6, player);//Full House
                        break;
                    default:
                        setValue(1, player);//One Pair
                        break;
                }
                break;
            case 3:
                switch (player.getSecondPairCount()){
                    case 2:
                        setValue(6, player);//Full House
                        break;
                    default:
                        setValue(3, player);//Three of a Kind
                        break;
                }
                break;
            case 4:
                setValue(7, player);//Four of a Kind
                break;
            default:
                switch (player.getSecondPairCount()){
                    case 2:
                        setValue(1, player);//One Pair
                        break;
                    case 3:
                        setValue(3, player);//Three of a Kind
                        break;
                    case 4:
                        setValue(7, player);//Four of a Kind
                        break;
                }
                break;
        }
        if (bank[0].getSuit() == bank[1].getSuit()){
            if (bank[1].getSuit() == bank[2].getSuit()){
                if (bank[2].getSuit() == bank[3].getSuit()){
                    if (bank[3].getSuit() == bank[4].getSuit() && bank[4].getSuit() != card.suits.Zero){
                        player.setFlush(true);
                    }
                }
            }
        }
        if (player.getStraightCount() == 4){
            if (player.isFlush()){
                if (bank[4].getNumber() == 14){
                    setValue(9, player);//Royal Flush
                }else {
                    setValue(8, player);//Straight Flush
                }
            }else{
                setValue(4, player);//Straight
            }
        }
        zeroingBets();
    }

    public void setValue(int value, player player){
        if (player.getDeckValue()<value){
            player.setDeckValue(value);
        }
        thisDeckValue = value;
    }

    public card giveCard(){
        int cardNumber = rand.nextInt(0, 52);
        while(deck[cardNumber].getSuit() == card.suits.Zero){
            cardNumber = rand.nextInt(0, 52);
        }

        card temp = deck[cardNumber];
        deck[cardNumber] = new card(card.suits.Zero, 0,"0");
        return temp;
    }

    public void betSetter(){
        setHighestBet();
        for (int i = 0; i < players.size()-1; i++) {
            if (players.get(i).playing && players.get(i).getDeckValue() != highestBet) {
                players.get(i).playTurn(highestBet);
            }
        }
        setHighestBet();
        Main.setBet();
    }

    public void setHighestBet(){
        for (player player : players) {
            if (highestBet < player.getBet()) {
                highestBet = player.getBet();
            }
        }
    }

    public void cardWriter(player player, int cardCount){
        for (int i = 0; i<cardCount; i++){
            switch (i){
                case 0:
                    System.out.print(player.firstCard.getWriting());
                    break;
                case 1:
                    System.out.print(player.secondCard.getWriting());
                    break;
                case 2:
                    System.out.print(player.thirdCard.getWriting());
                    break;
                case 3:
                    System.out.print(player.fourthCard.getWriting());
                    break;
                case 4:
                    System.out.print(player.fifthCard.getWriting());
                    break;
            }
            System.out.print(", ");
        }
        System.out.println(" are the cards of " + player.getPlayerName());
    }

    public void tieBreaker(player player){
        if (winningValue == player.getDeckValue()){
            player.setDeckValue(player.getFirstCard().getNumber() + player.getSecondCard().getNumber());
        }else{
            player.setDeckValue(0);
        }
    }

    public void zeroingBets(){
        for (player player : players){
            player.setBet(0);
        }
    }
}