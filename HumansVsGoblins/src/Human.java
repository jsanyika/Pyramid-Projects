import java.util.HashMap;

public class Human extends Characters{

    private String name;
    private HashMap<Object, Object> inventory = new HashMap<>();


    public Human(Land world) {
        super(world);
        setName("Human");
    }

    public boolean makeAMove(String direction){
        switch (direction) {
            case("n") :
                this.setPosition(getXPosition(), getYPosition() + 1);
                return true;
            case("s"):
                this.setPosition(getXPosition(), getYPosition() - 1);
                return true;
            case("e"):
                this.setPosition(this.getXPosition() + 1, this.getYPosition());
                return true;
            case("w"):
                this.setPosition(this.getXPosition() - 1, this.getYPosition());
                return true;
            default:
                return false;
        }
    }
}
