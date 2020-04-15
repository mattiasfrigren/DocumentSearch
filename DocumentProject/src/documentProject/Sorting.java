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
        if (library.getDocumentList().size()>1) {
            String[] titlesInArray = getTitlesInArray();
            quickSort(titlesInArray);
            printSortedArrays(titlesInArray,"librarytitles");
        }
        else {
            System.out.println("There is no titles(or only one) to sort in the library.");
        }
    }
    /**
     * Method to get all the titles in the documentlist in an array.
     * @return the Stringarray of titles.
     */
    private String[] getTitlesInArray() {
        String[] titles = new String[library.getDocumentList().size()];
        for (int i = 0; i<titles.length;i++) {
            titles[i] = library.getDocumentList().get(i).getTitle();
        }
        return titles;
    }
    /**
     * Method for sorting words in a document. It calls the sorting algorithm with the words,
     * print the new order and ask the user if he wants to save the new order.
     */
    public void sortText() throws IOException {
        library.readInTitle();
        String title = library.getTitle();
        String content = library.getTextContent(title);
        if (content!=null) {
            String[] words = library.createStringArray(content);
            quickSort(words);
            printSortedArrays(words,title);
            if (askForSaveSort()){
                saveSorted(title,words);
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
    private void printSortedArrays(String[] parts, String parent) {
        System.out.println("Sorted " + parent + ":");
        for (String word : parts) {
            System.out.println(word);
        }
    }

    /**
     * This method asks if the user wants to save the new sortingorder.
     * @return true if the user wants to save it
     */
    private boolean askForSaveSort() {
        String saveAnswer = "";
        System.out.println("Enter \"save\" to save the document as sorted or enter \"exit\".");
        while (saveAnswer.equals("")) {
            saveAnswer = reader.getString();
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
    private void saveSorted(String title, String[] words) throws IOException {
        library.updateFile(title, String.join(" ", words));
        library.updateTextContent(title, String.join(" ", words));
        System.out.println("The sorting is saved.");
    }
}