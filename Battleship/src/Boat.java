import java.util.ArrayList;

public class Boat {
    private int size;
    private char letter;
    private String name;
    private boolean destroyed;
    private int health;
    private ArrayList<int[]> coordinates = new ArrayList<>();

    public Boat(){
        destroyed = false;
    }

    public void setHealth(int health) { this.health = health; }
    public int getHealth() { return this.health; }
    public ArrayList<int[]> getCoordinates() { return coordinates; }
    public void setCoordinates(ArrayList<int[]> coordinates) { this.coordinates = coordinates; }
    public void addToCoordinates(int x, int y){ coordinates.add(new int[]{x, y});}
    public int getSize() { return this.size; }
    public void setSize(int size) { this.size = size;}
    public char getLetter() { return letter; }
    public boolean getDestroyed() { return destroyed; }
    public void setDestroyed(boolean destroyed) { this.destroyed = destroyed; }
    public boolean takeDamage() {
        this.setHealth(this.getHealth() - 1);
        if (this.getHealth() <= 0){
            this.setDestroyed(true);
            System.out.println(this.getName() + " has been destroyed!");
        }
        return this.getDestroyed();
    }

    public String getName() {
        return name;
    }
}
