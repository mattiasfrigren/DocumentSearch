package TestPackage;

import documentProject.QuickSort;
import documentProject.Submenus;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.fail;

public class QuickSortTest {

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
    private <T> void assertArrayEquals(T[] input, T[] expected) {
        if (!Arrays.equals(input, expected)){
            fail("the two arrays are not equal");
        }
    }

    @Test
    public void Words_can_be_sorted () {

        final String[] array = new String[]{"Anara", "armadillo", "aardvark"};
        Submenus.quickSort(array); // method quickSort taken from the Submenu to implement the comparator from there to here and be able to test the String array
        assertArrayEquals(new String[]{"aardvark", "Anara", "armadillo"}, array);

    }
}
