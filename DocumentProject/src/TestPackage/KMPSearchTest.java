package TestPackage;

import documentProject.DocumentLibrary;
import documentProject.KMPSearch;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KMPSearchTest {

    @Test
    void searchKMP() {
        KMPSearch kMPSearch = new KMPSearch();
        String fullText = "hej jag heter mattias";
        String searchWord = "jag";
        int[] places = kMPSearch.searchKMP(fullText,searchWord);
        assertEquals(4,places[0]);
    }
    @Test
    void convertListToArrayTest() {
        KMPSearch kMPSearch = new KMPSearch();
        List<Integer> test = new ArrayList<>();
        test.add(7);
        test.add(99);
        int[] testarray = kMPSearch.convertListToArray(test);
        assertEquals(testarray.length,test.size());

    }
    @Test
    void getTimesTest() {
        KMPSearch kMPSearch = new KMPSearch();
        assertEquals(2,kMPSearch.getTimes("Två kaniner bor i två burar","två"));
    }

    @Test
    void getTextContetTest() throws IOException {
        DocumentLibrary.getLibrary().readInFilesToList();
        KMPSearch kMPSearch = new KMPSearch();
        assertEquals("SystemTest that will make sure to be executed. we will be able to sort and search in this document.",kMPSearch.getTextContet("SystemTestTitle"));
    }

    @Test
    void testCompareDocuments() throws IOException {
        DocumentLibrary.getLibrary().readInFilesToList();
        KMPSearch kMPSearch = new KMPSearch();
        assertEquals(7,kMPSearch.getMax("s"));
        assertTrue(kMPSearch.getMaxAppearing().equals("SystemTestTitle.txt"));
    }
    @Test
    void testSearchTitle() throws IOException {
        DocumentLibrary.getLibrary().readInFilesToList();
        KMPSearch kMPSearch = new KMPSearch();
        kMPSearch.titleSearch = "test";
        kMPSearch.searchForTitle();
        assertEquals("SystemTestTitle.txt testtesttest.txt ",kMPSearch.getMaxAppearing());
    }
}




