public class card {

    suits suit;
    int number;
    String writing;

    public enum suits {
        Spades, Hearts, Diamonds, Clubs, Zero
        //♠ ♥ ♦ ♣
    }
    
    public card(suits suit, int number, String writing){
        this.suit = suit;
        this.number = number;
        this.writing = writing;
    }
}
