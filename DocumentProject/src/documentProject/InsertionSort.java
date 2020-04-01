package documentProject;

// suitable for around 100 elements
public class InsertionSort {

    public static void insertionSortImperative (int [] input) {

        for (int i = 1; i < input.length - 1; i++) {
            int key = input[i]; // key is an element with the index
            int j = i - 1;

            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
                input[j + 1] = key;
            }
        }
}