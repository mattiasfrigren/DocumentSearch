package TestPackage;

import documentProject.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingFormatArgumentException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A testclass for testing the userinputs.
 * @author Henrik
 */
class InputReaderTest {
    /**
     * Sets the "inputted number" to a double and checks if an exception is thrown.
     */
    @Test
    void getIntTestWithDouble() {
        InputReader testreader = InputReader.getInputReader();
        testreader.setGetIntThrowed(false);
        testreader.setInputtedNumber(4.3);
        testreader.getInt();
        Assertions.assertTrue(testreader.getGetIntThrowed());
    }
    /**
     * Sets the "inputted number" to a string and checks if an exception is thrown.
     */
    @Test
    void getIntTestWithString() {
        InputReader testreader = InputReader.getInputReader();
        testreader.setGetIntThrowed(false);
        testreader.setInputtedNumber("hej");
        testreader.getInt();
        Assertions.assertTrue(testreader.getGetIntThrowed());
    }
    /**
     * Sets the "inputted number" to a legit number and check if the returning value is correct.
     */
    @Test
    void getIntTestWithInt() {
        InputReader testreader = InputReader.getInputReader();
        testreader.setInputtedNumber(99);
        Assertions.assertEquals(99,testreader.getInt());
    }
    /**
     * Sets the "inputted name" to nothing and checks if an exception is thrown.
     */
    @Test
    void testGetStringWithNoInput() {
        InputReader testreader = InputReader.getInputReader();
        testreader.setInputtedName("");
        testreader.getString();
        Assertions.assertTrue(testreader.getGetStringThrowed());
    }
    /**
     * Sets the "inputted name" to a valid string and checks if the returning value is the same..
     */
    @Test
    void testGetStringWithAValidString() {
        InputReader testreader = InputReader.getInputReader();
        testreader.setInputtedName("testFile");
        Assertions.assertEquals("testFile",testreader.getString());
    }
}