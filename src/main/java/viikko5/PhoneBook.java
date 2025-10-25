package viikko5;
//tehtävä 3
import java.util.HashMap;
import java.util.Map;
public class PhoneBook {
    // luo puhelinluettelo käyttäen HashMap tietorakennetta
    private final Map<String, String> entries = new HashMap<>();
    // lisää nimi ja numero puhelinluetteloon
        public void add(String name, String number) {
        entries.put(name, number);
        }
    // etsi nimi
        public String find(String name) {
        return entries.get(name);
        }
    // palauttaa puhelinluettelon merkintöjen määrän.
    public int size() {
    return entries.size();
    }
}