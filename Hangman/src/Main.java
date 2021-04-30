import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Create scanner object to acquire a word

        System.out.println("For this game of hangman you will provide a word for someone else to guess.\n" +
                "The other player will guess one letter at a time and I'll fill in the blanks for you.\n" +
                "So what would you like the word to be?");

        /*TODO Check to only allow letters and no numbers*/
        char[] word = input.nextLine().toLowerCase().toCharArray(); //Create a char array with the word provided.



        char[] guesses = new char[word.length]; //Create an empty array to match the word

        //Fill in the guesses array with underscores
        for (int i = 0; i <= guesses.length - 1; i++){
            guesses[i] = '_';
        }

        int tries = 0; //counter for number of guesses
        ArrayList<Character> letters = new ArrayList<Character>(); //Array list to hold guessed letters

        char letter; //Instantiate the guessed letter variable
        boolean rightOrWrong; //boolean to track if the guesses letter is in the word
        boolean loop = true; //boolean to continue or break the loop

        while(loop) { //start of the game loop
            drawHangman(tries); //Draw gallows based on number of tries
            print(guesses, letters); //Print word built so far and letters guessed
            if (Arrays.equals(word, guesses)) {
                System.out.println("You won!");
                System.out.println("Would you like to play again? (y/n)");
                String answer = input.next();
                if(answer.equals("y")) {
                    char[][] wordAndGuesses = getWord(input);
                    word = wordAndGuesses[0];
                    guesses = wordAndGuesses[1];
                    tries = 0 ;
                    letters.clear();
                } else if (answer.equals("n")) {
                    System.out.println("Ok! See ya next time!");
                    loop = false;
                } else {
                    System.out.println("I'll take that as a no. See ya!");
                    loop = false;
                }
            } else if (tries >= 7) {
                System.out.println("You lose!");
                System.out.println("Would you like to play again? (y/n)");
                String answer = input.next();
                if(answer.equals("y")) {
                    char[][] wordAndGuesses = getWord(input);
                    word = wordAndGuesses[0];
                    guesses = wordAndGuesses[1];
                    tries = 0 ;
                    letters.clear();
                } else if (answer.equals("n")) {
                    System.out.println("Ok! See ya next time!");
                    loop = false;
                } else {
                    System.out.println("I'll take that as a no. See ya!");
                    loop = false;
                }
            }
            else {
                System.out.println("Guess a letter.");

                letter = Character.toLowerCase(input.next().charAt(0));
                if (letters.contains(letter)) {
                    System.out.println("You've already guessed that letter");
                } else {

                    letters.add(letter);
                    rightOrWrong = check(word, letter);

                    if (rightOrWrong) {
                        guesses = addLetters(word, letter, guesses);
                    } else {
                        tries++;
                    }
                }
            }
        }





    }

    public static boolean askToContinue() {

        
        return false;
    }

    public static char[][] getWord(Scanner input) {

        System.out.println("Please choose a new word.");
        char[] word = input.next().toLowerCase().toCharArray();
        char [] guesses = new char[word.length];
        for (int i = 0; i <= guesses.length - 1; i++){
            guesses[i] = '_';
        }

        char[][] returnVariables = {word, guesses};
        return returnVariables;
    }

    //Adds the correct letters to the guesses array by checking against the word array then returns it
    public static char[] addLetters(char[] word, char letter, char[] guesses) {
        for (int i = 0; i <= word.length - 1; i++) {
            if (word[i] == letter) {
                guesses[i] = letter;
            }
        }
        return guesses;
    }

    //A centralized method to check if the letter is in the word.
    // Returns true or false based on the result
    public static boolean check (char[] word, char letter){
        for(char letters : word){
            if (letter == letters){
                return true;
            }
        }
        return false;
    }

    //First prints the word with the letters guesses so far and then the individual letters
    // the player has guessed
    public static void print(char[] guesses, ArrayList<Character> letters) {
        System.out.print("Your word: ");
        for (char guess : guesses) {
            System.out.print(guess + " ");
        }
        System.out.println("");
        System.out.print("Letters: ");

        for (char letter : letters) {
            System.out.print(letter + " ");
        }
        System.out.println("");
    }


    //This draws the hangman based on the number of tries the player has.
    public static void drawHangman(int tries) {

        switch (tries) {
            case(0) :
                System.out.println("  +------+\n" +
                                   "  |      |\n" +
                                   "         |\n" +
                                   "         |\n" +
                                   "         |\n" +
                                   "         |\n" +
                                   "         |\n" +
                                   "==============");
                break;
            case(1) :
                System.out.println("  +------+\n" +
                                   "  |      |\n" +
                                   "  O      |\n" +
                                   "         |\n" +
                                   "         |\n" +
                                   "         |\n" +
                                   "         |\n" +
                                   "==============");
                break;
            case(2):
                System.out.println("  +------+\n" +
                        "  |      |\n" +
                        "  O      |\n" +
                        "  |      |\n" +
                        "         |\n" +
                        "         |\n" +
                        "         |\n" +
                        "==============");
                break;
            case(3) :
                System.out.println("  +------+\n" +
                        "  |      |\n" +
                        "  O      |\n" +
                        "  |      |\n" +
                        "  |      |\n" +
                        "         |\n" +
                        "         |\n" +
                        "==============");
                break;
            case(4):
                System.out.println("  +------+\n" +
                        "  |      |\n" +
                        "  O      |\n" +
                        " /|      |\n" +
                        "  |      |\n" +
                        "         |\n" +
                        "         |\n" +
                        "==============");
                break;
            case(5) :
                System.out.println("  +------+\n" +
                        "  |      |\n" +
                        "  O      |\n" +
                        " /|\\     |\n" +
                        "  |      |\n" +
                        "         |\n" +
                        "         |\n" +
                        "==============");
                break;
            case(6) :
                System.out.println("  +------+\n" +
                        "  |      |\n" +
                        "  O      |\n" +
                        " /|\\     |\n" +
                        "  |      |\n" +
                        " /       |\n" +
                        "         |\n" +
                        "==============");
                break;
            case(7) :
                System.out.println("  +------+\n" +
                        "  |      |\n" +
                        "  O      |\n" +
                        " /|\\     |\n" +
                        "  |      |\n" +
                        " / \\     |\n" +
                        "         |\n" +
                        "==============");
                break;
            default:
                break;
        }

    }
}
