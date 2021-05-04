public class Grid {

    private char[][] grid = new char[10][10];
    private final char emptySpace = 'o';

    public Grid(){
        for(int i = 0; i <= 9; i ++){
            for(int j = 0; j <= 9; j++){
                this.grid[i][j] = emptySpace;
            }
        }
    }

    public char[][] getGrid(){
        return grid;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  0 1 2 3 4 5 6 7 8 9 y\n");

        for(int i = 0; i <= 9; i++) {
            stringBuilder.append(i + " ");
            for(int j = 0; j <= 9; j++) {
                stringBuilder.append(getGrid()[i][j] + " ");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("x \n");
        return stringBuilder.toString();
    }

    public char getCharAtCoordinate(int[] coordinate){
        return grid[coordinate[0]][coordinate[1]];
    }
    public char getCharAtCoordinate(int x, int y){
        return grid[x][y];
    }

    public void setCharAtCoordinate(int[] coordinate, char character){
        grid[coordinate[0]][coordinate[1]] = character;
    }

    public boolean checkIfEmptySpace(int[] coordinates) {
        return getCharAtCoordinate(coordinates) == emptySpace;
    }
    public boolean checkIfEmptySpace(int x, int y){
        return getCharAtCoordinate(x, y) == emptySpace;
    }
}
