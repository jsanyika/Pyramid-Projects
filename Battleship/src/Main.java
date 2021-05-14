import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player();
        player1.printPrimary();
        Player player2 = new Player();
        player2.printPrimary();

        Scanner input = new Scanner(System.in);

        while(true){
            player1.printPrimary();
            player1.printTracking();
            System.out.println("What x value would you like to attack?");
            int x = input.nextInt();
            System.out.println("What y value would you like to attack?");
            int y = input.nextInt();
            player1.attack(x, y, player2);
            player2.printPrimary();

        }


    }
}
