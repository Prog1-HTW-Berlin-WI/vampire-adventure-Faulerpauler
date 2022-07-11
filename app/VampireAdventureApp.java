package app;

import java.util.Random;
import java.util.Scanner;

import model.CreatorVampire;
import model.Human;
import model.Vampire;
import model.VampireHunter;

/**
 * Klasse mit allen Methoden für die Vampire Adventure App
 * 
 */
public class VampireAdventureApp {
    // Scanner
    private static Scanner scanner = new Scanner(System.in);
    static Vampire[] vampires = new Vampire[10]; // Auf 10 Vampires begrenzt
    static CreatorVampire[] creatorVampires = new CreatorVampire[1]; // Auf 1 Creator Vampire begrenzt
    static Vampire selectedVampire;

    /**
     * Methode: main
     * Beschreibung: Erstellt Standard Vampire und Vampire Array und legt den
     * Selected Vampire fest. Das Menü von dem die weiteren Aktion ausgewählt werden
     * können wird aufgerufen.
     * 
     * @param args (String[])
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
     * Methode: intEingabe
     * Beschreibung: Ließt die Nutzereingabe für Intergers und gibt diese für die
     * weitere Verwendung zurück
     * 
     * @return choiceInternal (int) Nutzereingabe
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

    /**
     * Methode: stringEingabe
     * Beschreibung: Ließt die Nutzereingabe für Strings und gibt diese für die
     * weitere Verwendung zurück
     * 
     * @return choiceInternal (String) Nutzereingabe
     */
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
     * Methode: showMenu
     * Beschreibung: Zeigt das Nutzerinterface des Hauptmenü an und ruft die
     * Methoden intEingabe() und
     * mainMenuChoice() für die Verarbeitung der Nutzereingaben auf.
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
     * Methode: mainMenuChoice
     * Beschreibung: Verarbeitet die Menüeingabe und ruft die ausgewählte Aktion
     * auf.
     * 
     * @param choice (int)
     * 
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
     * Methode: createVampireMenu
     * Beschreibung: Zeigt das Nutzerinterface zum Erstellen von Vampiren an und
     * ruft die Methoden intEingabe() und createVampireChoice() für die Verarbeitung
     * der Nutzereingaben auf.
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
     * Methode: createVampireChoices
     * Beschreibung: Verarbeitet die Nutzereingabe und ruft die ausgewählte Aktion
     * auf.
     * 
     * @param choice (int) Nutzereingabe
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

    /**
     * Methode: createCreatorVampire
     * Beschreibung: Kontrolliert ob ein Creator Vampir erstellt werden kann,
     * erstellt diesen wenn möglich und fügt ihn zum Vampire Array hinzu.
     */
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

    /**
     * Methode: createVampire
     * Beschreibung: Kontrolliert ob ein weiterer Vampir erstellt werden kann,
     * erstellt diesen wenn möglich und fügt ihn zum Vampire Array hinzu.
     */
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

    /**
     * Methode: showSlectedVampire
     * Beschreibung: Zeigt alle Attribute des Selected Vampires aus.
     *
     */
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

    /**
     * Methode: listAllVampires
     * Beschreibung: Zeigt eine Liste aller Vampire an aus welcher der Nutzer einen
     * Vampir auswählen kann um ihn zum selected Vampire zu machen.
     */
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
     * Methode: listAllVampiresChoice
     * Beschreibung: Verarbeitet die Menüeingabe und ruft die ausgewählte Aktion
     * auf.
     * 
     * @param choice (int) Nutzereingabe
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
     * Methode: deleteVampire
     * Beschreibung: Zeigt eine Liste aller Vampire an aus welcher der Nutzer einen
     * auswählen kann um diesen zu löschen.
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
     * Methode: deleteVampireChoice
     * Beschreibung: Verarbeitet die Menüeingabe und ruft die ausgewählte Aktion
     * auf.
     * 
     * @param choice (int) Nutzereingabe
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

    /**
     * Methode: deleteChosenVampire
     * Beschreibung: Löscht den ausgewählten Vampir aus dem Vampire Array
     * 
     * @param choice (int) Nutzereingabe
     */
    private static void deleteChosenVampire(int choice) {
        System.out.println("\tThe Vampire <" + vampires[choice - 1].getName() + "> has been deleted.");

        if (vampires[choice - 1] instanceof CreatorVampire) {
            creatorVampires[0] = null;
        }
        vampires[choice - 1] = null;
    }

    /**
     * Methode nextRound
     * Beschreibung: Wartet auf eine Nutzereingabe um die nächste Runde zu starten.
     */
    private static void nextRound() {
        while (true) {
            System.out.println("Press <1> to start the next round!");
            int choice = intEingabe();
            if (choice == 1) {
                break;
            } else {
                System.out.println("Invalid input. To start the next round press <1>!");
            }
        }
    }

    /**
     * Methode: startNightlyAdventure
     * Beschreibung: Startet ein Spiel welches 15 Runden geht und entscheidet
     * welches Ereignis eintreten soll.
     * 
     */
    private static void startNightlyAdventure() {
        int counter = 1;
        System.out.println("Rise vampires, the sun has gone down and there is lots that needs to be done.");

        Random random = new Random();

        while (counter <= 15) {
            System.out.println("Time is running: Round " + counter + ".");
            int Ereignis = random.nextInt(10) + 1;

            if (Ereignis <= 7) {// Human
                meetHuman();

            }
            if (Ereignis > 7 && Ereignis <= 9) { // Vampire Hunter
                meetVampireHunter();
                nextRound();

            } else { // Nothing
                System.out.println("hurry! Find fresh blood, before the sunrise will end your journey");
                nextRound();
            }
            counter++;

        }

    }

    // Print Counter and a hint
    /**
     * Methode: meetHuman
     * Beschreibung: Ein neues Objekt von der Klasse Human wird erstellt. Es wird
     * entschieden ob dieser fliehen kann oder nicht. Wenn nicht kann vom Nutzer
     * entscheieden werden kann ein Vampir ausgewählt werden mit welchem der Human
     * angegriffen werden soll. Nachdem der Human erfolgreich stillgelegt wurde kann
     * der Vampir blut trinken und den Human gegebenenfalls un einen Vampir
     * umwandeln.
     */
    private static void meetHuman() {
        Human bob = new Human(getRandomBlood());
        Random random = new Random();
        int ZufallHuman = random.nextInt(5) + 1;

        System.out.println("A Human! Get him!");
        System.out.println("Fresh Blood! Get him!");

        while (true) {
            if (ZufallHuman == 1) {// 20% Human flees
                System.out.println(
                        "The Human managed to flee, your hunger is torturing you. You better get him next time!");
                nextRound();
                return;
            } else {
                System.out.println("The Escape attempt failed. Get him!!");
            }

            Vampire attackingVampire = chooseVampire("attack with");

            if (bob.defend() == true) {// hat sich verteidigt
                nextRound();
                return;
            } else { // konnte sich nicht verteidigen
                if (attackingVampire.attackHuman(bob) == true) {
                    System.out.println("Do you want to suck blood?\n <1>\t Yes\n<2>\t No");
                    int choice = intEingabe();
                    if (choice == 1) {
                        System.out.println("The human has " + bob.getAmountOfBlood()
                                + " liters of blood.\nHow much do you want to drink?");
                        int drinkChoice = intEingabe();
                        attackingVampire.drinkBlood(drinkChoice, bob);

                        if (bob.getAmountOfBlood() < 5) {
                            Vampire newVampire = bob.turnintoVampire(attackingVampire);
                            for (int i = 0; i < vampires.length; i++) {
                                if (vampires[i] != null) {
                                    vampires[i] = newVampire;
                                }
                            }
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

    }

    /**
     * Methode: chooseVampire
     * Beschreibung: Es kann ein Vampir für eie bestimmte Aktion ausgewählt werden.
     * Der Ausgewählte Vampir wird von der Methode zurückgegeben.
     * 
     * @param action (String) Die Aktion für welche der Vampir ausgewählt wird
     * @return attackingVampire (Vampire) Der ausgewählte Vampir
     */
    private static Vampire chooseVampire(String action) {
        System.out.println("\nSelect a Vampire to " + action + "\n");
        int x = 1;
        for (int i = 0; i < vampires.length; i++) {
            String isCreator = "";
            if (vampires[i] instanceof CreatorVampire) {
                isCreator = "<C>";
            } else {
                isCreator = "";
            }
            if (vampires[i] != null) {
                System.out.println("(" + (x) + ") <" + vampires[i].getName() + "> Hunger: <"
                        + vampires[i].getHunger() + "> " + isCreator);
                x++;
            }

        }
        int choice = intEingabe();
        Vampire attackingVampire = vampires[choice];
        return attackingVampire;
    }

    /**
     * Methode: getRandomBlood
     * Beschreibung: Gibt eine zufällige Menge an Blut aus
     * 
     * @return r (int) Zufällige Zahl zwischen 6 und 8
     */
    public static int getRandomBlood() {
        Random r = new Random();
        return r.nextInt(3) + 6;
    }

    /**
     * Methode: meetVampireHunter
     * Beschreibung: Erstellt ein Objekt von der Klasse VampireHunter und gibt dem
     * Nutzer 4 mögliche Aktionen zur Auswahl. Je nach Nutzereingabe wird auf die
     * dementsprechende Methode weitergeleitet.
     */
    public static void meetVampireHunter() {
        VampireHunter blade = new VampireHunter("Blade");
        System.out.println("A Vampire Hunter has crossed your way. Your time has come...");
        // OPTION TO CHOOSE {1}, {2}, {3}, {4}
        String VHoptions[] = { "<1>\t Sacrifice one of your vampires",
                "<2>\t Try to flee from the vampire hunter",
                "<3>\t Fight the vampire hunter",
                "<4>\t Call it a night" };
        while (true) {
            for (int i = 0; i < VHoptions.length; i++) {
                System.out.println(VHoptions[i]);
            }
            int choice = intEingabe();
            switch (choice) {
                case 1:
                    sacrifice(blade);
                    return;
                case 2:
                    flee(blade);
                    return;
                case 3:
                    fight(blade);

                case 4:
                    callItANight();
                default:
                    System.out.println("Invalid input, please choose a number between 1 and 4.");
            }
        }
    }

    /**
     * Methode: sacrifice
     * Beschreibung: Ein Vampir wird geopfert um den VampireHunter mit 50%iger
     * Wahrscheinlichkeit loszuwerden.
     * 
     * @param name (VampireHunter) Der angreifende Vampire Hunter
     */
    public static void sacrifice(VampireHunter name) {
        Vampire creator = vampires[0];
        for (int i = 0; i < vampires.length; i++) {
            if (vampires[i] instanceof CreatorVampire) {
                creator = vampires[i];
            }
        }
        // DELETE SACRFICED VAMPIRE
        while (true) {
            Vampire sacrification = chooseVampire("sacrifice");
            if (sacrification instanceof CreatorVampire) {
                System.out.println("You can't sacrifice your creator Vampire");
            } else {
                for (int i = 0; i < vampires.length; i++) {
                    if (vampires[i].getId() == sacrification.getId()) {
                        vampires[i] = null;
                    }
                }
                break;
            }
        }
        Random random = new Random();
        int ZufallSacrifice = random.nextInt(1);
        if (ZufallSacrifice == 1) {
            System.out.println("The Sacrfice could satisfy the VampireHunter. The VampireHunter left");
            return;
        } else {
            System.out.println("The VampireHunter is still on a rampage, watch out!!");
            name.attackVampire(creator);
            return;
        }
    }

    /**
     * Methode: flee
     * Beschreibung: Ein Fluchtversuch wird gestartet. Wenn dieser fehlschlägt fügt
     * der Vampire Hunter dem Creator Vampire Schaden hinzu.
     * 
     * @param name (VampireHunter) Der angreifende Vampire Hunter
     */
    public static void flee(VampireHunter name) {
        Vampire creator = vampires[0];
        for (int i = 0; i < vampires.length; i++) {
            if (vampires[i] instanceof CreatorVampire) {
                creator = vampires[i];
            }
        }

        Random random = new Random();
        int ZufallFlee = random.nextInt(10) + 1;
        if (ZufallFlee <= 6) {
            System.out.println("Watch your steps, fortunately, this time we managed to escape.");
            return;
        } else {
            System.out.println("Your escape failed!!! The vampire hunter is starting another attack!!");
            name.attackVampire(creator);
            return;

        }
    }

    /**
     * Methode: fight
     * Beschreibung: Der Nutzer kann einen Vampir auswählen mit dem der Vampire
     * Hunter angegriffen werden soll. der Schaden wird zufällig ausgewählt.
     * 
     * @param name (VampireHunter) Der angreifende Vampire Hunter
     */
    public static void fight(VampireHunter name) {
        Vampire creator = vampires[0];
        for (int i = 0; i < vampires.length; i++) {
            if (vampires[i] instanceof CreatorVampire) {
                creator = vampires[i];
            }
        }

        Random random = new Random();
        int ZufallFight = random.nextInt(3);
        if (ZufallFight == 0) {
            name.takeDamage(150);
            System.out.println(
                    "You injured the VampireHunter. The VampireHunter has " + name.getEnergy() + " energy left.");
        }
        if (ZufallFight == 1) {
            name.takeDamage(300);
            System.out.println(
                    "You just landed a critical hit. The VampireHunter has " + name.getEnergy() + " energy left.");

        } else {
            System.out.println("You missed!! This could be your End!!");
        }

        name.attackVampire(creator);
        return;
    }

    /**
     * Methode: callItANight
     * Beschreibung: Die Runde wird beendet und der Nutzer wird zurück ins Hauptmenü
     * geleitet.
     */
    public static void callItANight() {
        System.out.println("You chickened out! The night is over now!");
        while (true) {
            System.out.println("\nPress <1> to get back to the main menu.");
            int choice = intEingabe();
            if (choice == 1) {
                showMenu();
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    /**
     * Methode: quit
     * Beschreibung: Das Spiel wird beendet.
     */
    private static void quit() {
        System.out.println("\nGAME OVER! See you next time.\n");
        System.exit(0);
    }
}
