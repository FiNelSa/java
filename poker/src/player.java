public class player {

    card firstCard;
    card secondCard;
    card thirdCard;
    card fourthCard;
    card fifthCard;
    int deckValue;
    int bet;
    int samePairCount;
    int firstPairCount;
    int secondPairCount;
    int straightCount;
    boolean isFlush;
    boolean playing;
    String playerName;

    public player(boolean playing, String userName){
        this.playing = playing;
        this.playerName = userName;
    }

    public player(card firstCard, card secondCard, card thirdCard, card fourthCard, card fifthCard, String playerName){
        this.firstCard = firstCard;
        this.secondCard = secondCard;
        this.thirdCard = thirdCard;
        this.fourthCard = fourthCard;
        this.fifthCard = fifthCard;
        this.playerName = playerName;
    }

    public void increaseSamePairCount(){
        this.samePairCount++;
    }
    public void increaseFirstPairCount(){
        this.firstPairCount++;
    }
    public void increaseSecondPairCount(){
        this.secondPairCount++;
    }
    public void increaseStraightCount(){
        this.straightCount++;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void playTurn(int highestBet){
        if (bet == 0){
            bet = 10;
        }
        double gap = (double) highestBet / bet;
        if (gap == 0) {
            switch (deckValue){
                case 0:
                    break;
                case 1:
                    bet = bet + 25;
                    break;
                case 2:
                    bet = bet + 35;
                    break;
                default:
                    bet = bet + 55;
            }
        }else if (gap<1.5){
            bet = highestBet;
        }else if (gap<2){
            if (1<=deckValue){
                bet = highestBet;
            }
        }else if(2<=deckValue){
            bet = highestBet+25;
        }else{
            this.playing = false;
            System.out.println(playerName + " has folded");
        }

        if (playing){
            System.out.println(playerName + "'s bet is : " + bet);
        }
    }
}
