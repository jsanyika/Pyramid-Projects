import java.util.Scanner;

public class Player {
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

    public Player(){
        printPrimary();
        placeBoat(carrier);
        printPrimary();
        placeBoat(patrolBoat1);
    }

    public void printPrimary(){
        System.out.print(primaryGrid.toString());
    }

    public boolean placeBoat(Boat boat){

        System.out.println("Where would you like the x value for your " + boat.getName() + " to be?(" + boat.getSize() +
                " spaces needed)");

        int x = Integer.parseInt(input.nextLine());
        System.out.println("And the y value?");
        int y = Integer.parseInt(input.nextLine());
        System.out.println("And what about the rotation?(h/v)");
        String rotation = input.nextLine();

        if (checkPath(boat, x, y, rotation)){
            switch (rotation) {
                case("h") :
                    for (int i = x; i < x + boat.getSize(); i++){
                        primaryGrid.setCharAtCoordinate(new int[]{i, y}, boat.getLetter());
                    }
                    return true;
                case("v") :
                    for (int i = y; i < y + boat.getSize(); y++) {
                    primaryGrid.setCharAtCoordinate(new int[]{x, i}, boat.getLetter());
                }
                    return true;
                default :
                    return false;

            }
        } else {
            System.out.println("That path is unavailable. Let's try again");
            placeBoat(boat);
        }
        return true;
    }

    public boolean checkPath(Boat boat, int x, int y, String rotation){
        try {
            switch (rotation) {
                case ("h"):
                    for (int i = x; i < x + boat.getSize(); i++) {
                        if (!primaryGrid.checkIfEmptySpace(i, y)) {

                            return false;
                        }
                    }
                case ("v"):
                    for (int i = y; i < y + boat.getSize(); i++) {
                        if (!primaryGrid.checkIfEmptySpace(x, i)) {
                            return false;
                        }
                    }
            }
        } catch (IndexOutOfBoundsException e){
            return false;
        }
        return true;
    }


}
