package documentProject;

import java.io.IOException;
import java.util.Scanner;

public class Hub {
    private static Hub hub = new Hub();
    private static DocumentLibrary library = DocumentLibrary.getLibrary();
    private Hub() {
        int input = 0;
        System.out.println("Welcome to main menu.");
        while (input !=7) {
            Scanner sc = new Scanner(System.in);
            printMenu();
            input = sc.nextInt();
            switch (input) {
                case 1:
                    try { library.CreateNewTxtFile(); }
                    catch (IOException e) { e.printStackTrace(); }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Its not an alternative in the menu, please try again.");
            }
        }
    }
    private void printMenu() {
        System.out.println("[1] Read .txt from computer and store it.\n[2] Print a document.\n[3] Sort words in a specific document." +
                "\n[4] Sort words in all documents.\n[5] Search in a specific document.\n[6] Search in all documents.\n[7] Exit system.");
    }
    public static Hub getHub() {
        return hub;
    }
}
