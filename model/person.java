package model;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String name;

    private String gender;          // Geschlecht der Person
    private LocalDate birthDate;    // Geburtsdatum der Person
    private String hairColor;       // Haarfarbe: dunkel oder hell
    private boolean glasses;        // Trägt eine Brille
    private String job;             // AE, SI, DP oder extern
    private boolean beard;          // Hat einen Bart
    private boolean pet;            // Hat ein Haustier
    private boolean siblings;       // Hat Geschwister
    private String phone;           // Apple oder Android
    private boolean driverslicense; // Hat einen Führerschein
    private boolean car;            // Kommt mit dem Auto
    private boolean city;           // Wohnt in Düsseldorf
    private boolean vegetarian;     // Ist vegetarisch oder vegan
    private boolean tea;            // Trinkt Tee
    private boolean smoke;          // Konsumiert Nikotin
    private boolean partner;        // Hat einen Partner oder eine Partnerin

    public Person(
            String name,
            String gender,
            LocalDate birthDate,
            String hairColor,
            boolean glasses,
            String job,
            boolean beard,
            boolean pet,
            boolean siblings,
            String phone,
            boolean driverslicense,
            boolean car,
            boolean city,
            boolean vegetarian,
            boolean tea,
            boolean smoke,
            boolean partner
    ) {

        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.hairColor = hairColor;
        this.glasses = glasses;
        this.job = job;
        this.beard = beard;
        this.pet = pet;
        this.siblings = siblings;
        this.phone = phone;
        this.driverslicense = driverslicense;
        this.car = car;
        this.city = city;
        this.vegetarian = vegetarian;
        this.tea = tea;
        this.smoke = smoke;
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    /*
     * Berechnet das aktuelle Alter automatisch
     * anhand des gespeicherten Geburtsdatums.
     */
    public int getAge() {

        if (birthDate == null) {
            return 0;
        }

        return Period.between(
                birthDate,
                LocalDate.now()
        ).getYears();
    }

    public String getHairColor() {
        return hairColor;
    }

    public boolean hasGlasses() {
        return glasses;
    }

    public String getJob() {
        return job;
    }

    public boolean hasBeard() {
        return beard;
    }

    public boolean hasPet() {
        return pet;
    }

    public boolean hasSiblings() {
        return siblings;
    }

    public String getPhone() {
        return phone;
    }

    public boolean hasDriverslicense() {
        return driverslicense;
    }

    public boolean hasCar() {
        return car;
    }

    public boolean hasCity() {
        return city;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public boolean hasTea() {
        return tea;
    }

    public boolean doesSmoke() {
        return smoke;
    }

    public boolean hasPartner() {
        return partner;
    }
}