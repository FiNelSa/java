import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();

        int action;
        int ante = 15;
        int money = 1000;
        boolean cont = true;

        while(cont) {
            int bet = 0;

            System.out.println("Money : " + money);
            System.out.println("Ante is 15. Raise your blind bet.");
            bet += game.checkRaise(scan.nextInt(), ante);

            game.GameOpening();

            System.out.println("Select your action : \n 1 Fold \n 2 Check \n 3 Raise");
            action = scan.nextInt();

            if (action == 1){
                action = 0;
                break;
            }else if (action == 3){
                action = 0;
                System.out.println("Place your bet");
                bet += game.checkRaise(scan.nextInt(), ante);
            }

            game.MidGame();

            System.out.println("Select your action : \n 1 Check \n 2 Raise");
            action = scan.nextInt();

            if (action == 2){
                action = 0;
                System.out.println("Place your bet");
                bet += game.checkRaise(scan.nextInt(), ante);
            }

            game.FourthCard();

            System.out.println("Select your action : \n 1 Check \n 2 Raise");
            action = scan.nextInt();

            if (action == 2){
                action = 0;
                System.out.println("Place your bet");
                bet += game.checkRaise(scan.nextInt(), ante);
            }

            game.TheLastCard();

            game.theAbsoluteTortureToMyself();

            System.out.println("Do you want to play again?");
            cont = scan.nextBoolean();
        }
    }
}