package documentProject;

// select pivot
//move smaller elements to the left and bigger elements to the right
// recursively sort left and right part

import java.util.Comparator;

public class QuickSort implements SortingAlgorithm {


        public <T extends Comparable<T>> void sort(T[] array) {


        if (array.length == 0)
            return; //end if the length of the array == 0

        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);

        if (low >= high)
            return; //end if there is nothing to compare

        // choose the pivot
        int middle = low + (high - low) / 2;
        T pivot = array[middle];

        // divide into subArrays that are lower and higher towards pivot
        int i = low, j = high;
        while (i <= j) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }
            while (array[j].compareTo(pivot) > 0) {
                j--;
            }


            if (i <= j) { //swap
                T temp = (T) array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        //calling on recourse for sorting of left and right parts
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    private <T> void quickSort(T[] array, int low, int high) {



    }
}
