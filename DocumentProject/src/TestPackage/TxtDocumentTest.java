package TestPackage;

import documentProject.TxtDocument;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TxtDocumentTest {

    @Test
    void txtDoc(){
        TxtDocument txt = new TxtDocument("titleTest", "textTest");
        assertEquals("titleTest",txt.getTitle());
    }

}