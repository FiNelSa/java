public class card {
    public enum suits {
        Spades, Hearts, Diamonds, Clubs, Zero
        //♠ ♥ ♦ ♣
    }

    suits suit;
    int number;
    String writing;

    public card(suits suit, int number, String writing){
        this.suit = suit;
        this.number = number;
        this.writing = writing;
    }

    public int getNumber() {
        return number;
    }

    public suits getSuit() {
        return suit;
    }

    public String getWriting(){
        return writing;
    }

}
