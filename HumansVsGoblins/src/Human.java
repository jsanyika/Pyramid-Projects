import java.util.HashMap;

public class Human extends Characters{

    private String name;
    private HashMap<Object, Object> inventory = new HashMap<>();


    public Human(Land world) {
        super(world);
        setName("Human");
    }

    public boolean makeAMove(String direction){
        int[] currentPosition = this.getPosition();
        switch (direction) {
            case("n") :
            case("s"):
            case("e"):
            case("w"):
            default:
        }
        return true;
    }
}
