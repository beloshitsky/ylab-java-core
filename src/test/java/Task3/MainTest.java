package Task3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
class MainTest {
    @ParameterizedTest
    @CsvSource({"abcde, abcdefghijklm123nopqrstuvwxyz",
            "fvyz, abcdefghijklm123nopqrstuvwxyz"})
    void testTrueSearch(String subStr, String test) {
        assertTrue(Main.fuzzySearch(subStr, test));
    }

    @ParameterizedTest
    @CsvSource({"m32, abcdefghijklm123nopqrstuvwxyz",
            "aabbccdefghijklm123nopqrstuvwxyz, abcdefghijklm123nopqrstuvwxyz"})
    void testFalseSearch(String subStr, String test) {
        assertFalse(Main.fuzzySearch(subStr, test));
    }
}
