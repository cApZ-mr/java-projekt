package model;

import java.util.function.Predicate;

public class Question {

    private String text;
    private Predicate<Person> condition;

    public Question(
            String text,
            Predicate<Person> condition
    ) {

        this.text = text;
        this.condition = condition;
    }

    public String getText() {
        return text;
    }

    /*
     * Prüft für eine Person, ob die Antwort
     * auf diese Frage "Ja" wäre.
     */
    public boolean matches(Person person) {
        return condition.test(person);
    }
}