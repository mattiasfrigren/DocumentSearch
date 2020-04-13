package TestPackage;

import documentProject.DocumentLibrary;
import documentProject.KMPSearch;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testclass for test the searchalgorithm.
 * @author Mattias and Henrik
 */
class KMPSearchTest {
    /**
     * Test to check that searchword appear on correct index in the text.
     */
    @Test
    void searchKMP() {
        KMPSearch kMPSearch = new KMPSearch();
        String fullText = "hej jag heter mattias";
        String searchWord = "jag";
        int[] places = kMPSearch.searchKMP(fullText,searchWord);
        assertEquals(4,places[0]);
    }
    /**
     * Test to ensure that after converting list to array the length is the same.
     */
    @Test
    void convertListToArrayTest() {
        KMPSearch kMPSearch = new KMPSearch();
        List<Integer> test = new ArrayList<>();
        test.add(7);
        test.add(99);
        int[] testArray = kMPSearch.convertListToArray(test);
        assertEquals(testArray.length,test.size());
    }
    /**
     * Test to ensure that the array of integers is the correct length.
     */
    @Test
    void getTimesTest() {
        KMPSearch kMPSearch = new KMPSearch();
        assertEquals(2,kMPSearch.getTimes("Två kaniner bor i två burar","två"));
    }
    /**
     * Test to ensure that correct textcontent is returned when calling the method with a title. The document
     * obviously must exist in the documentpackage.
     * @throws IOException if error while reading
     */
    @Test
    void getTextContentTest() throws IOException {
        DocumentLibrary.getLibrary().readInFilesToList();
        KMPSearch kMPSearch = new KMPSearch();
        assertEquals("SystemTest that will make sure to be executed. we will be able to sort and search in this document."
        ,DocumentLibrary.getLibrary().getTextContent(DocumentLibrary.getLibrary().getTitle()));
    }

    /**
     * Test to ensure that the method returns the correct number of the total hits of the searchword in a document.
     * @throws IOException if error while reading.
     */
    @Test
    void testGetMaxCompareDocuments() throws IOException {
        DocumentLibrary.getLibrary().readInFilesToList();
        KMPSearch kMPSearch = new KMPSearch();
        assertEquals(7,kMPSearch.getMax("s"));
    }
    /**
     * Test to ensure that the method set the correct title of the most relevant document.
     * @throws IOException if error while reading.
     */
    @Test
    void testTitleCompareDocuments() throws IOException {
        DocumentLibrary.getLibrary().readInFilesToList();
        KMPSearch kMPSearch = new KMPSearch();
        kMPSearch.getMax("s");
        assertTrue(kMPSearch.getMaxAppearing().equals("SystemTestTitle.txt"));
    }

    /**
     * Test to ensure correct title is found when searching for a title.
     * @throws IOException if error while reading.
     */
    @Test
    void testSearchTitle() throws IOException {
        DocumentLibrary.getLibrary().readInFilesToList();
        KMPSearch kMPSearch = new KMPSearch();
        kMPSearch.titleSearch = "test";
        kMPSearch.searchForTitle();
        assertEquals("SystemTestTitle.txt ",kMPSearch.getMaxAppearing());
    }
}