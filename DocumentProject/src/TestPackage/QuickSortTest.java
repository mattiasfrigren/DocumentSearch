package TestPackage;

import documentProject.DocumentLibrary;
import documentProject.QuickSort;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.fail;

public class QuickSortTest {

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
}
