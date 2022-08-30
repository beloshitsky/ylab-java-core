package Task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    int[][] testArray = {{-3, -2, -1}, {0, 1, 2}, {10, 20, 30}};

    @Test
    void findMax() {
        assertEquals(30, Main.findMax(testArray));
    }

    @Test
    void findMin() {
        assertEquals(-3, Main.findMin(testArray));
    }

    @Test
    void findAverage() {
        assertEquals(6, Main.findAverage(testArray));
    }
}
