import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Create scanner object
        System.out.println("Greetings, friend! Would you kindly share your name with me?");
        String name = input.nextLine(); //Get player's name
        System.out.println("Ok " + name + ", I am going to think of a number between 1 and 20. \n" +
                "You'll have 6 tries. If you can guess it you win, if not I win. Let's begin...");

        //Pick a random number between 1 and 20
        int number = pickANumber();
        System.out.println("Ok, I have my number. What is your first guess?");

        //Some initial set up
        boolean exit = false;
        int guess;
        int counter = 0;
        int compScore = 0;
        int playerScore = 0;

        //Game loop
        while(!exit) {
            //Increase try count and if it has reached 6 inform player of loss
            counter++;
            if (counter > 6) {
                compScore++;
                System.out.println("Sorry, " + name + ", you lose.\n" +
                        "Would you like to try again?(y/n)");
                exit = askToContinue(input, name);
                if (!exit) {
                    number = pickANumber();
                    counter = 0;
                }
            } else {
                try {
                    guess = Integer.parseInt(input.nextLine()); //Take user input

                    //Check if guess is above, below, or correct
                    if (guess > number) {
                        System.out.println("Too high. Try again!");
                    } else if (guess < number) {
                        System.out.println("Too low. Try again!");
                    } else {
                        playerScore++;
                        System.out.println("You got it, " + name + "! \n" +
                                "Would you like to try again? (y/n)");
                        exit = askToContinue(input, name);
                        if (!exit) {
                            number = pickANumber();
                            counter = 0;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("That wasn't a number but it still counts as a guess");
                }
            }
        }
        System.out.println("Final Score: \n" +
                "You: " + playerScore + "\n" +
                "Me : " + compScore);
    }

    public static int pickANumber(){
        double f = Math.random()/Math.nextDown(1.0);
        double x = 1*(1.0 - f) + 20*f;
        return (int)x;
    }

    public static boolean askToContinue(Scanner input, String name){
        switch (input.nextLine()) {
            case("n") :
                System.out.println("Alright " + name + "! See ya next time!");
                return true;
            case("y") :
                System.out.println("Ok, " + name + ", I'm going to think of a new number. \n" +
                        "What will be your first guess?");
                return false;
            default:
                System.out.println("I'm just going to take that as a no.");
                return true;
        }
    }
}
