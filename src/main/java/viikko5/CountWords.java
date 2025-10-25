package viikko5;
// tehtvä 1
public class CountWords {
    public static int countWords(String text) {
    if (text == null || text.trim().isEmpty()) {
        return 0; // null tai tyhjä merkkijono ei sisällä sanoja, palauta 0 jotta voi ajaa testit
    }
   int wordCount = 0;
    boolean inWord = false;
    for (int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        if (c == ' ') {
            inWord = false;
        } else if (!inWord) {
            wordCount++;
            inWord = true;
        }
    }
    return wordCount;
    }
}