package documentProject;

import java.io.IOException;
import java.util.Scanner;

//TODO add exception class
public class Submenus {
    private static InputReader reader = new InputReader();
    public static void showHandleDocumentMenu() throws IOException {
        int userInput = 0;
        while (userInput!=5) {
            System.out.println("What would you like to do?\n[1] Create new document\n[2] Delete document\n" +
                    "[3] Print all titles in the library\n[4] Print a document\n[5] Exit to main menu");
            userInput = reader.getInt();
            switch (userInput) {
                case 1:
                        DocumentLibrary.getLibrary().createNewTxtFile();
                    break;
                case 2:
                        DocumentLibrary.getLibrary().deleteTxtFileFromLocalAndList();
                    break;
                case 3:
                    DocumentLibrary.getLibrary().printAllTitles();
                    break;
                case 4:
                    DocumentLibrary.getLibrary().chooseTitleToPrint();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Its not an alternative in the menu, please try again.");
            }
        }
    }
    public static void searchMenu() {
        int userInput = 0;
        while (userInput!=4) {
            System.out.println("What would you like to do?\n[1] Search for a title\n[2] Search for a phrase in a document\n" +
                    "[3] Search for a phrase in all documents\n[4] Exit to main menu");
            userInput = reader.getInt();
            switch (userInput) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Its not an alternative in the menu, please try again.");
            }
        }
    }
    public static void sortMenu() {
        int userInput = 0;
        while (userInput!=3) {
            System.out.println("What would you like to do?\n[1] Sort titles\n[2] Sort words in a document\n" +
                    "[3] Exit to main menu");
            userInput = reader.getInt();
            switch (userInput) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Its not an alternative in the menu, please try again.");
            }
        }
    }
}
