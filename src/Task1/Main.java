package Task1;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
/*
Заполните двумерный массив случайным числами и выведите максимальное, минимальное и среднее значение.
 */

public class Main {
    public static void main(String[] args) {
        int[][] numbers = new int[5][5];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = ThreadLocalRandom.current().nextInt() % 100;
            }
        }

        System.out.println("Массив чисел: " + Arrays.deepToString(numbers));
        System.out.println("Max: " + findMax(numbers));
        System.out.println("Min: " + findMin(numbers));
        System.out.println("Average: " + findAverage(numbers));
    }

    public static int findMax (int[][] numbers) {
        int max = numbers[0][0];

        for (int[] number : numbers) {
            for (int i : number) {
                if (i > max) {
                    max = i;
                }
            }
        }

        return max;
    }

    public static int findMin (int[][] numbers) {
        int min = numbers[0][0];

        for (int[] number : numbers) {
            for (int i : number) {
                if (i < min) {
                    min = i;
                }
            }
        }

        return min;
    }

    public static int findAverage (int[][] numbers) {
        int sum = 0;
        int countOfElements = 0;

        for (int[] num : numbers) {
            for (int j : num) {
                sum += j;
                countOfElements++;
            }
        }
        return sum / countOfElements;
    }
}
