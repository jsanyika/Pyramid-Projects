import java.util.ArrayList;
import java.util.Scanner;

public class Computer {

    private Scanner input = new Scanner(System.in);
    private Tracking trackingGrid = new Tracking();
    private Primary primaryGrid = new Primary();
    private Carrier carrier = new Carrier();
    private Battleship battleship1 = new Battleship();
    private Battleship battleship2 = new Battleship();
    private Destroyer destroyer1 = new Destroyer();
    private Destroyer destroyer2 = new Destroyer();
    private Destroyer destroyer3 = new Destroyer();
    private Submarine submarine1 = new Submarine();
    private Submarine submarine2 = new Submarine();
    private Submarine submarine3 = new Submarine();
    private PatrolBoat patrolBoat1 = new PatrolBoat();
    private PatrolBoat patrolBoat2 = new PatrolBoat();
    private ArrayList<Boat> boats = new ArrayList<>();

    public Computer(){

    }

    public int[] getRandomCoordinates(){
        double f = -1;
        int x = -1;
        int y = -1;
        int rotation = -1;
        f = Math.random()/Math.nextDown(1.0);
        x = (int)(0*(1.0 - f) + 10*f);
        f = Math.random()/Math.nextDown(1.0);
        y = (int)(0*(1.0 - f) + 10*f);
        f = Math.random()/Math.nextDown(1.0);
        rotation = (int)(1*(1.0 - f) + 2*f);

        return new int[]{x,y,rotation};
    }
}
