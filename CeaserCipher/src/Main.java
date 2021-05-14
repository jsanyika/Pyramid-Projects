import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        File file = null;
        try {
            file = new File("Resources\\file.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch(IOException ignored) {
        }
            System.out.println("Would you like to encrypt or decrypt(e/d)?");
            String answer = getAnswer(scanner, "e", "d");

            switch (answer) {
                case ("e"):
                    System.out.println("What is the message you would like to encrypt?");
                    String message = scanner.nextLine();
                    System.out.println("What is the key you would like to use?");
                    int key = Integer.MIN_VALUE;
                    while (key == Integer.MIN_VALUE) {
                        try {
                            key = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Any integer, please.");
                            scanner.next();
                        }
                    }

                    caeserEncrypt(message, key, file);
                    break;

                case ("d"):
                    System.out.println("Do you have a message to decrypt(y/n)? If not, I will decrypt every \n" +
                            "line in file.txt.");
                    answer = getAnswer(scanner, "y", "n");
                    switch (answer) {
                        case ("y"):
                            System.out.println("What is the message you would like to decrypt?");
                            message = scanner.nextLine();
                            System.out.println("What is the key you would like to use?");
                            key = Integer.MIN_VALUE;
                            while (key == Integer.MIN_VALUE) {
                                try {
                                    key = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Any integer, please.");
                                    scanner.next();
                                }
                            }
                            System.out.println(caeserDecrypt(message, key));
                            break;
                        case ("n"):
                            decryptAndPrintFile(file);
                            break;
                    }
                    break;


            }


    }

    public static String caeserEncrypt(String message, int key, File file) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(result.toString() + "," + key);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ignore){}

        return result.toString();
    }

    public static String caeserDecrypt(String message, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        key = 26 - (key % 26);
        for(char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                stringBuilder.append(newCharacter);
            } else {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    public static void decryptAndPrintFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String[] fileLine = scanner.nextLine().split(",");
                System.out.println(caeserDecrypt(fileLine[0], Integer.parseInt(fileLine[1])));
            }

        } catch (FileNotFoundException e) {
            System.out.println("That file could not be found. Please try again.");
        }
    }

    public static String getAnswer(Scanner scanner, String choice1, String choice2) {
        String answer = null;

        while (answer == null) {
            answer = Character.toString(scanner.nextLine().toLowerCase().charAt(0));

            if (!answer.equals(choice1) && !answer.equals(choice2)) {
                answer = null;
                System.out.println("Please input either " + choice1 + " or " + choice2);
            }

        }
        return answer;
    }
}
