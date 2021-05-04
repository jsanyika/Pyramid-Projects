public class Battleship extends Boat{

    private char letter = 'B';
    private String name = "Battleship";

    public Battleship() {
        this.setSize(4);
    }

    public char getLetter(){
        return this.letter;
    }

    @Override
    public String getName() {
        return name;
    }
}
