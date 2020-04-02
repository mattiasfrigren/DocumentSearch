package TestPackage;

import documentProject.InputReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputReaderTest {


    @Test
    void getInt_test() {

    }

    @Test
    void getInt_whitespace_stopsReading() {
        int[] readValues = new int[]{
                (int)'3',
                (int)' ',
                (int)'x',
                -1
        };

        InputStream in = new InputStream() {
            int currentPosition = 0;
            @Override
            public int read() {
                int value = readValues[currentPosition];
                currentPosition++;
                return value;
            }
        };

        int actual = InputReader.getInt(in);
        assertEquals( 3, actual);
    }

    @Test
    void getInt_multipleDigits_decimal() {
        int[] readValues = new int[]{
                (int)'1',
                (int)'3',
                (int)'\n',
                -1
        };

        InputStream in = new InputStream() {
            int currentPosition = 0;
            @Override
            public int read() {
                int value = readValues[currentPosition];
                currentPosition++;
                return value;
            }
        };

        int actual = InputReader.getInt(in);
        assertEquals(13, actual);
    }
}
