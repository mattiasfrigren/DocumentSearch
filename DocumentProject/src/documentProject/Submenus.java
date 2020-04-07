package documentProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

//TODO add exception class
public class Submenus {
    private static InputReader reader = new InputReader();
    private KMPSearch search = new KMPSearch();
    public void showHandleDocumentMenu() throws IOException {
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
    public void searchMenu() {
        int userInput = 0;
        while (userInput!=5) {
            System.out.println("What would you like to do?\n[1] Search for a title.\n[2] Search for a word in a document " +
                    "and print indexes of word(s).\n[3] Search for a word in a document and get number of times appearing."+
                    "\n[4] Search for a word in all documents and show most times appearing.\n[5] Exit to main menu.");
            userInput = reader.getInt();
            switch (userInput) {
                case 1:
                    break;
                case 2:
                    search.getIndexes();
                    break;
                case 3:
                    search.countWords();
                    break;
                case 4:
                    search.compareDocuments();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Its not an alternative in the menu, please try again.");
            }
        }
    }
    public void sortMenu() {
        int userInput = 0;
        while (userInput!=3) {
            System.out.println("What would you like to do?\n[1] Sort titles\n[2] Sort words in a document\n" +
                    "[3] Exit to main menu");
            userInput = reader.getInt();
            switch (userInput) {
                case 1:
                    String[] titles = new File(DifferentLocalStoragePaths.docPath + "\\out\\production\\DocumentProject\\documentPackage\\")
                            .list();
                    quickSort(titles);
                    System.out.println();
                    //assert titles != null;
                    if (titles != null) { //if we don't need a warning that titles are null. It's a safe way.
                        for (String word: titles) {
                            System.out.println(word);
                        }
                    }
                    System.out.println();
                    System.out.println();

                    break;

                case 2:
                    System.out.println("Enter txt file name");
                    String filename = InputReader.getString();

                        String newWords = DocumentLibrary.getLibrary().getTextContent(filename);
                        String[] words = new String[] {newWords};
                        words = removeDuplicates(words);
                        quickSort(words);
                        System.out.println("Words in " + filename + ":");
                        for (String word: words) {
                            System.out.println(word);
                        }
                        System.out.println();
                        System.out.println();

                    break;

              /*  case 3:
                    try {
                        File directory = new File(DifferentLocalStoragePaths.docPath + "\\DocumentProject\\documentPackage\\");
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
                    break; */
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