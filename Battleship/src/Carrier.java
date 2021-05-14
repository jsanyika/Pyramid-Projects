import java.util.ArrayList;

public class Carrier extends Boat{

    private char letter = 'C';
    private String name = "Carrier";

    public Carrier() {
        super();
        this.setSize(5);
        this.setHealth(this.getSize());
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
