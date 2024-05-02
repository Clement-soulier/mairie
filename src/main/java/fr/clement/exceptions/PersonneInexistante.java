package fr.clement.exceptions;

public class PersonneInexistante extends Exception {
    private int numero_citoyen;

    public PersonneInexistante() {
        super("Cette personne n'existe pas");
    }

    public PersonneInexistante(int num_citoyen) {
        super("Le citoyen ayant le numéro" + " " + num_citoyen + " " + "n'existe pas");
        numero_citoyen = num_citoyen;
    }

    public String to_string() {
        return "Le citoyen ayant le numéro " + numero_citoyen + " " + "n'existe pas";
    }
}
