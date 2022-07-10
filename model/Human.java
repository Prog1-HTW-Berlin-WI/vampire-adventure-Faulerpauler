package model;
import java.util.Random;
import java.util.UUID;

/**
 * Class Human mit Attributen erstellen 
 * @param name
 * @param  id
 * @param random
 * @param amountOfBlood
 */
public class Human {

    private String name;
    private String id = UUID.randomUUID().toString();
    Random random;
    private int amountOfBlood;

    /**
     * Konstruktor für die Class Human erstellen.
     * @param amountOfBlood
     */
    public Human(int amountOfBlood) {
        this.amountOfBlood = amountOfBlood;

    }

    /**
     * bolean defend-Methode, um Vampir-Angriffe abzuwehren
     * @param random
     * @param verteidigung
     * @return
     */
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

        /**
         * @param flee
         */
    public void flee(int flee) {
        flee = random.nextInt(4) + 1;
        if (flee == 1) {
            System.out.println("The Human managed to flee");
            if (flee != 1) {
                System.out.println("The Escape Attempt failed. Get him!!");
            }
        }
    }

        /**
         * turnIntoVampire-Methode
         * "Human" wird zu "Vampire"
         * @param creator
         * @return
         */
    public Vampire turnintoVampire(Vampire creator) {
        Vampire newVampire = new Vampire(this.name, creator);
        System.out.println("You just created a new member of the Family");
        return newVampire;
    }

    /**
     * Hier findet man alle Getter und Setter der Attribute der Class Human
     * @return
     */

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
