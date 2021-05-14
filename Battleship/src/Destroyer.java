public class Destroyer extends Boat{

    private char letter = 'D';
    private String name = "Destroyer";

    public Destroyer(){
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
