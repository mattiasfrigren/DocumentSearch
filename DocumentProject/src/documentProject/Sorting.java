package documentProject;

import java.io.*;
import java.util.Comparator;
/**
 * methods for sorting texts is places in the Sorting class
 * @author Anara Henrik
 */
public class Sorting {
    private InputReader reader = InputReader.getInputReader();
    private DocumentLibrary library = DocumentLibrary.getLibrary();
    /**
     * quick sorting algorithm is called to sort words in documents
     * @param words all with upper case and lower case sorted together
     */
    public static void quickSort(String[] words) {
        Comparator<String> caseInsensitiveStringComparator = (word1, word2) -> word1.compareToIgnoreCase(word2);
        new QuickSort<>(caseInsensitiveStringComparator).sort(words);
    }
    /**
     * method to sort titles and print it to the user.
     */
    public void sortTitles() {
        if (library.getDocumentList().size()>0) {
            String[] titlesInArray = getTitlesInArray();
            quickSort(titlesInArray);
            printSortedArrays(titlesInArray,"librarytitles",true);
        }
        else {
            System.out.println("There is no titles to sort in the library.");
        }
    }
    /**
     * Method to get all the titles in the documentlist in an array.
     * @return the Stringarray of titles.
     */
    public String[] getTitlesInArray() {
        if (library.getDocumentList().size()>0) {
            String[] titles = new String[library.getDocumentList().size()];
            for (int i = 0; i < titles.length; i++) {
                titles[i] = library.getDocumentList().get(i).getTitle();
            }
            return titles;
        }
        return null;
    }
    /**
     * Method for sorting words in a document. It calls the sorting algorithm with the words,
     * print the new order and ask the user if he wants to save the new order. If the document is to big to
     * sort it will be stackoverflow and therefore it catches this.
     */
    public void sortText() throws IOException {
        library.readInTitle();
        String title = library.getTitle();
        String content = library.getTextContent(title);
        if (content!=null) {
            try {
                String[] words = library.createStringArray(content);
                quickSort(words);
                printSortedArrays(words, title, false);
                if (askForSaveSort()) {
                    saveSorted(title, words);
                }
            }
            catch (StackOverflowError s) {
            System.err.println("The document is to large to sort, please try another next time.");
            }
        }
        else {
            System.out.println("There is no \""+title+"\" in the library.");
        }
    }

    /**
     * The method prints both the titles and the words after sorting.
     * @param parts The words
     * @param parent If it titles or content
     */
    private void printSortedArrays(String[] parts, String parent, boolean isTitle) {
        System.out.println("Sorted " + parent + ":");
        for (String word : parts) {
            if (isTitle) {System.out.println(word+", ");}
            else System.out.print(word+", ");
        }
    }

    /**
     * This method asks if the user wants to save the new sortingorder.
     * @return true if the user wants to save it
     */
    public boolean askForSaveSort() {
        String saveAnswer = "";
        System.out.println("\nEnter \"save\" to save the document as sorted or enter \"exit\".");
        while (saveAnswer.equals("")) {
             saveAnswer = "save"; //(for testing)
            //saveAnswer = reader.getString().toLowerCase();
            if (saveAnswer.equals("save")) {
               return true;
            }
        }
        return false;
    }
    /**
     * This method calls the savingmethods in the library.
     * @param title The title which will be overwritten.
     * @param words The content which will be overwritten.
     */
    public void saveSorted(String title, String[] words) throws IOException {
        library.updateFile(title, String.join(" ", words));
        library.updateTextContent(title, String.join(" ", words));
        System.out.println("The sorting is saved.");
    }
}