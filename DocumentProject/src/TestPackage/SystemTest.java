package TestPackage;

import documentProject.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class creating all the objects needed in the systemtest and runs all unittests.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SystemTest {
    DocumentLibrary testLibrary = DocumentLibrary.getLibrary();
    InputReader testReader = InputReader.getInputReader();
    KMPSearch kMPSearch = new KMPSearch();
     String docPath = DifferentLocalStoragePaths.getDocPath();
    @Test
    @Order(2)
    void readAllFilesTest() throws IOException {
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
        testLibrary.createNewTxtFile();
        testLibrary.getDocumentList().get(DocumentLibrary.getLibrary().getDocumentList().size()-1).getTitle().equals("tjäna");
    }
    @Test
    @Order(4)
    void saveToTxtFileTest() throws IOException {
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
        File testFile = new File(docPath+"\\DocumentProject\\src\\documentPackage\\testFile.txt");
        testFile.createNewFile();
      //  testLibrary.deleteTxtFile((String) testFile.getName().subSequence(0,testFile.getName().length()-4));
        assertFalse(testFile.exists());

    }
    @Test
    @Order(6)
    void deleteDocumentList(){
        TxtDocument testTxt = new TxtDocument("deleteTest","deleteContent");
        testLibrary.addToList(testTxt);
        assertTrue(testLibrary.getDocumentList().contains(testTxt));
       // testLibrary.deleteTxtDocument(testTxt);
        assertFalse(testLibrary.getDocumentList().contains(testTxt));
    }
    @Test
    @Order(7)
    void cutString(){
        String txt = "test.txt";
        assertEquals("test",testLibrary.cutString(txt));
    }
    @Test
    @Order(8)
    void checkIfDocExists() throws IOException {
        boolean doesExist = testLibrary.documentExists("SystemTestTitle");
        boolean doesNotExsist = testLibrary.documentExists("testp");
        assertTrue(doesNotExsist);
        assertFalse(doesExist);
    }
    @Test
    void compileStringArray() {
        String test = "testcompile";
        CompileText text = new CompileText();
        int [] testArr = text.compileStringArray(test);
        assertTrue(testArr.length == test.length());
    }

    @Test
    void getIntTestWithDouble() {
        testReader.setGetIntThrowed(false);
        testReader.setInputtedNumber(4.3);
        testReader.getInt();
        Assertions.assertTrue(testReader.getGetStringThrowed());
    }
    @Test
    void getIntTestWithString() {
        testReader.setGetIntThrowed(false);
        testReader.setInputtedNumber("hej");
        testReader.getInt();
        Assertions.assertTrue(testReader.getGetIntThrowed());
    }
    @Test
    void getIntTestWithInt() {
        testReader.setInputtedNumber(99);
        Assertions.assertEquals(99,testReader.getInt());
    }

    @Test
    void testGetStringWithNoInput() {
        testReader.setInputtedName("");
        testReader.getString();
        Assertions.assertTrue(testReader.getGetStringThrowed());
    }
    @Test
    void testGetStringWithAValidString() {
        testReader.setInputtedName("Banan");
        Assertions.assertEquals("Banan",testReader.getString());
    }

    @Test
    void searchKMP() {
        String fullText = "hej jag heter mattias";
        String searchWord = "jag";
        int[] places = kMPSearch.searchKMP(fullText,searchWord);
        assertEquals(4,places[0]);
    }
    @Test
    void convertListToArrayTest() {
        List<Integer> test = new ArrayList<>();
        test.add(7);
        test.add(99);
        int[] testarray = kMPSearch.convertListToArray(test);
        assertEquals(testarray.length,test.size());

    }
    @Test
    void getTimesTest() {
        assertEquals(2,kMPSearch.getTimes("Två kaniner bor i två burar","två"));
    }

    @Test
    void getTextContetTest() throws IOException {
        assertEquals("SystemTest that will make sure to be executed. we will be able to sort and search in this document.",
                DocumentLibrary.getLibrary().getTextContent(DocumentLibrary.getLibrary().getTitle()));
    }

    @Test
    void testGetMaxCompareDocuments() throws IOException {
        assertEquals(7,kMPSearch.getMax("s"));
    }

    @Test
    void testTitleCompareDocuments() throws IOException {
        kMPSearch.getMax("s");
        assertTrue(kMPSearch.getMaxAppearing().equals("SystemTestTitle.txt"));
    }

    @Test
    void testSearchTitle() throws IOException {
        kMPSearch.titleSearch = "test";
        kMPSearch.searchForTitle();
        assertEquals("SystemTestTitle.txt ",kMPSearch.getMaxAppearing());
    }


    //started with testing arrays with int-values first
    @Test
    public void givenUnsortedArray_whenQuickSort_thenSortedASC() {
        Integer[] input = {6, 2, 3, 4, 5, 1};
        new QuickSort<>(Integer::compareTo).sort(input);

        Integer[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(input, expected);
    }

    @Test
    public void QuickSort_sorted_theArrayList() {
        Integer[] input = {1, 2, 3, 4, 5, 6};
        new QuickSort<>(Integer::compareTo).sort(input);

        Integer[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, input);
    }

    @Test
    public void emptyArrayIsUnchanged() {
        final Integer[] array = new Integer[0];
        new QuickSort<Integer>((one, two) -> one - two).sort(array);
        assertArrayEquals(array, new Integer[0]);
    }
    @Test
    void singletonArrayIsUnchanged() {
        final Integer[] array = new Integer[]{1};
        new QuickSort<Integer>((one, two) -> one - two).sort(array);
        assertArrayEquals(array, new Integer[]{1});
    }


    //from here the tests are adapting to Strings and other types like String.length and back to ints in the end

    @Test
    public void Words_can_be_sorted () {
        final String[] array = new String[]{"Anara", "armadillo", "aardvark"};
        DocumentLibrary.quickSort(array); // method quickSort taken from the Submenu to implement the comparator from there to here and be able to test the String array
        assertArrayEquals(new String[]{"aardvark", "Anara", "armadillo"}, array);
    }

    @Test
    public void emptyWordsArrayIdUnchanged() {
        final String[] array = new String[]{};
        DocumentLibrary.quickSort(array);
        assertArrayEquals(new String[]{}, array);
    }

    @Test
    public void Words_can_be_sorted_by_length () {
        final String[] array = new String[]{"armadillo", "aardvark", "Anara"};
        Comparator<String> lengthComparator = (word1, word2) -> word1.length() - word2.length();
        new QuickSort<>(lengthComparator).sort(array);
        assertArrayEquals(new String[]{"Anara", "aardvark", "armadillo"}, array);
    }

    @Test
    public void givenUnsortedStringArray_whenQuickSort_thenSortedASC() {
        String[] input = {"5", "22", "3", "6", "41", "1"};
        DocumentLibrary.quickSort(input);
        String [] expected = {"1", "22", "3", "41", "5", "6"};
        assertArrayEquals(input, expected);
    }

    @Test
    public void givenUnsortedArrayAsStrings_whenQuickSort_thenSortedASC_asNumbers() {
        String[] input = {"5", "22", "3", "6", "41", "1"};
        //converting the strings with number values into integers and sorting them as ints
        Comparator<String> stringsAsIntComparator = (word1, word2) -> Integer.valueOf(word1).compareTo(Integer.valueOf(word2));
        new QuickSort<>(stringsAsIntComparator).sort(input);
        String [] expected = {"1", "3", "5", "6", "22", "41"};
        assertArrayEquals(input, expected);
    }


    private <T> void assertArrayEquals(T[] input, T[] expected) {
        if (!Arrays.equals(input, expected)){
            fail("the two arrays are not equal.\n" +
                    "expected:" + Arrays.deepToString(expected) + "\n" +
                    "actual:" + Arrays.deepToString(input)); //to see why it fails if it fails
        }
    }

    @Test
    void txtDoc(){
        TxtDocument txt = new TxtDocument("titleTest", "textTest");
        assertEquals("titleTest",txt.getTitle());
    }

}
