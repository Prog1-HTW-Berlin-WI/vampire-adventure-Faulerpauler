package app;

import java.util.Random;
import java.util.Scanner;

import model.CreatorVampire;
import model.Vampire;

public class VampireAdventureApp {
    // Scanner
    private static Scanner scanner = new Scanner(System.in);
    static Vampire[] vampires = new Vampire[10]; // Auf 10 Vampires begrenzt
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
        vampires[0] = standardCreatorVampire;
        vampires[1] = standardVampire1;
        vampires[2] = standardVampire2;
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
            // System.out.println(e.getMessage());
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
    private static void mainMenuChoice(int choice) {
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
                System.out.println("\nInvalid input. Please choose a correct number between 1 and 6");
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
        mainMenuChoice(choice);

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
                    break;
                }
            }

            for (int i = 0; i < vampires.length; i++) {
                if (vampires[i] == null) {
                    vampires[i] = newCreatorVampire;
                    break;
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
        if (creatorVampires[0] == null) {
            System.out.println("You have to create a Creator Vampire first");
            createVampireMenu();
        }

        if (b == true) { // Array is not full
            System.out.println("Wie soll dein Vampir heißen?");
            String vampireName = stringEingabe();
            System.out.println(vampireName + "? Ein super Name!");

            Vampire newVampire = new Vampire(vampireName, creatorVampires[0]);

            for (int i = 0; i < vampires.length; i++) {
                if (vampires[i] == null) {
                    vampires[i] = newVampire;
                    break;
                }

            }
            System.out.println("Dein Vampire wurde erstellt!");
        } else { // Array is full
            System.out.println("Du kannst leider keinen weiteren Vampire erstellen. ");
        }
        createVampireMenu();

    }

    private static void showSelectedVampire() {

        String vampireAttributes[] = { "\nVampire ID : <" + selectedVampire.getId() + ">",
                "Name: <" + selectedVampire.getName() + ">",
                "Is Creator: <" + Boolean.toString(selectedVampire instanceof CreatorVampire) + ">",
                "Creator: <->",
                "Energy: <" + Integer.toString(selectedVampire.getEnergy()) + ">",
                "Grandness: <" + Integer.toString(selectedVampire.getGrandness()) + ">",
                "Hunger: <" + Integer.toString(selectedVampire.getHunger()) + ">\n" };
        if ((selectedVampire instanceof CreatorVampire) == false) {
            vampireAttributes[3] = "Creator: <" + selectedVampire.getCreator().getName() + ">";
        }
        for (int i = 0; i < vampireAttributes.length; i++) {
            System.out.println(vampireAttributes[i]);
        }
        while (true) {
            System.out.println("Press <1> to go back to the main menu");
            int choice = intEingabe();
            if (choice == 1) {
                showMenu();
                break;
            } else {
                System.out.println("Invalid input. To go back to the main menu press <1>");
            }
        }

    }

    private static void listAllVampires() {
        System.out.println("\nSelect a Vampire\n");
        int x = 1;
        for (int i = 0; i < vampires.length; i++) {
            String isCreator = "";
            if (vampires[i] instanceof CreatorVampire) {
                isCreator = "<C>";
            } else {
                isCreator = "";
            }
            if (vampires[i] != null) {
                System.out.println("(" + (x) + ") <" + vampires[i].getName() + "> Energy: <"
                        + vampires[i].getEnergy() + "> " + isCreator);
                x++;
            }

        }
        System.out.println("(" + (x) + ") Zurück zum Hauptmenü");
        int choice = intEingabe();
        if (choice == x) {
            showMenu();
        }
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
                selectedVampire = vampires[0];
                System.out.println("\tYou selected the Vampire <" + vampires[0].getName() + ">");
                listAllVampires();
                break;
            case 2:
                selectedVampire = vampires[1];
                System.out.println("\tYou selected the Vampire <" + vampires[1].getName() + ">");
                listAllVampires();
                break;
            case 3:
                selectedVampire = vampires[2];
                System.out.println("\tYou selected the Vampire <" + vampires[2].getName() + ">");
                listAllVampires();
                break;
            case 4:
                selectedVampire = vampires[3];
                System.out.println("\tYou selected the Vampire <" + vampires[3].getName() + ">");
                listAllVampires();
                break;
            case 5:
                selectedVampire = vampires[4];
                System.out.println("\tYou selected the Vampire <" + vampires[4].getName() + ">");
                listAllVampires();
                break;
            case 6:
                selectedVampire = vampires[5];
                System.out.println("\tYou selected the Vampire <" + vampires[5].getName() + ">");
                listAllVampires();
                break;
            case 7:
                selectedVampire = vampires[6];
                System.out.println("\tYou selected the Vampire <" + vampires[6].getName() + ">");
                listAllVampires();
                break;
            case 8:
                selectedVampire = vampires[7];
                System.out.println("\tYou selected the Vampire <" + vampires[7].getName() + ">");
                listAllVampires();
                break;
            case 9:
                selectedVampire = vampires[8];
                System.out.println("\tYou selected the Vampire <" + vampires[8].getName() + ">");
                listAllVampires();
                break;
            case 10:
                selectedVampire = vampires[9];
                System.out.println("\tYou selected the Vampire <" + vampires[9].getName() + ">");
                listAllVampires();
                break;

            default: {
                System.out.println("Invalid input. Please choose a correct number between 1 and 4");
                listAllVampires();
            }
                break;
        }
    }

    /**
     * delete Vampire Menu
     * 
     */
    /*
     * private static void deleteVampire() {
     * String deleteVampireMenu[] = {
     * "(1)\t<" + creatorVampires[0].getName() + ">\t Energy: <" +
     * creatorVampires[0].getEnergy() + "> ",
     * "(2)\t<" + vampires[0].getName() + ">\t Energy: <" + vampires[0].getEnergy()
     * + "> ",
     * "(3)\t<" + vampires[1].getName() + ">\t Energy: <" + vampires[1].getEnergy()
     * + "> ",
     * "(4)\tZurück zum Hauptmenü" };
     * 
     * System.out.println("\nSelect a Vampire to delete\n");
     * 
     * for (int i = 0; i < deleteVampireMenu.length; i++) {
     * 
     * System.out.println(deleteVampireMenu[i]);
     * }
     * int choice = intEingabe();
     * 
     * deleteVampireChoice(choice);
     * }
     */

    private static void deleteVampire() {
        System.out.println("\nSelect a Vampire to delete\n");
        int x = 1;
        for (int i = 0; i < vampires.length; i++) {
            if (vampires[i] != null) {
                System.out.println("(" + (x) + ")\t<" + vampires[i].getName() + ">\t Energy: <"
                        + vampires[i].getEnergy() + "> ");
                x++;
            }

        }
        System.out.println("(" + (x) + ")\t Zurück zum Hauptmenü");
        int choice = intEingabe();
        if (choice == x) {
            showMenu();
        }
        deleteVampireChoice(choice);
    }

    /**
     * delete Vampires choices
     * 
     * @param choice
     */
    private static void deleteVampireChoice(int choice) {
        switch (choice) {
            case 1:
                deleteChosenVampire(choice);
                deleteVampire();
                break;
            case 2:
                deleteChosenVampire(choice);
                deleteVampire();
                break;
            case 3:
                deleteChosenVampire(choice);
                deleteVampire();
                break;
            case 4:
                deleteChosenVampire(choice);
                deleteVampire();
                break;
            case 5:
                deleteChosenVampire(choice);
                deleteVampire();
                break;
            case 6:
                deleteChosenVampire(choice);
                deleteVampire();
                break;
            case 7:
                deleteChosenVampire(choice);
                deleteVampire();
                break;
            case 8:
                deleteChosenVampire(choice);
                deleteVampire();
                break;
            case 9:
                deleteChosenVampire(choice);
                deleteVampire();
                break;
            case 10:
                deleteChosenVampire(choice);
                deleteVampire();
                break;
            default: {
                System.out.println("Invalid input. Please choose a valid number");
                deleteVampire();
                break;
            }
        }
    }

    private static void deleteChosenVampire(int choice) {
        System.out.println("\tThe Vampire <" + vampires[choice - 1].getName() + "> has been deleted.");

        if (vampires[choice - 1] instanceof CreatorVampire) {
            creatorVampires[0] = null;
        }
        vampires[choice - 1] = null;
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
        System.out.println("A Human! Get him!");
        Random random;
        int ZufallHuman = random.nextInt(10) + 1;
        
    }

    public static void VampireHunter(){
        System.out.println("A Vampire Hunter has crossed your way. Your time has come...");

    }

    public static void Nothing(){
         System.out.println("hurry! Find fresh blood, before the sunrise will end your journey");
         
     }

    

    private static void quit() {
        System.out.println("\nDas Spiel wird jetzt beendet, bis zum nächsten Mal!\n");
        System.exit(0);
    }

}
