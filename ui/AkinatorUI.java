package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
    private JLabel geniusImageLabel;

    private JButton yesButton;
    private JButton noButton;
    private JButton unsureButton;
    private JButton restartButton;

    /*
     * Die Bilder müssen im Ordner src/images liegen.
     */
    private final String[] poseImages = {
            "images/pose1.png",
            "images/pose2.png",
            "images/pose3.png",
            "images/pose4.png",
            "images/pose5.png",
            "images/pose6.png"
    };

    /*
     * -1 bedeutet, dass beim Spielstart
     * noch keine Pose ausgewählt wurde.
     */
    private int currentPoseIndex = -1;

    public AkinatorUI() {

        setTitle("Unser Akinator");
        setSize(950, 600);
        setMinimumSize(new Dimension(800, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createUI();
        startNewGame();
    }

    private void createUI() {

        // Hauptbereich
        JPanel mainPanel = new JPanel(
                new BorderLayout(20, 20)
        );

        mainPanel.setBackground(
                new Color(32, 28, 55)
        );

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        35,
                        25,
                        35
                )
        );

        // Überschrift
        titleLabel = new JLabel(
                "Unser Akinator",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        32
                )
        );

        titleLabel.setForeground(Color.WHITE);

        mainPanel.add(
                titleLabel,
                BorderLayout.NORTH
        );

        // Mittlerer Bereich
        JPanel centerPanel = new JPanel(
                new BorderLayout(25, 15)
        );

        centerPanel.setBackground(
                new Color(48, 42, 78)
        );

        centerPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(120, 100, 220),
                                2
                        ),
                        BorderFactory.createEmptyBorder(
                                25,
                                25,
                                25,
                                25
                        )
                )
        );

        // Bildbereich
        JPanel imagePanel = new JPanel(
                new BorderLayout()
        );

        imagePanel.setBackground(
                new Color(40, 35, 68)
        );

        imagePanel.setPreferredSize(
                new Dimension(300, 380)
        );

        imagePanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(150, 125, 255),
                                2
                        ),
                        BorderFactory.createEmptyBorder(
                                10,
                                10,
                                10,
                                10
                        )
                )
        );

        geniusImageLabel = new JLabel(
                "Bild wird geladen...",
                SwingConstants.CENTER
        );

        geniusImageLabel.setForeground(Color.WHITE);

        geniusImageLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        15
                )
        );

        imagePanel.add(
                geniusImageLabel,
                BorderLayout.CENTER
        );

        centerPanel.add(
                imagePanel,
                BorderLayout.WEST
        );

        // Fragebereich
        JPanel questionPanel = new JPanel(
                new BorderLayout(15, 15)
        );

        questionPanel.setOpaque(false);

        remainingLabel = new JLabel(
                "Verbleibende Personen: 0",
                SwingConstants.CENTER
        );

        remainingLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        16
                )
        );

        remainingLabel.setForeground(
                new Color(200, 195, 225)
        );

        questionPanel.add(
                remainingLabel,
                BorderLayout.NORTH
        );

        questionLabel = new JLabel(
                "Frage wird geladen...",
                SwingConstants.CENTER
        );

        questionLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        questionLabel.setForeground(Color.WHITE);

        questionPanel.add(
                questionLabel,
                BorderLayout.CENTER
        );

        resultLabel = new JLabel(
                "",
                SwingConstants.CENTER
        );

        resultLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        resultLabel.setForeground(
                new Color(180, 160, 255)
        );

        questionPanel.add(
                resultLabel,
                BorderLayout.SOUTH
        );

        centerPanel.add(
                questionPanel,
                BorderLayout.CENTER
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        // Buttonbereich
        JPanel buttonPanel = new JPanel(
                new GridLayout(1, 4, 10, 0)
        );

        buttonPanel.setBackground(
                new Color(32, 28, 55)
        );

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

        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        add(mainPanel);

        // Buttonaktionen
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

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );

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

        /*
         * Automatische Altersfragen hinzufügen.
         */
        addAgeQuestions();

        currentQuestion = null;
        currentPoseIndex = -1;

        questionLabel.setText(
                "Frage wird geladen..."
        );

        resultLabel.setText("");

        setAnswerButtonsEnabled(true);

        showNextQuestion();
    }

    private void addAgeQuestions() {

        /*
         * HashSet verhindert doppelte Alterswerte.
         */
        Set<Integer> uniqueAges = new HashSet<>();

        for (Person person : persons) {
            uniqueAges.add(person.getAge());
        }

        ArrayList<Integer> ages =
                new ArrayList<>(uniqueAges);

        Collections.sort(ages);

        /*
         * Aus den vorhandenen Alterswerten werden
         * automatisch mögliche Altersfragen erstellt.
         *
         * Der höchste Wert wird nicht verwendet,
         * weil dann alle Personen mit Ja antworten würden.
         */
        for (int index = 0;
             index < ages.size() - 1;
             index++) {

            int ageLimit = ages.get(index);

            questions.add(new Question(
                    "Ist deine Person "
                            + ageLimit
                            + " Jahre alt oder jünger?",
                    person ->
                            person.getAge() <= ageLimit
            ));
        }
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

        /*
         * Nach jeder Antwort wird anhand der aktuell
         * verbliebenen Personen die beste Frage gesucht.
         */
        currentQuestion = findBestQuestion();

        if (currentQuestion == null) {
            showMultipleResults();
            return;
        }

        questionLabel.setText(
                "<html>"
                        + "<div style='text-align: center; width: 350px;'>"
                        + currentQuestion.getText()
                        + "</div>"
                        + "</html>"
        );

        showNextPose();
    }

    private Question findBestQuestion() {

        /*
         * Hier werden alle Fragen gespeichert,
         * die aktuell gleich gut sind.
         */
        ArrayList<Question> bestQuestions =
                new ArrayList<>();

        int bestWorstCase = Integer.MAX_VALUE;

        for (Question question : questions) {

            int yesCount = 0;
            int noCount = 0;

            for (Person person : persons) {

                if (question.matches(person)) {
                    yesCount++;
                } else {
                    noCount++;
                }
            }

            /*
             * Wenn alle verbliebenen Personen dieselbe
             * Antwort hätten, ist die Frage nutzlos.
             */
            if (yesCount == 0 || noCount == 0) {
                continue;
            }

            /*
             * Worst Case bedeutet:
             * Wie viele Personen bleiben bei der
             * ungünstigeren Antwort maximal übrig?
             */
            int worstCase = Math.max(
                    yesCount,
                    noCount
            );

            /*
             * Eine bessere Frage wurde gefunden.
             * Die bisher gespeicherten Fragen werden
             * durch diese Frage ersetzt.
             */
            if (worstCase < bestWorstCase) {

                bestWorstCase = worstCase;

                bestQuestions.clear();
                bestQuestions.add(question);

            /*
             * Die Frage ist genauso effektiv wie
             * die bisher besten Fragen.
             */
            } else if (
                    worstCase == bestWorstCase
            ) {

                bestQuestions.add(question);
            }
        }

        if (bestQuestions.isEmpty()) {
            return null;
        }

        /*
         * Aus allen gleich guten Fragen wird
         * zufällig eine ausgewählt.
         */
        int randomIndex = (int) (
                Math.random()
                        * bestQuestions.size()
        );

        return bestQuestions.get(randomIndex);
    }

    private void showNextPose() {

        if (poseImages.length == 0) {

            geniusImageLabel.setIcon(null);

            geniusImageLabel.setText(
                    "Keine Bilder eingetragen."
            );

            return;
        }

        int newPoseIndex;

        if (poseImages.length == 1) {

            newPoseIndex = 0;

        } else {

            /*
             * Zufällige Pose auswählen.
             * Die vorherige Pose darf nicht direkt
             * erneut angezeigt werden.
             */
            do {

                newPoseIndex = (int) (
                        Math.random()
                                * poseImages.length
                );

            } while (
                    newPoseIndex == currentPoseIndex
            );
        }

        currentPoseIndex = newPoseIndex;

        String imagePath =
                poseImages[currentPoseIndex];

        setGeniusImage(imagePath);
    }

    private void setGeniusImage(
            String imagePath
    ) {

        BufferedImage originalImage =
                loadImage(imagePath);

        if (originalImage == null) {

            geniusImageLabel.setIcon(null);

            geniusImageLabel.setText(
                    "<html>"
                            + "<div style='text-align: center;'>"
                            + "Bild nicht gefunden:<br>"
                            + imagePath
                            + "</div>"
                            + "</html>"
            );

            return;
        }

        int maximumWidth = 275;
        int maximumHeight = 350;

        Image scaledImage = scaleImage(
                originalImage,
                maximumWidth,
                maximumHeight
        );

        geniusImageLabel.setText("");

        geniusImageLabel.setIcon(
                new ImageIcon(scaledImage)
        );
    }

    private BufferedImage loadImage(
            String imagePath
    ) {

        URL imageURL =
                getClass().getResource(imagePath);

        if (imageURL != null) {

            try {

                return ImageIO.read(imageURL);

            } catch (IOException exception) {

                System.out.println(
                        "Fehler beim Laden über den Classpath: "
                                + imagePath
                );
            }
        }

        /*
         * Die bestehende Pfadlogik bleibt erhalten.
         */
        String filePath =
                "src" + imagePath;

        File imageFile =
                new File(filePath);

        if (imageFile.exists()) {

            try {

                return ImageIO.read(imageFile);

            } catch (IOException exception) {

                System.out.println(
                        "Fehler beim Laden der Datei: "
                                + filePath
                );
            }
        }

        System.out.println(
                "Bild wurde nicht gefunden: "
                        + imagePath
        );

        return null;
    }

    private Image scaleImage(
            BufferedImage originalImage,
            int maximumWidth,
            int maximumHeight
    ) {

        int originalWidth =
                originalImage.getWidth();

        int originalHeight =
                originalImage.getHeight();

        double widthFactor =
                (double) maximumWidth
                        / originalWidth;

        double heightFactor =
                (double) maximumHeight
                        / originalHeight;

        /*
         * Der kleinere Faktor verhindert,
         * dass das Bild verzerrt wird.
         */
        double scaleFactor = Math.min(
                widthFactor,
                heightFactor
        );

        int newWidth = (int) (
                originalWidth * scaleFactor
        );

        int newHeight = (int) (
                originalHeight * scaleFactor
        );

        return originalImage.getScaledInstance(
                newWidth,
                newHeight,
                Image.SCALE_SMOOTH
        );
    }

    private void answerQuestion(
            boolean userAnswer
    ) {

        if (currentQuestion == null) {
            return;
        }

        /*
         * Personen entfernen, deren Eigenschaft
         * nicht zur Antwort passt.
         */
        persons.removeIf(person ->
                currentQuestion.matches(person)
                        != userAnswer
        );

        /*
         * Die gestellte Frage wird entfernt,
         * damit sie nicht erneut erscheint.
         */
        questions.remove(currentQuestion);

        currentQuestion = null;

        showNextQuestion();
    }

    private void skipQuestion() {

        if (currentQuestion == null) {
            return;
        }

        /*
         * Bei "Weiß nicht" wird keine Person entfernt.
         * Die Frage wird trotzdem entfernt.
         */
        questions.remove(currentQuestion);

        currentQuestion = null;

        showNextQuestion();
    }

    private void showPersonResult() {

        Person result = persons.get(0);

        questionLabel.setText(
                "Ich glaube, deine Person ist:"
        );

        resultLabel.setText(
                result.getName()
        );

        currentQuestion = null;

        setAnswerButtonsEnabled(false);
    }

    private void showNoResult() {

        questionLabel.setText(
                "Keine Person passt zu deinen Antworten."
        );

        resultLabel.setText(
                "Versuche es noch einmal."
        );

        currentQuestion = null;

        setAnswerButtonsEnabled(false);
    }

    private void showMultipleResults() {

        questionLabel.setText(
                "Ich konnte die Person nicht eindeutig bestimmen."
        );

        StringBuilder names = new StringBuilder(
                "<html>"
                        + "<div style='text-align: center;'>"
        );

        names.append(
                "Mögliche Personen:<br>"
        );

        for (Person person : persons) {

            names.append(person.getName())
                    .append("<br>");
        }

        names.append(
                "</div></html>"
        );

        resultLabel.setText(
                names.toString()
        );

        currentQuestion = null;

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

            AkinatorUI ui =
                    new AkinatorUI();

            ui.setVisible(true);
        });
    }
}