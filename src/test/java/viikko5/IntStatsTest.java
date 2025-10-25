package viikko5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntStatsTest {

    private IntStats stats;

    @BeforeEach
    void setUp() {
        stats = new IntStats();
    }


    // min
    @Test
    void min_handlesNullAndEmpty() {
        assertEquals(0, stats.min(null));
        assertEquals(0, stats.min(List.of()));
    }

    // @ParameterizedTest
    // @CsvSource({
    //         "1, 3,1,4,1,5",
    //         "-20, -10,-20,-5",
    //         "7, 7"
    // })
    // void min_returnsSmallest(int expected, String csv) {
    //     List<Integer> data = parse(csv);
    //     assertEquals(expected, stats.min(data));
    // }
    @ParameterizedTest
    @CsvSource(value = {
            "1|3,1,4,1,5",
            "-20|-10,-20,-5",
            "7|7"
    }, delimiter = '|')
    void min_returnsSmallest(int expected, String csv) {
        List<Integer> data = parse(csv);
        assertEquals(expected, stats.min(data));
    }

// max
@Test
void max_handlesNullAndEmpty() {
    assertEquals(0, stats.max(null));
    assertEquals(0, stats.max(List.of()));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "5| 3,1,4,1,5",
            "-5| -10,-20,-5",
            "7| 7"
    }, delimiter = '|')
    void max_returnsLargest(int expected, String csv) {
        List<Integer> data = parse(csv);
        assertEquals(expected, stats.max(data));
    }

    // average

    @Test
    void avg_handlesNullAndEmpty() {
        assertEquals(0.0, stats.avg(null));
        assertEquals(0.0, stats.avg(List.of()));
    }

    @Test
    void avg_basicCases_roundedToTwoDecimals() {
        // assertEquals for doubles: use delta (tolerance)
        assertEquals(2.00, stats.avg(List.of(1, 2, 3)), 1e-9);
        assertEquals(2.80, stats.avg(List.of(3, 1, 4, 1, 5)), 1e-9);
        assertEquals(-11.67, stats.avg(List.of(-10, -20, -5)), 1e-9);
    }

    // --- helper to parse CSV "3,1,4,1,5" -> List<Integer> ---
    private static List<Integer> parse(String csv) {
        String[] parts = csv.split(",");
        Integer[] arr = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return List.of(arr);
    }
}
