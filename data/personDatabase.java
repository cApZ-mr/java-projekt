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
                "dunkel",
                false,
                "AE",
                true,
                true,
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
                "dunkel",
                false,
                "SI",
                false,
                true,
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
                "dunkel",
                false,
                "AE",
                false,
                true,
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
                "dunkel",
                true,
                "SI",
                false,
                false,
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

          Person volkan = new Person(
                "Volkan",       //.
                "männlich",   //.
                22,
                "dunkel",
                false,
                "AE",
                true,
                true,       //ändern
                false,
                true,        //.
                "Apple",        //.
                false, //.
                false,            //.
                true,            //.
                false,
                false,
                false,          //.
                true,         //.
                false            //.
        );
        personen.add(volkan);
    }
}
