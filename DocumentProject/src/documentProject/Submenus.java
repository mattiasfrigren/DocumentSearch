package documentProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Submenus {
    public static void showHandleDocumentMenu() {
        int userInput = 0;
        while (userInput!=5) {
            System.out.println("What would you like to do?\n[1] Create new document\n[2] Delete document\n" +
                    "[3] Print all titles in the library\n[4] Print a document\n[5] Exit to main menu");
            userInput = InputReader.getInt(System.in);
            switch (userInput) {
                case InputReader.INPUT_FAILURE:
                    break;
                case 1:
                    try {
                        DocumentLibrary.getLibrary().createNewTxtFile();
                    } catch (LibraryException e) {
                        System.out.println("Was an error");
                    }
                    break;
                case 2:
                    try {
                        DocumentLibrary.getLibrary().deleteTxtFileFromLocalAndList();
                    } catch (IOException e) {
                        System.out.println("Was an error");
                    }
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
            userInput = InputReader.getInt(System.in);
            switch (userInput) {
                case InputReader.INPUT_FAILURE:
                    break;
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
        while (userInput!=4) {
            System.out.println(
                    "What would you like to do?\n" +
                            "[1] Sort titles\n" +
                            "[2] Sort words in a document\n" +
                            "[3] Sort words in all documents\n" +
                            "[4] Exit to main menu");
            userInput = InputReader.getInt(System.in);
            switch (userInput) {
                case InputReader.INPUT_FAILURE:
                    break;

                case 1:

                    break;

                case 2:
                    System.out.println("Enter txt file name");
                    String filename = InputReader.getString();
                    try {
                        String[] words = new WordsReader().readFile(DifferentLocalStoragePaths.docPath + "\\out\\production\\DocumentProject\\documentPackage\\" + filename);
                        words = removeDuplicates(words);
                        quickSort(words);
                        System.out.println("Words in " + filename + ":");
                        for (String word: words) {
                            System.out.println(word);
                        }
                        System.out.println();
                        System.out.println();
                    } catch (FileNotFoundException e) {
                        System.out.println("Not a real doc");
                    }
                    break;

                case 3:
                    try {
                        File directory = new File(DifferentLocalStoragePaths.docPath + "\\out\\production\\DocumentProject\\documentPackage\\");
                        String[] words = new WordsReader().readAllFiles(directory);
                        words = removeDuplicates(words);
                        quickSort(words);
                        System.out.println("Words in all files:");
                        for (String word: words) {
                            System.out.println(word);
                        }
                        System.out.println();
                        System.out.println();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Its not an alternative in the menu, please try again.");
            }
        }
    }

    // remove duplicates of words when we print out sorted words
    private static String[] removeDuplicates(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        return set.toArray(new String[0]);
    }

    public static void quickSort(String[] words) {
        //upper case and lower case sorted together
        Comparator<String> caseInsensitiveStringComparator = (word1, word2) -> word1.compareToIgnoreCase(word2);
        new QuickSort<String>(caseInsensitiveStringComparator).sort(words);
    }
}