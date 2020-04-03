package TestPackage;

import documentProject.KMPSearch;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KMPSearchTest {

    @Test
    void searchKMP() {
        String fullText = "hej jag heter mattias";
        String searchWord = "jag";
        KMPSearch search = new KMPSearch();
       int[] places = search.searchKMP(fullText,searchWord);
        assertEquals(4,places[0]);
    }
}