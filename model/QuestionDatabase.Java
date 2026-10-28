package data;

import java.util.ArrayList;

import model.Question;

public class QuestionDatabase {

    private ArrayList<Question> questions =
            new ArrayList<>();

    public QuestionDatabase() {

        questions.add(new Question(
                "Ist deine Person männlich?",
                person -> person.getGender()
                        .equalsIgnoreCase("männlich")
        ));

        questions.add(new Question(
                "Ist deine Person unter 24 Jahre alt?",
                person -> person.getAge() < 24
        ));

        questions.add(new Question(
                "Hat deine Person dunkle Haare?",
                person -> person.getHairColor()
                        .equalsIgnoreCase("dunkel")
        ));

        questions.add(new Question(
                "Trägt deine Person eine Brille?",
                person -> person.hasGlasses()
        ));

        questions.add(new Question(
                "Ist deine Person ein AEler?",
                person -> person.getJob()
                        .equalsIgnoreCase("AE")
        ));

        questions.add(new Question(
                "Ist deine Person ein SIler?",
                person -> person.getJob()
                        .equalsIgnoreCase("SI")
        ));

        questions.add(new Question(
                "Ist deine Person ein DPler?",
                person -> person.getJob()
                        .equalsIgnoreCase("DP")
        ));

        questions.add(new Question(
                "Ist deine Person extern?",
                person -> person.getJob()
                        .equalsIgnoreCase("extern")
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
                "Hat deine Person Geschwister?",
                person -> person.hasSiblings()
        ));

        questions.add(new Question(
                "Benutzt deine Person ein iPhone?",
                person -> person.getPhone()
                        .equalsIgnoreCase("Apple")
        ));

        questions.add(new Question(
                "Hat deine Person einen Führerschein?",
                person -> person.hasDriverslicense()
        ));

        questions.add(new Question(
                "Kommt deine Person mit dem Auto?",
                person -> person.hasCar()
        ));

        questions.add(new Question(
                "Wohnt deine Person in Düsseldorf?",
                person -> person.hasCity()
        ));

        questions.add(new Question(
                "Ist deine Person vegetarisch oder vegan?",
                person -> person.isVegetarian()
        ));

        questions.add(new Question(
                "Trinkt deine Person Tee?",
                person -> person.hasTea()
        ));

        questions.add(new Question(
                "Konsumiert deine Person Nikotin?",
                person -> person.doesSmoke()
        ));

        questions.add(new Question(
                "Hat deine Person einen Partner oder eine Partnerin?",
                person -> person.hasPartner()
        ));
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}