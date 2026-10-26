import model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionDatabase {

    public static List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "Trägt die Person eine Brille?",
                person -> person.hasGlasses()
        ));

        questions.add(new Question(
                "Hat die Person einen Bart?",
                person -> person.hasBeard()
        ));

        questions.add(new Question(
                "Hat die Person ein Haustier?",
                person -> person.hasPet()
        ));

        questions.add(new Question(
                "Hat die Person Geschwister?",
                person -> person.hasSiblings()
        ));

        questions.add(new Question(
                "Hat die Person einen Führerschein?",
                person -> person.hasDriverslicense()
        ));

        questions.add(new Question(
                "Kommt die Person mit dem Auto?",
                person -> person.hasCar()
        ));

        questions.add(new Question(
                "Wohnt die Person in Düsseldorf?",
                person -> person.hasCity()
        ));

        questions.add(new Question(
                "Ist die Person vegetarisch oder vegan?",
                person -> person.isVegetarian()
        ));

        questions.add(new Question(
                "Trinkt die Person Tee?",
                person -> person.hasTea()
        ));

        questions.add(new Question(
                "Konsumiert die Person Nikotin?",
                person -> person.doesSmoke()
        ));

        questions.add(new Question(
                "Hat die Person einen Partner oder eine Partnerin?",
                person -> person.hasPartner()
        ));

        questions.add(new Question(
                "Ist die Person für ein Meme bekannt?",
                person -> person.isMeme()
        ));

        questions.add(new Question(
                "Ist die Person unter 24 Jahre alt?",
                person -> person.getAge() < 24
        ));

        questions.add(new Question(
                "Benutzt die Person ein iPhone?",
                person -> person.getPhone().equalsIgnoreCase("Apple")
        ));

        questions.add(new Question(
                "Hat die Person braune Haare?",
                person -> person.getHairColor().equalsIgnoreCase("Braun")
        ));

        questions.add(new Question(
                "Hat die Person blonde Haare?",
                person -> person.getHairColor().equalsIgnoreCase("Blond")
        ));

        return questions;
    }
}