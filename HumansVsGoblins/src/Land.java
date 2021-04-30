import java.util.ArrayList;

public class Land {

    private Characters[][] gameWorld;
    private int size;
    private ArrayList<Characters> entities = new ArrayList<>();
    
    

    public Land(int size) {
        this.size = size;
        this.gameWorld = new Characters[size][size];
    }

    public Object[][] getGameWorld(){
        return this.gameWorld;
    }

    public int[] addCharacter(Characters entity){

        int[] coordinates = pickRandomCoordinates();
        addToGameWorld(coordinates, entity);
        return coordinates;
    }

    public int[] pickRandomCoordinates(){

        boolean taken = true;

        while(taken) {

            double f = Math.random() / Math.nextDown(1.0);
            double x = 1 * (1.0 - f) + this.size * f;
            f = Math.random() / Math.nextDown(1.0);
            double y = 1 * (1.0 - f) + this.size * f;

            if(gameWorld[(int)x][(int)y] == null) {
                int[] coordinates = {(int) x, (int) y};
                taken = false;
                return coordinates;
            }
        }
        return null;
    }

    public void addToGameWorld(int[] coordinates, Characters entity) {
        gameWorld[coordinates[0]][coordinates[1]] = entity;
    }

    public void drawGameWorld(){
        for(int i = 0; i <= size - 1; i++){
            for(int j = 0; j <= size - 1; j++){
                Characters space = this.gameWorld[i][j];
                if(space == null){
                    System.out.print("^  ");
                } else if(space.getName().equals("Human")) {
                    System.out.print("H  ");
                } else if(space.getName().equals("Runt")){
                    System.out.print("R  ");
                } else if(space.getName().equals("Minion")) {
                    System.out.print("M  ");
                } else if(space.getName().equals("Boss")){
                    System.out.print("B  ");
                }
            }
            System.out.print("\n");
        }
    }

}
