package documentProject;

// select pivot
// move smaller elements to the left and bigger elements to the right
// recursively sort left and right part

import java.util.Comparator;


public class QuickSort<T> {
    final Comparator<T> comparator; // here it is placed not to pass it through all functions, not to duplicate the code

    public QuickSort(Comparator<T> comparator){ //constructor to create a quick sort with the comparator
        this.comparator = comparator;
    }

    //kind of an overload to divide the method in 2 parts
    public void sort (T[] array) { //this is added to be as an interface
        sort(array, 0, array.length - 1);
    }

    private void sort (T[] array, int begin, int end) { //recursive function with the algorithm

        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            sort(array, begin, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
    }

    //partition method we need to sort by dividing the array into 2 parts: sorted and unsorted
    private int partition (T[] arr, int begin, int end) {

        T pivot = arr [end]; // take the last element (value, and split the array in the middle) as a pivot
        int i = (begin-1); //element i supposed to take the begin place

        for (int j = begin; j < end; j++) { //from i to j we need to swap the elements if they are on wrong position comparing to pivot
            if (comparator.compare(arr[j], pivot) <= 0) {
                i++;

                swap(arr, i, j);
            }
        }

        swap(arr, end, i + 1);

        return i+1;
    }

    private void swap(T[] array, int i, int j) {
        T swapTemp = array[i]; // for i if it is bigger than a temporal element, that bigger i takes place towards the end
        array[i] = array[j];
        array[j] = swapTemp; // so that bigger i moves to the right side if its temporally operated
    }
}