package documentProject;

import java.util.Comparator;

/**
 * select pivot
 * move smaller elements to the left and bigger elements to the right
 * recursively sort left and right part
 */

public class QuickSort<T> {
    final Comparator<T> comparator; // here it is placed not to pass it through all functions, not to duplicate the code

    public QuickSort(Comparator<T> comparator){ //constructor to create a quick sort with the comparator
        this.comparator = comparator;
    }

    //kind of an overload to divide the method in 2 parts
    public void sort (T[] array) { //this is added to be as an interface
        sort(array, 0, array.length - 1);
    }

    /**
     * recursive function with the algorithm
     * @param array of words to sort
     * @param begin first item
     * @param end last item
     */
    private void sort (T[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            sort(array, begin, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
    }

    /**
     * partition method we need to sort by dividing the array into 2 parts: sorted and unsorted
     * @return sorted array
     */
    private int partition (T[] arr, int begin, int end) {
        T pivot = arr [end]; // take the last element (value, and split the array in the middle) as a pivot
        int i = (begin-1);

        for (int j = begin; j < end; j++) { //from i to j we need to swap the elements if they are on wrong position comparing to pivot
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