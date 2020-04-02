package TestPackage;

import documentProject.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingFormatArgumentException;

import static org.junit.jupiter.api.Assertions.*;

public class InputReaderTest {
    InputReader testreader = new InputReader();

    @Test
    void getIntTestWithDouble() {
        testreader.getIntThrowed = false;
        testreader.inputtedNumber = 4.3;
        testreader.getInt();
        Assertions.assertTrue(testreader.getIntThrowed);
    }
    @Test
    void getIntTestWithString() {
        testreader.getIntThrowed = false;
        testreader.inputtedNumber = "hej";
        testreader.getInt();
        Assertions.assertTrue(testreader.getIntThrowed);
    }
    @Test
    void getIntTestWithInt() {
        testreader.inputtedNumber = 99;
        Assertions.assertEquals(99,testreader.getInt());
    }

    @Test
    void testGetStringWithNoInput() {
        testreader.inputtedName = "";
        testreader.getString();
        Assertions.assertTrue(testreader.getStringThrowed);
    }
    @Test
    void testGetStringWithAValidString() {
        testreader.inputtedName = "Banan";
        Assertions.assertEquals("Banan",testreader.getString());
    }
}
