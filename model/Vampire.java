package model;

import java.util.Random;
import java.util.UUID;

public class Vampire {
    private String id = UUID.randomUUID().toString();
    protected String name;
    private int grandness;
    private int hunger = 5;
    private Vampire creator = null;
    private boolean isDrinkingBlood;
    private boolean inFight;
    private boolean canControlInstincts; // nach 10 Nächten true
    private int energy = 10; // geringer als 10 -> finale Auslöschung
    private boolean finallyDead; // unwiederbringlich tot
    Random random = new Random();

    public Vampire(String name, Vampire creator) {
        this.name = name;
        this.creator = creator;
    }

    public Vampire() {

        // Creator Vampire hinzufügen
    }

    // Die Zufallsvariable muss in jede Methode gleich übernommen werden - bspw.
    public void attackHuman(Human human) {
        int zufallsergebnis = random.nextInt(10) + 1;
        if (zufallsergebnis <= 6) {
            drinkBlood();
            // User Input -> "Möchtest du Blut saugen?" -> "Ja" oder "Nein"
        }
        if (zufallsergebnis > 6) {
            System.out.println("Der Mensch konnte deinen Angriff abwehren.");
        }
    }

    // Hier KANN der Spielr entscheiden, ob sein Vampir Blut trinken soll oder nicht
    public void drinkBlood() {
        int amount = random.nextInt(10) + 1;
        if (amount <= 6) {
            // wie viel kann er denn trinken? (Input möglichkeit?)
        }

    }

    public boolean isDrinkingBlood() {
        return isDrinkingBlood;
    }

    // damage gibt es noch nicht - doch die Energie muss anhand der Stärke des
    // Schadens reduziert werden
    public void takeDamage(Vampire Paul) {
        int damage = random.nextInt(10) + 1; // Hier muss jedoch überall die Zufallsvariable übernommen werden, sonst
                                             // haben wir überall verschiedene Variablen
        energy = energy - damage;
        if (energy <= 0) {
            finallyDead = true;
            System.out.println("OH NEIN! DEIN VAMPIR IST GESTORBEN");// lol
        } else {
            System.out.println("Dein Vampir hat noch" + energy + "Lass dich nicht noch einmal treffen!");

        }
    }

    // Getter und Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrandness() {
        return grandness;
    }

    public void setGrandness(int grandness) {
        this.grandness = grandness;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public Vampire getCreator() {
        return creator;
    }

    public void setCreator(Vampire creator) {
        this.creator = creator;
    }

    public void setDrinkingBlood(boolean isDrinkingBlood) {
        this.isDrinkingBlood = isDrinkingBlood;
    }

    public boolean isInFight() {
        return inFight;
    }

    public void setInFight(boolean inFight) {
        this.inFight = inFight;
    }

    public boolean isCanControlInstincts() {
        return canControlInstincts;
    }

    public void setCanControlInstincts(boolean canControlInstincts) {
        this.canControlInstincts = canControlInstincts;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public boolean isFinallyDead() {
        return finallyDead;
    }

    public void setFinallyDead(boolean finallyDead) {
        this.finallyDead = finallyDead;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
