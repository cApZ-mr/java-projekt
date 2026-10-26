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
                LocalDate.of(2005, 11, 29),
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
                LocalDate.of(2004, 03, 31),
                "dunkel",
                false,
                "SI",
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
                false
        );
        persons.add(timon);

        Person ben = new Person(
                "Ben",
                "männlich",
                LocalDate.of(2004, 06, 15),
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
                LocalDate.of(2003, 10, 16),
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
                LocalDate.of(2004, 06, 01),
                "dunkel",
                false,
                "SI",
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
                LocalDate.of(2006, 01, 06),
                "dunkel",
                true,
                "AE",
                false,
                false,
                true,
                "Apple",
                true,
                true,
                false,
                false,
                true,
                false,
                true
        );
        persons.add(philip);

        Person henning = new Person(
                "Henning",
                "männlich",
                LocalDate.of(2001, 10, 15),
                "dunkel",
                true,
                "AE",
                true,
                false,
                true,
                "Apple",
                true,
                false,
                true,
                false,
                false,
                false,
                false
        );
        persons.add(henning);

        Person pouria = new Person(
                "Pouria",
                "männlich",
                LocalDate.of(2002, 12, 24),
                "dunkel",
                true,
                "AE",
                true,
                false,
                true,
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
                LocalDate.of(2001,02, 17),
                "dunkel",
                false,
                "AE",
                false,
                false,
                true,
                "Android",
                true,
                false,
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
                LocalDate.of(2005, 06, 16),
                "dunkel",
                true,
                "DP",
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
                LocalDate.of(2005, 05, 23),
                "dunkel",
                false,
                "AE",
                true,
                false,
                true,
                "Apple",
                true,
                false,
                true,
                true,
                true,
                true,
                false
        );
        persons.add(christian);

        Person sven = new Person(
                "Sven",
                "männlich",
                LocalDate.of(1999, 07, 19),
                "hell",
                true,
                "AE",
                false,
                false,
                true,
                "Apple",
                true,
                true,
                false,
                false,
                true,
                false,
                true
        );
        persons.add(sven);

        Person lina = new Person(
                "Lina",
                "weiblich",
                LocalDate.of(2003, 8, 22),
                "dunkel",
                false,
                "AE",
                false,
                true,
                false,
                "Android",
                false,
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
                LocalDate.of(2006, 12, 04),
                "dunkel",
                true,
                "SI",
                false,
                false,
                true,
                "Android",
                false,
                false,
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
                LocalDate.of(2007, 8, 12),
                "dunkel",
                true,
                "AE",
                false,
                false,
                true,
                "Apple",
                false,
                false,
                false,
                false,
                true,
                false,
                true
        );
        persons.add(nyambayar);

        Person nils = new Person(
                "Nils",
                "männlich",
                LocalDate.of(2001, 02, 8),
                "hell",
                true,
                "DP",
                true,
                false,
                true,
                "Apple",
                true,
                false,
                true,
                false,
                false,
                false,
                true
        );
        persons.add(nils);

        Person emily = new Person(
                "Emily",
                "weiblich",
                LocalDate.of(1998, 10, 05),
                "hell",
                true,
                "AE",
                false,
                false,
                true,
                "Android",
                false,
                false,
                false,
                true,
                false,
                false,
                true
        );
        persons.add(emily);

        Person moussa = new Person(
                "Moussa",
                "männlich",
                LocalDate.of(1998, 11, 26),
                "dunkel",
                true,
                "AE",
                true,
                false,
                true,
                "Android",
                false,
                false,
                true,
                false,
                false,
                false,
                true
        );
        persons.add(moussa);

        Person zinat = new Person(
                "Zinat",
                "weiblich",
                LocalDate.of(2007, 03, 18),
                "dunkel",
                true,
                "DP",
                false,
                true,
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

                Person harald = new Person(
                "Harald",
                "männlich",
                LocalDate.of(1959, 9, 16),
                "hell",
                true,
                "extern",
                true,
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
        persons.add(harald);
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }
}