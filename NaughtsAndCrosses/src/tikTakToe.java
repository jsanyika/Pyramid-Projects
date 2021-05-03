import java.lang.reflect.Array;

public class tikTakToe {

    private String[] gameboard;
    private Player playerX = new Player("x");
    private Player playerO = new Player("o");

    public tikTakToe(){
        gameboard = new String[9];
        for(int i = 0; i <= gameboard.length - 1; i++){
            gameboard[i] = Integer.toString(i);
        }

    }

    public Player getPlayerX(){
        return playerX;
    }
    public Player getPlayerO() {
        return playerO;
    }

    public boolean makeAMove(int space, String player) {
        try {
            if (gameboard[space].equals("x") || gameboard[space].equals("o")) {
                return false;
            } else {
                gameboard[space] = player;
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public String checkWinConditions() {
        for (int i = 0; i < 8; i++) {
            String line = null;

            switch (i) {
                case 0:
                    line = gameboard[0] + gameboard[1] + gameboard[2];
                    break;
                case 1:
                    line = gameboard[3] + gameboard[4] + gameboard[5];
                    break;
                case 2:
                    line = gameboard[6] + gameboard[7] + gameboard[8];
                    break;
                case 3:
                    line = gameboard[0] + gameboard[3] + gameboard[6];
                    break;
                case 4:
                    line = gameboard[1] + gameboard[4] + gameboard[7];
                    break;
                case 5:
                    line = gameboard[2] + gameboard[5] + gameboard[8];
                    break;
                case 6:
                    line = gameboard[0] + gameboard[4] + gameboard[8];
                    break;
                case 7:
                    line = gameboard[2] + gameboard[4] + gameboard[6];
                    break;
            }
            if (line.equals("xxx")) {
                return "x";
            } else if (line.equals("ooo")) {
                return "o";
            }
        }

        return null;
    }

    public void drawBoard(){
        for(int i = 0; i <= gameboard.length - 1; i++) {
            System.out.print(gameboard[i]+ " ");
            if(i == 2 || i == 5){
                System.out.print("\n");
            }
        }
        System.out.print("\n");
    }


}
