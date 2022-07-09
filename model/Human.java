package model;
import java.util.Random;
import java.util.UUID;

public class Human {
    
    private String name;
    private String id = UUID.randomUUID().toString();
    Random random;
    private int amountOfBlood = getRandomNumberInRange(6, 8);  // zufallsvariable von 6, 7 oder 8 
  


    public Human(int amountOfBlood){
        this.amountOfBlood = amountOfBlood;

    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max){
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random(); 
        return r.nextInt((max - min) + 1) + min;
   
    }

    public void defend(int verteidigung){
       
        verteidigung = random.nextInt(4)+1;
        if(verteidigung == 1){
            System.out.println("The Human threw Garlic at you! Damn that stinks...");
            //else
        }
    }

    public void flee(int flee){
        flee = random.nextInt(4)+1;
        if(flee == 1){
            System.out.println("The Human managed to flee");
        if (flee != 1){
            System.out.println("The Escape Attempt failed. Get him!!");
            }
        }
    }

    public void turnintoVampire(Human human){
        if(amountOfBlood <= 5){
            System.out.println("You just created a new member of the Family");
            //setmethode 
        }
    }

    // Getter & Setter

    public String getName(){
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

    public void setAmountOfBlood(int amountOfBlood){
        this.amountOfBlood = amountOfBlood;
    }
    
}

