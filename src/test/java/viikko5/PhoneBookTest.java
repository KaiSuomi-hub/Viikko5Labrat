package viikko5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
// lisääminen ja etsiminen
@Test
void addAndFind_basic() {
    PhoneBook pb = new PhoneBook();
    pb.add("Nimi1", "123");
    pb.add("Nimi2", "456");
    assertEquals("123", pb.find("Nimi1"));
    assertEquals("456", pb.find("Nimi2"));
    assertNull(pb.find("Nimi3"));
}
// koko
@Test
void size_countsUniqueNames() {
    PhoneBook pb = new PhoneBook();
    assertEquals(0, pb.size());
    pb.add("Nimi1", "123");
    assertEquals(1, pb.size());
    pb.add("Nimi2", "456");
    assertEquals(2, pb.size());
    pb.add("Nimi1", "999");
    assertEquals(2, pb.size());
}
// sama nimi päivittyy, koko ei kasva
@Test
void add_overwritesExistingNumber() {
    PhoneBook pb = new PhoneBook();
    pb.add("Nimi1", "123");
    assertEquals("123", pb.find("Nimi1"));
    pb.add("Nimi1", "999");
    assertEquals("999", pb.find("Nimi1"));
}
// eri nimet voivat käyttää samaa numeroa
@Test
void differentNamesMayShareSameNumber() {
    PhoneBook pb = new PhoneBook();
    pb.add("Nimi1", "123");
    pb.add("Nimi1A", "123");
    assertEquals("123", pb.find("Nimi1"));
    assertEquals("123", pb.find("Nimi1A"));
    assertEquals(2, pb.size());
    }
}