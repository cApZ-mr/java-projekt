package model;

public class person {
    private String name;

    private String gender;          // Geschlecht der Person
    private String age;             // Alter unter/über 24
    private String hairColor;       // Haarfarbe
    private String glasses;         // Trägt Brille Ja/Nein
    private String job;             // Vertiefungsrichtung
    private String beard;           // Hat Bart Ja/Nein
    private String ethnicity;       // Kommt aus Asien/Europa Ja/Nein
    private String pet;             // Hat Haustier Ja/Nein
    private String siblings;        // Hat Geschwister Ja/Nein
    private String phone;           // Apple oder Android
    private String driverslicense;  // Hat Führerschein Ja/Nein
    private String car;             // Kommt mit Auto Ja/Nein
    private String city;            // Wohnt in Düsseldorf Ja/Nein
    private String vegetarian;      // Ist Vegetarier/Vegan Ja/Nein
    private String tea;             // Trinkt deine Person Tee Ja/Nein (Bei Vodafone)
    private String smoke;           // Nikotin konsum opfer Ja/Nein
    private String partner;         // Hat Freund/Freundin
    private String meme;            // Ist die Person ein Meme (Bekannt für etwas)

    public person(String name, String gender, String age, String hairColor,
                  String glasses, String job, String beard, String ethnicity,
                  String pet, String siblings, String phone, String driverslicense,
                  String car, String city, String vegetarian, String tea,
                  String smoke, String partner, String meme) {

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

}
