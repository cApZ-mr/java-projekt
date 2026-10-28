package logic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import data.PersonDatabase;
import data.QuestionDatabase;
import model.Person;
import model.Question;

public class AkinatorUI extends JFrame {

    private ArrayList<Person> persons;
    private ArrayList<Question> questions;

    private Question currentQuestion;

    private JLabel titleLabel;
    private JLabel questionLabel;
    private JLabel remainingLabel;
    private JLabel resultLabel;

    private JButton yesButton;
    private JButton noButton;
    private JButton unsureButton;
    private JButton restartButton;

    public AkinatorUI() {

        setTitle("Unser Akinator");
        setSize(700, 450);
        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createUI();
        startNewGame();
    }

    private void createUI() {

        // Hintergrund
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBackground(new Color(32, 28, 55));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(30, 40, 30, 40)
        );

        // Überschrift
        titleLabel = new JLabel(
                "Unser Akinator",
                SwingConstants.CENTER
        );

        titleLabel.setFont(new Font(
                "Arial",
                Font.BOLD,
                32
        ));

        titleLabel.setForeground(Color.WHITE);

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Mitte
        JPanel centerPanel = new JPanel(
                new BorderLayout(15, 15)
        );

        centerPanel.setBackground(new Color(48, 42, 78));

        centerPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(120, 100, 220),
                                2
                        ),
                        BorderFactory.createEmptyBorder(
                                30,
                                30,
                                30,
                                30
                        )
                )
        );

        remainingLabel = new JLabel(
                "Verbleibende Personen: 0",
                SwingConstants.CENTER
        );

        remainingLabel.setFont(new Font(
                "Arial",
                Font.PLAIN,
                16
        ));

        remainingLabel.setForeground(
                new Color(200, 195, 225)
        );

        centerPanel.add(
                remainingLabel,
                BorderLayout.NORTH
        );

        questionLabel = new JLabel(
                "Frage wird geladen...",
                SwingConstants.CENTER
        );

        questionLabel.setFont(new Font(
                "Arial",
                Font.BOLD,
                24
        ));

        questionLabel.setForeground(Color.WHITE);

        centerPanel.add(
                questionLabel,
                BorderLayout.CENTER
        );

        resultLabel = new JLabel(
                "",
                SwingConstants.CENTER
        );

        resultLabel.setFont(new Font(
                "Arial",
                Font.BOLD,
                20
        ));

        resultLabel.setForeground(
                new Color(180, 160, 255)
        );

        centerPanel.add(
                resultLabel,
                BorderLayout.SOUTH
        );

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(
                new GridLayout(1, 4, 10, 0)
        );

        buttonPanel.setBackground(new Color(32, 28, 55));

        yesButton = createButton(
                "Ja",
                new Color(40, 170, 100)
        );

        noButton = createButton(
                "Nein",
                new Color(210, 70, 80)
        );

        unsureButton = createButton(
                "Weiß nicht",
                new Color(90, 90, 120)
        );

        restartButton = createButton(
                "Neu starten",
                new Color(110, 80, 210)
        );

        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        buttonPanel.add(unsureButton);
        buttonPanel.add(restartButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Aktionen
        yesButton.addActionListener(event ->
                answerQuestion(true)
        );

        noButton.addActionListener(event ->
                answerQuestion(false)
        );

        unsureButton.addActionListener(event ->
                skipQuestion()
        );

        restartButton.addActionListener(event ->
                startNewGame()
        );
    }

    private JButton createButton(
            String text,
            Color backgroundColor
    ) {

        JButton button = new JButton(text);

        button.setFont(new Font(
                "Arial",
                Font.BOLD,
                16
        ));

        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        12,
                        10,
                        12,
                        10
                )
        );

        return button;
    }

    private void startNewGame() {

        PersonDatabase personDatabase =
                new PersonDatabase();

        QuestionDatabase questionDatabase =
                new QuestionDatabase();

        persons = new ArrayList<>(
                personDatabase.getPersons()
        );

        questions = new ArrayList<>(
                questionDatabase.getQuestions()
        );

        currentQuestion = null;

        resultLabel.setText("");

        setAnswerButtonsEnabled(true);

        showNextQuestion();
    }

    private void showNextQuestion() {

        updateRemainingLabel();

        if (persons.isEmpty()) {

            showNoResult();
            return;
        }

        if (persons.size() == 1) {

            showPersonResult();
            return;
        }

        if (questions.isEmpty()) {

            showMultipleResults();
            return;
        }

        currentQuestion = findBestQuestion();

        if (currentQuestion == null) {

            showMultipleResults();
            return;
        }

        questionLabel.setText(
                "<html><div style='text-align: center;'>"
                + currentQuestion.getText()
                + "</div></html>"
        );
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
             * Wenn alle Personen dieselbe Antwort haben,
             * ist die Frage nicht hilfreich.
             */
            if (yesCount == 0 || noCount == 0) {
                continue;
            }

            int difference = Math.abs(
                    yesCount - noCount
            );

            if (difference < smallestDifference) {

                smallestDifference = difference;
                bestQuestion = question;
            }
        }

        return bestQuestion;
    }

    private void answerQuestion(boolean userAnswer) {

        if (currentQuestion == null) {
            return;
        }

        persons.removeIf(person ->
                currentQuestion.matches(person)
                        != userAnswer
        );

        questions.remove(currentQuestion);

        showNextQuestion();
    }

    private void skipQuestion() {

        if (currentQuestion == null) {
            return;
        }

        /*
         * Bei "Weiß nicht" wird keine Person entfernt.
         * Nur die aktuelle Frage wird übersprungen.
         */
        questions.remove(currentQuestion);

        showNextQuestion();
    }

    private void showPersonResult() {

        Person result = persons.get(0);

        questionLabel.setText(
                "Ich glaube, deine Person ist:"
        );

        resultLabel.setText(result.getName());

        setAnswerButtonsEnabled(false);
    }

    private void showNoResult() {

        questionLabel.setText(
                "Keine Person passt zu deinen Antworten."
        );

        resultLabel.setText(
                "Versuche es noch einmal."
        );

        setAnswerButtonsEnabled(false);
    }

    private void showMultipleResults() {

        questionLabel.setText(
                "Ich konnte die Person nicht eindeutig bestimmen."
        );

        StringBuilder names = new StringBuilder(
                "<html><div style='text-align: center;'>"
        );

        names.append("Mögliche Personen:<br>");

        for (Person person : persons) {
            names.append(person.getName())
                    .append("<br>");
        }

        names.append("</div></html>");

        resultLabel.setText(names.toString());

        setAnswerButtonsEnabled(false);
    }

    private void updateRemainingLabel() {

        remainingLabel.setText(
                "Verbleibende Personen: "
                + persons.size()
        );
    }

    private void setAnswerButtonsEnabled(
            boolean enabled
    ) {

        yesButton.setEnabled(enabled);
        noButton.setEnabled(enabled);
        unsureButton.setEnabled(enabled);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            AkinatorUI ui = new AkinatorUI();
            ui.setVisible(true);
        });
    }
}