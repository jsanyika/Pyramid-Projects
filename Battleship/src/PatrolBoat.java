public class PatrolBoat extends Boat{

    private char letter = 'P';
    private String name = "Patrol Boat";

    public PatrolBoat() {
        this.setSize(2);
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
