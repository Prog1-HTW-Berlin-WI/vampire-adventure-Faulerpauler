package app;

import java.util.Random;
import java.util.Scanner;

import model.CreatorVampire;
import model.Vampire;
import model.VampireHunter;

public class VampireAdventureApp {
    // Scanner
    private static Scanner scanner = new Scanner(System.in);
    static Vampire[] vampires = new Vampire[10]; // Auf 2 Vampires begrenzt
    static CreatorVampire[] creatorVampires = new CreatorVampire[1]; // Auf 1 Creator Vampire begrenzt
    static Vampire selectedVampire;

    /**
     * @param args mainklasse
     */
    public static void main(String[] args) {
        // Bei Start des Spiels Vampire erstellen
        CreatorVampire standardCreatorVampire = new CreatorVampire("Edward");
        creatorVampires[0] = standardCreatorVampire;

        Vampire standardVampire1 = new Vampire("Bella", standardCreatorVampire);
        Vampire standardVampire2 = new Vampire("Jacob", standardCreatorVampire);
        vampires[0] = standardVampire1;
        vampires[1] = standardVampire2;
        selectedVampire = standardCreatorVampire;

        showMenu();

    }

    /**
     * Read User Input
     * 
     * @return
     */
    private static int intEingabe() {
        System.out.print("\nPlease choose one of the options:");
        int choiceInternal = 0;
        try {
            choiceInternal = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return choiceInternal;
    }

    private static String stringEingabe() {
        String choiceInternal = "";
        try {
            choiceInternal = scanner.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return choiceInternal;
    }

    /**
     * 
     * 
     * @param choice mainmenu
     */
    private static void mainMenuChoise(int choice) {
        switch (choice) {
            case 1:
                createVampireMenu();
                break;
            case 2:
                showSelectedVampire();
                break;
            case 3:
                listAllVampires();
                break;
            case 4:
                deleteVampire();
                break;
            case 5:
                startNightlyAdventure();
                break;
            case 6:
                quit();
                break;
            default: {
                System.out.println("Invalid input. Please choose a correct number between 1 and 6");
                showMenu();
            }
                break;

        }
    }

    /**
     * Main Menu
     */
    private static void showMenu() {

        String menuItems[] = { "", "(1)\t Create Vampire", "(2)\t Show Selected Vampire", "(3)\t List all Vampires",
                "(4)\t Delete Vampire", "(5)\t Start Nightly Adventure", "(6)\t Quit" };

        System.out.println("\nVampire Adventures 1.0\n");
        System.out.println("Selected Vampire: <" + selectedVampire.getName() + ">\n");

        for (int i = 1; i < menuItems.length; i++) {
            System.out.println(menuItems[i]);
        }

        int choice = intEingabe();
        mainMenuChoise(choice);

    }

    /**
     * createVampire Menu
     * 
     */
    private static void createVampireMenu() {

        String createVampireMenu[] = { "", "(1)\t Creator Vampir erstellen", "(2)\t Vampire erstellen",
                "(3)\t Zurück zum Hauptmenü" };

        System.out.println("\nCreate Vampire\n");

        for (int i = 1; i < createVampireMenu.length; i++) {
            System.out.println(createVampireMenu[i]);
        }
        int choice = intEingabe();
        createVampireChoice(choice);

    }

    /**
     * createVampire choices
     * 
     * @param choice
     */
    private static void createVampireChoice(int choice) {
        switch (choice) {
            case 1:
                createCreatorVampire();
                break;
            case 2:
                createVampire();
                break;
            case 3:
                showMenu();
                break;
            default: {
                System.out.println("Invalid input. Please choose a correct number between 1 and 3");
                createVampireMenu();
            }
                break;
        }
    }

    // Create Creator Vampire
    private static void createCreatorVampire() {
        boolean b = false;
        for (int i = 0; i < creatorVampires.length; i++) { // Check if Creator Vampires Array is full
            if (creatorVampires[i] == null) {
                b = true;
            }
        }
        if (b == true) {
            System.out.println("Wie soll dein Creator Vampir heißen?");
            String creatorVampireName = stringEingabe();
            System.out.println(creatorVampireName + "? Ein super Name!");

            CreatorVampire newCreatorVampire = new CreatorVampire(creatorVampireName);

            for (int i = 0; i < creatorVampires.length; i++) {
                if (creatorVampires[i] == null) {
                    creatorVampires[i] = newCreatorVampire;
                }

            }

            System.out.println("Dein Creator Vampire wurde erstellt!");
        } else { // Array is full
            System.out.println("Du kannst leider keinen weiteren Creator Vampire erstellen. ");
        }
        createVampireMenu();

    }

    // Create Vampire
    private static void createVampire() {
        boolean b = false;
        for (int i = 0; i < vampires.length; i++) { // Check if Vampires Array is full
            if (vampires[i] == null) {
                b = true;
            }
        }
        if (b == true) { // Array is not full
            System.out.println("Wie soll dein Vampir heißen?");
            String vampireName = stringEingabe();
            System.out.println(vampireName + "? Ein super Name!");

            Vampire newVampire = new Vampire(vampireName, null);

            for (int i = 0; i < vampires.length; i++) {
                if (vampires[i] == null) {
                    vampires[i] = newVampire;
                }

            }
            System.out.println("Dein Vampire wurde erstellt!");
        } else { // Array is full
            System.out.println("Du kannst leider keinen weiteren Vampire erstellen. ");
        }
        createVampireMenu();

    }

    private static void showSelectedVampire() {
        System.out.println(
                "\nLeider hat die Methode noch keinen Code. Aber Du kannst hoffentlich nachvollziehen wie der Ablauf ist. Hier kannst du dir alle Attribute deines ausgewählten Vampirs anzeigen lassen.\n");
        showMenu();
    }

    /**
     * listAllVampires Menu
     * 
     */
    private static void listAllVampires() {

        String listAllVampiresMenu[] = { "",
                "(1)\t<" + creatorVampires[0].getName() + ">\t Energy: <" + creatorVampires[0].getEnergy() + "> ",
                "(1)\t<" + vampires[0].getName() + ">\t Energy: <" + vampires[0].getEnergy() + "> ",
                "(1)\t<" + vampires[1].getName() + ">\t Energy: <" + vampires[1].getEnergy() + "> ",
                "(4)\tZurück zum Hauptmenü" };

        System.out.println("\nSelect a Vampire\n");

        for (int i = 1; i < listAllVampiresMenu.length; i++) {
            System.out.println(listAllVampiresMenu[i]);
        }
        int choice = intEingabe();
        listAllVampiresChoice(choice);

    }

    /**
     * list all Vampires choices
     * 
     * @param choice
     */
    private static void listAllVampiresChoice(int choice) {
        switch (choice) {
            case 1:
                selectedVampire = creatorVampires[0];
                System.out.println("\tYou selected the Vampire <" + creatorVampires[0].getName() + ">");
                listAllVampires();
                break;
            case 2:
                selectedVampire = vampires[0];
                System.out.println("\tYou selected the Vampire <" + vampires[0].getName() + ">");
                listAllVampires();
                break;
            case 3:
                selectedVampire = vampires[1];
                System.out.println("\tYou selected the Vampire <" + vampires[1].getName() + ">");
                listAllVampires();
                break;
            case 4:
                showMenu();
                break;
            default: {
                System.out.println("Invalid input. Please choose a correct number between 1 and 4");
                listAllVampires();
            }
                break;
        }
    }

    private static void deleteVampire() {
        System.out.println(
                "\nLeider hat die Methode noch keinen Code. Aber Du kannst hoffentlich nachvollziehen wie der Ablauf ist. Hier kannst du Vampire löschen.\n");
        showMenu();
    }

    private static void startNightlyAdventure() {
        System.out.println("Rise vampires, the sun has gone down and there is lots that needs to be done.")
        System.out.println("“Time is running: Round 1”");
        Random random;

        int counter = 0;
            while (counter <= 15){
                counter++;
                int Ereignis = random.nextInt(10) + 1;
                if(Ereignis <= 7){
                    meetHuman();
                }
                if(Ereignis > 7 && Ereignis =< 9){

                }
                if(Ereignis == 10){
                    Nothing();
                    continue; 
                }
                
            }
                
            }
//Print Counter and a  hint 

    private static void meetHuman(){
        Random random;
        System.out.println("Fresh Blood! Get him!");
        int ZufallHuman = random.nextInt(5) + 1;
        if(ZufallHuman == 1 ){
            System.out.println("The Human managed to flee, your ravenous hunger is torturing you. You better get him next time!");
            // END ROUND
        } else{
            System.out.println("The Escape attempt failed. Get him!!");
        }

        int ZufallDefend = random.nextInt(4) + 1;
        if(ZufallDefend == 1){
            System.out.println("Argh! The Human is defending himself desperately, he is trying to flee!");
            meetHuman();
        } 

        int ZufallAttack = random.nextInt(10) + 1;
        System.out.println("Resistance is useless, your time has come, Human!!");
        if(ZufallAttack <= 7){
            System.out.println("You knocked the Human unconscious. Fresh Blood, for all of us!!");
            drinkBlood(); //undefined for VampireAdventure - Wie greifen wir Klassenübergreifend zu?
            // ja wer und wie viel
        } else{ 
           System.out.println("You missed your attack. Get him before he flees!!"); 
           meetHuman(); 
        }
}
    public static void meetVampireHunter(){
        System.out.println("A Vampire Hunter has crossed your way. Your time has come...");
         //OPTION TO CHOOSE {1}, {2}, {3}, {4}
    }
       
        //1. SACRIFICE 
        Random random;
        void sacrifice(){
            //DELETE SACRFICED VAMPIRE
            int ZufallSacrifice = random.nextInt(1) + 1
            if(ZufallSacrifice == 1){ 
                System.out.println("The Sacrfice could satisfy the VampireHunter. The VampireHunter left")
                //END ROUND
            } else{
                System.out.println("The VampireHunter is still on a rampage, watch out!!");
                attackVampire();
                //BACK TO OPTIONS
            }
        }
        
        //2. FLee
        void flee(){
            Random random;
            int ZufallFlee = random.nextInt(10) + 1;
            if(ZufallFlee <= 6){
                System.out.println("Watch your steps, fortunately, this time we managed to escaped.");
                //END ROUND
            } else{

            } 
        }

        //3. FIGHT
        void fight(){
            Random random;
            int ZufallFight = random.nextInt(3) +1;
            if(ZufallFight == 1){
                System.out.println("You injured the VampireHunter. The VampireHunter has "+energy+" energy left.");
                //ATTACK VAMPIRE 

            }
            if(ZufallFight == 2){
                System.out.println("You just landed a critical hit. The VampireHunter has "+energy+" energy left.");
                //ATTACK VAMPIRE 
            }

        }
    
        

    public static void Nothing(){
         System.out.println("hurry! Find fresh blood, before the sunrise will end your journey");
         // END ROUND
     }

    

    private static void quit() {
        System.out.println("\nGAME OVER! See you next time.\n");
        System.exit(0);
    }


