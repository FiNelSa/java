import java.util.Scanner;
import javax.swing.JFrame;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static JFrame window = new JFrame("Poker");
    static Game game = new Game();

    static int action;
    static int money = 1000;
    static boolean playAgain = true;
    static int bet = 0;

    public static void main(String[] args) {
        gui gd = new gui(1280, 720);
        gd.setUpGUI();

        while(playAgain) {
            game.getDeck();

            System.out.println("How many players do you want to play with?");
            game.addingPlayers(scan.nextInt());

            bet = 0;

            game.gameOpening();
            game.midGame();
            game.fourthCard();
            game.theLastCard();
            money += bet;
            money = game.calculation(money, bet);

            System.out.println("Money : " + money);

            System.out.println("Do you want to play again?");
            playAgain = scan.nextBoolean();
        }
        System.out.println("Thank you for playing");
    }

    public static void setBet(){
        System.out.println("Money : " + money);
        System.out.println("Your bet is : " + bet);
        System.out.println("Call is : " + (game.highestBet - bet) + ", please raise");
        System.out.print("Raise : ");
        int raise  = scan.nextInt();

        money -= raise;
        bet += raise;
        game.user.setBet(bet);
        while(bet < game.highestBet){
            System.out.println("Money : " + money);
            System.out.println("Your bet is : " + bet);
            System.out.println("Call is : " + (game.highestBet - bet) + ", please raise");
            System.out.print("Raise : ");
            raise  = scan.nextInt();

            money -= raise;
            bet += raise;
            game.user.setBet(bet);
        }
        if (game.highestBet < bet){
            game.setHighestBet();
            game.betSetter();
        }
    }
}