package viikko5;
// tehtvä 4
// DifficultyLevel luokka, jossa on Difficulty enum ja Task sisäluokka
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DifficultyLevel {
    public enum Difficulty { EASY, MEDIUM, HARD }

    // Tehtävä-luokka, jolla on otsikko ja vaikeustaso
    public static final class Task {
        private final String title;
        private final Difficulty difficulty;

        public Task(String title, Difficulty difficulty) {
            if (title == null || title.isBlank()) {
                throw new IllegalArgumentException("title ei saa olla tyhjä");
            }
            if (difficulty == null) {
                throw new IllegalArgumentException("difficulty ei saa olla null");
            }
            this.title = title;
            this.difficulty = difficulty;
        }

        public String getTitle() { return title; }
        public Difficulty getDifficulty() { return difficulty; }

        // Helpottaa testien vertailuja
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Task)) return false;
            Task task = (Task) o;
            return title.equals(task.title) && difficulty == task.difficulty;
        }
        @Override public int hashCode() { return Objects.hash(title, difficulty); }
        @Override public String toString() { return title + "(" + difficulty + ")"; }
    }
    // Suodattaa tehtävälistasta ne, joiden vaikeustaso vastaa annettua
    // palauttaa uuden listan (defensiivinen kopio)

    public List<Task> filterBy(List<Task> tasks, Difficulty d) {
        List<Task> out = new ArrayList<>();
        if (tasks == null || d == null) return out;
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t != null && t.getDifficulty() == d) {
                out.add(t);
            }
        }
        return out;
    }
}
