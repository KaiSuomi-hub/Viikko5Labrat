package viikko5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CountWordsTest {
// null ja tyhjä
    @Test
    void countWords_handlesNullAndOnlySpaces() {
        assertEquals(0, CountWords.countWords(null));
        assertEquals(0, CountWords.countWords(""));
        assertEquals(0, CountWords.countWords("   "));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1 | hei",
        "2 | hei maailma",
        "2 |   hei   maailma   ",
        "3 | Hei   maailma  !",
        "3 | kissa  koira   kana",
        "1 |  sana   ",
        "4 | a  b    c d",
        "3 | välilyönti  sisällä  lauseessa",
        "1 | \tword\t"  // skippaa tabit
    }, delimiter = '|')
    void countWords_examples(int expected, String input) {
        assertEquals(expected, CountWords.countWords(input));
    }
    // vain välimerkit, jotka erotettu välilyönneillä ovat sanoja
    @Test
    void countWords_onlyPunctuationSeparatedBySpaces() {
        // ! on merkki, mutta yksinään se lasketaan sanaksi
        assertEquals(1, CountWords.countWords(" ! "));
        // kaksi erillistä merkkiä lasketaan kahdeksi sanaksi koska ne on erotettu välilyönnillä
        assertEquals(2, CountWords.countWords("! ?"));
    }
}
