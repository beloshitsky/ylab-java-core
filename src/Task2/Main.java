package Task2;

import java.util.Arrays;

/*
Отсортируйте массив [5,6,3,2,5,1,4,9]
 */

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};

        System.out.println(Arrays.toString(array));

        sort(array, 0, array.length - 1);

        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    public static void sort(int[] array, int low, int high) {
        if (low >= high) return;

        int middle = low + (high - low) / 2;
        int pivot = array[middle];

        int i = low, j = high;

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) sort(array, low, j);

        if (high > i) sort(array, i, high);
    }
}
