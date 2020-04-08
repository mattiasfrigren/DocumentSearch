package TestPackage;

import documentProject.DifferentLocalStoragePaths;
import documentProject.DocumentLibrary;
import documentProject.TxtDocument;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DocumentLibraryTest {

    @Test
    @Order(2)
    void readAllFilesTest() throws IOException {
        DocumentLibrary testLibrary = DocumentLibrary.getLibrary();
        int i=0;
        File allTestFIles = new File(DifferentLocalStoragePaths.docPath+"\\DocumentProject\\src\\documentPackage");
        File[] fileArr = allTestFIles.listFiles();
        testLibrary.readInFilesToList();
        assertTrue(fileArr.length == testLibrary.getDocumentList().size());
        for (File file : fileArr) {
            assertTrue(file.getName().equals((testLibrary.getDocumentList().get(i).getTitle())+".txt"));
            i++;
        }
    }

    @Test
    @Order(1)
    void getLibraryTest() {
        DocumentLibrary library = null;
        DocumentLibrary.getLibrary();
        assertFalse(library != null);
    }

    @Test
    @Order(3)
    void createTxtDocTest() throws IOException {
        DocumentLibrary testLibrary = DocumentLibrary.getLibrary();
        testLibrary.createNewTxtFile();
        testLibrary.getDocumentList().get(DocumentLibrary.getLibrary().getDocumentList().size()-1).getTitle().equals("tjäna");
    }
    @Test
    @Order(4)
    void saveToTxtFileTest() throws IOException {
            DocumentLibrary testLibrary = DocumentLibrary.getLibrary();
            testLibrary.saveToTxtFile();
            File testfile = new File("");
            assertFalse(testfile.exists());
        testfile= new File(DifferentLocalStoragePaths.docPath+"\\" +
                "DocumentProject\\src\\documentPackage\\"+testLibrary.getTitle()+".txt");
        assertFalse(testfile.createNewFile());
        assertTrue(testfile.exists());
        assertEquals(testLibrary.getTitle()+".txt",testfile.getName());
    }


    @Test
    @Order(5)
    void deleteFileTest() throws IOException {
        DocumentLibrary testLibrary = DocumentLibrary.getLibrary();
        File testFile = new File(DifferentLocalStoragePaths.docPath+"\\DocumentProject\\src\\documentPackage\\testFile.txt");
        testFile.createNewFile();
        testLibrary.deleteTxtFile((String) testFile.getName().subSequence(0,testFile.getName().length()-4));
        assertFalse(testFile.exists());

    }
    @Test
    @Order(6)
    void deleteDocumentList(){
        DocumentLibrary testLibrary = DocumentLibrary.getLibrary();
        TxtDocument testTxt = new TxtDocument("deleteTest","deleteContent");
        testLibrary.addToList(testTxt);
        assertTrue(testLibrary.getDocumentList().contains(testTxt));
        testLibrary.deleteTxtDocument(testTxt);
        assertFalse(testLibrary.getDocumentList().contains(testTxt));
    }
    @Test
    @Order(7)
    void cutString(){
        DocumentLibrary testLibrary = DocumentLibrary.getLibrary();
        String txt = "test.txt";
        assertEquals("test",testLibrary.cutString(txt));
    }
    @Test
    @Order(8)
    void checkIfDocExists() throws IOException {
        DocumentLibrary.getLibrary().readInFilesToList();
        DocumentLibrary testLibrary = DocumentLibrary.getLibrary();
        boolean doesExist = testLibrary.documentExists("SystemTestTitle");
        boolean doesNotExsist = testLibrary.documentExists("testp");
        assertTrue(doesNotExsist);
        assertFalse(doesExist);
    }

}






