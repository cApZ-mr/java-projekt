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
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}