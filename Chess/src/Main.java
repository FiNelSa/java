import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {

    String wRook1 = "♖";
    String wRook2 = "♖";
    String wKnight1 = "♘";
    String wKnight2 = "♘";
    String wBishop1 = "♗";
    String wBishop2 = "♗";
    String wQueen = "♕";
    String wKing = "♔";
    String wPawn1 = "♙";
    String wPawn2 = "♙";
    String wPawn3 = "♙";
    String wPawn4 = "♙";
    String wPawn5 = "♙";
    String wPawn6 = "♙";
    String wPawn7 = "♙";
    String wPawn8 = "♙";

    String bRook1 = "♜";
    String bRook2 = "♜";
    String bKnight1 = "♞";
    String bKnight2 = "♞";
    String bBishop1 = "♝";
    String bBishop2 = "♝";
    String bQueen = "♛";
    String bKing = "♚";
    String bPawn1 = "♟";
    String bPawn2 = "♟";
    String bPawn3 = "♟";
    String bPawn4 = "♟";
    String bPawn5 = "♟";
    String bPawn6 = "♟";
    String bPawn7 = "♟";
    String bPawn8 = "♟";

    String[] eighthLine =   {bRook2, bKnight2, bBishop2, bQueen, bKing, bBishop1, bKnight1, bRook1};
    String[] seventhLine =  {bPawn8, bPawn7, bPawn6, bPawn5, bPawn4, bPawn3, bPawn2, bPawn1};
    String[] sixthLine =    {" ", " ", " ", " ", " ", " ", " ", " "};
    String[] fifthLine =    {" ", " ", " ", " ", " ", " ", " ", " "};
    String[] fourthLine =   {" ", " ", " ", " ", " ", " ", " ", " "};
    String[] thirdLine =    {" ", " ", " ", " ", " ", " ", " ", " "};
    String[] secondLine =   {wPawn1, wPawn2, wPawn3, wPawn4, wPawn5, wPawn6, wPawn7, wPawn8};
    String[] firstLine =    {wRook1, wKnight1, wBishop1, wQueen, wKing, wBishop2, wKnight2, wRook2};

    public void printBoard() {
        String[][] board = {eighthLine, seventhLine, sixthLine, fifthLine, fourthLine, thirdLine, secondLine, firstLine};

        for (int i = 0; i < board.length; i++) {
            System.out.print((8 - i));
            for (String cell : board[i]) {
                System.out.print(" " + cell);
            }
            System.out.println(" ");
        }
    }

    public static boolean movePiece(String move) {
        if (move.length() != 4){
            return false;
        }

        System.out.println();

        int fromCol     = move.charAt(0)-97;
        int fromLine    = move.charAt(1);
        int toCol       = move.charAt(2)-97;
        int toLine      = move.charAt(3);

        if (fromLine < 0 || fromLine > 7 || fromCol < 0 || fromCol > 7 || toLine < 0 || toLine > 7 || toCol < 0 || toCol > 7) {
            return false;
        };

        switch (fromCol){
            case 1 :
                switch (toCol){
                    
                }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Main chessGame = new Main();

        System.out.println("Please enter your moves like *e2e4* \n e2 : Which one \n e4 : Where will it go");
        chessGame.printBoard();

        System.out.println("Enter your move");
        movePiece(scan.nextLine());
    }
}