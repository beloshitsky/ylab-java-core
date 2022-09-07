package Task2;

/*
    Task2
    [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
*/

import java.util.*;

public class Main {
    private static int[] numbers = {3, 4, 2, 7};
    private static int sum = 10;

    public static void main(String[] args) {
        System.out.println(Arrays
                .toString(findPair(numbers, sum)));
    }

    public static int[] findPair(int[] numbers, int sum) {
        int left = 0;
        int right = numbers.length - 1;
        int [] result = new int[2];

        Arrays.sort(numbers);

        while (left < right) {
            if (numbers[left] + numbers[right] == sum) {
                result[0] = numbers[left];
                result[1] = numbers[right];
                left = right;
            }
            else if (numbers[left] + numbers[right] > sum) right--;
            else left++;
        }

        return result;
    }
}
