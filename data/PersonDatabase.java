package data;

import java.util.ArrayList;
import java.time.LocalDate;

import model.Person;

public class PersonDatabase {

    private ArrayList<Person> persons = new ArrayList<>();

    public PersonDatabase() {

        Person malte = new Person(
                "Malte",
                "männlich",
                LocalDate.of(2006, 5, 15),
                "dunkel",
                false,
                "AE",
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
                true
        );
        persons.add(malte);

        Person timon = new Person(
                "Timon",
                "männlich",
                LocalDate.of(2004, 4, 12),
                "dunkel",
                false,
                "SI",
                false,
                true,
                true,
                "Android",
                true,
                true,
                true,
                false,
                false,
                false,
                false
        );
        persons.add(timon);

        Person ben = new Person(
                "Ben",
                "männlich",
                LocalDate.of(2004, 3, 20),
                "dunkel",
                false,
                "AE",
                false,
                false,
                true,
                "Android",
                true,
                true,
                false,
                false,
                false,
                false,
                true
        );
        persons.add(ben);

        Person gaya = new Person(
                "Gaya",
                "männlich",
                LocalDate.of(2003, 6, 10),
                "dunkel",
                true,
                "SI",
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
                false
        );
        persons.add(gaya);

        Person volkan = new Person(
                "Volkan",
                "männlich",
                LocalDate.of(2004, 2, 18),
                "dunkel",
                false,
                "AE",
                true,
                false,
                true,
                "Apple",
                false,
                false,
                true,
                false,
                false,
                false,
                true
        );
        persons.add(volkan);

        Person philip = new Person(
                "Philip",
                "männlich",
                LocalDate.of(2003, 7, 22),
                "dunkel",
                true,
                "AE",
                false,
                false,
                false,
                "Apple",
                true,
                true,
                false,
                false,
                true,
                true,
                true
        );
        persons.add(philip);

        Person henning = new Person(
                "Henning",
                "männlich",
                LocalDate.of(2001, 5, 11),
                "dunkel",
                true,
                "AE",
                true,
                false,
                false,
                "Apple",
                true,
                true,
                false,
                false,
                false,
                false,
                false
        );
        persons.add(henning);

        Person pouria = new Person(
                "Pouria",
                "männlich",
                LocalDate.of(2001, 3, 14),
                "dunkel",
                true,
                "AE",
                true,
                false,
                false,
                "Apple",
                true,
                false,
                true,
                false,
                true,
                false,
                false
        );
        persons.add(pouria);

        Person marcel = new Person(
                "Marcel",
                "männlich",
                LocalDate.of(2001, 8, 7),
                "dunkel",
                false,
                "AE",
                false,
                false,
                false,
                "Apple",
                true,
                true,
                false,
                false,
                true,
                false,
                false
        );
        persons.add(marcel);

        Person mirabel = new Person(
                "Mirabel",
                "weiblich",
                LocalDate.of(2001, 1, 25),
                "dunkel",
                true,
                "AE",
                false,
                false,
                false,
                "Apple",
                true,
                true,
                false,
                false,
                false,
                false,
                false
        );
        persons.add(mirabel);

        Person christian = new Person(
                "Christian",
                "männlich",
                LocalDate.of(2001, 6, 17),
                "dunkel",
                false,
                "AE",
                true,
                false,
                false,
                "Apple",
                true,
                true,
                false,
                false,
                true,
                true,
                false
        );
        persons.add(christian);

        Person sven = new Person(
                "Sven",
                "männlich",
                LocalDate.of(2001, 9, 3),
                "hell",
                true,
                "AE",
                false,
                false,
                false,
                "Apple",
                true,
                true,
                false,
                false,
                true,
                false,
                false
        );
        persons.add(sven);

        Person lina = new Person(
                "Lina",
                "weiblich",
                LocalDate.of(2003, 4, 19),
                "dunkel",
                false,
                "AE",
                false,
                true,
                false,
                "Apple",
                true,
                false,
                false,
                false,
                false,
                true,
                true
        );
        persons.add(lina);

        Person saskia = new Person(
                "Saskia",
                "weiblich",
                LocalDate.of(2001, 2, 13),
                "dunkel",
                true,
                "SI",
                false,
                false,
                false,
                "Apple",
                true,
                true,
                false,
                false,
                false,
                false,
                false
        );
        persons.add(saskia);

        Person nyambayar = new Person(
                "Nyambayar",
                "männlich",
                LocalDate.of(2001, 7, 21),
                "dunkel",
                true,
                "AE",
                false,
                false,
                false,
                "Apple",
                true,
                true,
                false,
                false,
                true,
                false,
                false
        );
        persons.add(nyambayar);

        Person nils = new Person(
                "Nils",
                "männlich",
                LocalDate.of(2001, 10, 5),
                "hell",
                true,
                "AE",
                true,
                false,
                false,
                "Apple",
                true,
                true,
                false,
                false,
                false,
                false,
                false
        );
        persons.add(nils);

        Person emily = new Person(
                "Emily",
                "weiblich",
                LocalDate.of(1999, 5, 16),
                "hell",
                true,
                "AE",
                false,
                false,
                false,
                "Apple",
                true,
                true,
                false,
                false,
                false,
                false,
                false
        );
        persons.add(emily);

        Person moussa = new Person(
                "Moussa",
                "männlich",
                LocalDate.of(2001, 4, 28),
                "dunkel",
                true,
                "AE",
                true,
                false,
                false,
                "Apple",
                true,
                true,
                false,
                false,
                false,
                false,
                false
        );
        persons.add(moussa);

        Person zinat = new Person(
                "Zinat",
                "weiblich",
                LocalDate.of(2007, 6, 8),
                "dunkel",
                true,
                "DP",
                false,
                false,
                true,
                "Apple",
                false,
                false,
                true,
                false,
                true,
                true,
                false
        );
        persons.add(zinat);
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }
}