package data;
import java.util.ArrayList;
import model.person;

public class personDatabase {

    public static void main(String[] args) {

         ArrayList<person> personen = new ArrayList<>();

        person malte = new person(
                "Malte",
                "männlich",
                "unter24",
                "braun",
                "nein",
                "AE",
                "nein",
                "Europa",
                "ja",
                "ja",
                "Apple",
                "ja",
                "nein",
                "ja",
                "nein",
                "ja",
                "nein",
                "nein",
                "ja"
        );
        personen.add(malte);
    }
}
