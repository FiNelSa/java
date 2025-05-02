import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Market markt = new Market();
        try (Scanner scan = new Scanner(System.in)) {
            double money = 1000;

                while (true) {

                    System.out.println("Your money : " + money);
                    System.out.println("Your things' total value after time is " + markt.getTotalValue());

                    System.out.println("Value of sugar = " + markt.sugar + "\n Total pieces of your Sugar = " + markt.sugarPieces);
                    System.out.println("Value of salt = " + markt.salt + "\n Total pieces of your Salt = " + markt.saltPieces);
                    System.out.println("Value of bread = " + markt.bread + "\n Total pieces of your Bread = " + markt.breadPieces);
                    System.out.println("Value of UV Lights = " + markt.uvLight + "\n Total pieces of your UV Lights = " + markt.uvLightPieces);
                    //Informing the user.

                    System.out.println("If you want to buy or sell enter one, else enter zero.");
                    int cont = scan.nextInt();
                    if (cont==1){
                        System.out.println("How much Sugar do you want to buy or sell?");
                        int newSugar = scan.nextInt();
                        money -= markt.getSugarPrice()*newSugar;
                        markt.sugarPieces = markt.sugarPieces+newSugar;

                        System.out.println("How much Salt do you want to buy or sell?");
                        int newSalt = scan.nextInt();
                        money -= markt.getSaltPrice()*newSalt;
                        markt.setSaltPieces(markt.saltPieces + newSalt);

                        System.out.println("How much Bread do you want to buy or sell?");
                        int newBread = scan.nextInt();
                        money -= markt.getBreadPrice()*newBread;
                        markt.setBreadPieces(markt.breadPieces + newBread);

                        System.out.println("How much UV Lights do you want to buy or sell?");
                        int newUV = scan.nextInt();
                        money -= markt.getUVPrice()*newUV;
                        markt.setUVPieces(markt.uvLightPieces + newUV);
                    }
                    //Buying and Selling system.
                    
                    markt.SkipTurn();
                    //Skipping the turn.
                }
        }
    }
}