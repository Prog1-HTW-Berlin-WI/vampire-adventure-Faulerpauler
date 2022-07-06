package model;
import java.util.UUID;
import java.util.Random;

public class VampireHunter {

    private String id = UUID.randomUUID().toString(); 
    public String name; 
    public int experiencePoints; 
    public int energy = 1000; // Hier heißt das Attribut genauso wie beim Vampire -  Könnte das zu Problemen führen?
    public Random random; 

    public void attackVampire(int Treffer){
        Treffer = random.nextInt(1);
        if (Treffer == 0){
            System.out.println("Dein Vampir wurde vom VampireHunter getroffen! Du erleidest drei Schadenspunkte");
        }
        if (Treffer == 1){
            System.out.println("Du bist der Waffe des VampireHunters ausgewichen");
        }
    }

    public void takeDamage(int amount){
        amount = 5; // statt 5 -> damage dealt by vampire
        energy = energy - amount;
        System.out.println("Dein Vampir hat den VampireHunter verletzt.");

    }

    public void flee(){
        System.out.println("Ich fliehe nicht, ehe ich euch alle ausgerotter habe");
    }

    public void alive(){
        if(energy <= 0){
            System.out.println("Der VampireHunter ist gestorben. Ein Sieg für uns Vampire");
        }
        else{
            System.out.println("Der VampireHunter lebt noch immer?!");
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
