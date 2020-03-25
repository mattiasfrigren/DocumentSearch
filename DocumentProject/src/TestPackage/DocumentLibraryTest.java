package TestPackage;

import documentProject.DocumentLibrary;
import documentProject.TxtDocument;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentLibraryTest {

    @Test
    void getLibrary() {
        DocumentLibrary library = null;
        DocumentLibrary.getLibrary();
        assertFalse(library != null);
    }
}