package model;
import java.util.Random;

public class Human {
    
    private String name;
    private String id = UUID.randomUUID().toString();
    private Random amountOfBlood =  // zwischen 6 und 8 - wenn weniger als 5 dann ists aus 

    public Human(Random amountOfBlood){
        this.amountOfBlood = amountOfBlood;

    }
}


