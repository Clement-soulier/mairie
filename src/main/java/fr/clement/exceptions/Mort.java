package fr.clement.exceptions;

public class Mort extends Exception {
    private int numero_citoyen;

    public Mort() {
        super("Cette personne est morte");
    }

    public Mort(int num_citoyen) {
        super("Le citoyen ayant le numéro" + " " + num_citoyen + " " + "est mort(e)");
        numero_citoyen = num_citoyen;
    }

    public String to_string() {
        return "Le citoyen ayant le numéro" + " " + numero_citoyen + " " + "est mort(e)";
    }
}
