package model;

public class CreatorVampire extends Vampire {
    // Attribute
    private Vampire[] descendants;

    /**
     * Methode: CreatorVampire
     * Beschreibung: Ein neuer Creator Vampire wird erstellt.
     * 
     * @param name (String) Name des Creator Vampires
     */
    public CreatorVampire(String name) {
        super();
        this.name = name;
    }

    /**
     * Methode: listAllDescendants
     * Beschreibung: Alle Nachfahren des Creator Vampires werden ausgegeben.
     */
    public void listAllDescendants() {
        for (int i = 0; i < descendants.length; i++) {
            System.out.println(descendants[i]);
        }
    }

    // Getter & Setter
    public Vampire[] getDescendants() {
        return descendants;
    }

    public void setDescendants(Vampire[] descendants) {
        this.descendants = descendants;
    }

}
