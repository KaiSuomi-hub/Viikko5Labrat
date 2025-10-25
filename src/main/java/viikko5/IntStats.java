package viikko5;
// tehtävä 2
import java.util.List;

public class IntStats {
    // piennin
    public int min(List<Integer> luvut) {
        if (luvut == null || luvut.isEmpty())
            return 0;
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < luvut.size(); i++) {
            int v = luvut.get(i);
            if (v < m)
                m = v;
        }
        return m;
    }
    // Suurin
    public int max(List<Integer> luvut) {
        if (luvut == null || luvut.isEmpty())
            return 0;
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < luvut.size(); i++) {
            int v = luvut.get(i);
            if (v > m)
                m = v;
        }
        return m;
    }
    // Keskiarvo
    public double avg(List<Integer> luvut) {
        if (luvut == null || luvut.isEmpty())
            return 0.0;
        long sum = 0L;
        for (int i = 0; i < luvut.size(); i++) {
            sum += luvut.get(i);
        }
        double raw = (double) sum / luvut.size();
        return Math.round(raw * 100.0) / 100.0;

    }
}
