public class Carrier extends Boat{

    private char letter = 'C';
    private String name = "Carrier";

    public Carrier() {
        this.setSize(5);
    }

    @Override
    public char getLetter() {
        return letter;
    }

    @Override
    public String getName() {
        return name;
    }
}
