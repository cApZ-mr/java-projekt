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
    }
}
