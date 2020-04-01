package TestPackage;

import documentProject.InsertionSort;
import documentProject.QuickSort;
import documentProject.SortingAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortingAlgorithmTest {
    SortingAlgorithm algorithm;

    @BeforeEach
    void setUp() {
        //algorithm = new BubbleSort();
        //algorithm = new InsertionSort();

        algorithm = new QuickSort();
    }

    @Test
    public void givenUnsortedArray_whenInsertionSortImperative_thenSortedASC() {

        int[] input = {6, 2, 3, 4, 5, 1};
        InsertionSort.insertionSortImperative(input);
        
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals("the two arrays are not equal", expected, input);
    }

    private void assertArrayEquals(String s, int[] expected, int[] input) {
    }

    @Test
    public void QuickSort_sorted_theArrayList() {
        int[] input = {6, 2, 3, 4, 5, 1};
        InsertionSort.insertionSortImperative(input);

        int[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals("the two arrays are not equal", expected, input);

    }
}
