package documentProject;

import java.util.Comparator;

/**
 * QuickSort algorithm
 * @author Anara
 */
public class QuickSort<T> {
    /**
     * select pivot
     * move smaller elements to the left and bigger elements to the right
     * recursively sort left and right part
     * "final Comparator" here it is placed not to pass it through all functions, not to duplicate the code
     * QuickSort constructor to create a quick sort with the comparator
     * @param <T> type of items in arrays to be sorted
     */
    final Comparator<T> comparator;
    public QuickSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }
    /**
     * here "sort" is kind of an "overload" to divide the method in 2 parts
     * it is added to be as an interface
     * @param array temporal word document in thw form of an array
     */
    public void sort(T[] array) {
        sort(array, 0, array.length - 1);
    }
    /**
     * here "sort" is a recursive function with the algorithm
     * @param array of words to sort
     * @param begin first item
     * @param end last item
     */
    private void sort(T[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            sort(array, begin, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
    }
    /**
     * partition method we need to sort by dividing the array into 2 parts: sorted and unsorted
     * take the last element (value, and split the array in the middle) as a pivot
     * from "i" to "j" we need to swap the elements if they are on wrong position comparing to pivot
     * @return sorted array
     */
    private int partition(T[] arr, int begin, int end) {
        T pivot = arr [end];
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            if (comparator.compare(arr[j], pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, end, i + 1);
        return i+1;
    }
    /**
     * swapping the items to order them
     * @param array of words
     * @param i item
     * @param j item
     */
    private void swap(T[] array, int i, int j) {
        T swapTemp = array[i];
        array[i] = array[j];
        array[j] = swapTemp;
    }
}