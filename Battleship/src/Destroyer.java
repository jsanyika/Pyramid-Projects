public class Destroyer extends Boat{

    private char letter = 'D';
    private String name = "Destroyer";

    public Destroyer(){
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
