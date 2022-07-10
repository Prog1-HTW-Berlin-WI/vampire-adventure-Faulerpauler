package model;

import java.util.Random;
import java.util.UUID;

/** 
 * Class Vampire mit Attributen erstellen 
 */
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

    /**
     * Konstruktor für die Klass Vampire
     * @param name
     * @param creator
     */
    public Vampire(String name, Vampire creator) {
        this.name = name;
        this.creator = creator;
    }
    /**
     * zweiter Konstrukter für die Class Vampire 
     * Grund dafür ist der super()-Befehl in der Unterklasse CreatorVampire
     * Hierdurch wird der CreatorVampire hinzugefügt
     */
    public Vampire() {

    }

    /**
     * Die Methode attackHuman bedeutet, dass der angreifende Vampir den Menschen 
     * zu 60% der Fälle ruhig stellen kann.
     * @param human
     * @return
     */
    public boolean attackHuman(Human human) {
        System.out.println("Resistance is useless, your time has come, Human!!");
        int zufallsergebnis = random.nextInt(10) + 1;
        if (zufallsergebnis <= 6) {
            System.out.println("You knocked the Human unconscious. Fresh Blood, for all of us!!");
            return true;
        } else {
            System.out.println("He dodged your attack!");
            return false;
        }
    }

    /**
     * Die Methode drinkBlood erlaubt es, einem Vampir Blut bestimmter Menge zu trinken.
     * @param amount
     * @param human
     */
    public void drinkBlood(int amount, Human human) {
        human.setAmountOfBlood(human.getAmountOfBlood() - amount);
        this.hunger = this.hunger - amount;
    }

    /**
     * Die Methode isDrinkingBlood zeigt an, dass der Vampir gerade trinkt 
     * if true = isDrinkingBlood, if false = isNotDrinkingBlood
     * Da wir in der Methode keinen Nutzen gesehen haben, ist sie vollständigkeitshalber 
     * hier aufgelistet
     * @return
     */
    public boolean isDrinkingBlood() {
        // IF ja dann true setzen
        return isDrinkingBlood;
    }

    /**
     * Methode takeDamage
     * Der Vampir erleidet schaden
     * @param Paul
     */
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

    /**
     * Getter- und Setter-Methoden der Attribute der Class Vampire
     * @return
     */
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
