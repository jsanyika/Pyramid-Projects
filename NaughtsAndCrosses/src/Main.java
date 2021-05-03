import java.util.Scanner;
/*TODO Give computer player AI. Add draw conditions if board fills up. Add scoring. Fix play again mechanic*/

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe! \n" +
                "Would you like to be x or o? (x/o)");

        tikTakToe ttt = new tikTakToe();
        Player human;
        Player computer;

        String playerChoice = input.next().substring(0,1).toLowerCase();

        while(!(playerChoice.equals("x") || playerChoice.equals("o"))){
            System.out.println("Please choose 'x' or 'o'.");
            playerChoice = input.next().substring(0,1).toLowerCase();
        }

        if(playerChoice.equals("x")){
            human = ttt.getPlayerX();
            computer = ttt.getPlayerO();
        } else {
            human = ttt.getPlayerO();
            computer = ttt.getPlayerX();
        }

        boolean loop = true;
        boolean computerMoveSuccessful;
        boolean humanMoveSuccessful = false;

        ttt.drawBoard();

        while(loop){
            System.out.println("Where would you like to move?");
            while(!humanMoveSuccessful) {
                System.out.println("Please type a number on the board.");
                try {
                    humanMoveSuccessful = makeAMoveForPlayer(human, input, ttt);

                } catch (NumberFormatException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
            humanMoveSuccessful = false;

            computerMoveSuccessful = makeAMoveForComp(computer, ttt);
            while(!computerMoveSuccessful){
                computerMoveSuccessful = makeAMoveForComp(computer, ttt);
            }

            try {
                boolean someoneWon = checkWinConditions(ttt, human, input);
                if(someoneWon){
                    ttt = new tikTakToe();
                }
            } catch (NullPointerException ignored){

            }
            ttt.drawBoard();
        }

    }
    public static boolean makeAMoveForPlayer(Player player, Scanner input, tikTakToe ttt){
        int move = Integer.parseInt(input.next().substring(0,1).toLowerCase());
        return ttt.makeAMove(move, player.getLetter());
    }

    public static boolean makeAMoveForComp(Player player, tikTakToe ttt){
        double f = Math.random()/Math.nextDown(1.0);
        int computerMove = (int)(0*(1.0 - f) + 8*f);
        return ttt.makeAMove(computerMove, player.getLetter());
    }

    public static boolean checkWinConditions(tikTakToe ttt, Player player, Scanner input){
        switch (ttt.checkWinConditions()){
            case ("x") :
                switch (player.getLetter()){
                    case ("x") :
                        System.out.println("You won! Would you like to play again?(y/n)");
                        return askToPlayAgain(input);
                    case("y") :
                        System.out.println("Sorry, you lost. Would you like to play again?(y/n)");
                        return askToPlayAgain(input);
                    default :
                        System.out.println("idk what happened. let's move on. Play again? (y/n)");
                        return askToPlayAgain(input);

                }
            case ("y") :
                switch (player.getLetter()){
                    case ("y") :
                        System.out.println("You won! Would you like to play again?(y/n)");
                        return askToPlayAgain(input);
                    case ("x") :
                        System.out.println("Sorry, you lost. Would you like to play again?(y/n)");
                        return askToPlayAgain(input);
                    default :
                        System.out.println("idk what happened. let's move on. Play again? (y/n)");
                        return askToPlayAgain(input);
                }
            case ("d") :
                System.out.println("It's a draw! Would you like to play again? (y/n");
            default :
                return false;
        }
    }

    public static boolean askToPlayAgain(Scanner input) {
        switch (input.next().toLowerCase().substring(0,1)) {
            default :
                System.out.println("I'll take that as a no. See ya next time!");
                return false;
            case ("y") :
                System.out.println("Perfect! Let's begin again.");
                return true;
            case ("n") :
                System.out.println("Thanks for playing!");
                return false;
        }
    }
}


