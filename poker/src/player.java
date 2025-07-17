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

    public card getFirstCard() {
        return firstCard;
    }
    public void setFirstCard(card firstCard){
        this.firstCard = firstCard;
    }

    public card getSecondCard() {
        return secondCard;
    }
    public void setSecondCard(card secondCard) {
        this.secondCard = secondCard;
    }

    public card getThirdCard(){
        return thirdCard;
    }
    public void setThirdCard(card thirdcard) {
        this.thirdCard = thirdcard;
    }

    public card getFourthCard() {
        return fourthCard;
    }
    public void setFourthCard(card fourthCard) {
        this.fourthCard = fourthCard;
    }

    public card getFifthCard() {
        return fifthCard;
    }
    public void setFifthCard(card fifthCard) {
        this.fifthCard = fifthCard;
    }

    public int getDeckValue() {
        return deckValue;
    }
    public void setDeckValue(int deckValue) {
        this.deckValue = deckValue;
    }

    public int getBet() {
        return bet;
    }
    public void setBet(int bet) {
        this.bet = bet;
    }

    public int getSamePairCount() {
        return samePairCount;
    }
    public void setSamePairCount(int samePairCount) {
        this.samePairCount = samePairCount;
    }
    public void increaseSamePairCount(){
        this.samePairCount++;
    }

    public int getFirstPairCount() {
        return firstPairCount;
    }
    public void setFirstPairCount(int firstPairCount) {
        this.firstPairCount = firstPairCount;
    }
    public void increaseFirstPairCount(){
        this.firstPairCount++;
    }

    public int getSecondPairCount() {
        return secondPairCount;
    }
    public void setSecondPairCount(int secondPairCount) {
        this.secondPairCount = secondPairCount;
    }
    public void increaseSecondPairCount(){
        this.secondPairCount++;
    }

    public int getStraightCount() {
        return straightCount;
    }
    public void setStraightCount(int straightCount) {
        this.straightCount = straightCount;
    }
    public void increaseStraightCount(){
        this.straightCount++;
    }

    public boolean isFlush() {
        return isFlush;
    }
    public void setFlush(boolean isFlush) {
        this.isFlush = isFlush;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void playTurn(int highestBet){
        if (getBet() == 0){
            setBet(10);
        }
        double gap = (double) highestBet /getBet();
        if (gap == 0) {
            switch (getDeckValue()){
                case 0:
                    break;
                case 1:
                    setBet(getBet()+25);
                    break;
                case 2:
                    setBet(getBet()+35);
                    break;
                default:
                    setBet(getBet()+50);
            }
        }else if (gap<1.5){
            setBet(highestBet);
        }else if (gap<2){
            if (1<=getDeckValue()){
                setBet(highestBet);
            }
        }else if(2<=getDeckValue()){
            setBet(highestBet+25);
        }else{
            this.playing = false;
            System.out.println(getPlayerName() + " has folded");
        }

        if (playing){
            System.out.println(getPlayerName() + "'s bet is : " + getBet());
        }
    }
}
