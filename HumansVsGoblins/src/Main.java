import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to HumansVsGoblins! \n" +
                "In this game you will be playing as a human and your goal is to defeat every goblin.\n" +
                "Before we begin I just need =your help setting up a few things.\n" +
                "First, what would you like to be called?");

        String name = input.nextLine();

        System.out.println("Alright " + name + "!\n" +
                "Next we'll set up the size of the world. First I would like to know how large do you want the world?\n" +
                "(It will be a square grid, i.e. 25x25. You only need to input a single integer above 10)");
        int x = 0;

        while(x <= 10) {
            System.out.println("Pick an integer higher than 10");
            try {
                x = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException ignore) {
                System.out.println("That wasn't an integer.");
            }
        }

        Land world = new Land(x);

        Human human = new Human(world);

        BossGoblin bossGoblin = new BossGoblin(world);
        RuntGoblin runtGoblin = new RuntGoblin(world);
        MinionGoblin minionGoblin = new MinionGoblin(world);

        bossGoblin.setPosition(world.addCharacter(bossGoblin));
        runtGoblin.setPosition(world.addCharacter(runtGoblin));
        minionGoblin.setPosition(world.addCharacter(minionGoblin));
        human.setPosition(world.addCharacter(human));



        world.drawGameWorld();



    }
}
