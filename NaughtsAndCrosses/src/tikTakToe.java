public class tikTakToe {

    private char[] gameboard;

    tikTakToe(){
        gameboard = new char[9];

    }

    public boolean makeAMove(int space, char player) {
        if(gameboard[space] == 'x' || gameboard[space] == 'o') {
            return false;
        } else {
            gameboard[space] = player;
        }
        return true;
    }

    public char checkWinCondition() {

        return 'b';
    }

    //public char

    public void sayHello() {
        System.out.println("Hello World!");
    }
}
