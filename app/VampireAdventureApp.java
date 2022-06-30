package app;

import java.util.Random;
import java.util.Scanner;

/**
 * @author vemaj
 *
 */
public class VampireAdventureApp {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * @param args mainklasse
     */
    public static void main(String[] args) {

        // while (true) {
        showMenu();
        int choice = readUserInput();
        mainMenuChoise(choice);
        System.out.println("====================");
        // }
    }

    /**
     * 
     * @return
     */
    private static int readUserInput() {
        System.out.print("\nPlease choose one of the preceding options:");
        int choiceInternal = 0;
        try {
            choiceInternal = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return choiceInternal;
    }

    /**
     * 
     * @param choice mainmenu
     */
    private static void mainMenuChoise(int choice) {
        switch (choice) {
            case 1:
                createVampire();
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
     * 
     */
    private static void showMenu() {

        String menuItems[] = { "", "(1)\t Create Vampire", "(2)\t Show Selected Vampire", "(3)\t List all Vampires",
                "(4)\t Delete Vampire", "(5)\t Start Nightly Adventure", "(6)\t Quit" };

        System.out.println("\nVampire Adventures 1.0\n");
        System.out.println("Selected Vampire: <Selected Vampire Name>\n");

        for (int i = 1; i < menuItems.length; i++) {
            System.out.println(menuItems[i]);
        }

        int choice = readUserInput();
        mainMenuChoise(choice);

    }

    /**
     * createVampire Menu
     * 
     */
    private static void createVampire() {

        String createVampireMenu[] = { "", "(1)\t Creator Vampir erstellen", "(2)\t Vampire erstellen",
                "(3)\t Zurück zum Hauptmenü" };

        System.out.println("\nCreate Vampire\n");

        for (int i = 1; i < createVampireMenu.length; i++) {
            System.out.println(createVampireMenu[i]);
        }
        int choice = readUserInput();
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
                System.out.println("\nDas funktioniert leider noch nicht");
                createVampire();
                break;
            case 2:
                System.out.println("\nDas funktioniert leider noch nicht");
                createVampire();
                break;
            case 3:
                showMenu();
                break;
            default: {
                System.out.println("Invalid input. Please choose a correct number between 1 and 3");
                createVampire();
            }
                break;
        }
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

        String listAllVampiresMenu[] = { "", "(1)\t<Vampire Name>\t<Vampire Grandness?>",
                "(2)\t<Vampire Name>\t<Vampire Grandness?>",
                "(3)\t<Vampire Name>\t<Vampire Grandness?>", "(4)\tZurück zum Hauptmenü" };

        System.out.println("\nSelect a Vampire\n");

        for (int i = 1; i < listAllVampiresMenu.length; i++) {
            System.out.println(listAllVampiresMenu[i]);
        }
        int choice = readUserInput();
        listAllVampiresChoice(choice);

    }

    /**
     * createVampire choices
     * 
     * @param choice
     */
    private static void listAllVampiresChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("\nDas funktioniert leider noch nicht");
                listAllVampires();
                break;
            case 2:
                System.out.println("\nDas funktioniert leider noch nicht");
                listAllVampires();
                break;
            case 3:
                System.out.println("\nDas funktioniert leider noch nicht");
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
        System.out.println(
                "\nLeider hat die Methode noch keinen Code. Aber Du kannst hoffentlich nachvollziehen wie der Ablauf ist. Hier kannst du dein Abenteur starten\n");
        showMenu();
    }

    private static void quit() {
        System.out.println("\nDas Spiel wird jetzt beendet, bis zum nächsten Mal!\n");
        System.exit(0);
    }

}
