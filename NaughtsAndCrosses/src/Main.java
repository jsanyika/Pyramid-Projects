import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe! \n" +
                "Would you like to be x or o? (x/o)");

        


        tikTakToe ttt = new tikTakToe();
        ttt.sayHello();

        char[] gameboard = new char[9];

        String playerChoice = input.next().toLowerCase();

        if (playerChoice.equals("x")) {

        }
    }
}
