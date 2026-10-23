package model;

public class Person {
    private String name;

    private String gender;          // Geschlecht der Person
    private int age;                // Alter unter/über 24
    private String hairColor;       // Haarfarbe
    private boolean glasses;        // Trägt Brille Ja/Nein
    private String job;             // Vertiefungsrichtung
    private boolean beard;          // Hat Bart Ja/Nein
    private String ethnicity;       // Kommt aus Asien/Europa Ja/Nein
    private boolean pet;            // Hat Haustier Ja/Nein
    private boolean siblings;       // Hat Geschwister Ja/Nein
    private String phone;           // Apple oder Android
    private boolean driverslicense; // Hat Führerschein Ja/Nein
    private boolean car;            // Kommt mit Auto Ja/Nein
    private boolean city;           // Wohnt in Düsseldorf Ja/Nein
    private boolean vegetarian;     // Ist Vegetarier/Vegan Ja/Nein
    private boolean tea;            // Trinkt deine Person Tee Ja/Nein (Bei Vodafone)
    private boolean smoke;          // Nikotin konsum opfer Ja/Nein
    private boolean partner;        // Hat Freund/Freundin
    private boolean meme;           // Ist die Person ein Meme (Bekannt für etwas)

    public Person(String name, String gender, int age, String hairColor,
                  boolean glasses, String job, boolean beard, String ethnicity,
                  boolean pet, boolean siblings, String phone, boolean driverslicense,
                  boolean car, boolean city, boolean vegetarian, boolean tea,
                  boolean smoke, boolean partner, boolean meme) {

        this.name = name;
        this.gender = gender;
        this.age = age;
        this.hairColor = hairColor;
        this.glasses = glasses;
        this.job = job;
        this.beard = beard;
        this.ethnicity = ethnicity;
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
        this.meme = meme;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
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

    public String getEthnicity() {
        return ethnicity;
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

    public boolean isMeme() {
        return meme;
    }

}
