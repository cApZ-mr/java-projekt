package model;

public class Question {

    private String text;
    private String attribute;

    public Question(String text, String attribute) {
        this.text = text;
        this.attribute = attribute;
    }

    public String getText() {
        return text;
    }

    public boolean matches(Person person) {

        if (attribute.equals("male")) {
            return person.getGender().equalsIgnoreCase("männlich");
        }

        if (attribute.equals("under24")) {
            return person.getAge() < 24;
        }

        if (attribute.equals("over24")) {
            return person.getAge() > 24;
        }

        if (attribute.equals("glasses")) {
            return person.hasGlasses();
        }

        if (attribute.equals("beard")) {
            return person.hasBeard();
        }

        if (attribute.equals("pet")) {
            return person.hasPet();
        }

        return false;
    }
}