public class hangman {

    public int tries;
    public char[] wordArray;
    public char[] guesses;

    public hangman(String word) {
        wordArray = word.toCharArray();
        for(int i = 0; i <= wordArray.length - 1; i ++){
            wordArray[i] = Character.toLowerCase(wordArray[i]);
        }
        char[] guesses = new char[wordArray.length];
        for (int i = 0; i <= guesses.length - 1; i++){
            guesses[i] = '_';
        }

        tries = 0;
    }

    public void runGame() {

    }

}
