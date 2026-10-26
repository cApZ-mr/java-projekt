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
        questions = new ArrayList<>(questionDatabase.getQuestions());
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        while (persons.size() > 1 && !questions.isEmpty()) {

            Question bestQuestion = findBestQuestion();

            // Keine Frage kann die Personen weiter sinnvoll aufteilen
            if (bestQuestion == null) {
                break;
            }

            System.out.println();
            System.out.println(bestQuestion.getText());
            System.out.println("1 = Ja");
            System.out.println("2 = Nein");
            System.out.println("3 = Weiß nicht");

            int input = readAnswer(scanner);

            /*
             * Bei 1 oder 2 werden die Personen gefiltert.
             * Bei 3 bleiben alle Personen erhalten.
             */
            if (input == 1 || input == 2) {

                boolean userAnswer = input == 1;

                filterPersons(bestQuestion, userAnswer);

            } else {

                System.out.println();
                System.out.println("Die Frage wird übersprungen.");
            }

            /*
             * Die Frage wird immer entfernt.
             * Dadurch wird eine übersprungene Frage nicht erneut gestellt.
             */
            questions.remove(bestQuestion);

            System.out.println();
            System.out.println("Noch übrig: " + persons.size());

            for (Person person : persons) {
                System.out.println(person.getName());
            }
        }

        scanner.close();
        showResult();
    }

    private Question findBestQuestion() {

        Question bestQuestion = null;
        int smallestDifference = Integer.MAX_VALUE;

        for (Question question : questions) {

            int yesCount = 0;

            for (Person person : persons) {

                if (question.matches(person)) {
                    yesCount++;
                }
            }

            int noCount = persons.size() - yesCount;

            /*
             * Wenn alle Personen dieselbe Antwort hätten,
             * kann die Frage niemanden herausfiltern.
             */
            if (yesCount == 0 || noCount == 0) {
                continue;
            }

            /*
             * Je kleiner der Unterschied zwischen Ja und Nein,
             * desto besser teilt die Frage die Personen auf.
             */
            int difference = Math.abs(yesCount - noCount);

            if (difference < smallestDifference) {
                smallestDifference = difference;
                bestQuestion = question;
            }
        }

        return bestQuestion;
    }

    private int readAnswer(Scanner scanner) {

        while (true) {

            System.out.print("Antwort: ");

            if (scanner.hasNextInt()) {

                int input = scanner.nextInt();

                if (input >= 1 && input <= 3) {
                    return input;
                }

            } else {
                scanner.next();
            }

            System.out.println("Bitte nur 1, 2 oder 3 eingeben.");
        }
    }

    private void filterPersons(
            Question question,
            boolean userAnswer
    ) {

        persons.removeIf(person ->
                question.matches(person) != userAnswer
        );
    }

    private void showResult() {

        System.out.println();

        if (persons.size() == 1) {

            System.out.println(
                    "Deine Person ist: "
                    + persons.get(0).getName()
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