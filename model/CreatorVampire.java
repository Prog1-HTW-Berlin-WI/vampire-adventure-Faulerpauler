package model;

public class CreatorVampire extends Vampire {
    // Attribute
    private Vampire[] descendants;

    // Konstruktor
    public CreatorVampire(String name) {
        super();
        this.name = name;
    }

    // Operationen
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
