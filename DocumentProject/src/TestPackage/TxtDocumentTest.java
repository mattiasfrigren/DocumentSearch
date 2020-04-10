package TestPackage;

import documentProject.TxtDocument;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testclass for test the textdocumentclass.
 * @author Mattias
 */
class TxtDocumentTest {
    /**
     * Test to see that the correct title is set when creating new document.
     */
    @Test
    void txtDocTest(){
        TxtDocument txt = new TxtDocument("titleTest", "textTest");
        assertEquals("titleTest",txt.getTitle());
    }
}