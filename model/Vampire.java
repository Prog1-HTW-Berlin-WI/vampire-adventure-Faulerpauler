package model;
import java.util.Random;

public class Vampire {
    private String id = UUID.randomUUID().toString();
    private String name;
    private int grandness; 
    private int hunger = 5;
    private Vampire creator = null;
    private boolean isDrinkingBlood;
    private boolean inFight;
    private boolean canControlInstincts; // nach 10 Nächten true
    private int energy = 10; // geringer als 10 -> finale Auslöschung
    private boolean finallyDead; //unwiederbringlich tot  

    public Vampire(String name, Vampire creator ){
        this.name = name;
        this.creator = creator; 

    }

    public boolean attackHuman(Human human){
        Random random = new Random();
        int Zufallsergebnis = random.nextInt(100);
        if(human <= 60){
            return true;
        }
        if(human) > 60){
            return false;
        }
    }

    public boolean drinkBlood(){
        if  = true;
    }

    public boolean takeDamage(int damage){
        
    }


}