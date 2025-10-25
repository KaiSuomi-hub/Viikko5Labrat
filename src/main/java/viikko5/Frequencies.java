package viikko5;
//tehtävä 5
import java.util.HashMap;
import java.util.Map;

public final class Frequencies {
    public static Map<Character, Integer> frequencies(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        if (s == null || s.isEmpty()) return freq;
        // Käy merkit läpi
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Muuta pienaakkoseksi
            char lower = Character.toLowerCase(ch);
            if (!Character.isLetter(lower)) continue;
            // Päivitä laskuri
            Integer old = freq.get(lower);
            if (old == null) {
                freq.put(lower, 1);
            } else {
                freq.put(lower, old + 1);
            }
        }
        return freq;
    }
}
