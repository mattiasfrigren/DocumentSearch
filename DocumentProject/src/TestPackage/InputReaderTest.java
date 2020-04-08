package TestPackage;

import documentProject.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingFormatArgumentException;

import static org.junit.jupiter.api.Assertions.*;

public class InputReaderTest {

    @Test
    void getIntTestWithDouble() {
        InputReader testreader = new InputReader();
        testreader.getIntThrowed = false;
        testreader.inputtedNumber = 4.3;
        testreader.getInt();
        Assertions.assertTrue(testreader.getIntThrowed);
    }
    @Test
    void getIntTestWithString() {
        InputReader testreader = new InputReader();
        testreader.getIntThrowed = false;
        testreader.inputtedNumber = "hej";
        testreader.getInt();
        Assertions.assertTrue(testreader.getIntThrowed);
    }
    @Test
    void getIntTestWithInt() {
        InputReader testreader = new InputReader();
        testreader.inputtedNumber = 99;
        Assertions.assertEquals(99,testreader.getInt());
    }

    @Test
    void testGetStringWithNoInput() {
        InputReader testreader = new InputReader();
        testreader.inputtedName = "";
        testreader.getString();
        Assertions.assertTrue(testreader.getStringThrowed);
    }
    @Test
    void testGetStringWithAValidString() {
        InputReader testreader = new InputReader();
        testreader.inputtedName = "Banan";
        Assertions.assertEquals("Banan",testreader.getString());
    }
}
