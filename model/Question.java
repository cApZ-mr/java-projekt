package model;

import java.util.function.Predicate;

public class Question {

    private String text;
    private Predicate<Person> condition;

    public Question(String text, Predicate<Person> condition) {
        this.text = text;
        this.condition = condition;
    }

    public String getText() {
        return text;
    }

    public boolean matches(Person person) {
        return condition.test(person);
    }
}