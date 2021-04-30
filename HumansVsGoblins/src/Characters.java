public class Characters {

    private int health;
    private int defense;
    private int attack;
    private int[] position;
    private Land world;
    private String name;

    public Characters(Land world) {
        this.world = world;
    }



    private void setRandomLocation(){

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int[] coordinates) {
        this.position = coordinates;
    }

    public int[] getPosition(){
        return this.position;
    }
}
