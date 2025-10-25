package viikko5;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class FrequenciesTest {
    // null, tyhjä, ei-kirjaimia
    @Test
    void handlesNullAndEmpty() {
        assertTrue(Frequencies.frequencies(null).isEmpty());
        assertTrue(Frequencies.frequencies("").isEmpty());
        assertTrue(Frequencies.frequencies(" ,.!? ").isEmpty());
    }
    // yksittäinen kirjain, isot/pienet sekä ääkköset
    @Test
    void countsLetters_caseInsensitive_withNordic() {
        Map<Character,Integer> m = Frequencies.frequencies("Äiti, äiti!");
        assertEquals(3, m.size());
        assertEquals(2, m.get('ä'));
        assertEquals(4, m.get('i'));  // <-- was 2, should be 4
        assertEquals(2, m.get('t'));
    }
    // väli ja välimerkit
    @Test
    void ignoresSpacesAndPunctuation_andCountsOnlyLetters() {
        Map<Character,Integer> m = Frequencies.frequencies("A B! C? D.");
        assertEquals(1, m.get('a'));
        assertEquals(1, m.get('b'));
        assertEquals(1, m.get('c'));
        assertEquals(1, m.get('d'));
        assertEquals(4, m.size());
    }
    // sekaisin isoja, pieniä ja ääkkösiä
    @Test
    void mixesUpperLowerAndNordics() {
        Map<Character,Integer> m = Frequencies.frequencies("Åå Ää Öö aA");
        assertEquals(2, m.get('å'));
        assertEquals(2, m.get('ä'));
        assertEquals(2, m.get('ö'));
        assertEquals(2, m.get('a'));
        assertEquals(4, m.size());
    }
}
