package TestPackage;

import documentProject.CompileText;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompileTextTest {

    @Test
    void compileStringArray() {
        String test = "testcompile";
        CompileText text = new CompileText();
        int [] testArr = text.compileStringArray(test);
        assertTrue(testArr.length == test.length());
    }
}