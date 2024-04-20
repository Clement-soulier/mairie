package main.exceptions;

public class DejaMarie extends Exception {
    private int numero_citoyen;

    public DejaMarie() {
        super("Cette personne est déjà marié(e)");
    }

    public DejaMarie(int num_citoyen) {
        super("Le citoyen ayant le numéro" + " " + num_citoyen + " " + "est déjà marié(e)");
        numero_citoyen = num_citoyen;
    }

    public String to_string() {
        return "Le citoyen ayant le numéro" + " " + numero_citoyen + " " + "est déjà marié(e)";
    }
}
