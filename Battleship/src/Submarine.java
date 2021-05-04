public class Submarine extends Boat{

    private char letter = 'S';
    private String name = "Submarine";

    public Submarine(){
        this.setSize(3);
    }

    @Override
    public char getLetter() {
        return this.letter;
    }

    @Override
    public String getName() {
        return name;
    }
}
