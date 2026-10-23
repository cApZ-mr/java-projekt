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

            System.out.print("Antwort: ");
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

        scanner.close();
        showResult();
    }

    private void filterPersons(Question question, boolean userAnswer) {

        persons.removeIf(person ->
                question.matches(person) != userAnswer
        );
    }


    private void showResult() {

        System.out.println();

        if (persons.size() == 1) {

            System.out.println(
                    "Deine Person ist: " + persons.get(0).getName()
            );

        } else if (persons.isEmpty()) {

            System.out.println(
                    "Keine Person passt zu deinen Antworten."
            );

        } else {

            System.out.println(
                    "Ich konnte die Person nicht eindeutig bestimmen."
            );

            System.out.println("Mögliche Personen:");

            for (Person person : persons) {
                System.out.println(person.getName());
            }
        }
    }
}

