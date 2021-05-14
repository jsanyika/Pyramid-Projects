public class Submarine extends Boat{

    private char letter = 'S';
    private String name = "Submarine";

    public Submarine(){
        super();
        this.setSize(3);
        this.setHealth(this.getSize());
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
