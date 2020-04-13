package TestPackage;

import documentProject.CompileText;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testclass for testing the pattern of the word used in searching.
 * @author Mattias
 */
class CompileTextTest {
    /**
     * Test to ensure that the array has correct length and has correct integers of the expected pattern.
     */
    @Test
    void compileStringArray() {
        String test = "testcompile";
        CompileText text = new CompileText();
        int [] testArr = text.compileStringArray(test);
        assertTrue(testArr.length == test.length());
        assertArrayEquals(new int[]{0,0,0,1,0,0,0,0,0,0,0}, testArr);
    }
}