public class Player {

    private String letter;
    private int score;

    public Player(String letter) {
        this.letter = letter;
        score = 0;
    }

    public void addToScore(){
        score += 1;
    }

    public int getScore(){
        return score;
    }

    public String getLetter(){ return letter; }

}
