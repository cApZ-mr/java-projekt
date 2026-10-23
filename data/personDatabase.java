package data;

import java.util.ArrayList;
import model.Person;

public class PersonDatabase {

    private ArrayList<Person> persons = new ArrayList<>();

    public PersonDatabase() {

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
        persons.add(malte);


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
        persons.add(timon);


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
        persons.add(ben);


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
        persons.add(gaya);


        Person volkan = new Person(
                "Volkan",
                "männlich",
                22,
                "dunkel",
                false,
                "AE",
                true,
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
                true,
                false
        );
        persons.add(volkan);
    }


    public ArrayList<Person> getPersons() {
        return persons;
    }
}