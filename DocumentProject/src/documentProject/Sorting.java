package documentProject;

import java.io.*;
import java.util.Comparator;
/**
 * methods for sorting texts is places in the Sorting class
 * @author Anara
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
     * method to sort titles of the text files
     */
    public void sortTitles() {
        if (library.getDocumentList().size()>1) {
        String[] titlesInArray = getTitlesInArray();
        quickSort(titlesInArray);
        printSortedArrays(titlesInArray,"librarytitles");
        }
    }
    private String[] getTitlesInArray() {
        String[] titles = new String[library.getDocumentList().size()];
        for (int i = 0; i<titles.length;i++) {
            titles[i] = library.getDocumentList().get(i).getTitle();
        }
        return titles;
    }
    /**
     * method for sorting texts in the files
     * "while loop" allows to keep entering filenames if file does not exist
     * either we quit to the sort menu by pressing "q"
     */
    public void sortText() {
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
    private void printSortedArrays(String[] parts, String parent) {
        System.out.println("Sorted " + parent + ":");
        for (String word : parts) {
            System.out.println(word);
        }
    }

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
     * saveSorted method updates the document after choosing it to be saved as sorted by pressing "y"
     * otherwise it will be kept as an unsorted document
     * @param filename is the same filename
     * @param words gets saved as a sorted array
     */
    private void saveSorted(String filename, String[] words) {
        try {
            library.updateFile(filename, String.join(" ", words));
            library.updateTextContent(filename, String.join(" ", words));
            System.out.println("The sorting is saved.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}