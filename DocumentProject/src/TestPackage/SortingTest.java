package TestPackage;

import documentProject.DocumentLibrary;
import documentProject.Sorting;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the sortingclass. The method Quicksort is tested by the Quicksorttestclass.
 * Many methods in the sorting class are just methods which calls other already tested methods and
 * therefore not needs anymore testing at these.
 * @author Henrik
 */
class SortingTest {
    /**
     * This method checks after creating a new document that the last element in the array is that title.
     * @throws IOException
     */
    @Test
    void getTitlesInArray() throws IOException {
        Sorting sorting = new Sorting();
        DocumentLibrary library = DocumentLibrary.getLibrary();
        library.createNewTxtFile();
        String[] titles = sorting.getTitlesInArray();
        assertEquals("testFile",titles[titles.length-1]);
    }

    /**
     * Checks if the method returns true when user enters save.
     */
    @Test
    void askForSaveSort() {
        Sorting sorting = new Sorting();
        assertTrue(sorting.askForSaveSort());
    }
}