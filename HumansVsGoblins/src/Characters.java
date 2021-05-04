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

    public void setPosition(int x, int y) {
        this.position = new int[]{x, y};
    }

    public int[] getPosition(){
        return this.position;
    }

    public int getXPosition() { return this.position[0];}

    public int getYPosition() { return this.position[1]; }
}
