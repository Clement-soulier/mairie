package main.exceptions;

public class Mort extends Exception {
    public Mort() {
        super("Cette personne est déjà marié(e)");
    }

    public Mort(int num_citoyen) {
        super("Le citoyen ayant le numéro" + " " + num_citoyen + " " + "est mort");
    }
}
