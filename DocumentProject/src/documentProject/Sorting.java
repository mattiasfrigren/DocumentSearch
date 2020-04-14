package documentProject;
/**
 * Anara
 */
import java.io.*;
import java.util.Comparator;

public class Sorting {

    /**
     * quick sorting algorithm
     * @param words all sorted together
     */
    public static void quickSort(String[] words) {
        //upper case and lower case sorted together
        Comparator<String> caseInsensitiveStringComparator = (word1, word2) -> word1.compareToIgnoreCase(word2);
        new QuickSort<String>(caseInsensitiveStringComparator).sort(words);
    }

    /**
     * method to sort titles of the text files
     */
    public static void sortTitles() {
        String[] titles = new File(DifferentLocalStoragePaths.getDocPath() + "\\out\\production\\DocumentProject\\documentPackage\\")
                .list();
        Sorting.quickSort(titles);
        System.out.println();
        //assert titles != null;
        if (titles != null) { //if we don't need a warning that titles are null. It's a safe way.
            for (String word : titles) {
                System.out.println(word);
            }
        }
        System.out.println();
        System.out.println();
    }

    /**
     * method for sorting texts in the files
     * saving the file as sorted if to press "y", either the file will not be saved as sorted
     */
    public static void sortText() {
        System.out.println("Enter txt file name");
        String filename = InputReader.getString();

        String wordsString = DocumentLibrary.getLibrary().getTextContent(filename);
        while (wordsString == null) {
            System.out.println("File does not exist. Please enter the name of the document or go back to the sort menu by pressing [1]");

            filename = InputReader.getString();
            if (filename.equals("1")) {
                return;
            }
            Submenus.sortMenu();
            wordsString = DocumentLibrary.getLibrary().getTextContent(filename);
        }

        String[] words = DocumentLibrary.getLibrary().createStringArray(wordsString);
        Sorting.quickSort(words);
        System.out.println("Words in " + filename + ":");
        for (String word : words) {
            System.out.println(word);
        }

        System.out.println();

        System.out.println("Would you like to safe the document as sorted one? Y / N");
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