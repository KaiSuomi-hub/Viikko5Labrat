package viikko5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DifficultyLevelTest {

    private static List<DifficultyLevel.Task> sample() {
        return List.of(
                new DifficultyLevel.Task("Warm-up", DifficultyLevel.Difficulty.EASY),
                new DifficultyLevel.Task("Loops",   DifficultyLevel.Difficulty.MEDIUM),
                new DifficultyLevel.Task("Streams", DifficultyLevel.Difficulty.HARD),
                new DifficultyLevel.Task("Arrays",  DifficultyLevel.Difficulty.MEDIUM),
                new DifficultyLevel.Task("Enums",   DifficultyLevel.Difficulty.EASY)
        );
    }

    @Test
    void filterBy_returnsOnlyMatchingAndNewList() {
        DifficultyLevel dl = new DifficultyLevel();
        List<DifficultyLevel.Task> tasks = new ArrayList<>(sample());

        List<DifficultyLevel.Task> meds = dl.filterBy(tasks, DifficultyLevel.Difficulty.MEDIUM);

        assertEquals(2, meds.size(), "Should contain only MEDIUM tasks");
        assertTrue(meds.stream().allMatch(t -> t.getDifficulty() == DifficultyLevel.Difficulty.MEDIUM));

        // Returned list must be a new defensive copy
        meds.clear();
        assertEquals(5, tasks.size(), "Clearing result must not affect original list");
    }

    @ParameterizedTest
    @EnumSource(DifficultyLevel.Difficulty.class)
    void filterBy_handlesEachDifficulty(DifficultyLevel.Difficulty d) {
        DifficultyLevel dl = new DifficultyLevel();
        List<DifficultyLevel.Task> out = dl.filterBy(sample(), d);
        assertTrue(out.stream().allMatch(t -> t.getDifficulty() == d));
    }

    @Test
    void filterBy_nullInputsYieldEmpty() {
        DifficultyLevel dl = new DifficultyLevel();
        assertTrue(dl.filterBy(null, DifficultyLevel.Difficulty.EASY).isEmpty());
        assertTrue(dl.filterBy(sample(), null).isEmpty());
        assertTrue(dl.filterBy(null, null).isEmpty());
    }

    @Test
    void filterBy_ignoresNullTasksSafely() {
        DifficultyLevel dl = new DifficultyLevel();
        List<DifficultyLevel.Task> withNulls = new ArrayList<>(sample());
        withNulls.add(null); // include a null entry

        List<DifficultyLevel.Task> hards = dl.filterBy(withNulls, DifficultyLevel.Difficulty.HARD);
        assertEquals(1, hards.size());
        assertEquals("Streams", hards.get(0).getTitle());
    }

    @Test
    void task_constructor_validatesInputs() {
        // title must not be null/blank
        assertThrows(IllegalArgumentException.class,
                () -> new DifficultyLevel.Task(null, DifficultyLevel.Difficulty.EASY));
        assertThrows(IllegalArgumentException.class,
                () -> new DifficultyLevel.Task("   ", DifficultyLevel.Difficulty.EASY));

        // difficulty must not be null
        assertThrows(IllegalArgumentException.class,
                () -> new DifficultyLevel.Task("Valid", null));
    }
}
