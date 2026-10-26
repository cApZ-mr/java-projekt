package data;

import java.util.ArrayList;

import model.Question;

public class QuestionDatabase {

    private ArrayList<Question> questions = new ArrayList<>();

    public QuestionDatabase() {

        questions.add(new Question(
                "Ist deine Person männlich?",
                person -> person.getGender().equalsIgnoreCase("männlich")
        ));

        questions.add(new Question(
                "Ist deine Person unter 24 Jahre alt?",
                person -> person.getAge() < 24
        ));

        questions.add(new Question(
                "Trägt deine Person eine Brille?",
                person -> person.hasGlasses()
        ));

        questions.add(new Question(
                "Hat deine Person einen Bart?",
                person -> person.hasBeard()
        ));

        questions.add(new Question(
                "Hat deine Person ein Haustier?",
                person -> person.hasPet()
        ));

        questions.add(new Question(
                "Ist deine Person AEler?",
                person -> person.getJob().equalsIgnoreCase("AE")
        ));

        questions.add(new Question(
                "Ist deine Person aus Europa?",
                person -> person.getEthnicity()
        ));

        questions.add(new Question(
                "Hat deine Person Geschwister?",
                person -> person.hasSiblings()
        ));

        questions.add(new Question(
                "Nutzt deine Person Apple?",
                person -> person.getPhone().equalsIgnoreCase("Apple")
        ));

        questions.add(new Question(
                "Hat deine Person einen Führerschein?",
                person -> person.hasDriverslicense()
        ));

        questions.add(new Question(
                "Kommt deine Person mit dem Auto zur Arbeit?",
                person -> person.hasCar()
        ));

        questions.add(new Question(
                "Wohnt deine Person in Düsseldorf?",
                person -> person.hasCity()
        ));

        questions.add(new Question(
                "Ist deine Person Vegetarier oder Veganer?",
                person -> person.isVegetarian()
        ));

        questions.add(new Question(
                "Trinkt deine Person Tee auf der Arbeit?",
                person -> person.hasTea()
        ));

        questions.add(new Question(
                "Raucht deine Person?",
                person -> person.doesSmoke()
        ));

        questions.add(new Question(
                "Ist deine Person in einer Beziehung?",
                person -> person.hasPartner()
        ));

        questions.add(new Question(
                "Ist deine Person als Meme bekannt?",
                person -> person.isMeme()
        ));
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}