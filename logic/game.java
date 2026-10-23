package logic;

import java.util.ArrayList;
import java.util.Scanner;

import model.Person;
import model.Question;
import data.PersonDatabase;
import data.QuestionDatabase;

public class Game {

    private ArrayList<Person> persons;
    private ArrayList<Question> questions;

    public Game() {

        PersonDatabase personDatabase = new PersonDatabase();
        QuestionDatabase questionDatabase = new QuestionDatabase();

        persons = new ArrayList<>(personDatabase.getPersons());
        questions = questionDatabase.getQuestions();
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {

            System.out.println();
            System.out.println(question.getText());
            System.out.println("1 = Ja");
            System.out.println("2 = Nein");

            int input = scanner.nextInt();

            boolean userAnswer;

            if (input == 1) {
                userAnswer = true;
            } else {
                userAnswer = false;
            }

            filterPersons(question, userAnswer);

            System.out.println();
            System.out.println("Noch übrig: " + persons.size());

            for (Person person : persons) {
                System.out.println(person.getName());
            }

            if (persons.size() <= 1) {
                break;
            }
        }

        showResult();
    }
}