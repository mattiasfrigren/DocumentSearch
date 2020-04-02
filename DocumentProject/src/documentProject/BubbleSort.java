package documentProject;

/**
 * Anara

import java.util.Comparator;

public class BubbleSort implements SortingAlgorithm {

    // T is a place holder for the type of
    // T generics parameters (int, double, string, char and so on)

    public <SortedItem> void sort (SortedItem[] array, Comparator<SortedItem> comparator) { //Comparator - Interface, the result of it is if to compare equal it returns 0

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (isWrongOrder(array[i], array[j], comparator))
                    swap(array, i, j);
            }
        }
    }

    private <T> boolean isWrongOrder(T first, T second, Comparator<T> comparator) {

        // Compare returns > 0 if first > second,
        // returns 0 if they are equal, and < 0 otherwise.
        return comparator.compare(first, second) > 0; //method "compare" from JDK
    }

    public <T extends Comparable<T>> void sort(T[] array) { //default sort
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0)
                    swap(array, i, j);
            }
        }
    }

    private <T> void swap(T[] array, int i1, int i2) {
        T tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
*/