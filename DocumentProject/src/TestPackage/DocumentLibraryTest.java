package TestPackage;

import documentProject.DifferentLocalStoragePaths;
import documentProject.DocumentLibrary;
import documentProject.InputReader;
import documentProject.TxtDocument;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DocumentLibraryTest {
    String docPath = DifferentLocalStoragePaths.getDocPath();
    @Test
    @Order(2)
    void readAllFilesTest() throws IOException {
        DocumentLibrary testLibrary = DocumentLibrary.getLibrary();
        int i=0;
        File allTestFIles = new File(docPath+"\\DocumentProject\\src\\documentPackage");
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
        testfile= new File(docPath+"\\" +
                "DocumentProject\\src\\documentPackage\\"+testLibrary.getTitle()+".txt");
        assertFalse(testfile.createNewFile());
        assertTrue(testfile.exists());
        assertEquals(testLibrary.getTitle()+".txt",testfile.getName());
    }


    @Test
    @Order(5)
    void deleteFileTest() throws IOException {
        DocumentLibrary testLibrary = DocumentLibrary.getLibrary();
        testLibrary.readInTitle();
        File testFile = new File(docPath+"\\DocumentProject\\src\\documentPackage\\"+testLibrary.getTitle()+".txt");
        testFile.createNewFile();
        testLibrary.deleteTxtFile();
        assertFalse(testFile.exists());

    }
    @Test
    @Order(6)
    void deleteDocumentList(){
        DocumentLibrary testLibrary = DocumentLibrary.getLibrary();
        TxtDocument testTxt = new TxtDocument("deleteTest","deleteContent");
        testLibrary.setSavedDoc(true);
        testLibrary.addToList(testTxt);
        assertTrue(testLibrary.getDocumentList().contains(testTxt));
        testLibrary.documentExists(testTxt.getTitle());
        testLibrary.deleteTxtDocument();
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
        testLibrary.createNewTxtFile();
        boolean doesExist = testLibrary.documentExists("testFile");
        boolean doesNotExsist = testLibrary.documentExists("testp");
        assertTrue(doesNotExsist);
        assertFalse(doesExist);
    }
    @Test
    @Order(9)
    void updateFileTest() throws IOException {
        DocumentLibrary.getLibrary().readInFilesToList();
        assertEquals("testFile",DocumentLibrary.getLibrary().getDocumentList().get(11).getTextContent());
        DocumentLibrary.getLibrary().updateFile("testFile","newTestFile");
        File txtFile = new File(docPath+"\\DocumentProject\\src\\documentPackage\\testFile.txt");
        assertTrue(Files.readString(Paths.get(txtFile.getPath())).equals("newTestFile"));
    }

}






