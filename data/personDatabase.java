package data;
import java.util.ArrayList;
import model.Person;

public class PersonDatabase {

    public static void main(String[] args) {

        ArrayList<Person> personen = new ArrayList<>();

        Person malte = new Person(
                "Malte",
                "männlich",
                20,
                "braun",
                false,
                "AE",
                true,
                "Europa",
                true,
                true,
                "Apple",
                false,
                false,
                true,
                false,
                false,
                true,
                true,
                true
        );
        personen.add(malte);

          Person timon = new Person(
                "Timon",
                "männlich",
                22,
                "braun",
                false,
                "SI",
                false,
                "Europa",
                true,
                true,
                "Android",
                true,
                true,
                true,
                false,
                false,
                false,
                false,
                false
        );
        personen.add(timon);

          Person ben = new Person(
                "Ben",
                "männlich",
                22,
                "braun",
                false,
                "AE",
                false,
                "Europa",
                true,
                true,
                "Android",
                true,
                true,
                false,
                false,
                false,
                false,
                true,
                true
        );
        personen.add(ben);

          Person gaya = new Person(
                "Gaya",
                "männlich",
                23,
                "braun",
                true,
                "SI",
                false,
                "Asien",
                false,
                false,
                "Apple",
                true,
                true,
                false,
                false,
                false,
                true,
                false,
                false
        );
        personen.add(gaya);
    }
}
