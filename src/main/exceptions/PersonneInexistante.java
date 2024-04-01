package main.exceptions;

public class PersonneInexistante extends Exception {
    public PersonneInexistante() {
        super("Cette personne n'existe pas");
    }

    public PersonneInexistante(int num_citoyen) {
        super("Le citoyen ayant le numéro" + " " + num_citoyen + " " + "n'existe pas");
    }
}
