public class PatrolBoat extends Boat{

    private char letter = 'P';
    private String name = "Patrol Boat";

    public PatrolBoat() {
        super();
        this.setSize(2);
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
