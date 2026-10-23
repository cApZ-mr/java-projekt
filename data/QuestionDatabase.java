package data;

import java.util.ArrayList;
import model.Question;

public class QuestionDatabase {

    private ArrayList<Question> questions = new ArrayList<>();

    public QuestionDatabase() {

        questions.add(new Question(
                "Ist deine Person männlich?",
                "male"
        ));

        questions.add(new Question(
                "Ist deine Person unter 24 Jahre alt?",
                "under24"
        ));

        questions.add(new Question(
                "Ist deine Person über 24 Jahre alt?",
                "over24"
        ));

        questions.add(new Question(
                "Trägt deine Person eine Brille?",
                "glasses"
        ));

        questions.add(new Question(
                "Hat deine Person einen Bart?",
                "beard"
        ));

        questions.add(new Question(
                "Hat deine Person ein Haustier?",
                "pet"
        ));
        
        questions.add(new Question(
                "Ist deine Person AEler?",
                "job"

        ));

        questions.add(new Question(
                "Ist deine Person aus Europa?",
                "ethnicity"
        ));
        questions.add(new Question(
                "Hat deine Person Geschwister?",
                "siblings"
        ));
        questions.add(new Question(
                "Nutzt deine Person Apple?",
                "phone"
        ));
        questions.add(new Question(
                "Nutzt deine Person Android?",
                "phone"
        ));
        questions.add(new Question(
                "Hat deine Person einen Führerschein?",
                "driverslicense"
        ));
        questions.add(new Question(
                "Kommt deine Person mit dem Auto zur Arbeit?",
                "car"
        ));
        questions.add(new Question(
                "Kommt deine Person mit dem Öffis zur Arbeit?",
                "car"
        ));
        questions.add(new Question(
                "Wohnt deine Person in Düsseldorf",
                "city"
        ));
           questions.add(new Question(
                "Ist deine Person Vegetarier oder Veganer?",
                "vegetarian"
        ));
        questions.add(new Question(
                "Trinkt deine Person Tee auf der Arbeit?",
                "tea"
        ));
        questions.add(new Question(
                "Raucht deine Person?",
                "smoke"
        ));
        questions.add(new Question(
                "Ist deine Person in einer Beziehung?",
                "partner"
        ));
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}