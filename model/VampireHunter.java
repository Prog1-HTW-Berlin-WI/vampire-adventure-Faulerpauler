package model;

import java.util.UUID;
import java.util.Random;

/**
 * Class VampireHunter mit Attributen erstellen
 */
public class VampireHunter {

    private String id = UUID.randomUUID().toString();
    public String name;
    public int experiencePoints;
    public int energy = 1000; // Hier heißt das Attribut genauso wie beim Vampire - Könnte das zu Problemen
                              // führen?
    private boolean alive = true;
    public Random random;

    /**
     * VampireHunter Konstruktor
     * 
     * @param name
     */

    public VampireHunter(String name) {
        this.name = name;

    }

    /**
     * attack-Vampire-Methode
     * Der VampireHunter greift den Vampir an und trifft zu 50%.
     * Wenn er getroffen hat, dann erleidet der Vampir 3 Schadenspunkte.
     * 
     * @param vampire
     */
    public void attackVampire(Vampire vampire) {
        System.out.println("The VampireHunter is Attacking your Creator");
        int Treffer = random.nextInt(2);
        if (Treffer == 0) {
            System.out.println("The Creator just got hit! He Lost 3 energy.");
            vampire.setEnergy(vampire.getEnergy() - 3);
            System.out.println("The Creator has" + vampire.getEnergy() + "left.");
            return;
        }
        if (Treffer == 1) {
            System.out.println("You dodged the attack!! Good job!");
            return;
        }
    }

    /**
     * takeDamage-Methode
     * Der VampireHunter erleidet Schaden in Höhe der Schadenspunkte, die
     * der Vampir verursacht hat
     * 
     * @param amount
     */
    public void takeDamage(int amount) {
        this.setEnergy(this.getEnergy() - amount);
    }

    /**
     * flee-Methode
     * Ein VampireHunter flieht nie
     */
    public void flee() {
        System.out.println("I'd rather die then flee...");
    }

    /**
     * alive-Methode
     * Zeigt an, ob der VamoireHunter noch lebt oder gestorben ist
     */
    public void alive() {
        if (energy <= 0) {
            System.out.println("The VampireHunter Died. Victory!");
        } else {
            System.out.println("The VampireHunter has " + energy + "left");
        }

    }

    /**
     * Getter- und SetterM-Methoden der Attribute der Unterklasse VampireHunter
     * 
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

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

}
