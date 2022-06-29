package model;
import java.util.Random;
import java.util.UUID;

public class Human {
    
    private String name;
    private String id = UUID.randomUUID().toString();
    private Random amountOfBlood = random.nextInt(10)+1;  // zufallsvariable von 6, 7 oder 8 
    Random random;

    public Human(Random amountOfBlood){
        this.amountOfBlood = amountOfBlood;

    }

    public void defend(int verteidigung){
       
        verteidigung = random.nextInt(4)+1;
        if(verteidigung == 1){
            System.out.println("Der Mensch hat sich verteidigt, schnapp ihn dir endlich");
        }
    }

    public void flee(int flee){
        flee = random.nextInt(4)+1;
        if(flee == 1){
            System.out.println("Der Mensch ist dir entflohen");
    }

    public void turnintoVampire(Human human)
        if(amountOfBlood <= 5){
            //setmethode 
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

    public Random getAmountOfBlood() {
        return amountOfBlood;
    }

    public void setAmountOfBlood(Random amountOfBlood) {
        this.amountOfBlood = amountOfBlood;
    }
}


