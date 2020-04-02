package documentProject;

// select pivot
// move smaller elements to the left and bigger elements to the right
// recursively sort left and right part

import java.util.Comparator;


public class QuickSort<T> {

    final Comparator<T> comparator;

    public QuickSort(Comparator<T> comparator){
        this.comparator  = comparator;
    }

    //partition method we need to sort by dividing the array into 2 parts: sorted and unsorted

    public void sort (T[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort (T[] array, int begin, int end) {

        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            sort(array, begin, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
    }

    //take the last element as a pivot
    //partition method
    private int partition (T[] arr, int begin, int end) {

        T pivot = arr [end]; // take the last element as a pivot
        int i = (begin-1); //element i supposed to take the begin place

        for (int j = begin; j < end; j++) { //if j is a begin, than we need to swap it with the element i
            if (comparator.compare(arr[j], pivot) <= 0) {
                i++;

                swap(arr, i, j);
            }
        }

        swap(arr, end, i + 1);

        return i+1;
    }

    private void swap(T[] array, int i, int j) {
        T swapTemp = array[i]; // for i if it is bigger than a temporal element
        array[i] = array[j]; // that bigger i takes end place
        array[j] = swapTemp; // so that bigger i moves to the right side if its temporally operated
    }
}