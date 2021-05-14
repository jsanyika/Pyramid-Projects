public class Battleship extends Boat{

    private char letter = 'B';
    private String name = "Battleship";

    public Battleship() {
        super();
        this.setSize(4);
        this.setHealth(this.getSize());
    }

    public char getLetter(){
        return this.letter;
    }

    @Override
    public String getName() {
        return name;
    }
}
