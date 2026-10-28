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
            "images/pose5.png"
    };

    private int currentPoseIndex = 0;

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
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBackground(new Color(32, 28, 55));

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

        titleLabel.setFont(new Font(
                "Arial",
                Font.BOLD,
                32
        ));

        titleLabel.setForeground(Color.WHITE);

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Kompletter mittlerer Bereich
        JPanel centerPanel = new JPanel(
                new BorderLayout(25, 15)
        );

        centerPanel.setBackground(new Color(48, 42, 78));

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

        /*
         * Linker Bereich für das Genie-Bild.
         */
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

        geniusImageLabel.setFont(new Font(
                "Arial",
                Font.BOLD,
                15
        ));

        imagePanel.add(
                geniusImageLabel,
                BorderLayout.CENTER
        );

        centerPanel.add(
                imagePanel,
                BorderLayout.WEST
        );

        /*
         * Rechter Bereich für Frage und Ergebnis.
         */
        JPanel questionPanel = new JPanel(
                new BorderLayout(15, 15)
        );

        questionPanel.setOpaque(false);

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

        questionPanel.add(
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

        questionPanel.add(
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
        currentPoseIndex = 0;

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
                "<html>"
                        + "<div style='text-align: center; width: 350px;'>"
                        + currentQuestion.getText()
                        + "</div>"
                        + "</html>"
        );

        /*
         * Bei jeder neuen Frage wird die nächste Pose angezeigt.
         */
        showNextPose();
    }

    private void showNextPose() {

        if (poseImages.length == 0) {
            geniusImageLabel.setText(
                    "Keine Bilder eingetragen."
            );
            return;
        }

        String imagePath =
                poseImages[currentPoseIndex];

        setGeniusImage(imagePath);

        currentPoseIndex++;

        /*
         * Nach dem letzten Bild wieder beim ersten beginnen.
         */
        if (currentPoseIndex >= poseImages.length) {
            currentPoseIndex = 0;
        }
    }

    private void setGeniusImage(String imagePath) {

        BufferedImage originalImage = loadImage(imagePath);

        if (originalImage == null) {
            geniusImageLabel.setIcon(null);

            geniusImageLabel.setText(
                    "<html><div style='text-align: center;'>"
                            + "Bild nicht gefunden:<br>"
                            + imagePath
                            + "</div></html>"
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

    private BufferedImage loadImage(String imagePath) {

        /*
         * Zuerst wird versucht, das Bild über den Classpath
         * zu laden. Das funktioniert bei normalen Java-Projekten
         * und später auch bei einer JAR-Datei.
         */
        URL imageURL = getClass().getResource(imagePath);

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
         * Falls VS Code den Ressourcenordner nicht automatisch
         * erkennt, wird das Bild direkt aus src/images geladen.
         */
        String filePath = "src" + imagePath;

        File imageFile = new File(filePath);

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
                (double) maximumWidth / originalWidth;

        double heightFactor =
                (double) maximumHeight / originalHeight;

        /*
         * Der kleinere Faktor wird verwendet,
         * damit das Bild nicht verzerrt wird.
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

            int noCount =
                    persons.size() - yesCount;

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

        resultLabel.setText(
                result.getName()
        );

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
                "<html>"
                        + "<div style='text-align: center;'>"
        );

        names.append("Mögliche Personen:<br>");

        for (Person person : persons) {
            names.append(person.getName())
                    .append("<br>");
        }

        names.append("</div></html>");

        resultLabel.setText(
                names.toString()
        );

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