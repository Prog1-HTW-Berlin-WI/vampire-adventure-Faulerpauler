package model;

import java.util.UUID;
import java.util.Random;

public class VampireHunter {

    private String id = UUID.randomUUID().toString();
    public String name;
    public int experiencePoints;
    public int energy = 1000; // Hier heißt das Attribut genauso wie beim Vampire - Könnte das zu Problemen
                              // führen?
    public Random random;

    public void attackVampire(int Treffer){
        System.out.println("The VampireHunter is Attacking your Creator");
        Treffer = random.nextInt(1);
        if (Treffer == 0){
            System.out.println("The Creator just got hit! You Lost"+ damage +".");
            // get und set der Punkte
            System.out.println("The Creator has" + energy + "left.");
            // CHOOSE OPTIONS 
        }   
        if (Treffer == 1){
            System.out.println("You dodged the attack!! Good job!");
            // CHOOSE OPTIONS
        }
    }

    public void takeDamage(int amount) {
        amount = 5; // statt 5 -> damage dealt by vampire
        energy = energy - amount;
        System.out.println("The VampireHunter just lost" + amount + "energy.");

    }

    public void flee(){
        System.out.println("I'd rather die then flee...");
    }

    public void alive(){
        if(energy <= 0){
            System.out.println("The VampireHunter Died. Victory!");
        }
        else{
            System.out.println("The VampireHunter has "+ energy + "left");
        }

    }

    //Konstruktor 
    public VampireHunter(String name){
    this.name = name;

    }

    // Getter & Setter
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
