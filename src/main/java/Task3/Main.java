package Task3;
/*
    Task3
    Реализовать функцию нечеткого поиска

    fuzzySearch("car", "ca6$$#_rtwheel"); // true
    fuzzySearch("cwhl", "cartwheel"); // true
    fuzzySearch("cwhee", "cartwheel"); // true
    fuzzySearch("cartwheel", "cartwheel"); // true
    fuzzySearch("cwheeel", "cartwheel"); // false
    fuzzySearch("lw", "cartwheel"); // false
*/

public class Main {
    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearch("cwhl", "cartwheel"));
        System.out.println(fuzzySearch("cwhee", "cartwheel"));
        System.out.println(fuzzySearch("cartwheel", "cartwheel"));
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
        System.out.println(fuzzySearch("lw", "cartwheel"));
    }

    /**
     * метод ищет наибольшую общую подстроку и если она совпадает с переданной первой строкой возвращает true
     * @param subSequence - символы, которые нужно найти
     * @param string - данная строка
     * @return true если символы содержаться в строке в данной последовательности
     */
    public static boolean fuzzySearch(String subSequence, String string) {
        StringBuilder sb = new StringBuilder(Math.max(subSequence.length(), string.length()));
        int[][] array = findArray(subSequence, string);

        int i = subSequence.length() - 1;
        int j = string.length() - 1;
        int k = array[subSequence.length()][string.length()] - 1;

        while (k >= 0) {
            if (subSequence.charAt(i) == string.charAt(j)) {
                sb.append(subSequence.charAt(i));
                i--;
                j--;
                k--;
            } else if (array[i + 1][j] < array[i][j + 1]) i--;
            else j--;
        }
        return subSequence.equals(sb.reverse().toString());
    }

    // вспомогательный метод
    public static int[][] findArray(String left, String right) {
        int[][] array = new int[left.length() + 1][right.length() + 1];

        for (int i = 0; i < left.length(); i++) {
            for (int j = 0; j < right.length(); j++) {
                if (i == 0) array[i][j] = 0;
                if (j == 0) array[i][j] = 0;
                if (left.charAt(i) == right.charAt(j)) {
                    array[i + 1][j + 1] = array[i][j] + 1;
                } else {
                    array[i + 1][j + 1]
                            = Math.max(array[i + 1][j], array[i][j + 1]);
                }
            }
        }

        return array;
    }
}
