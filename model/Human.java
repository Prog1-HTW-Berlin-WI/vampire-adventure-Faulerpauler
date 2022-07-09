package model;

import java.util.Random;
import java.util.UUID;

public class Human {

    private String name;
    private String id = UUID.randomUUID().toString();
    Random random;
    private int amountOfBlood;

    // Konstruktor
    public Human(int amountOfBlood) {
        this.amountOfBlood = amountOfBlood;

    }

    public boolean defend() {
        Random random = new Random();
        int verteidigung = random.nextInt(4) + 1;
        if (verteidigung == 1) {
            System.out.println("The Human threw Garlic at you! Damn that stinks...");
            return true;
        } else {
            return false;
        }
    }

    public void flee(int flee) {
        flee = random.nextInt(4) + 1;
        if (flee == 1) {
            System.out.println("The Human managed to flee");
            if (flee != 1) {
                System.out.println("The Escape Attempt failed. Get him!!");
            }
        }
    }

    public Vampire turnintoVampire(Vampire creator) {
        Vampire newVampire = new Vampire(this.name, creator);
        System.out.println("You just created a new member of the Family");
        return newVampire;
    }

    // Getter & Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmountOfBlood() {
        return amountOfBlood;
    }

    public void setAmountOfBlood(int amountOfBlood) {
        this.amountOfBlood = amountOfBlood;
    }

}
