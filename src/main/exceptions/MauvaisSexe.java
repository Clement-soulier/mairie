package main.exceptions;

public class MauvaisSexe extends Exception {
    private int numero_citoyen;

    public MauvaisSexe() {
        super("Cette personne est déjà marié(e)");
    }

    public MauvaisSexe(int num_citoyen) {
        super("Le citoyen ayant le numéro" + " " + num_citoyen + " " + "n'a pas le bon sexe");
        numero_citoyen = num_citoyen;
    }

    public String to_string() {
        return "Le citoyen ayant le numéro" + " " + numero_citoyen + " " + "n'a pas le bon sexe";
    }
}
