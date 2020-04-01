package TestPackage;

import documentProject.DifferentLocalStoragePaths;
import documentProject.DocumentLibrary;
import documentProject.LibraryException;
import documentProject.TxtDocument;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DocumentLibraryTest {

    private DocumentLibrary testLibrary = DocumentLibrary.getLibrary();


    @Test
    void getLibraryTest() {
        DocumentLibrary library = null;
        DocumentLibrary.getLibrary();
        assertFalse(library != null);
    }
    //TODO Wrong in this test?
    @Test
    void createTxtDocTest(){
        String title = "hej";
        String text = "tjäna";
        DocumentLibrary.getLibrary().createTxtDocument();
        DocumentLibrary.getLibrary().getDocumentList().get(DocumentLibrary.getLibrary().getDocumentList().size()-1).getTitle().equals("hej");
    }
    @Test
    void saveToTxtFileTest() throws IOException, LibraryException {
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
    void readAllFilesTest() throws IOException {
        int i=0;
        File allTestFIles = new File(DifferentLocalStoragePaths.docPath+"\\DocumentProject\\src\\documentPackage");
        File[] fileArr = allTestFIles.listFiles();
        testLibrary.readInFilesToList();
        assertTrue(fileArr.length == testLibrary.getDocumentList().size());
        for (File file : fileArr) {
            assertTrue(file.getName().equals(testLibrary.getDocumentList().get(i).getTitle()));
            i++;
        }
    }
    @Test
    void deleteFileTest() throws IOException {
        File testFile = new File(DifferentLocalStoragePaths.docPath+"\\DocumentProject\\src\\documentPackage\\testFile.txt");
        testFile.createNewFile();
        testLibrary.deleteTxtFile(testFile);
        assertFalse(testFile.exists());
        
    }
    @Test
    void deleteDocumentList(){
        TxtDocument testTxt = new TxtDocument("deleteTest","deleteContent");
        testLibrary.addToList(testTxt);
        assertTrue(testLibrary.getDocumentList().contains(testTxt));
        testLibrary.deleteTxtDocument(testTxt);
        assertFalse(testLibrary.getDocumentList().contains(testTxt));
    }
}






