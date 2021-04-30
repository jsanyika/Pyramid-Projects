import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("This adventure will use keywords to progress. Some common examples will be:" +
                "'pick up', 'open', 'check inventory'. If you type 'use' you'll then be asked which item. " +
                "Check inventory to see what items you can use. Somethings will be contextual. Be creative!");
        ArrayList<String> inventory = new ArrayList<>(){{
            add("sword");
            add("shield");
            add("torch");
        }};
        System.out.println("You are an intrepid adventurer. You have come seeking riches in the lair of a" +
                "dragon. You enter the cave in before you you see a skeleton on the ground with a key nearby" +
                "and a tunnel leading deeper into cave.");
        String choice = Entrance(inventory);

        choice = firstHallway(inventory);

    }

    public static String Entrance(ArrayList<String> inventory) {
        while(true) {
            System.out.println("What would you like to do?");
            String choice = checkInput();
            switch (choice) {
                case ("pick up"):
                    if (inventory.contains("skeleton key")) {
                        System.out.println("You already picked up the key");
                    } else {
                        System.out.println("You add the key to your inventory");
                        inventory.add("skeleton key");
                    }
                    break;
                case ("check inventory"):
                    checkInventory(inventory);
                    break;
                case ("forward"):
                    System.out.println("You walk further into the cave. The walls stretch higher than you can" +
                            " reach and it's getting darker.");
                    return choice;
                default:
                    System.out.println("You stand confused");
                    break;
            }
        }
    }

    public static String firstHallway(ArrayList<String> inventory){
        boolean torch = false;
        String location = "firstHallway";
        while(true) {
            System.out.println("What would you like to do?");
            String choice = checkInput();
            switch (choice) {
                case("pick up") :
                    if(torch) {
                        if(inventory.contains("oil")){
                            System.out.println("You've already picked up the oil");
                            break;
                        } else {
                            System.out.println("You add the oil to your inventory");
                            inventory.add("oil");
                            break;
                        }
                    } else {
                        System.out.println("You can't see anything to pick up.");
                        break;
                    }
                case("check inventory") :
                    checkInventory(inventory);
                    break;
                case ("use"):
                    System.out.println("What would you like to use?");
                    if (use(inventory, location, checkInput()).equals("torch")) {
                        torch = true;
                }



            }
        }
    }

    public static String use(ArrayList<String> inventory, String location, String item) {
        if (inventory.contains(item)) {
            switch (location) {
                default:
                    break;
                case ("firstHallway"):
                    switch (item) {
                        default:
                            System.out.println("You see nowhere to use " + item + ".");
                            return null;

                        case ("torch"):
                            System.out.println("You light the hallway");
                            return "torch";
                    }

            }

        }
        return null;
    }

    public static void checkInventory(ArrayList<String> inventory) {
        System.out.println(inventory.toString());
    }

    public static String checkInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
