package documentProject;

import java.io.*;
import java.util.Comparator;

/**
 * methods for sorting texts is places in the Sorting class
 * @author Anara
 */
public class Sorting {
    /**
     * quick sorting algorithm is called to sort words in documents
     * @param words all with upper case and lower case sorted together
     */
    public static void quickSort(String[] words) {
        Comparator<String> caseInsensitiveStringComparator = (word1, word2) -> word1.compareToIgnoreCase(word2);
        new QuickSort<>(caseInsensitiveStringComparator).sort(words);
    }
    /**
     * method to sort titles of the text files
     */
    public void sortTitles() {
        String[] titles = new File(DifferentLocalStoragePaths.getDocPath() + "\\out\\production\\DocumentProject\\documentPackage\\")
                .list();
        Sorting.quickSort(titles);
        System.out.println();
        //assert titles != null;
        if (titles != null) {
            for (String word : titles) {
                System.out.println(word);
            }
        }
        System.out.println();
        System.out.println();
    }
    /**
     * method for sorting texts in the files
     * "while loop" allows to keep entering filenames if file does not exist
     * either we quit to the sort menu by pressing "q"
     */
    public void sortText() {
        System.out.println("Enter txt file name");
        String filename = InputReader.getString();

        String wordsString = DocumentLibrary.getLibrary().getTextContent(filename);
        while (wordsString == null) {
            System.out.println("File does not exist. Please enter the name of the document or go back to the sort menu by pressing [q]");

            filename = InputReader.getString();
            if (filename.equals("q")) {
               new Submenus().sortMenu();
                return;
            }
            wordsString = DocumentLibrary.getLibrary().getTextContent(filename);
        }
        String[] words = DocumentLibrary.getLibrary().createStringArray(wordsString);
        Sorting.quickSort(words);
        System.out.println("Words in " + filename + ":");
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println();
        saveSorted(filename, words);
    }
    /**
     * saveSorted method updates the document after choosing it to be saved as sorted by pressing "y"
     * otherwise it will be kept as an unsorted document
     * @param filename is the same filename
     * @param words gets saved as a sorted array
     */
    private void saveSorted(String filename, String[] words) {
        System.out.println("Would you like to save the document as sorted one? y / n");
        if (InputReader.getString().equals("y")) {
            try {
                DocumentLibrary.getLibrary().updateFile(filename, String.join(" ", words));
                DocumentLibrary.getLibrary().updateTextContent(filename, String.join(" ", words));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println();
        }
    }
}